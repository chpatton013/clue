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
public class SuperSleuthTest
{
    
    /**
     *
     */
    public SuperSleuthTest()
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
     * Test of getType method, of class SuperSleuth.
     */
    @Test
    public void testGetType()
    {
        System.out.println("getType");
        
        System.out.println("    AIR_VEHICLE");
        SuperSleuth instance = new SuperSleuth(SuperSleuthType.AIR_VEHICLE);
        SuperSleuthType expResult = SuperSleuthType.AIR_VEHICLE;
        SuperSleuthType result = instance.getType();
        assertEquals(expResult, result);
        
        System.out.println("    BLUE_CARD");
        instance = new SuperSleuth(SuperSleuthType.BLUE_CARD);
        expResult = SuperSleuthType.BLUE_CARD;
        result = instance.getType();
        assertEquals(expResult, result);
        
        System.out.println("    FEMALE_SUSPECT");
        instance = new SuperSleuth(SuperSleuthType.FEMALE_SUSPECT);
        expResult = SuperSleuthType.FEMALE_SUSPECT;
        result = instance.getType();
        assertEquals(expResult, result);
        
        System.out.println("    MALE_SUSPECT");
        instance = new SuperSleuth(SuperSleuthType.MALE_SUSPECT);
        expResult = SuperSleuthType.MALE_SUSPECT;
        result = instance.getType();
        assertEquals(expResult, result);
        
        System.out.println("    SOUTHERN_DESTINATION");
        instance = new SuperSleuth(SuperSleuthType.SOUTHERN_DESTINATION);
        expResult = SuperSleuthType.SOUTHERN_DESTINATION;
        result = instance.getType();
        assertEquals(expResult, result);
        
        System.out.println("    WESTERN_DESTINATION");
        instance = new SuperSleuth(SuperSleuthType.WESTERN_DESTINATION);
        expResult = SuperSleuthType.WESTERN_DESTINATION;
        result = instance.getType();
        assertEquals(expResult, result);
    }
    
}
