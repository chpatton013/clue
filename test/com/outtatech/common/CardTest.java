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
public class CardTest 
{
    
    /**
     *
     */
    public CardTest() 
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
     *
     */
    @Test
    public void getCardID()
    {
        System.out.println("getCardID");
        Card instance = new Card(CardType.HINT);
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        
        
        /*instance = new Card(CardType.ACTION);
        expResult = 1;
        result = instance.getID();
        assertEquals(expResult, result);*/
    }
    
    /**
     * Test of getCardType method, of class Card.
     */
    @Test
    public void testGetCardType() 
    {
        System.out.println("getCardType");
        Card instance = new Card(CardType.HINT);
        CardType expResult = CardType.HINT;
        CardType result = instance.getCardType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}