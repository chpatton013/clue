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
public class LobbyCreateRequestTest
{
    
    /**
     *
     */
    public LobbyCreateRequestTest()
    {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    /**
     *
     */
    @Before
    public void setUp()
    {
    }
    
    /**
     *
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getLobbyName method, of class LobbyCreateRequest.
     */
    @Test
    public void testGetLobbyName()
    {
        System.out.println("getLobbyName");
        
        LobbyCreateRequest instance = new LobbyCreateRequest("lobby");
        String expResult = "lobby";
        String result = instance.getLobbyName();
        assertEquals(expResult, result);
    }
    
}
