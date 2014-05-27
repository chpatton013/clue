package com.outtatech.client;

import com.lloseng.ocsf.client.AbstractClient;
import com.outtatech.server.messaging.ServerResponse;
import java.io.IOException;

/**
 * Version-latenightpizzaparty
 * The networking layer for the client application. Handles all incoming and
 * outgoing network traffic by communicating directly with the ClientController.
 *
 * @author Chris
 */
public class ClientNetwork extends AbstractClient
{
    private ClientController ctrl;

    /**
     * Version-latenightpizzaparty
     * Construct a new ClientNetwork on the give port.
     *
     * @param host String value server name or ip method parameter
     * @param port the port number to connect to the server on method parameter
     * @throws java.io.IOException
     */
    public ClientNetwork(String host, int port) throws IOException
    {
        super(host, port);
        this.openConnection();
    }

    /**
     * Version-latenightpizzaparty
     * Sets this instance's reference to the ClientController
     *
     * @param ctrl the client controller reference method parameter
     */
    public void setClientController(ClientController ctrl)
    {
        this.ctrl = ctrl;
    }

    /**
     * Version-latenightpizzaparty
     * Return this instance's reference to the ClientController.
     *
     * @return the internal reference to the ClientController. return value
     * @see ClientController
     */
    public ClientController getClientController()
    {
        return ctrl;
    }

    /**
     * Version-latenightpizzaparty
     * Send an object to the server.
     *
     * @param obj the object to send as a message. method parameter
     */
    public void sendMessageToServer(Object obj)
    {
        // Call OCSF's sendToServer method
        // Just in case...
        try
        {
            sendToServer(obj);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Version-latenightpizzaparty
     * Handles a message sent from the server to this client.
     *
     * @param msg the message sent. method parameter
     */
    @Override
    protected void handleMessageFromServer(Object msg)
    {
        ctrl.reactToMessage((ServerResponse) msg);
    }

    /**
     * Version-latenightpizzaparty
     * Respond to normal server connection closure.
     */
    @Override
    protected void connectionClosed()
    {
        // Call OCSF close
    }

    /**
     * Version-latenightpizzaparty
     * Respond to irregular server connection closure.
     *
     * @param exception Exception that caused irregular closure. method parameter
     */
    @Override
    protected void connectionException(Exception exception)
    {
        // Prompt an error popup on the GUI
        System.out.println(exception.getMessage());
    }
}
