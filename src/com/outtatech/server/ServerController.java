package com.outtatech.server;

import com.lloseng.ocsf.server.ConnectionToClient;
import com.outtatech.client.messaging.*;
import com.outtatech.common.*;
import com.outtatech.server.messaging.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
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
    private Map<ConnectionToClient, ServerPlayer> connectionToPlayer;
    //maybe mapped differently? AI are serverplayers
    private Map<ServerPlayer, AI> robots;
    private Map<Integer, Lobby> lobbies;
    private ServerNetwork network;

    private int gameCounter = 1;
    private int playerCounter = 1;
    private int robotCounter = 1;

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
        this.connectionToPlayer
                = new ConcurrentHashMap<ConnectionToClient, ServerPlayer>();
        this.games = new ConcurrentHashMap<ConnectionToClient, Game>();
        this.players
                = new ConcurrentHashMap<Game, CopyOnWriteArrayList<ConnectionToClient>>();
        this.humans = new ConcurrentHashMap<ServerPlayer, ConnectionToClient>();
        this.robots = new ConcurrentHashMap<ServerPlayer, AI>();
        this.lobbies = new ConcurrentHashMap<Integer, Lobby>();
        this.gameIdToGame = new ConcurrentHashMap<Integer, Game>();

        try
        {
            network.listen();
        }
        catch (IOException ex)
        {
            System.err.println(ex.getMessage());
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
            handleActionRequest(actionReq, connectionToPlayer.get(connection));
        }
        /*
         * AccusationRequest respond with AccusationResponse
         */
        else if (obj instanceof AccusationRequest)
        {
            AccusationRequest accusationReq = (AccusationRequest) obj;
            handleAccusation(connectionToPlayer.get(connection), accusationReq);
        }
        /*
         * SuggestionRequest respond with SuggestionResponse
         */
        else if (obj instanceof SuggestionRequest)
        {
            SuggestionRequest suggestionReq = (SuggestionRequest) obj;
            handleSuggestion(suggestionReq, connectionToPlayer.get(connection),
                    games.get(connection));
        }
        /*
         * AddAIRequest respond with AddAIResponse
         */
        else if (obj instanceof AddAIRequest)
        {
            AddAIRequest addAIReq = (AddAIRequest) obj;
            // Get the requestor's lobby
            Lobby lobby = lobbies.get(addAIReq.getLobbyId());
            // Get the game associated with the lobby
            Game lobbyGame = gameIdToGame.get(lobby.getGameId());

            if (lobbyGame.getPlayers().size() >= 5)
            {
                return;
            }

            ServerPlayer newPlayer = new AI(addAIReq.getDifficulty(), this,
                    games.get(connection));
            newPlayer.setName("ClueBot" + this.robotCounter++);
            robots.put(newPlayer, (AI) newPlayer);

            // Add the AI
            lobbyGame.addServerPlayer(newPlayer);
            // Inform game players

            List<Player> players = lobbyGame.getPlayers();
            Map<Integer, String> names = new HashMap<Integer, String>();
            for (Player temp : players)
            {
                names.put(temp.getPlayerId(), temp.getName());
            }

            informPlayers(lobbyGame, new LobbyJoinResponse(lobby,
                    newPlayer.getPlayerId(), names));
        }

        /*
         * LobbyJoinRequest respond with LobbyJoinResponse
         * notify all clients.
         */
        else if (obj instanceof LobbyJoinRequest)
        {
            System.out.println("Got LobbyJoinRequest");
            Lobby lobby = lobbies.get(((LobbyJoinRequest) obj).getLobbyId());
            Game game = gameIdToGame.get(lobby.getGameId());

            if (game.getPlayers().size() >= 5)
            {
                return;
            }

            ServerPlayer serverPlayer = new ServerPlayer();
            serverPlayer.setName("CluePlayer" + this.playerCounter++);
            this.humans.put(serverPlayer, connection);
            this.connectionToPlayer.put(connection, serverPlayer);
            games.put(connection, game);

            List<ConnectionToClient> cxns = this.getGameClients(
                    lobby.getLobbyId());
            cxns.add(connection);

            game.addServerPlayer(serverPlayer);

            List<Player> players = game.getPlayers();
            Map<Integer, String> names = new HashMap<Integer, String>();
            for (Player temp : players)
            {
                names.put(temp.getPlayerId(), temp.getName());
            }

            for (ConnectionToClient temp : cxns)
            {
                System.out.println(temp.getId());
            }

            forwardMessage(new LobbyJoinResponse(lobby,
                    serverPlayer.getPlayerId(), names), cxns);
        }

        /**
         * LobbyCreateRequest respond with LobbyCreateResponse else if
         */
        else if (obj instanceof LobbyCreateRequest)
        {
            System.out.println("recieved lobby create from: " + connection.getId());
            LobbyCreateRequest lcr = (LobbyCreateRequest) obj;
            Game game = new Game();
            Lobby lobby = new Lobby(lcr.getLobbyName() + gameCounter++,
                    game.getGameId(), true);
            games.put(connection, game);
            gameIdToGame.put(game.getGameId(), game);
            lobbies.put(game.getGameId(), lobby);
            players.put(game, new CopyOnWriteArrayList<ConnectionToClient>());

            //@TODO Only the requesting client will be updated.  Other clients
            //will need to send a lobby discovery response to refresh.
            forwardMessage(new LobbyCreateResponse(lobby), connection);
            handleLobbyCreateRequestNotification(game);
        }

        /**
         * SinglePlayerGameRequest respond with LobbyJoinResponse else if
         */
        else if (obj instanceof SinglePlayerGameRequest)
        {
            String lobbyName = "single_player_lobby";
            Game game = new Game();
            Lobby lobby = new Lobby(lobbyName, game.getGameId(), false);

            games.put(connection, game);
            gameIdToGame.put(game.getGameId(), game);
            lobbies.put(game.getGameId(), lobby);
            players.put(game, new CopyOnWriteArrayList<ConnectionToClient>());

            ServerPlayer serverPlayer = new ServerPlayer();
            serverPlayer.setName("CluePlayer" + this.playerCounter++);
            game.addServerPlayer(serverPlayer);
            this.humans.put(serverPlayer, connection);
            this.connectionToPlayer.put(connection, serverPlayer);
            List<ConnectionToClient> cxns = this.getGameClients(
                    lobby.getLobbyId());
            cxns.add(this.humans.get(serverPlayer));

            List<Player> players = game.getPlayers();
            Map<Integer, String> names = new HashMap<Integer, String>();
            for (Player temp : players)
            {
                names.put(temp.getPlayerId(), temp.getName());
            }

            forwardMessage(new LobbyJoinResponse(lobby,
                    serverPlayer.getPlayerId(), names), connection);
        }
        else if (obj instanceof KickPlayerRequest)
        {
            Integer playerId = ((KickPlayerRequest) obj).getPlayerId();
            Game game = games.get(connection);
            Player player = game.getServerPlayers().get(playerId);
            this.forwardMessage(new KickPlayerResponse(playerId),
                    players.get(game));
            game.getServerPlayers().remove(playerId);

        }
        else if (obj instanceof LobbyLeaveRequest)
        {
            System.out.println("lobbyleaveRequest");
            for (ConnectionToClient temp : games.keySet())
            {
                System.out.println(temp.getId());
            }

            if (games.containsKey(connection))
            {
                System.out.println("removing connection " + connection.getId());
                Game game = games.get(connection);
                ServerPlayer player = connectionToPlayer.get(connection);
                int playerId = player.getPlayerId();
                game.getServerPlayers().remove(playerId);
                games.remove(connection);
                players.get(game).remove(connection);
                connectionToPlayer.remove(connection);
                humans.remove(player);
                if (game.getServerPlayers().size() == 0)
                {
                    gameIdToGame.remove(game.getGameId());
                    players.remove(game);
                    lobbies.remove(game.getGameId());
                }
                else
                {
                    this.forwardMessage(new LobbyLeaveResponse(playerId),
                            players.get(game));
                }
            }
        }

        /**
         *
         */
        else if (obj instanceof GameStartRequest)
        {
            Game game = games.get(connection);
            Lobby lobby = lobbies.get(game.getGameId());
            handleGameStartRequest(game, lobby, connection);
            dealActionCard(game);
        }
        /**
         *
         */
        else if (obj instanceof GameStateRequest)
        {
            this.handleGameStateRequest(games.get(connection), connection);
        }
        /**
         * else if EndTurnRequest respond with GameStateResponse
         */
        else if (obj instanceof EndTurnRequest)
        {
            EndTurnRequest endTurnReq = (EndTurnRequest) obj;
            handleEndTurnRequest(games.get(connection), connectionToPlayer.get(
                    connection));
//            forwardMessage(new GameStateResponse()), connection, false);
        }
    }

    void handleEndTurnRequest(Game game, ServerPlayer initiator)
    {
        game.advanceTurn();
        dealActionCard(game);
    }

    /**
     * Given a player and a message, distribute the message to AI or Human
     *
     * @param player
     * @param msg
     */
    private void informPlayer(ServerPlayer player, ServerResponse msg)
    {
        if (player instanceof AI)
        {
            AI aiPlayer = (AI) player;
            informAI(msg, aiPlayer);
        }
        else
        {
            forwardMessage(msg, humans.get(player));
        }
    }

    /**
     * Given a game and a message, distributes the message to AI and Players
     *
     * @param game the game that contains the players the msg should be sent to
     * @param msg the message that should be sent to the players in the game
     */
    private void informPlayers(List<ServerPlayer> gameServerPlayers,
            ServerResponse msg)
    {
        ArrayList<ConnectionToClient> gamePlayers
                = new ArrayList<ConnectionToClient>();

        ArrayList<AI> aiPlayers = new ArrayList<AI>();

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
        //informAI(msg, aiPlayers);
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
        //informAI(msg, aiPlayers);
    }

    private class Refutation {
        public Integer playerId;
        public HintCard card;
        public Refutation(Integer playerId, HintCard card)
        {
            this.playerId = playerId;
            this.card = card;
        }
    }

    private Refutation findRefutingCard(List<ServerPlayer> gameServerPlayers,
            Solution guess)
    {

        for (ServerPlayer player : gameServerPlayers)
        {
            for (HintCard card : player.getHintCardsHand())
            {
                if (card instanceof DestinationCard)
                {
                    DestinationCard dest = (DestinationCard) card;
                    if (dest.getDestination().equals(guess.getDestination()))
                    {
                        return new Refutation(player.getPlayerId(), dest);
                    }
                }
                else if (card instanceof SuspectCard)
                {
                    SuspectCard susp = (SuspectCard) card;
                    if (susp.getSuspect().equals(guess.getSuspect()))
                    {
                        return new Refutation(player.getPlayerId(), susp);
                    }
                }
                else if (card instanceof VehicleCard)
                {
                    VehicleCard vehicle = (VehicleCard) card;
                    if (vehicle.getVehicle().equals(guess.getVehicle()))
                    {
                        return new Refutation(player.getPlayerId(), vehicle);
                    }
                }
            }
        }

        return null;
    }

    private void handleSuggestion(SuggestionRequest suggestionReq,
            ServerPlayer player, Game clientGame)
    {
        //Get all players in game, except the accusor
        List<ServerPlayer> gameServerPlayers
                = clientGame.getServerPlayersList();

        gameServerPlayers.remove(player);

        // Get the suggestion out of the request
        Suggestion suggestion = suggestionReq.getCard();

        // Get the suggestion type
        SuggestionType suggType = suggestion.getType();

        // Get the suggestion solution
        Solution suggestedSol = suggestionReq.getSuggestion();

        // Move the players location
        moveLocation(player, suggestionReq.getDestination());

        // See if anyone has a card to refute the suggestion
        Refutation refutation = findRefutingCard(gameServerPlayers,
                suggestionReq.getSuggestion());
        Integer refutingPlayerID = null;
        HintCard refutingCard = null;
        if (refutation != null)
        {
            refutingPlayerID = refutation.playerId;
            refutingCard = refutation.card;
        }

        // Response to send everyone but the accusor
        SuggestionResponse respAll
                = new SuggestionResponse(player.getPlayerId(),
                        refutingPlayerID, null, suggestionReq.getSuggestion());

        // Response to send the accusor
        SuggestionResponse respAccusor = new SuggestionResponse(player.
                getPlayerId(),
                refutingPlayerID, refutingCard, suggestionReq.getSuggestion());

        // Send everyone but the accusor a suggestion response with a null refutingCard
        informPlayers(gameServerPlayers, respAll);

        List<ServerPlayer> accusorList = new ArrayList<ServerPlayer>();
        accusorList.add(player);

        informPlayers(accusorList, respAccusor);

        //Remove the action card from the players hand
        player.removeActionCard(suggestionReq.getCard());

    }

    private void handleAccusation(ServerPlayer fromPlayer,
            AccusationRequest accusationReq)
    {
        Game clientGame;
        Solution accusation = accusationReq.getSolution();
        //Get players game
        if (fromPlayer instanceof AI)
        {
            AI aiPlayer = (AI) fromPlayer;
            clientGame = aiPlayer.getGame();
        }
        else
        {
            clientGame = games.get(humans.get(fromPlayer));
        }

        //Get all players in game
        List<ServerPlayer> gameServerPlayers
                = clientGame.getServerPlayersList();

        Solution sol = clientGame.getSolution();
        //Create accusation response
        AccusationResponse accResp = new AccusationResponse(accusation,
                accusation.equals(clientGame.getSolution()), fromPlayer.getPlayerId());

        informPlayers(gameServerPlayers, accResp);
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
        System.out.println("Recieved a message from the AI");
        if (obj instanceof ActionRequest)
        {
            System.out.println("Recieved an ActionRequest");
            ActionRequest rqst = (ActionRequest) obj;
            Game game = robot.getGame();
            List<ServerPlayer> players = game.getServerPlayersList();
            handleActionRequest(rqst, (ServerPlayer) robot);
        }
        else if (obj instanceof AccusationRequest)
        {
            System.out.println("AccusationRequest");
            AccusationRequest accusationReq = (AccusationRequest) obj;
            handleAccusation(robot, accusationReq);
        }
        else if (obj instanceof EndTurnRequest)
        {
            System.out.println("EndTurnRequest");
            EndTurnRequest rqst = (EndTurnRequest) obj;
            handleEndTurnRequest(robot.getGame(), robot);
        }
        else if (obj instanceof SuggestionRequest)
        {
            System.out.println("SuggestionRequest");
            SuggestionRequest rqst = (SuggestionRequest) obj;
            handleSuggestion(rqst, robot, robot.getGame());
        }
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
        System.out.println("Informing the AI about " + obj);
        ai.reactToServer(obj);
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
    private void handleGameStartRequest(Game game, Lobby lobby,
            ConnectionToClient connection)
    {
        game.initialize();

        // Get all players in game
        List<ServerPlayer> gameServerPlayers = game.getServerPlayersList();

        // Deal out all hint cards
        Integer playerCount = gameServerPlayers.size();
        for (int index = 0; game.getHintCardsSize() > 0; index++)
        {
            gameServerPlayers.get(index % playerCount).addHintCard(game.
                    popHintCard());
        }

        // Add one action card to each hand.
        for (ServerPlayer pl : gameServerPlayers)
        {
            pl.addActionCard(game.popActionCard());
        }

        for (ServerPlayer pl : gameServerPlayers)
        {
            GameStateResponse gameResponse = new GameStateResponse(
                    game.getDrawPile().size(), game.getPlayerIdTurnOrder(),
                    game.getCurrentPlayerIndex(), game.getPlayerIdNames(),
                    pl.getHintCardsHand(),
                    pl.getActionCardsHand(),
                    game.getDestToPlayerId());
            informPlayer(pl, gameResponse);
        }

        // Remove lobby when game starts
        lobbies.remove(game.getGameId());
    }

    private void handleGameStateRequest(Game game, ConnectionToClient cxn)
    {
        ServerPlayer serverPlayer = connectionToPlayer.get(cxn);
        this.forwardMessage(new GameStateResponse(
                game.getDrawPile().size(), game.getPlayerIdTurnOrder(),
                game.getCurrentPlayerIndex(), game.getPlayerIdNames(),
                serverPlayer.getHintCardsHand(),
                serverPlayer.getActionCardsHand(),
                game.getDestToPlayerId()), cxn);
    }

    private void handleAllSnoop(AllSnoop card, List<ServerPlayer> players)
    {
        System.out.println("Handling all snoop!");
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

            System.out.println("Got through player directions");

            List<HintCard> cards = otherPlayer.getHintCardsHand();
            List<Card> revealed = new ArrayList<Card>();
            Integer randomCard = new Random().nextInt(
                    otherPlayer.getHintCardsHand().size());

            revealed.add(otherPlayer.getHintCardsHand().get(randomCard));
            RevealCardResponse response
                    = new RevealCardResponse(card, revealed);

            if (humans.containsKey(curPlayer))
            {
                forwardMessage(response, humans.get(curPlayer));
            }
            else
            {
                informAI(response, (AI) curPlayer);
            }
        }
    }

    private void handlePrivateTip(PrivateTip card, Integer playerId,
            ServerPlayer player, boolean isAI)
    {
        System.out.println("Handling private tip");

        // Get the requestor's game
        ConnectionToClient connection = null;
        Game curGame;
        if (humans.containsKey(player))
        {
            connection = humans.get(player);
        }
        if (!isAI)
        {
            curGame = games.get(connection);
        }
        else
        {
            curGame = ((AI) player).getGame();
        }
        ServerPlayer opponent = curGame.getServerPlayers().get(playerId);

        // List playableCards to return
        ArrayList<Card> playableCards = new ArrayList();
        List<HintCard> hintCardsHand = opponent.getHintCardsHand();
        PrivateTipType privateTipType = card.getType();

        for (int cardInHand = 0; cardInHand < hintCardsHand.size();
                cardInHand++)
        {
            HintCard curHintCard = hintCardsHand.get(cardInHand);
            HintCardType curHintType = hintCardsHand.get(cardInHand).
                    getHintType();

            switch (privateTipType)
            {
                case ALL_DESTINATIONS:
                    if (curHintType == HintCardType.DESTINATION)
                    {
                        playableCards.add(curHintCard);
                    }
                    break;
                case ALL_VEHICLES:
                    if (curHintType == HintCardType.VEHICLE)
                    {
                        playableCards.add(curHintCard);
                    }
                    break;
                case ALL_SUSPECTS:
                    if (curHintType == HintCardType.SUSPECT)
                    {
                        playableCards.add(curHintCard);
                    }
                    break;
                case ONE_FEMALE_SUSPECT:
                    if (curHintType == HintCardType.SUSPECT)
                    {
                        if (((SuspectCard) curHintCard).getGender()
                                == Gender.FEMALE)
                        {
                            playableCards.add(curHintCard);
                        }
                    }
                    break;
                case ONE_NORTHERN_DESTINATION:
                    if (curHintType == HintCardType.DESTINATION)
                    {
                        if (((DestinationCard) curHintCard).getIsNorth())
                        {
                            playableCards.add(curHintCard);
                        }

                    }
                    break;
                case ONE_RED_VEHICLE:
                    if (curHintType == HintCardType.VEHICLE)
                    {
                        if (((VehicleCard) curHintCard).getCardColor()
                                == CardColor.RED)
                        {
                            playableCards.add(curHintCard);
                        }
                    }
                    break;
            }
        }

        List<Card> revealed = new ArrayList<Card>();
        Integer randomCard;

        if (playableCards.size() > 0)
        {
            switch (privateTipType)
            {
                case ALL_DESTINATIONS:
                    revealed.addAll(playableCards);
                    break;
                case ALL_VEHICLES:
                    revealed.addAll(playableCards);
                    break;
                case ALL_SUSPECTS:
                    revealed.addAll(playableCards);
                    break;
                case ONE_FEMALE_SUSPECT:
                    randomCard = (int) (Math.random() * playableCards.size());
                    System.out.println(randomCard);
                    revealed.add(playableCards.get(randomCard));
                    break;
                case ONE_NORTHERN_DESTINATION:
                    randomCard = (int) (Math.random() * playableCards.size());
                    System.out.println(randomCard);
                    revealed.add(playableCards.get(randomCard));
                    break;
                case ONE_RED_VEHICLE:
                    randomCard = (int) (Math.random() * playableCards.size());
                    System.out.println(randomCard);
                    revealed.add(playableCards.get(randomCard));
                    break;
            }

            System.out.println("Made it out of the second switch!");

            // Create a new CardDealResponse
            RevealCardResponse response = new RevealCardResponse(card, revealed);
            if (!isAI)
            {
                System.out.println("sending to player");
                forwardMessage(response, connection);
            }
            else
            {
                System.out.println("sending to AI");
                informAI(response, robots.get(player));
            }
        }
    }

    private void handleSnoop(Snoop card, Integer playerId,
            ServerPlayer player, boolean isAI)
    {
        System.out.println("Handling Snoop!");
        // Get the requestor's game
        ConnectionToClient connection = null;
        Game curGame;

        if (humans.containsKey(player))
        {
            connection = humans.get(player);
        }
        if (!isAI)
        {
            curGame = games.get(connection);
        }
        else
        {
            curGame = ((AI) player).getGame();
        }
        ServerPlayer opponent = curGame.getServerPlayers().get(playerId);
        Integer randomCard = new Random().nextInt(
                opponent.getHintCardsHand().size());

        List<Card> snoopedCards = new ArrayList();
        snoopedCards.add(opponent.hintCardsHand.get(randomCard));
        // Find the player with the given ID
        RevealCardResponse response
                = new RevealCardResponse(card, snoopedCards);

        if (!isAI)
        {
            forwardMessage(response, connection);
        }
        else
        {
            informAI(response, robots.get(player));
        }

    }

    private void handleSuperSleuth(SuperSleuth sleuthCard,
            ServerPlayer player, boolean isAI)
    {
        System.out.println("Handling Super Sleuth");
        // Get the requestor's game
        ConnectionToClient connection = null;
        Game curGame;

        if (humans.containsKey(player))
        {
            connection = humans.get(player);
        }
        if (!isAI)
        {
            curGame = games.get(connection);
        }
        else
        {
            curGame = ((AI) player).getGame();
        }
        List<ServerPlayer> opponents = curGame.getServerPlayersList();
        opponents.remove(player);
        List<Card> revealedCards = new ArrayList<Card>();
        // List playableCards to return
        for (ServerPlayer opponent : opponents)
        {
            ArrayList<HintCard> playableCards = new ArrayList();
            List<HintCard> hintCardsHand = opponent.getHintCardsHand();
            SuperSleuthType sleuthType = sleuthCard.getType();

            for (int cardInHand = 0; cardInHand < hintCardsHand.size();
                    cardInHand++)
            {
                HintCard curHintCard = hintCardsHand.get(cardInHand);
                HintCardType curHintType = hintCardsHand.get(cardInHand).
                        getHintType();

                switch (sleuthType)
                {
                    case AIR_VEHICLE:
                        if (curHintType == HintCardType.VEHICLE)
                        {
                            if (((VehicleCard) curHintCard).getIsAir())
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    case BLUE_CARD:
                        if (curHintType == HintCardType.VEHICLE)
                        {
                            VehicleCard vehicleHint = (VehicleCard) curHintCard;
                            if (vehicleHint.getCardColor() == CardColor.BLUE)
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    case FEMALE_SUSPECT:
                        if (curHintType == HintCardType.SUSPECT)
                        {
                            if (((SuspectCard) curHintCard).getGender()
                                    == Gender.FEMALE)
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                    break;
                    case MALE_SUSPECT:
                        if (curHintType == HintCardType.SUSPECT)
                        {
                            if (((SuspectCard) curHintCard).getGender()
                                    == Gender.MALE)
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    case SOUTHERN_DESTINATION:
                        if (curHintType == HintCardType.DESTINATION)
                        {
                            if (!((DestinationCard) curHintCard).getIsNorth())
                            {
                                playableCards.add(curHintCard);
                            }

                        }
                    break;
                    case WESTERN_DESTINATION:
                        if (curHintType == HintCardType.DESTINATION)
                        {
                            if (((DestinationCard) curHintCard).getIsWest())
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                }
            }
            revealedCards.addAll(playableCards);
        }

        RevealCardResponse response = new RevealCardResponse(sleuthCard,
                revealedCards);
        if (!isAI)
        {
            forwardMessage(response, connection);
        }
        else
        {
            informAI(response, robots.get(player));
        }

    }

    private void handleActionRequest(ActionRequest actionReq,
            ServerPlayer player)
    {
        System.out.println("handling Action Request!");
        boolean isAI = true;
        Game game;
        ConnectionToClient connection = null;

        if (humans.containsKey(player))
        {
            System.out.println("Action Player was a human");
            connection = humans.get(player);
            isAI = false;
        }

        ActionCard card = actionReq.getActionCard();

//Get the players game
        if (!isAI)
        {
            game = games.get(connection);
        }
        else
        {
            game = ((AI) player).getGame();
        }
        List<ServerPlayer> players = game.getServerPlayersList();

        System.out.println("Got the Action Card " + card.getActionType());

        if (card instanceof AllSnoop)
        {
            System.out.println("AllSnoop");
            AllSnoop allSnoopCard = (AllSnoop) card;
            handleAllSnoop(allSnoopCard, players);
        }
        else if (card instanceof PrivateTip)
        {
            System.out.println("PrivateTip");
            PrivateTip privTipCard = (PrivateTip) card;
            handlePrivateTip(privTipCard, actionReq.getPlayerId(), player, isAI);
        }
        else if (card instanceof Snoop)
        {
            System.out.println("Snoop");
            Snoop snoopCard = (Snoop) card;
            handleSnoop(snoopCard, actionReq.getPlayerId(), player, isAI);
        }
        else if (card instanceof SuperSleuth)
        {
            System.out.println("SuperSleuth");
            SuperSleuth superSleuthCard = (SuperSleuth) card;
            handleSuperSleuth(superSleuthCard, player, isAI);
        }
        else if (card instanceof Suggestion)
        {
            System.out.println("Not implemented yet!");
        }

        player.removeActionCard(card);
        game.discardActionCard(card);
    }

    /**
     * <<<<<<< HEAD Deal an action card to the current active player in game by
     * adding a card to their ServerPlayer hand and sending a message. =======
     * Deal an action card to the current active player in game by adding a card
     * to their ServerPlayer hand and sending a message. >>>>>>>
     * 983e08ff407cdb233c3d4737c61d0632f3222714
     *
     * @param game the game with the player to deal an action card to.
     */
    private void dealActionCard(Game game)
    {
        System.out.println("server: dealActionCard: " + game);
        ServerPlayer player = game.getCurrentPlayer();
        System.out.println("server: current player index: " + game.getCurrentPlayerIndex());
        System.out.println("server: current player: " + player.getName());

        ActionCard newCard = null;
        if (player.getActionCardsHand().size() < 2)
        {
            List<ActionCard> drawCards = new ArrayList<ActionCard>();
            newCard = game.getDrawPile().remove(0);
            System.out.println("server: dealing card: " + newCard);
        }

        // Add the card to the server player's hand if they're not an AI
        // AI will take care of this themselves.
        if (!(player instanceof AI))
        {
            player.addActionCard(newCard);
        }

        ServerResponse response = new CardDealResponse(newCard);
        informPlayer(player, response);
    }

    /**
     * Swaps a players location if necessary
     *
     * @param player the player who wants their destination changed
     * @param destination the destination the player would like to move to
     */
    private void moveLocation(ServerPlayer player, DestinationID destination)
    {
        Game game;
        // Find out who has the destination
        // First get the current player's game
        if (player instanceof AI)
        {
            AI playerAI = (AI) player;
            game = playerAI.getGame();
        }
        else
        {
            ConnectionToClient playerConn = humans.get(player);
            game = games.get(playerConn);
        }
        DestinationID curDest = game.getPlayerIdToDest().get(player.getPlayerId());

        if (game == null)
        {
            System.out.println("Game could not be found in moveLocation");
            return;
        }

        //Swap locations
        game.swapLocations(player.getPlayerId(), destination);

        //Build a list of playerIDs
        List<Integer> playerTurnOrder = new ArrayList<Integer>();

        for (ServerPlayer activePlayer : game.getPlayerTurnOrder())
        {
            playerTurnOrder.add(activePlayer.getPlayerId());
        }

        GameStateResponse newGameState = new GameStateResponse(game.
                getDrawPile().size(), playerTurnOrder, game.
                getCurrentPlayerIndex(), game.getPlayerIdNames(),
                null, game.getDrawPile(), game.getDestToPlayerId());

        informPlayers(game, newGameState);
    }
    
    private void handleLobbyCreateRequestNotification(Game game)
    {
        System.out.println("sending lobby notifications");
        List<Lobby> publicLobbies = new ArrayList<Lobby>();
        for (Lobby lobby : lobbies.values())
        {
            if (lobby.isVisible())
            {
                publicLobbies.add(lobby);
            }
        }

        LobbyDiscoveryResponse ldr = new LobbyDiscoveryResponse(publicLobbies);
        
        //Sending to all, may be risky if a client 
        //is not ignoring messages from a incorrect state.
        network.sendToAllClients(ldr);
    }
}
