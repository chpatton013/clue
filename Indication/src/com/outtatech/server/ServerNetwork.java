package com.outtatech.server;

import com.lloseng.ocsf.server.AbstractServer;
import com.lloseng.ocsf.server.ConnectionToClient;
import java.util.List;

/**
 * ServerNetwork class extends the AbstractServer class
 * in the OCSF framework.  An instance of this class will
 * hold a collection of connected clients and a game controller.
 * The class facilitates communication to and from the clients.
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class ServerNetwork extends AbstractServer
{
    private ServerController ctrl;
    private List<ConnectionToClient> clients;

    /**
     * Construct a ServerNetwork, requires an integer to designate
     * which port should be used.  Calls its super class,
     * AbstractServer, constructor.
     * @param port the networking port the server will listen on
     */
    public ServerNetwork(int port) 
    {
        super(port);
    }
    
    /**
     * Sends an Object to all client connections provide in the client list.
     * @param obj Object to send to client connections
     * @param clientList list of client connections 
     */
    public void sendMessageToClients(Object obj, List<ConnectionToClient> clientList) 
    {
    }
    
    /**
     * Sends an Object to the provided client connection.
     * @param obj Object to send to client connections
     * @param client the client connection
     */
    public void sendMessageToClient(Object obj, ConnectionToClient client) 
    {
    }
    
    /**
     * Receives an Object from a client connection
     * @param message Object received from the client connection
     * @param client ConnectionToClient client to responded too.
     */
    @Override
    public void handleMessageFromClient
        (Object message, ConnectionToClient client)
    {
    }
}