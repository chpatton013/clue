/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client.messaging;

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
public class LobbyJoinRequestTest
{
    
    public LobbyJoinRequestTest()
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
     * Test of getLobbyId method, of class LobbyJoinRequest.
     */
    @Test
    public void testGetLobbyId()
    {
        System.out.println("getLobbyId");
        
        LobbyJoinRequest instance = new LobbyJoinRequest(new Integer(5));
        Integer expResult = new Integer(5);
        Integer result = instance.getLobbyId();
        assertEquals(expResult, result);
    }
    
}
