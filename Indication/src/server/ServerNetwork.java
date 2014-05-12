package server;

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
     * @param port 
     */
    public ServerNetwork(int port) 
    {
        super(port);
    }
    
    /**
     * 
     * @param obj
     * @param clientList 
     */
    public void send(Object obj, List<ConnectionToClient> clientList) 
    {
    }
    
    /**
     * 
     * @param message
     * @param client 
     */
    @Override
    public void handleMessageFromClient
        (Object message, ConnectionToClient client)
    {
    }
}