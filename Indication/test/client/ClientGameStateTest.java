/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import com.outtatech.common.Card;
import com.outtatech.common.CardType;
import com.outtatech.common.DestinationID;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        
        ClientGameState instance = new ClientGameState(4, new Object(), list, 
                map);
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
        ClientGameState instance = new ClientGameState(4, obj, list, 
                map);
        
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
        
        ClientGameState instance = new ClientGameState(4, new Object(), list, 
                map);
        
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
        
        ClientGameState instance = new ClientGameState(4, new Object(), list, 
                map);
        Map<DestinationID, Integer> expResult = map;
        Map<DestinationID, Integer> result = instance.getDestToPlayerId();
        assertEquals(expResult, result);
    }
    
}
