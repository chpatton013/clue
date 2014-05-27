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
public class PrivateTipTest
{
    
    /**
     *
     */
    public PrivateTipTest()
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
     * Test of getType method, of class PrivateTip.
     */
    @Test
    public void testGetType()
    {
        System.out.println("getType");
        
        System.out.println("    ALL_DESTINATIONS");
        PrivateTip instance = new PrivateTip(PrivateTipType.ALL_DESTINATIONS);
        PrivateTipType expResult = PrivateTipType.ALL_DESTINATIONS;
        PrivateTipType result = instance.getType();
        assertEquals(expResult, result);
        
        System.out.println("    ALL_VEHCILES");
        instance = new PrivateTip(PrivateTipType.ALL_VEHICLES);
        expResult = PrivateTipType.ALL_VEHICLES;
        result = instance.getType();
        assertEquals(expResult, result);
        
        System.out.println("    ONE_NORTHERN_DESTINATION");
        instance = new PrivateTip(PrivateTipType.ONE_NORTHERN_DESTINATION);
        expResult = PrivateTipType.ONE_NORTHERN_DESTINATION;
        result = instance.getType();
        assertEquals(expResult, result);
        
        System.out.println("    ALL_SUSPECTS");
        instance = new PrivateTip(PrivateTipType.ALL_SUSPECTS);
        expResult = PrivateTipType.ALL_SUSPECTS;
        result = instance.getType();
        assertEquals(expResult, result);
        
        System.out.println("    ONE_FEMALE_SUSPECT");
        instance = new PrivateTip(PrivateTipType.ONE_FEMALE_SUSPECT);
        expResult = PrivateTipType.ONE_FEMALE_SUSPECT;
        result = instance.getType();
        assertEquals(expResult, result);
        
        System.out.println("    ONE_RED_VEHICLE");
        instance = new PrivateTip(PrivateTipType.ONE_RED_VEHICLE);
        expResult = PrivateTipType.ONE_RED_VEHICLE;
        result = instance.getType();
        assertEquals(expResult, result);
    }
    
}
