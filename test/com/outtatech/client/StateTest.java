package com.outtatech.client;

import com.outtatech.client.State;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bennettschalich
 */
public class StateTest
{
    
    /**
     *
     */
    public StateTest()
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
     * Test of setHostName method, of class State.
     */
    @Test
    public void testSetGetHostName()
    {
        System.out.println("setGetHostName");
        String hostname = "host_guy";
        State instance = new State();
        instance.setHostName(hostname);
        String expResult = "host_guy";
        String result = instance.getHostName();
        assertEquals(expResult, result);
    }
}
