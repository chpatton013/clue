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
public class PrivateTipTypeTest
{
    
    /**
     *
     */
    public PrivateTipTypeTest()
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
     * Test of values method, of class PrivateTipType.
     */
    @Test
    public void testValues()
    {
        System.out.println("Values");
        PrivateTipType[] expResult = {PrivateTipType.ALL_DESTINATIONS, 
                PrivateTipType.ALL_VEHICLES, 
                PrivateTipType.ONE_NORTHERN_DESTINATION, 
                PrivateTipType.ALL_SUSPECTS, PrivateTipType.ONE_FEMALE_SUSPECT, 
                PrivateTipType.ONE_RED_VEHICLE};
        PrivateTipType[] result = PrivateTipType.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class PrivateTipType.
     */
    @Test
    public void testValueOf()
    {
        System.out.println("ValueOf");
        
        System.out.println("    ALL_DESTINATIONS");
        String name = "ALL_DESTINATIONS";
        PrivateTipType expResult = PrivateTipType.ALL_DESTINATIONS;
        PrivateTipType result = PrivateTipType.valueOf(name);
        assertEquals(expResult, result);
        
        System.out.println("    ALL_VEHICLES");
        name = "ALL_VEHICLES";
        expResult = PrivateTipType.ALL_VEHICLES;
        result = PrivateTipType.valueOf(name);
        assertEquals(expResult, result);
        
        System.out.println("    ONE_NORTHER_DESTINATION");
        name = "ONE_NORTHERN_DESTINATION";
        expResult = PrivateTipType.ONE_NORTHERN_DESTINATION;
        result = PrivateTipType.valueOf(name);
        assertEquals(expResult, result);
        
        System.out.println("    ALL_SUSPECTS");
        name = "ALL_SUSPECTS";
        expResult = PrivateTipType.ALL_SUSPECTS;
        result = PrivateTipType.valueOf(name);
        assertEquals(expResult, result);
        
        System.out.println("    ONE_FEMALE_SUSPECT");
        name = "ONE_FEMALE_SUSPECT";
        expResult = PrivateTipType.ONE_FEMALE_SUSPECT;
        result = PrivateTipType.valueOf(name);
        assertEquals(expResult, result);
        
        System.out.println("    ONE_RED_VEHICLE");
        name = "ONE_RED_VEHICLE";
        expResult = PrivateTipType.ONE_RED_VEHICLE;
        result = PrivateTipType.valueOf(name);
        assertEquals(expResult, result);
    }
    
}
