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
public class SuperSleuthTypeTest
{
    
    /**
     *
     */
    public SuperSleuthTypeTest()
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
     * Test of values method, of class SuperSleuthType.
     */
    @Test
    public void testValues()
    {
        System.out.println("Values");
        SuperSleuthType[] expResult = {SuperSleuthType.AIR_VEHICLE, 
            SuperSleuthType.BLUE_CARD, SuperSleuthType.FEMALE_SUSPECT, 
            SuperSleuthType.MALE_SUSPECT, SuperSleuthType.SOUTHERN_DESTINATION,
            SuperSleuthType.WESTERN_DESTINATION};
        SuperSleuthType[] result = SuperSleuthType.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class SuperSleuthType.
     */
    @Test
    public void testValueOf()
    {
        System.out.println("ValueOf");
        
        System.out.println("    AIR_VEHICLE");
        String name = "AIR_VEHICLE";
        SuperSleuthType expResult = SuperSleuthType.AIR_VEHICLE;
        SuperSleuthType result = SuperSleuthType.valueOf(name);
        assertEquals(expResult, result);
        
        System.out.println("    BLUE_CARD");
        name = "BLUE_CARD";
        expResult = SuperSleuthType.BLUE_CARD;
        result = SuperSleuthType.valueOf(name);
        assertEquals(expResult, result);
        
        System.out.println("    FEMALE_SUSPECT");
        name = "FEMALE_SUSPECT";
        expResult = SuperSleuthType.FEMALE_SUSPECT;
        result = SuperSleuthType.valueOf(name);
        assertEquals(expResult, result);
        
        System.out.println("    MALE_SUSPECT");
        name = "MALE_SUSPECT";
        expResult = SuperSleuthType.MALE_SUSPECT;
        result = SuperSleuthType.valueOf(name);
        assertEquals(expResult, result);
        
        System.out.println("    SOUTHERN_DESTINATION");
        name = "SOUTHERN_DESTINATION";
        expResult = SuperSleuthType.SOUTHERN_DESTINATION;
        result = SuperSleuthType.valueOf(name);
        assertEquals(expResult, result);
        
        System.out.println("    WESTERN_DESTINATION");
        name = "WESTERN_DESTINATION";
        expResult = SuperSleuthType.WESTERN_DESTINATION;
        result = SuperSleuthType.valueOf(name);
        assertEquals(expResult, result);
    }
}
