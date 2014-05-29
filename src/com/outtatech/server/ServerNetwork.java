package com.outtatech.server;

import com.lloseng.ocsf.server.AbstractServer;
import com.lloseng.ocsf.server.ConnectionToClient;
import com.outtatech.client.messaging.AddAIRequest;
import com.outtatech.client.messaging.LobbyLeaveRequest;
import com.outtatech.server.messaging.ServerResponse;
import java.util.List;

/**
 * Version-latenightpizzaparty
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
     * Version-latenightpizzaparty
     * Construct a ServerNetwork, requires an integer to designate which port
     * should be used. Calls its super class, AbstractServer, constructor.
     *
     * @param port the networking port the server will listen on method parameter
     */
    public ServerNetwork(int port)
    {
        super(port);
    }

    /**
     * Version-latenightpizzaparty
     * Sets this instance's server controller
     *
     * @param ctrl the ServerController object. method parameter
     */
    public void setServerController(ServerController ctrl)
    {
        this.ctrl = ctrl;
    }

    /**
     * Version-latenightpizzaparty
     * Sends a Message object to all client connections provide in the client
     * list.
     *
     * @param msg ServerResponse to send to client connections method parameter
     * @param clientList list of client connections method parameter
     */
    public void sendMessageToClients(ServerResponse msg,
            List<ConnectionToClient> clientList)
    {
        // Just in case...
        try
        {
            // For each ConnectionToClient in clientList
            // Iterate over this set
            for (ConnectionToClient client : clientList)
            {
                // Call sendMessageToClient on obj
                client.sendToClient(msg);
            }
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Version-latenightpizzaparty
     * Sends an Object to the provided client connection.
     *
     * @param msg ServerResponse to send to client connections method parameter
     * @param client the client connection method parameter
     */
    public void sendMessageToClient(Object msg,
            ConnectionToClient client)
    {
        // Ensure the obj is instanceof ServerMessage
        // Just in case...
        try
        {
            // Call OCSF's sendToClient on obj
            client.sendToClient(msg);
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Version-latenightpizzaparty
     * Receives an Object from a client connection
     *
     * @param message Object received from the client connection method parameter
     * @param client ConnectionToClient client to responded too. method parameter
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
     * Version-latenightpizzaparty
     * Method called each time a client disconnects. The client is guaranteed to
     * be disconnected but the thread is still active until it is asynchronously
     * removed from the thread group.
     *
     * @param client the connection with the client. method parameter
     */
    @Override
    synchronized protected void clientDisconnected(
            ConnectionToClient client)
    {
        System.out.println("Client has Disconnected!");
        Integer lobbyId = ctrl.getLobbyId(client);
        Difficulty difficulty = new Difficulty(3, 3);
        LobbyLeaveRequest rqst = new LobbyLeaveRequest();
        ctrl.reactToNetwork(rqst, client);
        AddAIRequest air = new AddAIRequest(difficulty, lobbyId);
        ctrl.reactToNetwork(air, client);
    }
}
