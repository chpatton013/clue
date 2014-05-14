package com.outtatech.server;

import java.util.Map;
import com.lloseng.ocsf.server.ConnectionToClient;

/**
 * The ServerController controls every game being played. Each game has a
 * set of players connected to the ServerController, represented by the 
 * Connection object. This association is tracked with a map of Connection to
 * Game. This implies that multiple Connection keys will point to the same
 * Game value.
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class ServerController 
{
    private Map<ConnectionToClient, Game> games;
    private Map<ServerPlayer, ConnectionToClient> humans;
    private Map<ServerPlayer, AI> robots;

    /**
     * Construct a ServerController object.  A ServerController instance
     * can be used to facilitate changes to multiple Game instances with
     * many different Client connections and any AI players.
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
     * @param obj Object signaling an action.
     * @param connection ConnectionToClient used to respond back to client.
     */
    public void reactToNetwork(Object obj, ConnectionToClient connection) 
    {
    }
    
    /**
     * Handles a request made by an AI player.
     * @param obj Object signaling an action.
     * @param robot AI instance that triggered the action.
     */
    public void reactToRobot(Object obj, AI robot) 
    {
    }
    
    /**
     * Provides a hook to send Objects to a networked client.
     * @param obj Object to send to network hooks
     */
    public void send(Object obj) 
    {
    }
}