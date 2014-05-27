package com.outtatech.server.messaging;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import com.outtatech.common.*;
import com.outtatech.server.*;

/**
 *
 * @author bschache
 */
public class LobbyJoinResponseTest {
    
    /**
     *
     */
    public LobbyJoinResponseTest() {
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
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of getJoinedPlayerId method, of class LobbyJoinResponse.
     */
    @Test
    public void testGetJoinedPlayerId() {
        System.out.println("getPlayerId");
        Integer expResult = 99999;
        //List<Player> players = new ArrayList<Player>();
        Map<Integer, String> players = new HashMap<Integer, String>();
        LobbyJoinResponse instance = new LobbyJoinResponse(new Lobby("Lobby 1", 1, true),
                expResult, players);
        Integer result = instance.getPlayerId();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testGetLobby() {
        System.out.println("getLobby");
        Lobby expResult = new Lobby("Lobby 1", 1, true);
        //List<Player> players = new ArrayList<Player>();
        Map<Integer, String> players = new HashMap<Integer, String>();
        LobbyJoinResponse instance = new LobbyJoinResponse(expResult,
                9999, players);
        Lobby result = instance.getLobby();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testGetPlayers() {
        System.out.println("getPlayers");
        String playerName = "Player 1";
        int playerId = 4444;
        Lobby lobby = new Lobby("Lobby 1", 1, true);
        //List<Player> expResult = new ArrayList<Player>();
        Map<Integer, String> expResult = new HashMap<Integer, String>();
        expResult.put(playerId, playerName);
        LobbyJoinResponse instance = new LobbyJoinResponse(lobby,
                9999, expResult);
        //List<Player> result = instance.getPlayers();
        Map<Integer, String> result = new HashMap<Integer, String>();
        result.put(playerId, playerName);
        assertEquals(expResult, result);
    }
    
}