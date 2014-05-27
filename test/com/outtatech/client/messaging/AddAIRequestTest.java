package com.outtatech.client.messaging;

import com.outtatech.server.Difficulty;
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
public class AddAIRequestTest
{
    
    /**
     *
     */
    public AddAIRequestTest()
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
     * Test of setLobbyId and getLobbyId methods, of class AddAIRequest.
     */
    @Test
    public void testGetSetLobbyId()
    {
        System.out.println("setLobbyId");
        
        AddAIRequest instance = new AddAIRequest(new Difficulty(5, 5), new Integer(5));
        Integer expResult = new Integer(5);
        Integer result = instance.getLobbyId();
        assertEquals(expResult, result);
        
        instance.setLobbyId(new Integer(6));
        expResult = new Integer(6);
        result = instance.getLobbyId();
        assertEquals(expResult, result);
    }
  
    /**
     * Test of getDifficulty method, of class AddAIRequest.
     */
    @Test
    public void testGetDifficulty()
    {
        System.out.println("getDifficulty");
        
        Difficulty diff = new Difficulty(4, 5);
        AddAIRequest instance = new AddAIRequest(diff, new Integer(2));
        Difficulty expResult = diff;
        Difficulty result = instance.getDifficulty();
        assertEquals(expResult, result);
    }
    
}
