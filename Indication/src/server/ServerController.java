package server;

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
public class ServerController {

    private Map<ConnectionToClient, Game> games;
    private Map<ServerPlayer, ConnectionToClient> humans;
    private Map<ServerPlayer, AI> robots;

    /**
     * Construct a ServerController object.  A ServerController instance
     * can be used to facilitate changes to multiple Game instances with
     * many different Client connections and any AI players.
     * @param games
     * @param humans
     * @param robots 
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
     * 
     * @param obj
     * @param connection 
     */
    public void reactToNetwork(Object obj, ConnectionToClient connection) 
    {
    }
    
    /**
     * 
     * @param obj
     * @param robot 
     */
    public void reactToRobot(Object obj, AI robot) 
    {
    }
    
    /**
     * 
     * @param obj 
     */
    public void send(Object obj) 
    {
    }
}