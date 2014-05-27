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
                = new HashMap<ConnectionToClient, ServerPlayer>();
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
         * SuggestionRequest respond with SuggestionResponse
         */
        else if (obj instanceof SuggestionRequest)
        {
            SuggestionRequest suggestionReq = (SuggestionRequest) obj;
            handleSuggestion(suggestionReq, connection);
        }
        /*
         * AddAIRequest respond with AddAIResponse
         */
        else if (obj instanceof AddAIRequest)
        {
            System.out.println("Recieved AI Request");
            AddAIRequest addAIReq = (AddAIRequest) obj;
            int num = games.get(connection).getPlayers().size();
            ServerPlayer newPlayer = new AI(addAIReq.getDifficulty(), this,
                    games.get(connection));
            System.out.println("Creating new Clue Bot");
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
            for (Player temp : players)
            {
                System.out.println(temp.getName());
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
            for (Player temp : players)
            {
                names.put(temp.getPlayerId(), temp.getName());
            }

            forwardMessage(new LobbyJoinResponse(lobby,
                    serverPlayer.getPlayerId(), names), cxns);
        }

        /**
         * LobbyCreateRequest respond with LobbyCreateResponse else if
         */
        else if (obj instanceof LobbyCreateRequest)
        {
            LobbyCreateRequest lcr = (LobbyCreateRequest) obj;
            Game game = new Game();
            game.addServerPlayer(connectionToPlayer.get(connection));
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
            serverPlayer.setName("single_player_host");
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

        /**
         *
         */
        else if (obj instanceof GameStartRequest)
        {
            Game game = games.get(connection);
            handleGameStartRequest(games.get(connection), lobbies.get(game.
                    getGameId()));
        }
        /**
         * @TODO Add a response class? PlayersResponse? List of player names and
         * made up AI names? or Add a list of players to the
         * LobbyDiscoveryResponse?
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
        ServerPlayer newCurrent = game.advanceTurn();
        List<ActionCard> drawCards = new ArrayList<ActionCard>();
        drawCards.add(game.getDrawPile().remove(0));
        ServerResponse response = new CardDealResponse(drawCards);
        informPlayer(initiator, response);
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

    private HintCard findRefutingCard(List<ServerPlayer> gameServerPlayers,
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
                        return dest;
                    }
                }
                else if (card instanceof SuspectCard)
                {
                    SuspectCard susp = (SuspectCard) card;
                    if (susp.getSuspect().equals(guess.getSuspect()))
                    {
                        return susp;
                    }
                }
                else if (card instanceof VehicleCard)
                {
                    VehicleCard vehicle = (VehicleCard) card;
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

        if (suggestion.equals(clientGame.getSolution()))
        {
            SuggestionResponse suggResp = new SuggestionResponse(true);

        }
        else
        {
            SuggestionResponse suggResp = new SuggestionResponse(false);
            //Find a refuting card
            HintCard refutingCard = findRefutingCard(gameServerPlayers,
                    suggestion);
            suggResp.setRefutingCard(refutingCard);
            //Send to humans
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
    private void handleGameStartRequest(Game game, Lobby lobby)
    {
        game.initialize();

        //Get all players in game
        List<ServerPlayer> gameServerPlayers = game.getServerPlayersList();

        Integer playerCount = gameServerPlayers.size();
        int playerIndex = 0;

        //Deal out all hint cards
        for (int index = 0; game.getHintCardsSize() > 0; index++)
        {
            gameServerPlayers.get(index % playerCount).addHintCard(game.
                    popHintCard());
        }

        List<Integer> idList = new ArrayList<Integer>();
        List<Integer> playerTurnOrder = new ArrayList<Integer>();
        Map<Integer, String> nameMap = new HashMap<Integer, String>();

        //Add one action card to each hand.
        for (ServerPlayer pl : gameServerPlayers)
        {
            pl.addActionCard(game.popActionCard());
            idList.add(pl.getPlayerId());
            nameMap.put(pl.getPlayerId(), pl.getName());
        }

        for (ServerPlayer pl : game.getPlayerTurnOrder())
        {
            playerTurnOrder.add(playerTurnOrder.size(), pl.getPlayerId());
            GameStateResponse gameResponse = new GameStateResponse(game.
                    getDrawPile().size(), playerTurnOrder, game.
                    getCurrentPlayerIndex(), nameMap, pl.hintCardsHand);
            informPlayer(pl, gameResponse);
        }

        for (ServerPlayer serverPlayer : gameServerPlayers)
        {
            CardDealResponse msg = new CardDealResponse(
                    serverPlayer.actionCardsHand);
            informPlayer(serverPlayer, msg);
        }

        // Remove lobby when game starts
        waiting.remove(game);

    }

    private void handleGameStateRequest(Game game, ConnectionToClient cxn)
    {
        Integer deckSize = game.getDrawPile().size();
        ServerPlayer serverPlayer = connectionToPlayer.get(cxn);

        List<Integer> playerTurnOrder = new ArrayList<Integer>(
                game.getServerPlayers().keySet());

        Integer currentActivePlayer = playerTurnOrder.get(0);

        Map<Integer, String> names = new HashMap<Integer, String>();
        for (Player player : game.getServerPlayers().values())
        {
            System.out.println(player.getName());
            names.put(player.getPlayerId(), player.getName());
        }

        this.forwardMessage(new GameStateResponse(deckSize, playerTurnOrder,
                currentActivePlayer, names, serverPlayer.getHintCardsHand()),
                cxn);
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

        for (int cardInHand = 0; cardInHand < hintCardsHand.size(); cardInHand++)
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
                    if (curHintType == HintCardType.DESTINATION)
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

        forwardMessage(response, connection);

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
            PrivateTip privTipCard = (PrivateTip) card;
            handlePrivateTip(privTipCard, actionReq.getPlayerId(), connection);
        }
        else if (card instanceof Snoop)
        {
            Snoop snoopCard = (Snoop) card;
            handleSnoop(snoopCard, actionReq.getPlayerId(), connection);
        }
        else if (card instanceof SuperSleuth)
        {
            SuperSleuth superSleuthCard = (SuperSleuth) card;
            handleSuperSleuth(superSleuthCard, connection);
        }
    }
}