/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client;

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
    * Test of getGameList method, of class ClientLobbyDiscoveryState.
    */
   @Test
   public void testGetGameList() {
      System.out.println("getGameList");
      List<Integer> input = new ArrayList<Integer>();
      input.add(5);
      input.add(4);
      input.add(666);
      ClientLobbyDiscoveryState instance = new ClientLobbyDiscoveryState(input);
      List<Integer> expResult = new ArrayList<Integer>();
      expResult.add(5);
      expResult.add(4);
      expResult.add(666);
      List<Integer> result = instance.getGameList();
      assertEquals(expResult, result);
   }
   
}
