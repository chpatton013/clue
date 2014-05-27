package com.outtatech.server;

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
public class DifficultyTest
{
    
    /**
     *
     */
    public DifficultyTest()
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
     * Test of getIntelligence and setIntelligence methods, of class Difficulty.
     */
    @Test
    public void testGetSetIntelligence()
    {
        System.out.println("getIntelligence");
        
        Difficulty instance = new Difficulty(4, 5);
        int expResult = 4;
        int result = instance.getIntelligence();
        assertEquals(expResult, result);
        
        instance.setIntelligence(2);
        expResult = 2;
        result = instance.getIntelligence();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRiskiness and setRiskiness methods, of class Difficulty.
     */
    @Test
    public void testGetSetRiskiness()
    {
        System.out.println("getRiskiness");
        
        Difficulty instance = new Difficulty(4, 5);
        int expResult = 5;
        int result = instance.getRiskiness();
        assertEquals(expResult, result);
        
        instance.setRiskiness(2);
        expResult = 2;
        result = instance.getRiskiness();
        assertEquals(expResult, result);
    }
}
