package server;

import java.util.Map;
import com.lloseng.ocsf.server.ConnectionToClient;

public class ServerController {

    private Map<ConnectionToClient, Game> games;
    private Map<ServerPlayer, ConnectionToClient> humans;
    private Map<ServerPlayer, AI> robots;

    public ServerController() 
    {
    }
    
    public void reactToNetwork(Object obj, ConnectionToClient connection) 
    {
    }
    
    public void reactToRobot(Object obj, AI robot) 
    {
    }
    
    public void send(Object obj) 
    {
    }
}