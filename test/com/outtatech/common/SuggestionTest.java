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
public class SuggestionTest
{
    
    /**
     *
     */
    public SuggestionTest()
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
     * Test of getType method, of class Suggestion.
     */
    @Test
    public void testGetType()
    {
        System.out.println("getType");
        
        System.out.println("    ANY");
        Suggestion instance = new Suggestion(SuggestionType.ANY);
        SuggestionType expResult = SuggestionType.ANY;
        SuggestionType result = instance.getType();
        assertEquals(expResult, result);
        
        System.out.println("    CURRENT");
        instance = new Suggestion(SuggestionType.CURRENT);
        expResult = SuggestionType.CURRENT;
        result = instance.getType();
        assertEquals(expResult, result);
    }
    
}
