package com.outtatech.client;

import com.outtatech.client.ClientLobbyDiscoveryState;
import com.outtatech.common.Player;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Map;

/**
 *
 * @author bennettschalich
 */
public class ClientLobbyStateTest
{
    
    public ClientLobbyStateTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getPlayer method, of class ClientLobbyState.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        ClientLobbyState instance = null;
        Map<Integer, String> expResult = null;
        Map<Integer, String> result = instance.getPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class ClientLobbyState.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ClientLobbyState instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayers method, of class ClientLobbyState.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        ClientLobbyState instance = null;
        Map<Integer, String> expResult = null;
        Map<Integer, String> result = instance.getPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPlayer method, of class ClientLobbyState.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        Player player = null;
        ClientLobbyState instance = null;
        instance.addPlayer(1,"Bob");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayers method, of class ClientLobbyState.
     */
    @Test
    public void testSetPlayers() {
        System.out.println("setPlayers");
        Map<Integer, String> players = null;
        ClientLobbyState instance = null;
        instance.setPlayers(players);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameOwner method, of class ClientLobbyState.
     */
    @Test
    public void testGetGameOwner() {
        System.out.println("getGameOwner");
        ClientLobbyState instance = null;
        boolean expResult = false;
        boolean result = instance.getGameOwner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
