package com.outtatech.server;

import com.outtatech.client.ClientController;
import com.outtatech.client.ClientMenuState;
import com.outtatech.client.ClientNetwork;
import com.outtatech.client.messaging.LobbyListRequest;
import com.outtatech.common.Card;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jbilous
 */
public class ServerControllerTest
{
    private ClientMenuState state;
    private ClientNetwork clientnw;
    private ClientController clientctrl;
    
    private ServerNetwork servernw;
    private ServerController serverctrl;
    
    /**
     *
     */
    @Before
    public void setUp()
    {
        state = new ClientMenuState();
        try
        {
        clientnw = new ClientNetwork("localhost", 5300);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        //clientctrl = new ClientController(state, clientnw);
        clientctrl = new ClientController();
        clientnw.setClientController(clientctrl);
        
        servernw = new ServerNetwork(5300);
        serverctrl = new ServerController(servernw);
        servernw.setServerController(serverctrl);
    }
    
    /**
     *
     */
    @After
    public void tearDown()
    {
        try {
          clientnw.closeConnection();
        } catch(Exception e) {
            System.out.println("Problem closing connection");
        }
    }
    
    /**@Test
    public void testCreateLobby() {
        
        //Send a new LobbyListRequest
        LobbyListRequest llreq = new LobbyListRequest();
        clientctrl.forwardMessage(llreq);
        
    }**/
}
