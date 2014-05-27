package com.outtatech.client;

import com.outtatech.client.ClientGameState;
import com.outtatech.common.Card;
import com.outtatech.common.CardType;
import com.outtatech.common.DestinationID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bennettschalich
 */
public class ClientGameStateTest
{
    
    public ClientGameStateTest()
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
     * Test of getPlayerId method, of class ClientGameState.
     */
    @Test
    public void testSetGetPlayerId()
    {
        System.out.println("getPlayerId");
        
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        list.add(new Card(CardType.ACTION));
        
        Map<DestinationID, Integer> map = new HashMap<DestinationID, Integer>();
        map.put(DestinationID.CONEY_ISLAND, new Integer(5));
        map.put(DestinationID.THE_ALAMO, new Integer(3));
        
        Map<Integer, String> players = null;
        ClientGameState instance = new ClientGameState(4, list, players);
        int expResult = 4;
        int result = instance.getPlayerId();
        assertEquals(expResult, result);
        
        instance.setPlayerId(3);
        expResult = 3;
        result = instance.getPlayerId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNotes method, of class ClientGameState.
     */
    @Test
    public void testGetNotes()
    {
        System.out.println("getNotes");
        
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        list.add(new Card(CardType.ACTION));
        
        Map<DestinationID, Integer> map = new HashMap<DestinationID, Integer>();
        map.put(DestinationID.CONEY_ISLAND, new Integer(5));
        map.put(DestinationID.THE_ALAMO, new Integer(3));
        
        Object obj = new Object();
        Map<Integer, String> players = null;
        ClientGameState instance = new ClientGameState(4, list, players);
        
        Object expResult = obj;
        Object result = instance.getNotes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHand method, of class ClientGameState.
     */
    @Test
    public void testGetHand()
    {
        System.out.println("getHand");
        
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        list.add(new Card(CardType.ACTION));
        
        Map<DestinationID, Integer> map = new HashMap<DestinationID, Integer>();
        map.put(DestinationID.CONEY_ISLAND, new Integer(5));
        map.put(DestinationID.THE_ALAMO, new Integer(3));
        
        Map<Integer, String> players = null;
        ClientGameState instance = new ClientGameState(4, list, players);
        List<Card> expResult = list;
        List<Card> result = instance.getHand();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestToPlayerId method, of class ClientGameState.
     */
    @Test
    public void testGetDestToPlayerId()
    {
        System.out.println("getDestToPlayerId");
        
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        list.add(new Card(CardType.ACTION));
        
        Map<DestinationID, Integer> map = new HashMap<DestinationID, Integer>();
        map.put(DestinationID.CONEY_ISLAND, new Integer(5));
        map.put(DestinationID.THE_ALAMO, new Integer(3));
        
        Map<Integer, String> players = null;
        ClientGameState instance = new ClientGameState(4, list, players);
        Map<DestinationID, Integer> expResult = map;
        Map<DestinationID, Integer> result = instance.getDestToPlayerId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNewAccusation method, of class ClientGameState.
     */
    @Test
    public void testSetNewAccusation() {
        System.out.println("setNewAccusation");
        ClientGameState instance = null;
        instance.setNewAccusation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccusationStatus method, of class ClientGameState.
     */
    @Test
    public void testGetAccusationStatus() {
        System.out.println("getAccusationStatus");
        ClientGameState instance = null;
        boolean expResult = false;
        boolean result = instance.getAccusationStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccusation method, of class ClientGameState.
     */
    @Test
    public void testGetAccusation() {
        System.out.println("getAccusation");
        ClientGameState instance = null;
        boolean expResult = false;
        boolean result = instance.getAccusation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerId method, of class ClientGameState.
     */
    @Test
    public void testGetPlayerId() {
        System.out.println("getPlayerId");
        ClientGameState instance = null;
        int expResult = 0;
        int result = instance.getPlayerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRevealed method, of class ClientGameState.
     */
    @Test
    public void testGetRevealed() {
        System.out.println("getRevealed");
        ClientGameState instance = null;
        List expResult = null;
        List result = instance.getRevealed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRevealed method, of class ClientGameState.
     */
    @Test
    public void testSetRevealed() {
        System.out.println("setRevealed");
        List<Card> revealed = null;
        ClientGameState instance = null;
        instance.setRevealed(revealed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRevealStatus method, of class ClientGameState.
     */
    @Test
    public void testGetRevealStatus() {
        System.out.println("getRevealStatus");
        ClientGameState instance = null;
        boolean expResult = false;
        boolean result = instance.getRevealStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRevealStatus method, of class ClientGameState.
     */
    @Test
    public void testSetRevealStatus() {
        System.out.println("setRevealStatus");
        boolean revealStatus = false;
        ClientGameState instance = null;
        instance.setRevealStatus(revealStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayerId method, of class ClientGameState.
     */
    @Test
    public void testSetPlayerId() {
        System.out.println("setPlayerId");
        int playerID = 0;
        ClientGameState instance = null;
        instance.setPlayerId(playerID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeckCardCount method, of class ClientGameState.
     */
    @Test
    public void testGetDeckCardCount() {
        System.out.println("getDeckCardCount");
        ClientGameState instance = null;
        Integer expResult = null;
        Integer result = instance.getDeckCardCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerTurnOrder method, of class ClientGameState.
     */
    @Test
    public void testGetPlayerTurnOrder() {
        System.out.println("getPlayerTurnOrder");
        ClientGameState instance = null;
        List expResult = null;
        List result = instance.getPlayerTurnOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentActivePlayer method, of class ClientGameState.
     */
    @Test
    public void testGetCurrentActivePlayer() {
        System.out.println("getCurrentActivePlayer");
        ClientGameState instance = null;
        Integer expResult = null;
        Integer result = instance.getCurrentActivePlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeckCardCount method, of class ClientGameState.
     */
    @Test
    public void testSetDeckCardCount() {
        System.out.println("setDeckCardCount");
        Integer deckCardCount = null;
        ClientGameState instance = null;
        instance.setDeckCardCount(deckCardCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayerTurnOrder method, of class ClientGameState.
     */
    @Test
    public void testSetPlayerTurnOrder() {
        System.out.println("setPlayerTurnOrder");
        List<Integer> playerTurnOrder = null;
        ClientGameState instance = null;
        instance.setPlayerTurnOrder(playerTurnOrder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentActivePlayer method, of class ClientGameState.
     */
    @Test
    public void testSetCurrentActivePlayer() {
        System.out.println("setCurrentActivePlayer");
        Integer currectActivePlayer = null;
        ClientGameState instance = null;
        instance.setCurrentActivePlayer(currectActivePlayer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pushGameLog method, of class ClientGameState.
     */
    @Test
    public void testPushGameLog() {
        System.out.println("pushGameLog");
        String message = "";
        ClientGameState instance = null;
        instance.pushGameLog(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pollGameLog method, of class ClientGameState.
     */
    @Test
    public void testPollGameLog() {
        System.out.println("pollGameLog");
        ClientGameState instance = null;
        String expResult = "";
        String result = instance.pollGameLog();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pollGameLog method, of class ClientGameState.
     */
    @Test
    public void testGetPlayers() 
    {
        System.out.println("pollGameLog");
        HashMap<Integer, String> players = new HashMap<Integer, String>();
        players.put(1, "Player 1");
        ClientGameState instance = new ClientGameState(4, null, players);;
        Map<Integer, String> expResult = players;
        Map<Integer, String> result = instance.getPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
