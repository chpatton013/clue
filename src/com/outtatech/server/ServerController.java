package com.outtatech.server;

import com.lloseng.ocsf.server.ConnectionToClient;
import com.outtatech.client.messaging.*;
import com.outtatech.common.Card;
import com.outtatech.common.Player;
import com.outtatech.common.Solution;
import com.outtatech.server.messaging.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<Game, ArrayList<ConnectionToClient>> players;
    private Map<ServerPlayer, ConnectionToClient> humans;
    //maybe mapped differently? AI are serverplayers
    private Map<ServerPlayer, AI> robots;
    private Map<Integer, Lobby> lobbies;
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
        this.games = new HashMap<ConnectionToClient, Game>();
        this.players = new HashMap<Game, ArrayList<ConnectionToClient>>();
        this.humans = new HashMap<ServerPlayer, ConnectionToClient>();
        this.robots = new HashMap<ServerPlayer, AI>();
        this.lobbies = new HashMap<Integer, Lobby>();
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
            forwardMessage(new LobbyDiscoveryResponse(new ArrayList(lobbies.
                    values())),
                    connection);
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
            ServerPlayer newPlayer = new AI(addAIReq.getDifficulty(), this);
            
            // Get the requestor's lobby
            Lobby lobby = lobbies.get(addAIReq.getLobbyId());
            // Get the game associated with the lobby
            Game lobbyGame = gameIdToGame.get(lobby.getGameId());
            // Add the AI
            lobbyGame.addServerPlayer(newPlayer);
            // Inform game players
            informPlayers(lobbyGame, new LobbyJoinResponse(lobby,newPlayer));
        }
        
        /* 
         * LobbyJoinRequest respond with LobbyJoinResponse
         * notify all clients.
         */
        else if (obj instanceof LobbyJoinRequest)
        {
            Lobby lobby = lobbies.get(((LobbyJoinRequest) obj).getLobbyId());
            ServerPlayer serverPlayer = new ServerPlayer();
            games.get(lobby.getGameId()).addServerPlayer(serverPlayer);
            forwardMessage(new LobbyJoinResponse(lobby, serverPlayer),
                    getGameClients(lobby.gameId));
        }
        
        /**
         * LobbyCreateRequest respond with LobbyCreateResponse else if
         */
        else if (obj instanceof LobbyCreateRequest)
        {
            LobbyCreateRequest lcr = (LobbyCreateRequest)obj;
            Game game = new Game();
            Lobby lobby = new Lobby(lcr.getLobbyName(), game.getGameId());
            games.put(connection, game);
            gameIdToGame.put(game.getGameId(), game);
            lobbies.put(game.getGameId(), lobby);
            
            //@TODO Only the requesting client will be updated.  Other clients
            //will need to send a lobby discovery response to refresh.
            forwardMessage(new LobbyCreateResponse(lobby), connection);
        }
        
        /**
         * 
         */
        else if (obj instanceof GameStartRequest)
        {
            handleGameStartRequest();
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
            //need to create an AI
            games.get(connection).getServerPlayers().add(null);
            //update the mapping
            //forwardMessage(new ActionResponse(), connection, false);
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
        else if (obj instanceof RevealCardRequest)
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
        List<ServerPlayer> gameServerPlayers
                = game.getServerPlayers();

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
                = clientGame.getServerPlayers();

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
        AccusationResponse accResp = new AccusationResponse(
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
    public void reactToRobot(Object obj, AI robot)
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
    
    private ArrayList<ConnectionToClient> getGameClients(Integer gameId)
    {
        Game game = gameIdToGame.get(gameId);
        
        return this.players.get(game);
    }
    
    public Integer getLobbyId(ConnectionToClient client) 
    {
        return games.get(client).getGameId();
    }
    
    /**
     * Brian Schacherer TODO
     * For the appropriate Game instance:
            //deal Hint cards
            //deal one Action card to each player
            //draw pile is already shuffled
            //on deal of Action Card pop remove from top
            //of draw pile(item at index 0 getFirst ) and push to client
        */
    private void handleGameStartRequest()
    {
    } 
}
