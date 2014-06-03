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
    
    /**
     *
     */
    public ClientGameStateTest()
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
        instance.setNotes(obj);
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
        instance.setDestToPlayerId(map);
        Map<DestinationID, Integer> result = instance.getDestToPlayerId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccusationStatus method, of class ClientGameState.
     */
    @Test
    public void testGetAccusationStatus() {
        System.out.println("getAccusationStatus");
        
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        list.add(new Card(CardType.ACTION));
        
        Map<DestinationID, Integer> map = new HashMap<DestinationID, Integer>();
        map.put(DestinationID.CONEY_ISLAND, new Integer(5));
        map.put(DestinationID.THE_ALAMO, new Integer(3));
        
        Map<Integer, String> players = null;
        ClientGameState instance = new ClientGameState(4, list, players);
        boolean expResult = false;
        boolean result = instance.getAccusationStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccusation method, of class ClientGameState.
     */
    @Test
    public void testGetAccusation() {
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        list.add(new Card(CardType.ACTION));
        
        Map<DestinationID, Integer> map = new HashMap<DestinationID, Integer>();
        map.put(DestinationID.CONEY_ISLAND, new Integer(5));
        map.put(DestinationID.THE_ALAMO, new Integer(3));
        
        Map<Integer, String> players = null;
        ClientGameState instance = new ClientGameState(4, list, players);
        boolean expResult = false;
        boolean result = instance.getAccusation();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPlayerId method, of class ClientGameState.
     */
    @Test
    public void testGetPlayerId() {
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

    }

    /**
     * Test of getRevealed method, of class ClientGameState.
     */
    @Test
    public void testGetRevealed() {
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        list.add(new Card(CardType.ACTION));
        
        Map<DestinationID, Integer> map = new HashMap<DestinationID, Integer>();
        map.put(DestinationID.CONEY_ISLAND, new Integer(5));
        map.put(DestinationID.THE_ALAMO, new Integer(3));
        
        Map<Integer, String> players = null;
        ClientGameState instance = new ClientGameState(4, list, players);
        List expResult = new ArrayList<Card>();
        List result = instance.getRevealed();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRevealStatus method, of class ClientGameState.
     */
    @Test
    public void testGetRevealStatus() {
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        list.add(new Card(CardType.ACTION));
        
        Map<DestinationID, Integer> map = new HashMap<DestinationID, Integer>();
        map.put(DestinationID.CONEY_ISLAND, new Integer(5));
        map.put(DestinationID.THE_ALAMO, new Integer(3));
        
        Map<Integer, String> players = null;
        ClientGameState instance = new ClientGameState(4, list, players);
        boolean expResult = false;
        boolean result = instance.getRevealStatus();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCurrentActivePlayer method, of class ClientGameState.
     */
    @Test
    public void testGetCurrentActivePlayer() {
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        list.add(new Card(CardType.ACTION));
        
        Map<DestinationID, Integer> map = new HashMap<DestinationID, Integer>();
        map.put(DestinationID.CONEY_ISLAND, new Integer(5));
        map.put(DestinationID.THE_ALAMO, new Integer(3));
        
        Map<Integer, String> players = null;
        ClientGameState instance = new ClientGameState(4, list, players);
        Integer expResult = null;
        Integer result = instance.getCurrentActivePlayer();
        assertEquals(expResult, result);
    }

    /**
     * Test of pollGameLog method, of class ClientGameState.
     */
    @Test
    public void testPollGameLog() {
        System.out.println("pollGameLog");
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        list.add(new Card(CardType.ACTION));
        
        Map<DestinationID, Integer> map = new HashMap<DestinationID, Integer>();
        map.put(DestinationID.CONEY_ISLAND, new Integer(5));
        map.put(DestinationID.THE_ALAMO, new Integer(3));
        
        Map<Integer, String> players = null;
        ClientGameState instance = new ClientGameState(4, list, players);
        String expResult = null;
        String result = instance.pollGameLog();
        assertEquals(expResult, result);

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

    }
}
