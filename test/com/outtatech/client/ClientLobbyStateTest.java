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
import java.util.*;

/**
 *
 * @author bennettschalich
 */
public class ClientLobbyStateTest
{
    
    /**
     *
     */
    public ClientLobbyStateTest()
    {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    /**
     *
     */
    @Before
    public void setUp()
    {
    }
    
    /**
     *
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getPlayer method, of class ClientLobbyState.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        
        Integer pID = new Integer(5);
        Map<Integer, String> players = new HashMap<Integer, String>();
        boolean owner = false;
        int lID = 10;
        
        ClientLobbyState instance = new ClientLobbyState(pID, players, owner, lID);
        Map<Integer, String> expResult = players;
        Map<Integer, String> result = instance.getPlayers();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of getId method, of class ClientLobbyState.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Integer pID = new Integer(5);
        Map<Integer, String> players = new HashMap<Integer, String>();
        boolean owner = false;
        int lID = 10;
        
        ClientLobbyState instance = new ClientLobbyState(pID, players, owner, lID);
        int expResult = lID;
        int result = instance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of getGameOwner method, of class ClientLobbyState.
     */
    @Test
    public void testGetGameOwner() {
        System.out.println("getGameOwner");
        Integer pID = new Integer(5);
        Map<Integer, String> players = new HashMap<Integer, String>();
        boolean owner = false;
        int lID = 10;
        
        ClientLobbyState instance = new ClientLobbyState(pID, players, owner, lID);
        boolean expResult = false;
        boolean result = instance.getGameOwner();
        assertEquals(expResult, result);

    }
    
}
