package client;

import com.lloseng.ocsf.client.AbstractClient;

class ClientNetwork extends AbstractClient
{
    private ClientController ctrl;
    private ConnectionToClient server;

    public ClientNetwork(int port)
    {
        super(port);
    }

    public ClientController getClientController()
    {
    }

    public ConnectionToClient getServer()
    {
    }

    public void send(Object obj)
    {
    }

    public void receive(Object obj)
    {
    }

    @Override
    public void handleMessageFromServer(Object msg)
    {
    }
}
