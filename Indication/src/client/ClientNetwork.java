package client;

import com.lloseng.ocsf.client.AbstractClient;

/**
 * The networking layer for the client application.
 * Handles all incoming and outgoing network traffic by communicating directly
 * with the ClientController.
 * @author Chris
 */
public class ClientNetwork extends AbstractClient
{
    private ClientController ctrl;

    /**
     * Construct a new ClientNetwork on the give port.
     *
     * @param host String value server name or ip
     * @param  port the port number to connect to the server on
     */
    public ClientNetwork(String host, int port)
    {
        super(host, port);
    }

    /**
     * Return this instance's reference to the ClientController.
     *
     * @return the internal reference to the ClientController.
     * @see    ClientController
     */
    public ClientController getClientController()
    {
        return ctrl;
    }

    /**
     * Send an object to the server.
     *
     * @param  obj   the object to send as a message.
     */
    public void send(Object obj)
    {
    }

    /**
     * Handles a message sent from the server to this client.
     *
     * @param msg   the message sent.
     */
    @Override
    protected void handleMessageFromServer(Object msg)
    {
    }
    
    /**
     * Respond to normal server connection closure.
     */
    @Override
    protected void connectionClosed() 
    {
    }

    /**
     * Respond to irregular server connection closure.
     *
     * @param exception Exception that caused irregular closure.
     */
    @Override
    protected void connectionException(Exception exception) 
    {
    }
}
