package com.outtatech.server.messaging;

import com.outtatech.server.Lobby;
import java.util.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MarkFeldman
 */
public class LobbyDiscoveryResponseTest {
    
    /**
     *
     */
    public LobbyDiscoveryResponseTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getLobbies method, of class LobbyDiscoveryResponse.
     */
    @Test
    public void testGetLobbies() {
        System.out.println("Testing getLobbies");
        
        List<Lobby> expResult = new ArrayList();
        expResult.add(new Lobby("Lobby 1", 1, true));
        expResult.add(new Lobby("Lobby 2", 2, false));
        
        LobbyDiscoveryResponse lobbyDiscovery = new LobbyDiscoveryResponse(expResult);
        List<Lobby> result = lobbyDiscovery.getLobbies();
        assertEquals(expResult, result);
    }
    
}
