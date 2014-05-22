package com.outtatech.server;

import java.util.Map;
import com.lloseng.ocsf.server.ConnectionToClient;

/**
 * The ServerController controls every game being played. Each game has a set of
 * players connected to the ServerController, represented by the Connection
 * object. This association is tracked with a map of Connection to Game. This
 * implies that multiple Connection keys will point to the same Game value.
 *
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class ServerController
{
    private Map<ConnectionToClient, Game> games;
    private Map<ServerPlayer, ConnectionToClient> humans;
    private Map<ServerPlayer, AI> robots;

    /**
     * Construct a ServerController object. A ServerController instance can be
     * used to facilitate changes to multiple Game instances with many different
     * Client connections and any AI players.
     *
     * @param games a Map of Client connections and Games
     * @param humans a Map of ServerPlayers and Client Connections
     * @param robots a Map of ServerPlayers and AI instances
     */
    public ServerController(Map<ConnectionToClient, Game> games,
            Map<ServerPlayer, ConnectionToClient> humans,
            Map<ServerPlayer, AI> robots)
    {
        this.games = games;
        this.humans = humans;
        this.robots = robots;
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
         * LobbyJoinRequest respond with LobbyUpdateResponse else if
         * LobbyCreateRequest respond with LobbyCreateResponse else if
         * ActionRequest respond with ActionResponse
         *
         * else if AddAIRequest?
         *
         * @TODO Add a response class? PlayersResponse? List of player names and
         * made up AI names? or Add a list of players to the
         * LobbyDiscoveryResponse?
         *
         * else if EndTurnRequest respond with GameStateResponse
         *
         * else if RevealCardRequest(prompted by an ActionResponse) respond with
         * a GameStateResponse
         *
         * Responses are made via the forwardMessage function.
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
         *
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
     * Provides a hook to send Objects to a networked client.
     *
     * @param obj Object to send to network hooks
     */
    public void forwardMessage(Object obj)
    {
        /**
         * @TODO instead of checking the instanceOf on this object maybe we
         * should add a flag designating whether all clients should be notified
         * or just one client. Or we can add a forwardMessageToAll function.
         *
         * Determine the instance of this object if the object instance requires
         * notifying all clients then call ServerNetwork.sendMessageToClients().
         * If only one client needs to be notified by the response then call
         * ServerNetwork.sendMessageToClient().
         */
    }
}
