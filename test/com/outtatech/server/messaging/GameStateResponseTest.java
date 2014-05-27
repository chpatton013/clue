package com.outtatech.server.messaging;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dmangin
 */
public class GameStateResponseTest {
    
    public GameStateResponseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDeckCardCount method, of class GameStateResponse.
     */
    @Test
    public void testGetDeckCardCount() {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        System.out.println("getDeckCardCount");
        GameStateResponse instance = new GameStateResponse(32, 
                temp, 2);
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
        GameStateResponse instance = new GameStateResponse(32, 
                temp, 2);
        ArrayList<Integer> expResult = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
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
        GameStateResponse instance = new GameStateResponse(32, 
                temp, 2);
        Integer expResult = 2;
        Integer result = instance.getCurrentActivePlayer();
        assertEquals(expResult, result);
    }
    
}
