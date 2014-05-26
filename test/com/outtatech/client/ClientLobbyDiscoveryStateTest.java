/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client;

import com.outtatech.server.Lobby;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author chiuwe
 */
public class ClientLobbyDiscoveryStateTest {
   
   public ClientLobbyDiscoveryStateTest() {
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
     * Test of getLobbyList method, of class ClientLobbyDiscoveryState.
     */
    @Test
    public void testGetLobbyList() {
        System.out.println("getLobbyList");
        ClientLobbyDiscoveryState instance = null;
        List expResult = null;
        List result = instance.getLobbyList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLobbyList method, of class ClientLobbyDiscoveryState.
     */
    @Test
    public void testSetLobbyList() {
        System.out.println("setLobbyList");
        List<Lobby> newLobbyList = null;
        ClientLobbyDiscoveryState instance = null;
        instance.setLobbyList(newLobbyList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
   
}
