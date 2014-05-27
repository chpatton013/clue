package com.outtatech.server;

import com.lloseng.ocsf.server.ConnectionToClient;
import com.outtatech.client.messaging.*;
import com.outtatech.common.*;
import com.outtatech.server.messaging.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Version-latenightpizzaparty
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
    private Map<ServerPlayer, Lobby> waiting;
    private ServerNetwork network;

    /**
     * Version-latenightpizzaparty
     * Construct a ServerController object. A ServerController instance can be
     * used to facilitate changes to multiple Game instances with many different
     * Client connections and any AI players.
     *
     * @param network method parameter
     */
    public ServerController(ServerNetwork network)
    {
        this.network = network;
        this.network.setServerController(this);
        this.connectionToPlayer
            = new HashMap<ConnectionToClient, ServerPlayer>();
        this.games = new HashMap<ConnectionToClient, Game>();
        this.players
            = new HashMap<Game, CopyOnWriteArrayList<ConnectionToClient>>();
        this.humans = new HashMap<ServerPlayer, ConnectionToClient>();
        this.robots = new HashMap<ServerPlayer, AI>();
        this.lobbies = new HashMap<Integer, Lobby>();
        this.gameIdToGame = new HashMap<Integer, Game>();

        // Just in case...
        try
        {
            network.listen();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Version-latenightpizzaparty
     * Handle a network request from a client.
     *
     * @param obj Object signaling an action. method parameter
     * @param connection ConnectionToClient used to respond back to client.
     * method parameter
     */
    public void reactToNetwork(Object obj, ConnectionToClient connection)
    {
        // Guard against this
        if (obj instanceof EndTurnRequest)
        {
            EndTurnRequest rqst = (EndTurnRequest) obj;
            Game game = games.get(connection);
            handleEndTurnRequest(game, connectionToPlayer.get(connection));
        }
        /**
         * Version-latenightpizzaparty
         * Check the Object obj with the instanceOf (io) method if instanceOf
         * LobbyListRequest respond with LobbyDiscoveryResponse else if
         */
        // Guard against this
        if (obj instanceof LobbyListRequest)
        {
            List<Lobby> publicLobbies = new ArrayList<Lobby>();
            // Iterate over this set
            for (Lobby lobby : lobbies.values())
            {
                // Guard against this
                if (lobby.isVisible())
                {
                    publicLobbies.add(lobby);
                }
            }
            // Iterate over this set
            forwardMessage(new LobbyDiscoveryResponse(publicLobbies),
                    connection);
        }
        // Otherwise...
        else if (obj instanceof ActionRequest)
        {
            ActionRequest actionReq = (ActionRequest) obj;
            handleActionRequest(actionReq, connection);
        }
        /*
         * AccusationRequest respond with AccusationResponse
         */
        // Otherwise...
        else if (obj instanceof AccusationRequest)
        {
            AccusationRequest accusationReq = (AccusationRequest) obj;
            handleAccusation(accusationReq, connection);
        }
        /*
         * SuggestionRequest respond with SuggestionResponse
         */
        // Otherwise...
        else if (obj instanceof SuggestionRequest)
        {
            SuggestionRequest suggestionReq = (SuggestionRequest) obj;
            handleSuggestion(suggestionReq, connection);
        }
        /*
         * AddAIRequest respond with AddAIResponse
         */
        // Otherwise...
        else if (obj instanceof AddAIRequest)
        {
            AddAIRequest addAIReq = (AddAIRequest) obj;
            int num = games.get(connection).getPlayers().size();
            ServerPlayer newPlayer = new AI(addAIReq.getDifficulty(), this,
                    games.get(connection));
            newPlayer.setName("CLUEBot" + num);

            // Get the requestor's lobby
            Lobby lobby = lobbies.get(addAIReq.getLobbyId());
            // Get the game associated with the lobby
            Game lobbyGame = gameIdToGame.get(lobby.getGameId());
            // Add the AI
            lobbyGame.addServerPlayer(newPlayer);
            // Inform game players

            List<Player> players = lobbyGame.getPlayers();
            Map<Integer, String> names = new HashMap<Integer, String>();
            // Iterate over this set
            for (Player temp : players)
            {
                names.put(temp.getPlayerId(), temp.getName());
            }

            informPlayers(lobbyGame, new LobbyJoinResponse(lobby,
                    newPlayer.getPlayerId(), names));
        }

        // Otherwise...
        else if (obj instanceof KickPlayerRequest)
        {
            KickPlayerRequest rqst = ((KickPlayerRequest) obj);
            Player player = null;
            Game game = games.get(connection);
            List<Player> players = game.getPlayers();
            Map<Integer, ServerPlayer> map = game.getServerPlayers();
            // Iterate over this set
            for (Player temp : players)
            {
                // Guard against this
                if (rqst.getPlayerId() == temp.getPlayerId())
                {
                    map.remove(temp.getPlayerId());
                    player = temp;
                }
            }
            // Iterate over this set
            forwardMessage(new KickPlayerResponse(player.getPlayerId()),
                    connection);
        }

        /*
         * LobbyJoinRequest respond with LobbyJoinResponse
         * notify all clients.
         */
        // Otherwise...
        else if (obj instanceof LobbyJoinRequest)
        {
            Lobby lobby = lobbies.get(((LobbyJoinRequest) obj).getLobbyId());
            ServerPlayer serverPlayer = new ServerPlayer();
            int num = humans.keySet().size();
            serverPlayer.setName("CluePlayer" + (num + 1));
            this.humans.put(serverPlayer, connection);
            this.connectionToPlayer.put(connection, serverPlayer);
            List<ConnectionToClient> cxns = this.getGameClients(
                    lobby.getLobbyId());
            cxns.add(this.humans.get(serverPlayer));

            Game game = gameIdToGame.get(lobby.getGameId());
            game.addServerPlayer(serverPlayer);

            List<Player> players = game.getPlayers();
            Map<Integer, String> names = new HashMap<Integer, String>();
            // Iterate over this set
            for (Player temp : players)
            {
                names.put(temp.getPlayerId(), temp.getName());
            }

            // Iterate over this set
            forwardMessage(new LobbyJoinResponse(lobby,
                    serverPlayer.getPlayerId(), names), cxns);
        }

        /**
         * Version-latenightpizzaparty
         * LobbyCreateRequest respond with LobbyCreateResponse else if
         */
        // Otherwise...
        else if (obj instanceof LobbyCreateRequest)
        {
            LobbyCreateRequest lcr = (LobbyCreateRequest) obj;
            Game game = new Game();
            Lobby lobby = new Lobby(lcr.getLobbyName(), game.getGameId(), true);
            games.put(connection, game);
            gameIdToGame.put(game.getGameId(), game);
            lobbies.put(game.getGameId(), lobby);
            players.put(game, new CopyOnWriteArrayList<ConnectionToClient>());

            // Iterate over this set
            forwardMessage(new LobbyCreateResponse(lobby), connection);
        }

        /**
         * Version-latenightpizzaparty
         * SinglePlayerGameRequest respond with LobbyJoinResponse else if
         */
        // Otherwise...
        else if (obj instanceof SinglePlayerGameRequest)
        {
            String lobbyName = "single_player_lobby";
            Game game = new Game();
            Lobby lobby = new Lobby(lobbyName, game.getGameId(), false);

            games.put(connection, game);
            gameIdToGame.put(game.getGameId(), game);
            lobbies.put(game.getGameId(), lobby);
            players.put(game, new CopyOnWriteArrayList<ConnectionToClient>());

            // Iterate over this set
            forwardMessage(new LobbyCreateResponse(lobby), connection);
        }

        /**
         * Version-latenightpizzaparty
         *
         */
        // Otherwise...
        else if (obj instanceof GameStartRequest)
        {
            handleGameStartRequest(games.get(connection));
        }
        /**
         * Version-latenightpizzaparty
         * @TODO Add a response class? PlayersResponse? List of player names and
         * made up AI names? or Add a list of players to the
         * LobbyDiscoveryResponse?
         */

        // Otherwise...
        else if (obj instanceof GameStateRequest)
        {
            this.handleGameStateRequest(games.get(connection), connection);
        }
        /**
         * Version-latenightpizzaparty
         * else if EndTurnRequest respond with GameStateResponse
         */
        // Otherwise...
        else if (obj instanceof EndTurnRequest)
        {
            EndTurnRequest endTurnReq = (EndTurnRequest) obj;
            handleEndTurnRequest(games.get(connection), connectionToPlayer.get(
                    connection));
//            forwardMessage(new GameStateResponse()), connection, false);
        }
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param game method parameter
     * @param initiator method parameter
     */
    public void handleEndTurnRequest(Game game, ServerPlayer initiator)
    {
        ServerPlayer newCurrent = game.advanceTurn();
        List<Card> drawCards = new ArrayList<Card>();
        drawCards.add(game.getDrawPile().remove(0));
        ServerResponse response = new CardDealResponse(drawCards);
        informPlayer(initiator, response);
    }

    /**
     * Version-latenightpizzaparty
     * Given a player and a message, distribute the message to AI or Human
     *
     * @param player method parameter
     * @param msg method parameter
     */
    private void informPlayer(ServerPlayer player, ServerResponse msg)
    {
        // Guard against this
        if (player instanceof AI)
        {
            AI aiPlayer = (AI) player;
            informAI(msg, aiPlayer);
        }
        // Otherwise...
        else
        {
            // Iterate over this set
            forwardMessage(msg, humans.get(player));
        }
    }

    /**
     * Version-latenightpizzaparty
     * Given a game and a message, distributes the message to AI and Players
     *
     * @param game the game that contains the players the msg should be 
     * sent to method parameter
     * @param msg the message that should be sent to the players in the 
     * game method parameter
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
        // Iterate over this set
        for (ServerPlayer serverPlayer : gameServerPlayers)
        {
            // Guard against this
            if (!humans.containsKey(serverPlayer))
            {
                aiPlayers.add(robots.get(serverPlayer));
            }
            // Otherwise...
            else
            {
                gamePlayers.add(humans.get(serverPlayer));
            }
        }

        // Send all human players in the lobby a LobbyUpdateResponse
        // Iterate over this set
        forwardMessage(msg, gamePlayers);
        //informAI(msg, aiPlayers);
    }

    private HintCard findRefutingCard(List<ServerPlayer> gameServerPlayers,
            Solution guess)
    {

        // Iterate over this set
        for (ServerPlayer player : gameServerPlayers)
        {
            // Iterate over this set
            for (HintCard card : player.getHintCardsHand())
            {
                // Guard against this
                if (card instanceof DestinationCard)
                {
                    DestinationCard dest = (DestinationCard) card;
                    // Guard against this
                    if (dest.getDestination().equals(guess.getDestination()))
                    {
                        return dest;
                    }
                }
                // Otherwise...
                else if (card instanceof SuspectCard)
                {
                    SuspectCard susp = (SuspectCard) card;
                    // Guard against this
                    if (susp.getSuspect().equals(guess.getSuspect()))
                    {
                        return susp;
                    }
                }
                // Otherwise...
                else if (card instanceof VehicleCard)
                {
                    VehicleCard vehicle = (VehicleCard) card;
                    // Guard against this
                    if (vehicle.getVehicle().equals(guess.getVehicle()))
                    {
                        return vehicle;
                    }
                }
            }
        }

        return gameServerPlayers.get(0).getHintCardsHand().get(0);
    }

    private void handleSuggestion(SuggestionRequest suggestionReq,
            ConnectionToClient connection)
    {
        ArrayList<ConnectionToClient> gamePlayers
            = new ArrayList<ConnectionToClient>();
        ArrayList<AI> aiPlayers = new ArrayList<AI>();

        Solution suggestion = suggestionReq.getSuggestion();

        //Get the clients game
        Game clientGame = games.get(connection);

        //Get all players in game
        List<ServerPlayer> gameServerPlayers
            = clientGame.getServerPlayersList();

        //Build a list of human client connections to send accusation
        //response to
        // Iterate over this set
        for (ServerPlayer serverPlayer : gameServerPlayers)
        {
            // Guard against this
            if (!humans.containsKey(serverPlayer))
            {
                aiPlayers.add(robots.get(serverPlayer));
            }
            // Otherwise...
            else
            {
                gamePlayers.add(humans.get(serverPlayer));
            }
        }

        // Guard against this
        if (suggestion.equals(clientGame.getSolution()))
        {
            SuggestionResponse suggResp = new SuggestionResponse(true);

        }
        // Otherwise...
        else
        {
            SuggestionResponse suggResp = new SuggestionResponse(false);
            //Find a refuting card
            HintCard refutingCard = findRefutingCard(gameServerPlayers,
                    suggestion);
            suggResp.setRefutingCard(refutingCard);
            //Send to humans
            // Iterate over this set
            forwardMessage(suggResp, gamePlayers);

            //Send to AI
            informAI(suggResp, aiPlayers);
        }

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
        // Iterate over this set
        for (ServerPlayer serverPlayer : gameServerPlayers)
        {
            // Guard against this
            if (!humans.containsKey(serverPlayer))
            {
                aiPlayers.add(robots.get(serverPlayer));
            }
            // Otherwise...
            else
            {
                gamePlayers.add(humans.get(serverPlayer));
            }
        }

        //Create accusation response
        AccusationResponse accResp = new AccusationResponse(accusation,
                accusation.equals(clientGame.getSolution()));

        //Send to humans
        // Iterate over this set
        forwardMessage(accResp, gamePlayers);

        //Send to AI
        informAI(accResp, aiPlayers);
    }

    /**
     * Version-latenightpizzaparty
     * Handles a request made by an AI player.
     *
     * @param obj Object signaling an action. method parameter
     * @param robot AI instance that triggered the action. method parameter
     */
    public void reactToRobot(ClientRequest obj, AI robot)
    {
        /**
         * Version-latenightpizzaparty
         * Using the robots Map find the Game instance of the AI robot.
         */

        /**
         * Version-latenightpizzaparty
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

    /**
     * Version-latenightpizzaparty
     *
     * @param obj method parameter
     * @param ai method parameter
     */
    public void informAI(Object obj, List<AI> ai)
    {
        // Iterate over this set
        for (AI bot : ai)
        {
            informAI(obj, ai);
        }
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param obj method parameter
     * @param ai method parameter
     */
    public void informAI(Object obj, AI ai)
    {
        ai.reactToServer(obj);
    }

    /**
     * Version-latenightpizzaparty
     * Provides a hook to send a single message to a networked client.
     *
     * @param obj Object to send to network hooks method parameter
     * @param client The connection to send the object to method parameter
     */
    public void forwardMessage(Object obj, ConnectionToClient client)
    {
        network.sendMessageToClient(obj, client);
    }

    /**
     * Version-latenightpizzaparty
     * Provides a hook to send Objects to a networked client.
     *
     * @param obj Object to send to network hooks method parameter
     * @param clients The connections to send the object to method parameter
     */
    public void forwardMessage(Object obj, List<ConnectionToClient> clients)
    {
        /**
         * Version-latenightpizzaparty
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

    /**
     * Version-latenightpizzaparty
     *
     * @param client method parameter
     * @return return value
     */
    public Integer getLobbyId(ConnectionToClient client)
    {
        return games.get(client).getGameId();
    }

    /**
     * Version-latenightpizzaparty
     * Using the provided Game instance deal hint cards to the Server Players.
     * Deal out all HintCards for the Game instance. Deal out one ActionCard to
     * each player
     *
     * @TODO also send out a GameStateResponse??
     * @param game method parameter
     */
    private void handleGameStartRequest(Game game)
    {
        ArrayList<ArrayList<Card>> playerHands = 
                new ArrayList<ArrayList<Card>>();

        //Get all players in game
        List<ServerPlayer> gameServerPlayers = game.getServerPlayersList();

        Integer playerCount = gameServerPlayers.size();

        // Iterate over this set
        for (ServerPlayer serverPlayer : gameServerPlayers)
        {
            playerHands.add(new ArrayList<Card>());
        }

        //Deal out all hint cards
        // Iterate over this set
        for (int index = 0; game.getHintCardsSize() > 0; index++)
        {
            playerHands.get(index % (playerCount)).add(game.popHintCard());
        }

        //Add one action card to each hand.
        // Iterate over this set
        for (ArrayList<Card> alc : playerHands)
        {
            alc.add(game.popActionCard());
        }

        // Iterate over this set
        for (ServerPlayer serverPlayer : gameServerPlayers)
        {
            CardDealResponse msg = new CardDealResponse(playerHands.remove(0));
            // Guard against this
            if (!humans.containsKey(serverPlayer))
            {
                //Send to AI
                //informAI(msg, robots.get(serverPlayer));
            }
            // Otherwise...
            else
            {
                //Send to human
                // Iterate over this set
                forwardMessage(msg, humans.get(serverPlayer));
            }
        }

        // Remove lobby when game starts
        waiting.remove(game);

    }

    private void handleGameStateRequest(Game game, ConnectionToClient cxn)
    {
        game.initPlayerTurnOrder();

        Integer currentActivePlayer = game.getCurrentPlayer().getPlayerId();
        Map<Integer, String> names = new HashMap<Integer, String>();
        // Iterate over this set
        for (Player player : game.getServerPlayers().values())
        {
            names.put(player.getPlayerId(), player.getName());
        }

        this.forwardMessage(new GameStateResponse(currentActivePlayer, names),
                cxn);
    }

    private void handleAllSnoop(AllSnoop card, List<ServerPlayer> players)
    {
        // Iterate over this set
        for (int playerNum = 0; playerNum < players.size(); playerNum++)
        {
            ServerPlayer curPlayer = players.get(playerNum);
            ServerPlayer otherPlayer;
            // Guard against this
            if (!card.getDirection())
            {
                // Guard against this
                if (playerNum == 0)
                {
                    otherPlayer = players.get(players.size() - 1);
                }
                // Otherwise...
                else
                {
                    otherPlayer = players.get(playerNum - 1);
                }
            }
            // Otherwise...
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
            // Iterate over this set
            forwardMessage(response, humans.get(curPlayer));
        }
    }

    private void handlePrivateTip(PrivateTip card, Integer playerId,
            ConnectionToClient connection)
    {
        // Get the requestor's game
        Game curGame = games.get(connection);
        ServerPlayer opponent = curGame.getServerPlayers().get(playerId);

        // List playableCards to return
        ArrayList<HintCard> playableCards = new ArrayList();
        List<HintCard> hintCardsHand = opponent.getHintCardsHand();
        PrivateTipType privateTipType = card.getType();

        // Iterate over this set
        for (int cardInHand = 0; cardInHand < hintCardsHand.size(); cardInHand++)
        {
            HintCard curHintCard = hintCardsHand.get(cardInHand);
            HintCardType curHintType = 
                    hintCardsHand.get(cardInHand).getHintType();

            //Choose the right option
            switch (privateTipType)
            {
                case ALL_DESTINATIONS:
                    // Guard against this
                    if (curHintType == HintCardType.DESTINATION)
                    {
                        playableCards.add(curHintCard);
                    }
                    break;
                case ALL_VEHICLES:
                    // Guard against this
                    if (curHintType == HintCardType.VEHICLE)
                    {
                        playableCards.add(curHintCard);
                    }
                    break;
                case ALL_SUSPECTS:
                    // Guard against this
                    if (curHintType == HintCardType.SUSPECT)
                    {
                        playableCards.add(curHintCard);
                    }
                    break;
                case ONE_FEMALE_SUSPECT:
                    // Guard against this
                    if (curHintType == HintCardType.DESTINATION)
                    {
                        // Guard against this
                        if (((SuspectCard) curHintCard).getGender()
                                == Gender.FEMALE)
                        {
                            playableCards.add(curHintCard);
                        }
                    }
                    break;
                case ONE_NORTHERN_DESTINATION:
                    // Guard against this
                    if (curHintType == HintCardType.DESTINATION)
                    {
                        // Guard against this
                        if (((DestinationCard) curHintCard).getIsNorth())
                        {
                            playableCards.add(curHintCard);
                        }

                    }
                    break;
                case ONE_RED_VEHICLE:
                    // Guard against this
                    if (curHintType == HintCardType.VEHICLE)
                    {
                        // Guard against this
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

        //Choose the right option
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
                randomCard = new Random().nextInt(
                        playableCards.size());
                revealed.add(playableCards.get(randomCard));
                break;
            case ONE_NORTHERN_DESTINATION:
                randomCard = new Random().nextInt(
                        playableCards.size());
                revealed.add(playableCards.get(randomCard));
                break;
            case ONE_RED_VEHICLE:
                randomCard = new Random().nextInt(
                        playableCards.size());
                revealed.add(playableCards.get(randomCard));
                break;
        }

        // Create a new CardDealResponse
        RevealCardResponse response = new RevealCardResponse(card, revealed);
        // Iterate over this set
        forwardMessage(response, connection);
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
        // Iterate over this set
        forwardMessage(response, connection);

    }

    private void handleSuperSleuth(SuperSleuth sleuthCard,
            ConnectionToClient connection)
    {
        // Get the requestor's game
        Game curGame = games.get(connection);
        List<ServerPlayer> opponents = curGame.getServerPlayersList();
        List<Card> revealedCards = new ArrayList<Card>();
        // List playableCards to return
        // Iterate over this set
        for (ServerPlayer opponent : opponents)
        {
            ArrayList<HintCard> playableCards = new ArrayList();
            List<HintCard> hintCardsHand = opponent.getHintCardsHand();
            SuperSleuthType sleuthType = sleuthCard.getType();

            // Iterate over this set
            for (int cardInHand = 0; cardInHand < hintCardsHand.size();
                    cardInHand++)
            {
                HintCard curHintCard = hintCardsHand.get(cardInHand);
                HintCardType curHintType = 
                        hintCardsHand.get(cardInHand).getHintType();

                switch (sleuthType)
                {
                    case AIR_VEHICLE:
                        // Guard against this
                        if (curHintType == HintCardType.VEHICLE)
                        {
                            // Guard against this
                            if (((VehicleCard) curHintCard).getIsAir())
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    case BLUE_CARD:
                        // Guard against this
                        if (curHintType == HintCardType.VEHICLE)
                        {
                            VehicleCard vehicleHint = (VehicleCard) curHintCard;
                            // Guard against this
                            if (vehicleHint.getCardColor() == CardColor.BLUE)
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    case FEMALE_SUSPECT:
                        // Guard against this
                        if (curHintType == HintCardType.SUSPECT)
                        {
                            // Guard against this
                            if (((SuspectCard) curHintCard).getGender()
                                    == Gender.FEMALE)
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    case MALE_SUSPECT:
                        // Guard against this
                        if (curHintType == HintCardType.SUSPECT)
                        {
                            // Guard against this
                            if (((SuspectCard) curHintCard).getGender()
                                    == Gender.MALE)
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    case SOUTHERN_DESTINATION:
                        // Guard against this
                        if (curHintType == HintCardType.DESTINATION)
                        {
                            // Guard against this
                            if (!((DestinationCard) curHintCard).getIsNorth())
                            {
                                playableCards.add(curHintCard);
                            }

                        }
                        break;
                    case WESTERN_DESTINATION:
                        // Guard against this
                        if (curHintType == HintCardType.DESTINATION)
                        {
                            // Guard against this
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

        // Iterate over this set
        forwardMessage(response, connection);

    }

    private void handleActionRequest(ActionRequest actionReq,
            ConnectionToClient connection)
    {
        ActionCard card = actionReq.getActionCard();
        //Get the players game
        Game game = games.get(connection);
        List<ServerPlayer> players = game.getServerPlayersList();

        // Guard against this
        if (card instanceof AllSnoop)
        {
            AllSnoop allSnoopCard = (AllSnoop) card;
            handleAllSnoop(allSnoopCard, players);
        }
        // Otherwise...
        else if (card instanceof PrivateTip)
        {
            PrivateTip privTipCard = (PrivateTip) card;
            handlePrivateTip(privTipCard, actionReq.getPlayerId(), connection);
        }
        // Otherwise...
        else if (card instanceof Snoop)
        {
            Snoop snoopCard = (Snoop) card;
            handleSnoop(snoopCard, actionReq.getPlayerId(), connection);
        }
        // Otherwise...
        else if (card instanceof SuperSleuth)
        {
            SuperSleuth superSleuthCard = (SuperSleuth) card;
            handleSuperSleuth(superSleuthCard, connection);
        }
    }
}
