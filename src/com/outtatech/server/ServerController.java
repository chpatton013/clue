package com.outtatech.server;

import com.lloseng.ocsf.server.ConnectionToClient;
import com.outtatech.client.messaging.*;
import com.outtatech.common.Card;
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
 * @author Steven Chiu, James Bilous
 * @version 1.0 - May 11, 2014
 */
public class ServerController
{
    private Map<ConnectionToClient, Game> games;
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
        if (obj instanceof LobbyListRequest) {
            forwardMessage(new 
                LobbyDiscoveryResponse(new ArrayList(lobbies.values())), 
                    connection);
        }
        else if (obj instanceof AccusationRequest)
        {
            AccusationRequest accusation = (AccusationRequest)obj;
            List<Card> accusationCards = accusation.getAccusationCards();
            
        }
        /* 
         * LobbyJoinRequest respond with LobbyUpdateResponse else if
        */
        else if (obj instanceof LobbyJoinRequest) {
            
            forwardMessage(new LobbyUpdateResponse(
                lobbies.get(((LobbyJoinRequest)obj).getLobbyId())), 
                    connection, false);
        }
       /**
         * LobbyCreateRequest respond with LobbyCreateResponse else if
         */
        else if (obj instanceof LobbyCreateRequest) {
            Lobby temp = new Lobby(((LobbyCreateRequest)obj).getLobbyName(), 
                    (games.get(connection)).getGameId());
            lobbies.put(temp.getLobbyId(), temp);
            forwardMessage(new LobbyCreateResponse(temp), connection, false);
        }
       /**
         * ActionRequest respond with ActionResponse else if
         */
        else if (obj instanceof ActionRequest) 
        {
            ActionRequest temp = ((ActionRequest)obj);
            forwardMessage(new ActionResponse(temp.getActionCard(), 
                temp.getPlayerId()), connection, false);
        }
        /** AddAIRequest?
         */
        else if (obj instanceof AddAIRequest) 
        {
            AddAIRequest temp = ((AddAIRequest)obj);
            int num = (robots.keySet()).size();
            //need to create an AI
            games.get(connection).getServerPlayers().add(null);
            //update the mapping
            //forwardMessage(new ActionResponse(), connection, false);
        }
        /** @TODO Add a response class? PlayersResponse? List of player names and
         * made up AI names? or Add a list of players to the
         * LobbyDiscoveryResponse?
         */
        
       /** else if EndTurnRequest respond with GameStateResponse
        */
        else if (obj instanceof EndTurnRequest) 
        {
            //forwardMessage(new GameStateResponse()), connection, false);
        }
        /** else if RevealCardRequest(prompted by an ActionResponse) respond with
         * a GameStateResponse
         */
        else if (obj instanceof RevealCardRequest) 
        {
            //forwardMessage(new GameStateResponse()), connection, false);
        }
       /** Responses are made via the forwardMessage function.
         */
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
        
        /** Check instanceOf obj to determine what change needs to be made the AI
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
        network.sendMessageToClients((ServerResponse)obj, clients);
    }
    
    private boolean isHuman(ServerPlayer player) {
        return humans.containsKey(player);
    }
}
