/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.server.messaging;

import com.outtatech.server.Lobby;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dmangin
 */
public class LobbyCreateResponseTest {
    
    public LobbyCreateResponseTest() {
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
     * Test of getLobby method, of class LobbyCreateResponse.
     */
    @Test
    public void testGetLobby() {
        Lobby temp = new Lobby("TestLobby", 12);
        LobbyCreateResponse instance = new LobbyCreateResponse(temp);
        Lobby expResult = temp;
        Lobby result = instance.getLobby();
        assertEquals(expResult, result);
    }
    
}