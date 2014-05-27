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
public class VehicleCardTest
{
    
    /**
     *
     */
    public VehicleCardTest()
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
     * Test of getVehicle method, of class VehicleCard.
     */
    @Test
    public void testGetVehicle()
    {
        System.out.println("getVehicle");
        
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
        VehicleCard instance = new VehicleCard(VehicleID.SEAPLANE, CardColor.RED);
        VehicleID expResult = VehicleID.SEAPLANE;
        VehicleID result = instance.getVehicle();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testAutomobile()
    {
        VehicleCard instance = new VehicleCard(VehicleID.AUTOMOBILE, CardColor.RED);
        VehicleID expResult = VehicleID.AUTOMOBILE;
        VehicleID result = instance.getVehicle();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testAirliner()
    {
        VehicleCard instance = new VehicleCard(VehicleID.AIRLINER, CardColor.RED);
        VehicleID expResult = VehicleID.AIRLINER;
        VehicleID result = instance.getVehicle();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testHotAirBalloon()
    {
        VehicleCard instance = new VehicleCard(VehicleID.HOT_AIR_BALLOON, CardColor.RED);
        VehicleID expResult = VehicleID.HOT_AIR_BALLOON;
        VehicleID result = instance.getVehicle();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testLimousine()
    {
        VehicleCard instance = new VehicleCard(VehicleID.LIMOUSINE, CardColor.RED);
        VehicleID expResult = VehicleID.LIMOUSINE;
        VehicleID result = instance.getVehicle();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testTrain()
    {
        VehicleCard instance = new VehicleCard(VehicleID.TRAIN, CardColor.RED);
        VehicleID expResult = VehicleID.TRAIN;
        VehicleID result = instance.getVehicle();
        assertEquals(expResult, result);
    }
}
