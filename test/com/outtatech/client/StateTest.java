/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client;

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
public class StateTest
{
    
    public StateTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
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
