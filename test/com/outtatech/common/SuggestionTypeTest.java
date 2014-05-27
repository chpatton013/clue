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
public class SuggestionTypeTest
{
    
    /**
     *
     */
    public SuggestionTypeTest()
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
     * Test of values method, of class SuggestionType.
     */
    @Test
    public void testValues()
    {
        System.out.println("Values");
        SuggestionType[] expResult = {SuggestionType.ANY, SuggestionType.CURRENT};
        SuggestionType[] result = SuggestionType.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class SuggestionType.
     */
    @Test
    public void testValueOf()
    {
        System.out.println("ValueOf");
        
        System.out.println("    ANY");
        String name = "ANY";
        SuggestionType expResult = SuggestionType.ANY;
        SuggestionType result = SuggestionType.valueOf(name);
        assertEquals(expResult, result);
        
        System.out.println("    CURRENT");
        name = "CURRENT";
        expResult = SuggestionType.CURRENT;
        result = SuggestionType.valueOf(name);
        assertEquals(expResult, result);
    }
}
