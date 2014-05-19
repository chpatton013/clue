/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    List<Card> hand;
    
    public ServerPlayerTest()
    {
        hand = new ArrayList<Card>();
        hand.add(new Snoop());
        hand.add(new SuspectCard(SuspectID.WHITE));
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
     * Test of getPlayerId method, of class ServerPlayer
     */
    @Test
    public void testGetPlayerId()
    {
        System.out.println("getPlayerId");
        
        ServerPlayer instance = new ServerPlayer(1, new Object(), "Bob", 
                new Color(1, 1, 1), hand);
        Object expResult = 1;
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
        
        ServerPlayer instance = new ServerPlayer(1, obj, "Bob", 
                new Color(1, 1, 1), hand);
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
        
        ServerPlayer instance = new ServerPlayer(1, new Object(), "Bob", 
                new Color(1, 1, 1), hand);
        
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
        
        ServerPlayer instance = new ServerPlayer(1, new Object(), "Bob", 
                new Color(1, 1, 1), hand);
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
        
        ServerPlayer instance = new ServerPlayer(1, new Object(), "Bob", 
                new Color(1, 1, 1), hand);
        
        List<Card> expResult = hand;
        List<Card> result = instance.getHand();
        assertEquals(expResult, result);
        
        List<Card> list = new ArrayList<Card>();
        list.add(new AllSnoop(true));
        list.add(new VehicleCard(VehicleID.SEAPLANE));
        
        instance.setHand(list);
        expResult = list;
        result = instance.getHand();
        assertEquals(expResult, result);
    }
}
