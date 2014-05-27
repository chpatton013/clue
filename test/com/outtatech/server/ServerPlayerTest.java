package com.outtatech.server;

import com.outtatech.common.*;
import java.awt.Color;
import java.util.*;
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
public class ServerPlayerTest
{
    List<ActionCard> actionCardsHand;
    List<HintCard> hintCardsHand;
    
    /**
     *
     */
    public ServerPlayerTest()
    {
        actionCardsHand = new ArrayList<ActionCard>();
        hintCardsHand = new ArrayList<HintCard>();
        actionCardsHand.add(new Snoop());
        //hintCardsHand.add(new SuspectCard(SuspectID.WHITE, CardColor.RED));
        hintCardsHand.add(new SuspectCard(SuspectID.WHITE));
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
     * Test of getPlayerId method, of class ServerPlayer
     */
    @Test
    public void testGetPlayerId()
    {
        System.out.println("getPlayerId");
        
        //ServerPlayer instance = new ServerPlayer(1, new Object(), "Bob", 
        //        new Color(1, 1, 1), hintCardsHand, actionCardsHand);
        ServerPlayer instance = new ServerPlayer();
        Object expResult = 0;
        Object result = instance.getPlayerId();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNotes and setNotes methods, of class ServerPlayer.
     */
    @Test
    public void testGetSetNotes()
    {
        System.out.println("getNotes");
        
        Object obj = new Object();
        
        //ServerPlayer instance = new ServerPlayer(1, obj, "Bob", 
        //        new Color(1, 1, 1), hintCardsHand, actionCardsHand);
        ServerPlayer instance = new ServerPlayer();
        instance.setNotes(obj);
        Object expResult = obj;
        Object result = instance.getNotes();
        assertEquals(expResult, result);
        
        Object newObj = new Color(1, 1, 1);
        instance.setNotes(newObj);
        expResult = newObj;
        result = instance.getNotes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName and setName methods, of class ServerPlayer.
     */
    @Test
    public void testGetSetName()
    {
        System.out.println("getName");
        
        //ServerPlayer instance = new ServerPlayer(1, new Object(), "Bob", 
        //        new Color(1, 1, 1), hintCardsHand, actionCardsHand);
        ServerPlayer instance = new ServerPlayer();
        instance.setName("Bob");
        String expResult = "Bob";
        String result = instance.getName();
        assertEquals(expResult, result);
        
        instance.setName("Jill");
        expResult = "Jill";
        result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor and setColor method, of class ServerPlayer.
     */
    @Test
    public void testGetSetColor()
    {
        System.out.println("getColor");
        
        //ServerPlayer instance = new ServerPlayer(1, new Object(), "Bob", 
        //        new Color(1, 1, 1), hintCardsHand, actionCardsHand);
        ServerPlayer instance = new ServerPlayer();
        
        instance.setColor(new Color(1,1,1));
        Color expResult = new Color(1, 1, 1);
        Color result = instance.getColor();
        assertEquals(expResult, result);
        
        instance.setColor(new Color(0, 0, 0));
        expResult = new Color(0, 0, 0);
        result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHand and setHand methods, of class ServerPlayer.
     */
    @Test
    public void testGetSetHand()
    {
        System.out.println("getHand");
        
        //ServerPlayer instance = new ServerPlayer(1, new Object(), "Bob", 
        //        new Color(1, 1, 1), hintCardsHand, actionCardsHand);
        ServerPlayer instance = new ServerPlayer();
        instance.setHintCardsHand(hintCardsHand);
        List<HintCard> expResult1 = hintCardsHand;
        List<HintCard> result1 = instance.getHintCardsHand();
        assertEquals(expResult1, result1);
        instance.setActionCardsHand(actionCardsHand);
        List<ActionCard> expResult2 = actionCardsHand;
        List<ActionCard> result2 = instance.getActionCardsHand();
        assertEquals(expResult2, result2);
        
        List<ActionCard> actionList = new ArrayList();
        actionList.add(new AllSnoop(true));
        
        List<HintCard> hintList = new ArrayList();
        hintList.add(new VehicleCard(VehicleID.SEAPLANE, CardColor.RED));
        
        instance.setHintCardsHand(hintList);
        expResult1 = hintList;
        result1 = instance.getHintCardsHand();
        assertEquals(expResult1, result1);
        
        instance.setActionCardsHand(actionList);
        expResult2 = actionList;
        result2 = instance.getActionCardsHand();
        assertEquals(expResult2, result2);
    }
}
