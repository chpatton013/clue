package client;

import com.lloseng.ocsf.client.AbstractClient;

/**
 * The networking layer for the client application.
 * Handles all incoming and outgoing network traffic by communicating directly
 * with the ClientController.
 */
class ClientNetwork extends AbstractClient
{
    private ClientController ctrl;

    /**
     * Construct a new ClientNetwork on the give port.
     *
     * @param  port  the port number to connect to the server on
     */
    public ClientNetwork(int port)
    {
        super(port);
    }

    /**
     * Return this instance's reference to the ClientController.
     *
     * @return the internal reference to the ClientController.
     * @see    ClientController
     */
    public ClientController getClientController()
    {
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
     * Handle reception of an object from the server.
     *
     * @param  obj   incoming object from server.
     */
    public void receive(Object obj)
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
}
