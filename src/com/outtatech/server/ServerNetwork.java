package com.outtatech.server;

import com.lloseng.ocsf.server.AbstractServer;
import com.lloseng.ocsf.server.ConnectionToClient;
import com.outtatech.server.messaging.ServerResponse;
import com.outtatech.client.messaging.AddAIRequest;
import java.util.List;

/**
 * ServerNetwork class extends the AbstractServer class in the OCSF framework.
 * An instance of this class will hold a collection of connected clients and a
 * game controller. The class facilitates communication to and from the clients.
 *
 * @author Steven Chiu, Brian Schacherer
 * @version 1.0 - May 11, 2014
 */
public class ServerNetwork extends AbstractServer
{
    private ServerController ctrl;
    private List<ConnectionToClient> clients;

    /**
     * Construct a ServerNetwork, requires an integer to designate which port
     * should be used. Calls its super class, AbstractServer, constructor.
     *
     * @param port the networking port the server will listen on
     */
    public ServerNetwork(int port)
    {
        super(port);
    }

    /**
     * Sets this instance's server controller
     *
     * @param ctrl the ServerController object.
     */
    public void setServerController(ServerController ctrl)
    {
        this.ctrl = ctrl;
    }

    /**
     * Sends a Message object to all client connections provide in the client
     * list.
     *
     * @param msg ServerResponse to send to client connections
     * @param clientList list of client connections
     */
    public void sendMessageToClients(ServerResponse msg,
            List<ConnectionToClient> clientList)
    {
        try
        {
            // For each ConnectionToClient in clientList
            for (ConnectionToClient client : clientList)
            {
                // Call sendMessageToClient on obj
                client.sendToClient(msg);
            }
        }
        catch (Exception e)
        {
            // Handle Exception
            System.out.println("Error sending message to client");
        }
    }

    /**
     * Sends an Object to the provided client connection.
     *
     * @param msg ServerResponse to send to client connections
     * @param client the client connection
     */
    public void sendMessageToClient(Object msg,
            ConnectionToClient client)
    {
        // Ensure the obj is instanceof ServerMessage
        try
        {
            // Call OCSF's sendToClient on obj
            client.sendToClient(msg);
        }
        catch (Exception e)
        {
            System.out.println("Error sending message to client");

        }
    }

    /**
     * Receives an Object from a client connection
     *
     * @param message Object received from the client connection
     * @param client ConnectionToClient client to responded too.
     */
    @Override
    public void handleMessageFromClient(Object message,
            ConnectionToClient client)
    {
        // Cast message to the appropriate ClientMessage type
        // Update server state based on message as appropriate.
        ctrl.reactToNetwork(message, client);
    }

    /**
     * Method called each time a client disconnects. The client is guaranteed to
     * be disconnected but the thread is still active until it is asynchronously
     * removed from the thread group.
     *
     * @param client the connection with the client.
     */
    @Override
    synchronized protected void clientDisconnected(
            ConnectionToClient client)
    {
        Integer lobbyId = ctrl.getLobbyId(client);
        Difficulty difficulty = new Difficulty(3, 3);
        AddAIRequest air = new AddAIRequest(difficulty, lobbyId);
        ctrl.reactToNetwork(air, client);
    }
}
