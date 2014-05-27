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
public class VehicleIDTest
{
    
    /**
     *
     */
    public VehicleIDTest()
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
     * Test of values method, of class VehicleID.
     */
    @Test
    public void testValues()
    {
        System.out.println("Values");
        VehicleID[] expResult = {VehicleID.SEAPLANE, VehicleID.AUTOMOBILE, 
            VehicleID.AIRLINER, VehicleID.HOT_AIR_BALLOON, VehicleID.LIMOUSINE, 
            VehicleID.TRAIN};
        VehicleID[] result = VehicleID.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class VehicleID.
     */
    @Test
    public void testValueOf()
    {
        System.out.println("ValueOf");
        
        System.out.println("SEAPLANE");
        testSeaPlane();
        
        System.out.println("AUTOMOBLE");
        testAutomobile();
        
        System.out.println("AIRLINER");
        testAirliner();
        
        System.out.println("HOT_AIR_BALLOON");
        testHotAirBalloon();
        
        System.out.println("LIMOUSINE");
        testLimousine();
        
        System.out.println("TRAIN");
        testTrain();
    }
    
    /**
     *
     */
    public void testSeaPlane()
    {
        String name = "SEAPLANE";
        VehicleID expResult = VehicleID.SEAPLANE;
        VehicleID result = VehicleID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testAutomobile()
    {
        String name = "AUTOMOBILE";
        VehicleID expResult = VehicleID.AUTOMOBILE;
        VehicleID result = VehicleID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testAirliner()
    {
        String name = "AIRLINER";
        VehicleID expResult = VehicleID.AIRLINER;
        VehicleID result = VehicleID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testHotAirBalloon()
    {
        String name = "HOT_AIR_BALLOON";
        VehicleID expResult = VehicleID.HOT_AIR_BALLOON;
        VehicleID result = VehicleID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testLimousine()
    {
        String name = "LIMOUSINE";
        VehicleID expResult = VehicleID.LIMOUSINE;
        VehicleID result = VehicleID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testTrain()
    {
        String name = "TRAIN";
        VehicleID expResult = VehicleID.TRAIN;
        VehicleID result = VehicleID.valueOf(name);
        assertEquals(expResult, result);
    }
}
