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
public class HintCardTest
{
    
    /**
     *
     */
    public HintCardTest()
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
     * Test of getHintType method, of class HintCard.
     */
    @Test
    public void testGetHintType()
    {
        System.out.println("GetHintType");
        
        System.out.println("Vehicle");
        testGetVehicle();
        
        System.out.println("Suspect");
        testGetSuspect();
        
        System.out.println("Destination");
        testGetDestination();
    }
    
    /**
     *
     */
    @Test
    public void testSpecificHintCards()
    {
        System.out.println("VehicleCard");
        testVehicleCard();
        
        System.out.println("SuspectCard");
        testSuspectCard();
        
        System.out.println("DestinationCard");
        testDestinationCard();
    }
    
    /**
     *
     */
    public void testVehicleCard()
    {
        HintCard instance = new VehicleCard(VehicleID.SEAPLANE, CardColor.RED);
        VehicleID expResult = VehicleID.SEAPLANE;
        VehicleID result = ((VehicleCard)instance).getVehicle();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testSuspectCard()
    {
        HintCard instance = new SuspectCard(SuspectID.WHITE);
        SuspectID expResult = SuspectID.WHITE;
        SuspectID result = ((SuspectCard)instance).getSuspect();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testDestinationCard()
    {
        HintCard instance = new DestinationCard(DestinationID.CONEY_ISLAND);
        DestinationID expResult = DestinationID.CONEY_ISLAND;
        DestinationID result = ((DestinationCard)instance).getDestination();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testGetVehicle()
    {
        HintCard instance = new HintCard(HintCardType.VEHICLE);
        HintCardType expResult = HintCardType.VEHICLE;
        HintCardType result = instance.getHintType();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testGetSuspect()
    {
        HintCard instance = new HintCard(HintCardType.SUSPECT);
        HintCardType expResult = HintCardType.SUSPECT;
        HintCardType result = instance.getHintType();
        assertEquals(expResult, result); 
    }
    
    /**
     *
     */
    public void testGetDestination()
    {
        HintCard instance = new HintCard(HintCardType.DESTINATION);
        HintCardType expResult = HintCardType.DESTINATION;
        HintCardType result = instance.getHintType();
        assertEquals(expResult, result);
    }
}
