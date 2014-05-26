package com.outtatech.server;

import com.lloseng.ocsf.server.ConnectionToClient;
import com.outtatech.client.messaging.*;
import com.outtatech.common.ActionCard;
import com.outtatech.common.ActionCardType;
import com.outtatech.common.AllSnoop;
import com.outtatech.common.Card;
import com.outtatech.common.HintCard;
import com.outtatech.common.Player;
import com.outtatech.common.PrivateTip;
import com.outtatech.common.Snoop;
import com.outtatech.common.Solution;
import com.outtatech.common.Suggestion;
import com.outtatech.common.SuperSleuth;
import com.outtatech.server.messaging.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The ServerController controls every game being played. Each game has a set of
 * players connected to the ServerController, represented by the Connection
 * object. This association is tracked with a map of Connection to Game. This
 * implies that multiple Connection keys will point to the same Game value.
 *
 * @author Steven Chiu, James Bilous, Brian Schacherer
 * @version 1.0 - May 11, 2014
 */
public class ServerController
{
    private Map<ConnectionToClient, Game> games;
    private Map<Integer, Game> gameIdToGame;
    private Map<Game, CopyOnWriteArrayList<ConnectionToClient>> players;
    private Map<ServerPlayer, ConnectionToClient> humans;
    //maybe mapped differently? AI are serverplayers
    private Map<ServerPlayer, AI> robots;
    private Map<Integer, Lobby> lobbies;
    private Map<ServerPlayer, Lobby> waiting;
    private ServerNetwork network;

    /**
     * Construct a ServerController object. A ServerController instance can be
     * used to facilitate changes to multiple Game instances with many different
     * Client connections and any AI players.
     *
     * @param games a Map of Client connections and Games
     * @param humans a Map of ServerPlayers and Client Connections
     * @param robots a Map of ServerPlayers and AI instances
     */
    public ServerController(ServerNetwork network)
    {
        this.network = network;
        this.network.setServerController(this);

        this.games = new HashMap<ConnectionToClient, Game>();
        this.players
                = new HashMap<Game, CopyOnWriteArrayList<ConnectionToClient>>();
        this.humans = new HashMap<ServerPlayer, ConnectionToClient>();
        this.robots = new HashMap<ServerPlayer, AI>();
        this.lobbies = new HashMap<Integer, Lobby>();
        this.gameIdToGame = new HashMap<Integer, Game>();

        try
        {
            network.listen();
        }
        catch (IOException ex)
        {

        }
    }

    /**
     * Handle a network request from a client.
     *
     * @param obj Object signaling an action.
     * @param connection ConnectionToClient used to respond back to client.
     */
    public void reactToNetwork(Object obj, ConnectionToClient connection)
    {
        /**
         * Check the Object obj with the instanceOf (io) method if instanceOf
         * LobbyListRequest respond with LobbyDiscoveryResponse else if
         */
        if (obj instanceof LobbyListRequest)
        {
            List<Lobby> publicLobbies = new ArrayList<Lobby>();
            for (Lobby lobby : lobbies.values())
            {
                if (lobby.isVisible())
                {
                    publicLobbies.add(lobby);
                }
            }
            forwardMessage(new LobbyDiscoveryResponse(publicLobbies),
                    connection);
        }
        else if (obj instanceof ActionRequest)
        {
            ActionRequest actionReq = (ActionRequest) obj;
            handleActionRequest(actionReq, connection);
        }
        /* 
         * AccusationRequest respond with AccusationResponse
         */
        else if (obj instanceof AccusationRequest)
        {
            AccusationRequest accusationReq = (AccusationRequest) obj;
            handleAccusation(accusationReq, connection);
        }
        /*
         * AddAIRequest respond with AddAIResponse
         */
        else if (obj instanceof AddAIRequest)
        {
            AddAIRequest addAIReq = (AddAIRequest) obj;
            ServerPlayer newPlayer = new AI(addAIReq.getDifficulty(), this, games.get(connection));

            // Get the requestor's lobby
            Lobby lobby = lobbies.get(addAIReq.getLobbyId());
            // Get the game associated with the lobby
            Game lobbyGame = gameIdToGame.get(lobby.getGameId());
            // Add the AI
            lobbyGame.addServerPlayer(newPlayer);
            // Inform game players
            informPlayers(lobbyGame, new LobbyJoinResponse(lobby,
                    newPlayer.getPlayerId(), lobbyGame.getPlayers()));
        }

        /* 
         * LobbyJoinRequest respond with LobbyJoinResponse
         * notify all clients.
         */
        else if (obj instanceof LobbyJoinRequest)
        {
            Lobby lobby = lobbies.get(((LobbyJoinRequest) obj).getLobbyId());
            ServerPlayer serverPlayer = new ServerPlayer();
            serverPlayer.setName("xXDragonDildos69Xx");

            this.humans.put(serverPlayer, connection);
            List<ConnectionToClient> cxns = this.getGameClients(lobby.
                    getLobbyId());
            cxns.add(this.humans.get(serverPlayer));

            Game game = gameIdToGame.get(lobby.getGameId());
            game.addServerPlayer(serverPlayer);

            forwardMessage(new LobbyJoinResponse(lobby, serverPlayer.
                    getPlayerId(), game.getPlayers()),
                    cxns);
        }

        /**
         * LobbyCreateRequest respond with LobbyCreateResponse else if
         */
        else if (obj instanceof LobbyCreateRequest)
        {
            LobbyCreateRequest lcr = (LobbyCreateRequest) obj;
            Game game = new Game();
            Lobby lobby = new Lobby(lcr.getLobbyName(), game.getGameId(), true);
            games.put(connection, game);
            gameIdToGame.put(game.getGameId(), game);
            lobbies.put(game.getGameId(), lobby);
            players.put(game, new CopyOnWriteArrayList<ConnectionToClient>());

            //@TODO Only the requesting client will be updated.  Other clients
            //will need to send a lobby discovery response to refresh.
            forwardMessage(new LobbyCreateResponse(lobby), connection);
        }

        /**
         *
         */
        else if (obj instanceof GameStartRequest)
        {
            handleGameStartRequest(games.get(connection));
        }
        /**
         * ActionRequest respond with ActionResponse else if
         */
        else if (obj instanceof ActionRequest)
        {
//            ActionRequest temp = ((ActionRequest) obj);
//            forwardMessage(new ActionResponse(temp.getActionCard(),
//                    temp.getPlayerId()), connection, false);
        }
        /**
         * AddAIRequest?
         */
        else if (obj instanceof AddAIRequest)
        {
            AddAIRequest temp = ((AddAIRequest) obj);
            int num = (robots.keySet()).size();
            AI bot = new AI(new Difficulty(100, 100), this, games.get(connection));
            bot.setName("CLUEBot" + num);
            games.get(connection).getServerPlayers()
                    .put(bot.getPlayerId(), bot);
            //update the mapping
            forwardMessage(new LobbyJoinResponse(lobbies.get(temp.getLobbyId()),
                    bot.getPlayerId(), games.get(connection).getPlayers()),
                    connection);
        }
        /**
         * @TODO Add a response class? PlayersResponse? List of player names and
         * made up AI names? or Add a list of players to the
         * LobbyDiscoveryResponse?
         */

        /**
         * else if EndTurnRequest respond with GameStateResponse
         */
        else if (obj instanceof EndTurnRequest)
        {
            //forwardMessage(new GameStateResponse()), connection, false);
        }
        /**
         * else if RevealCardRequest(prompted by an ActionResponse) respond with
         * a GameStateResponse
         */
        else if (obj instanceof RevealCardResponse)
        {
            //forwardMessage(new GameStateResponse()), connection, false);
        }
        /**
         * Responses are made via the forwardMessage function.
         */
    }

    /**
     * Given a game and a message, distributes the message to AI and Players
     *
     * @param game the game that contains the players the msg should be sent to
     * @param msg the message that should be sent to the players in the game
     */
    private void informPlayers(Game game, ServerResponse msg)
    {
        ArrayList<ConnectionToClient> gamePlayers
                = new ArrayList<ConnectionToClient>();

        ArrayList<AI> aiPlayers = new ArrayList<AI>();

        //Get all players in game
        List<ServerPlayer> gameServerPlayers = game.getServerPlayersList();

        // Build a list of human client connections to send 
        // LobbyUpdateResponse to
        for (ServerPlayer serverPlayer : gameServerPlayers)
        {
            if (!humans.containsKey(serverPlayer))
            {
                aiPlayers.add(robots.get(serverPlayer));
            }
            else
            {
                gamePlayers.add(humans.get(serverPlayer));
            }
        }

        // Send all human players in the lobby a LobbyUpdateResponse
        forwardMessage(msg, gamePlayers);
        informAI(msg, aiPlayers);
    }

    private void handleAccusation(AccusationRequest accusationReq,
            ConnectionToClient connection)
    {
        ArrayList<ConnectionToClient> gamePlayers
                = new ArrayList<ConnectionToClient>();
        ArrayList<AI> aiPlayers = new ArrayList<AI>();

        Solution accusation = accusationReq.getSolution();
        //Get the clients game
        Game clientGame = games.get(connection);

        //Get all players in game
        List<ServerPlayer> gameServerPlayers
                = clientGame.getServerPlayersList();

        //Build a list of human client connections to send accusation
        //response to
        for (ServerPlayer serverPlayer : gameServerPlayers)
        {
            if (!humans.containsKey(serverPlayer))
            {
                aiPlayers.add(robots.get(serverPlayer));
            }
            else
            {
                gamePlayers.add(humans.get(serverPlayer));
            }
        }

        //Create accusation response
        AccusationResponse accResp = new AccusationResponse(accusation,
                accusation.equals(clientGame.getSolution()));

        //Send to humans
        forwardMessage(accResp, gamePlayers);

        //Send to AI
        informAI(accResp, aiPlayers);
    }

    /**
     * Handles a request made by an AI player.
     *
     * @param obj Object signaling an action.
     * @param robot AI instance that triggered the action.
     */
    public void reactToRobot(ClientRequest obj, AI robot)
    {
        /**
         * Using the robots Map find the Game instance of the AI robot.
         */

        /**
         * Check instanceOf obj to determine what change needs to be made the AI
         * Players Game instance.
         *
         * If the Object obj instance designates an action that a human player
         * must respond to, construct an ActionResponse Object and send out
         * using the forwardMessage() function and this will call
         * (sendMessageToClient()).
         *
         * Notify all Clients that the Game instance has changed.
         * forwardMessage() and this will call (sendMessageToClients()).
         */
    }

    public void informAI(Object obj, List<AI> ai)
    {
        for (AI bot : ai)
        {
            informAI(obj, ai);
        }
    }

    public void informAI(Object obj, AI ai)
    {

    }

    /**
     * Provides a hook to send a single message to a networked client.
     *
     * @param obj Object to send to network hooks
     * @param client The connection to send the object to
     */
    public void forwardMessage(Object obj, ConnectionToClient client)
    {
        network.sendMessageToClient(obj, client);
    }

    /**
     * Provides a hook to send Objects to a networked client.
     *
     * @param obj Object to send to network hooks
     * @param clients The connections to send the object to
     */
    public void forwardMessage(Object obj, List<ConnectionToClient> clients)
    {
        /**
         * Determine the instance of this object if the object instance requires
         * notifying all clients then call ServerNetwork.sendMessageToClients().
         * If only one client needs to be notified by the response then call
         * ServerNetwork.sendMessageToClient().
         */
        network.sendMessageToClients((ServerResponse) obj, clients);
    }

    private boolean isHuman(ServerPlayer player)
    {
        return humans.containsKey(player);
    }

    private CopyOnWriteArrayList<ConnectionToClient> getGameClients(
            Integer gameId)
    {
        Game game = gameIdToGame.get(gameId);

        return this.players.get(game);
    }

    public Integer getLobbyId(ConnectionToClient client)
    {
        return games.get(client).getGameId();
    }

    /**
     * Using the provided Game instance deal hint cards to the Server Players.
     * Deal out all HintCards for the Game instance. Deal out one ActionCard to
     * each player
     *
     * @TODO also send out a GameStateResponse??
     * @param game
     */
    private void handleGameStartRequest(Game game)
    {
        ArrayList<ArrayList<Card>> playerHands = new ArrayList<>();

        //Get all players in game
        List<ServerPlayer> gameServerPlayers = game.getServerPlayersList();

        Integer playerCount = gameServerPlayers.size();

        for (ServerPlayer serverPlayer : gameServerPlayers)
        {
            playerHands.add(new ArrayList<Card>());
        }

        //Deal out all hint cards
        for (int index = 0; game.getHintCardsSize() > 0; index++)
        {
            playerHands.get(index % (playerCount - 1)).add(game.popHintCard());
        }

        //Add one action card to each hand.
        for (ArrayList<Card> alc : playerHands)
        {
            alc.add(game.popActionCard());
        }

        for (ServerPlayer serverPlayer : gameServerPlayers)
        {
            CardDealResponse msg = new CardDealResponse(playerHands.remove(0));
            if (!humans.containsKey(serverPlayer))
            {
                //Send to AI
                informAI(msg, robots.get(serverPlayer));
            }
            else
            {
                //Send to human
                forwardMessage(msg, humans.get(serverPlayer));
            }
        }

    }

    private void handleAllSnoop(AllSnoop card, List<ServerPlayer> players)
    {
        for (int playerNum = 0; playerNum < players.size(); playerNum++)
        {
            ServerPlayer curPlayer = players.get(playerNum);
            ServerPlayer otherPlayer;
            if (!card.getDirection())
            {
                if (playerNum == 0)
                {
                    otherPlayer = players.get(players.size() - 1);
                }
                else
                {
                    otherPlayer = players.get(playerNum - 1);
                }
            }
            else
            {
                otherPlayer = players.get((playerNum + 1) % players.size());
            }

            List<HintCard> cards = otherPlayer.getHintCardsHand();
            List<Card> revealed = new ArrayList<Card>();
            Integer randomCard = new Random().nextInt(
                    otherPlayer.getHintCardsHand().size());

            revealed.add(otherPlayer.getHintCardsHand().get(randomCard));
            RevealCardResponse response 
                    = new RevealCardResponse(card, revealed);
            forwardMessage(response, humans.get(curPlayer));
        }
    }

    private void handlePrivateTip()
    {

    }

    private void handleSnoop(Snoop card, Integer playerId, 
            ConnectionToClient connection)
    {
        // Get the requestor's game
        Game curGame = games.get(connection);
        ServerPlayer opponent = curGame.getServerPlayers().get(playerId);
        Integer randomCard = new Random().nextInt(
                opponent.getHintCardsHand().size());

        List<Card> snoopedCards = new ArrayList();
        snoopedCards.add(opponent.hintCardsHand.get(randomCard));
        // Find the player with the given ID
        RevealCardResponse response 
                = new RevealCardResponse(card, snoopedCards);
        
    }

    private void handleSuggestion()
    {

    }

    private void handleSuperSleuth()
    {

    }

    private void handleActionRequest(ActionRequest actionReq,
            ConnectionToClient connection)
    {
        ActionCard card = actionReq.getActionCard();
        //Get the players game
        Game game = games.get(connection);
        List<ServerPlayer> players = game.getServerPlayersList();

        if (card instanceof AllSnoop)
        {
            AllSnoop allSnoopCard = (AllSnoop) card;
            handleAllSnoop(allSnoopCard, players);
        }
        else if (card instanceof PrivateTip)
        {
            handlePrivateTip();
        }
        else if (card instanceof Snoop)
        {
            Snoop snoopCard = (Snoop) card;
            handleSnoop(snoopCard, actionReq.getPlayerId(), connection);
        }
        else if (card instanceof Suggestion)
        {
            handleSuggestion();
        }
        else if (card instanceof SuperSleuth)
        {
            handleSuperSleuth();
        }
    }
}
