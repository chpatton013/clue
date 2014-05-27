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
public class HintCardTypeTest 
{
    
    /**
     *
     */
    public HintCardTypeTest() 
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
     * Test of values method, of class HintCardType.
     */
    @Test
    public void testValues() 
    {
        System.out.println("Values");
        HintCardType[] expResult = {HintCardType.VEHICLE, HintCardType.SUSPECT, 
            HintCardType.DESTINATION};
        HintCardType[] result = HintCardType.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class HintCardType.
     */
    @Test
    public void testValueOf() 
    {
        System.out.println("ValueOf");
        
        System.out.println("VEHICLE");
        testVehicle();
        
        System.out.println("SUSPECT");
        testSuspect();
        
        System.out.println("DESTINATION");
        testDestination();
    }
    
    /**
     *
     */
    public void testVehicle()
    {
        String name = "VEHICLE";
        HintCardType expResult = HintCardType.VEHICLE;
        HintCardType result = HintCardType.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testSuspect()
    {
        String name = "SUSPECT";
        HintCardType expResult = HintCardType.SUSPECT;
        HintCardType result = HintCardType.valueOf(name);
        assertEquals(expResult, result); 
    }
    
    /**
     *
     */
    public void testDestination()
    {
        String name = "DESTINATION";
        HintCardType expResult = HintCardType.DESTINATION;
        HintCardType result = HintCardType.valueOf(name);
        assertEquals(expResult, result);
    }
}
