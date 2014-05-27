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
public class ActionCardTypeTest 
{
    
    /**
     *
     */
    public ActionCardTypeTest() 
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
     * Test of values method, of class ActionCardType.
     */
    @Test
    public void testValues() 
    {
        System.out.println("Values");
        ActionCardType[] expResult = {ActionCardType.SUGGESTION, 
            ActionCardType.SNOOP, ActionCardType.ALL_SNOOP, 
            ActionCardType.SUPER_SLEUTH, ActionCardType.PRIVATE_TIP};
        ActionCardType[] result = ActionCardType.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class ActionCardType.
     */
    @Test
    public void testValueOf() 
    {
        System.out.println("ValueOf");
        
        System.out.println("SNOOP");
        testSnoop();
        
        System.out.println("ALL_SNOOP");
        testAllSnoop();
        
        System.out.println("PRIVATE_TIP");
        testPrivateTip();
        
        System.out.println("SUGGESTION");
        testSuggestion();
        
        System.out.println("SUPER_SLEUTH");
        testSuperSleuth();
    }
    
    /**
     *
     */
    public void testSnoop()
    {
        String name = "SNOOP";
        ActionCardType expResult = ActionCardType.SNOOP;
        ActionCardType result = ActionCardType.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testAllSnoop()
    {
        String name = "ALL_SNOOP";
        ActionCardType expResult = ActionCardType.ALL_SNOOP;
        ActionCardType result = ActionCardType.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testPrivateTip()
    {
        String name = "PRIVATE_TIP";
        ActionCardType expResult = ActionCardType.PRIVATE_TIP;
        ActionCardType result = ActionCardType.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testSuggestion()
    {
        String name = "SUGGESTION";
        ActionCardType expResult = ActionCardType.SUGGESTION;
        ActionCardType result = ActionCardType.valueOf(name);
        assertEquals(expResult, result);
    }
    
    private void testSuperSleuth()
    {
        String name = "SUPER_SLEUTH";
        ActionCardType expResult = ActionCardType.SUPER_SLEUTH;
        ActionCardType result = ActionCardType.valueOf(name);
        assertEquals(expResult, result);
    }
}
