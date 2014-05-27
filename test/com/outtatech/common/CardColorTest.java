package com.outtatech.common;

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
public class CardColorTest
{
    
    /**
     *
     */
    public CardColorTest()
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
     * Test of values method, of class CardColor.
     */
    @Test
    public void testValues()
    {
        System.out.println("values");
        CardColor[] expResult = {CardColor.RED, CardColor.BLUE};
        CardColor[] result = CardColor.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class CardColor.
     */
    @Test
    public void testValueOf()
    {
        System.out.println("valueOf");
        
        String name = "RED";
        CardColor expResult = CardColor.RED;
        CardColor result = CardColor.valueOf(name);
        assertEquals(expResult, result);
        
        name = "BLUE";
        expResult = CardColor.BLUE;
        result = CardColor.valueOf(name);
        assertEquals(expResult, result);
    }
    
}
