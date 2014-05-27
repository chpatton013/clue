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
public class GenderTest
{
    
    /**
     *
     */
    public GenderTest()
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
     * Test of values method, of class Gender.
     */
    @Test
    public void testValues()
    {
        System.out.println("values");
        Gender[] expResult = {Gender.MALE, Gender.FEMALE};
        Gender[] result = Gender.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class Gender.
     */
    @Test
    public void testValueOf()
    {
        System.out.println("valueOf");
        String name = "MALE";
        Gender expResult = Gender.MALE;
        Gender result = Gender.valueOf(name);
        assertEquals(expResult, result);
        
        name = "FEMALE";
        expResult = Gender.FEMALE;
        result = Gender.valueOf(name);
        assertEquals(expResult, result);
    }
}
