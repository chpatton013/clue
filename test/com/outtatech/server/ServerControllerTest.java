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
    
    
    @Test
    public void initServer()
    {
        ServerNetwork sn = new ServerNetwork(7777);
        ServerController sc = new ServerController(sn);
    }
}
