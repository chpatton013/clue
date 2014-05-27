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
   
    /**
     *
     */
    public KickPlayerRequestTest() {
   }
   
    /**
     *
     */
    @BeforeClass
   public static void setUpClass() {
   }
   
    /**
     *
     */
    @AfterClass
   public static void tearDownClass() {
   }
   
    /**
     *
     */
    @Before
   public void setUp() {
   }
   
    /**
     *
     */
    @After
   public void tearDown() {
   }

   /**
    * Test of getPlayerId method, of class KickPlayerRequest.
    */
   @Test
   public void testGetPlayerId() {
      System.out.println("getPlayerId");
      KickPlayerRequest instance = new KickPlayerRequest(59);
      Integer expResult = 59;
      Integer result = instance.getPlayerId();
      assertEquals(expResult, result);
   }

}
