package com.outtatech.server.messaging;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.outtatech.common.*;

/**
 *
 * @author dmangin
 */
public class GameStateResponseTest {
    
    /**
     *
     */
    public GameStateResponseTest() {
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
     * Test of getDeckCardCount method, of class GameStateResponse.
     */
    @Test
    public void testGetDeckCardCount() {
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        System.out.println("getDeckCardCount");
        Map<Integer, String> players = new HashMap<Integer, String>();
        //GameStateResponse instance = new GameStateResponse(32, 
        //        temp, 2);
        List<HintCard> hc = null;
        GameStateResponse instance = new GameStateResponse(32, temp, 2
                , players, hc);
                
        Integer expResult = 32;
        Integer result = instance.getDeckCardCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerTurnOrder method, of class GameStateResponse.
     */
    @Test
    public void testGetPlayerTurnOrder() {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        System.out.println("getDeckCardCount");
        //GameStateResponse instance = new GameStateResponse(32, 
        //        temp, 2);
        Map<Integer, String> players = new HashMap<Integer, String>();
        List<HintCard> hc = null;
        GameStateResponse instance = new GameStateResponse(32, temp, 
                2, players, hc);
        
        ArrayList<Integer> expResult = new ArrayList<Integer>();
        expResult.add(2);
        expResult.add(3);
        expResult.add(4);
        expResult.add(5);
        expResult.add(6);
        List<Integer> result = instance.getPlayerTurnOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to 
        // fail.
    }

    /**
     * Test of getCurrentActivePlayer method, of class GameStateResponse.
     */
    @Test
    public void testGetCurrentActivePlayer() {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        //GameStateResponse instance = new GameStateResponse(32, 
        //        temp, 2);
        Map<Integer, String> players = new HashMap<Integer, String>();
        List<HintCard> hc = null;
        GameStateResponse instance = new GameStateResponse(32, temp, 2, 
                players, hc);
        
        Integer expResult = 2;
        Integer result = instance.getCurrentActivePlayer();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getCurrentActivePlayer method, of class GameStateResponse.
     */
    @Test
    public void testGetPlayers() {
        String playerName = "Player 1";
        int playerId = 4444;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        //GameStateResponse instance = new GameStateResponse(32, 
        //        temp, 2);
        Map<Integer, String> players = new HashMap<Integer, String>();
        players.put(playerId, playerName);
        List<HintCard> hc = null;
        GameStateResponse instance = new GameStateResponse(32, temp, 
                2, players, hc);
        
        Map<Integer, String> expResult = players;
        Map<Integer, String> result = instance.getPlayers();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getCurrentActivePlayer method, of class GameStateResponse.
     */
    @Test
    public void testGetHintCards() {
        String playerName = "Player 1";
        int playerId = 4444;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        //GameStateResponse instance = new GameStateResponse(32, 
        //        temp, 2);
        Map<Integer, String> players = new HashMap<Integer, String>();
        players.put(playerId, playerName);
        List<HintCard> hc = new ArrayList<>();
        hc.add(new HintCard(HintCardType.DESTINATION));
        
        GameStateResponse instance = new GameStateResponse(32, temp, 
                2, players, hc);
        
        List<HintCard> expResult = hc;
        List<HintCard> result = instance.getHintCards();
        assertEquals(expResult, result);
    }
}
