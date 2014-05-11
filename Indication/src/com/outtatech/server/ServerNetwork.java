package com.outtatech.server;

import com.lloseng.ocsf.server.AbstractServer;
import com.lloseng.ocsf.server.ConnectionToClient;
import java.util.List;

public class ServerNetwork extends AbstractServer
{

    private ServerController ctrl;
    private List<ConnectionToClient> clients;

    public ServerNetwork(int port) 
    {
        super(port);
    }
    
    public void send(Object obj, List<ConnectionToClient> clientList) 
    {
    }
    
    @Override
    public void handleMessageFromClient
        (Object message, ConnectionToClient client)
    {
    }
}