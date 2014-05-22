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
public class ClientLobbyStateTest
{
    
    public ClientLobbyStateTest()
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
     * Test of getGameList method, of class ClientLobbyState.
     */
    @Test
    public void testGetGameList()
    {
        System.out.println("getGameList");
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        
        ClientLobbyState instance = new ClientLobbyState(list);
        List<Integer> expResult = list;
        List<Integer> result = instance.getGameList();
        assertEquals(expResult, result);
    }
    
}
