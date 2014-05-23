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
 * @author chiuwe
 */
public class LobbyUpdateResponseTest {
   
   public LobbyUpdateResponseTest() {
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
    * Test of getLobby method, of class LobbyUpdateResponse.
    */
   @Test
   public void testGetLobby() {
      System.out.println("getLobby");
      Lobby input = new Lobby("testLobby", 69);
      LobbyUpdateResponse instance = new LobbyUpdateResponse(input);
      Lobby expResult = new Lobby("testLobby", 69);
      Lobby result = instance.getLobby();
      assertEquals(expResult, result);
   }
   
}
