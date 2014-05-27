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
public class CardTypeTest 
{
    
    /**
     *
     */
    public CardTypeTest() 
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
     * Test of values method, of class CardType.
     */
    @Test
    public void testValues() 
    {
        System.out.println("Values");
        
        CardType[] expResult = {CardType.HINT, CardType.ACTION};
        CardType[] result = CardType.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class CardType.
     */
    @Test
    public void testValueOf() {
        System.out.println("ValueOf");
        
        System.out.println("HINT");
        String name = "HINT";
        CardType expResult = CardType.HINT;
        CardType result = CardType.valueOf(name);
        assertEquals(expResult, result);
        
        System.out.println("ACTION");
        name = "ACTION";
        expResult = CardType.ACTION;
        result = CardType.valueOf(name);
        assertEquals(expResult, result);
    }
}
