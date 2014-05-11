package com.outtatech.server;

import com.lloseng.ocsf.server.ConnectionToClient;
import java.util.List;
import java.util.Map;

public class ServerController {

    private Map<ConnectionToClient, Game> playersToGames;
    private Map<Integer, Game> games;
    private Map<ServerPlayer, ConnectionToClient> humans;
    private Map<ServerPlayer, AI> robots;
    private List<Lobby> lobbies;

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