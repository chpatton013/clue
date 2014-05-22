/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client;

import java.util.List;
import java.util.ArrayList;
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
public class ClientPreGameStateTest
{
    
    public ClientPreGameStateTest()
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
     * Test of getPlayerId method, of class ClientPreGameState.
     */
    @Test
    public void testSetGetPlayerId()
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        
        ClientPreGameState instance = new ClientPreGameState(3, list, false);
        int expResult = 3;
        int result = instance.getPlayerId();
        assertEquals(expResult, result);
        
        instance.setPlayerId(5);
        expResult = 5;
        result = instance.getPlayerId();
        assertEquals(expResult, result);
    }
    /**
     * Test of getPlayerIdList method, of class ClientPreGameState.
     * HAVE NOT YET TESTED THIS
     */
    @Test
    public void testGetPlayerIdList()
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        
        ClientPreGameState instance = new ClientPreGameState(3, list, false);
        List<Integer> expResult = new ArrayList<Integer>();
        expResult.add(1);
        expResult.add(2);
        List<Integer> result = instance.getPlayerIdList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGameOwner method, of class ClientPreGameState.
     */
    @Test
    public void testSetGetGameOwner()
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        
        ClientPreGameState instance = new ClientPreGameState(5, list, false);
        boolean expResult = false;
        boolean result = instance.getGameOwner();
        assertEquals(expResult, result);
        
        instance.setGameOwner(true);
        expResult = true;
        result = instance.getGameOwner();
        assertEquals(expResult, result);
    }
}
