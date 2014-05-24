/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server.messaging;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bschache
 */
public class LobbyJoinResponseTest {
    
    public LobbyJoinResponseTest() {
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
     * Test of getJoinedPlayerId method, of class LobbyJoinResponse.
     */
    @Test
    public void testGetJoinedPlayerId() {
        System.out.println("getJoinedPlayerId");
        Integer expResult = 99999;
        LobbyJoinResponse instance = new LobbyJoinResponse(expResult);
        Integer result = instance.getJoinedPlayerId();
        assertEquals(expResult, result);
    }
}