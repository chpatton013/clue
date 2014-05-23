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
 * @author chiuwe
 */
public class KickPlayerRequestTest {
   
   public KickPlayerRequestTest() {
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
    * Test of getPlayerId method, of class KickPlayerRequest.
    */
   @Test
   public void testGetPlayerId() {
      System.out.println("getPlayerId");
      KickPlayerRequest instance = new KickPlayerRequest(59, 4873);
      Integer expResult = 59;
      Integer result = instance.getPlayerId();
      assertEquals(expResult, result);
   }

   /**
    * Test of getLobbyId method, of class KickPlayerRequest.
    */
   @Test
   public void testGetLobbyId() {
      System.out.println("getLobbyId");
      KickPlayerRequest instance = new KickPlayerRequest(59, 4873);
      Integer expResult = 4873;
      Integer result = instance.getLobbyId();
      assertEquals(expResult, result);
   }
}
