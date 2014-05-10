package server;

import java.util.Map;

public class ServerController {

    private Map<Coneection, Game> games;
    private Map<ServerPlayer, Connection> humans;
    private Map<Server, AI> robots;

    public ServerController() 
    {
    }
    
    public void reactToNetwork(Ojbect obj, Connection connection) 
    {
    }
    
    public void reactToRobot(Object obj, AI robot) 
    {
    }
    
    public void send(Object obj) 
    {
    }
}