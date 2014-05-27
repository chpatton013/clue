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
public class DestinationCardTest 
{
    
    public DestinationCardTest() 
    {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDestination method, of class DestinationCard.
     */
    @Test
    public void testGetDestination() {
        System.out.println("GetDestination");
        
        System.out.println("    NIAGRA_FALLS");
        testNiagraFalls();
        
        System.out.println("    GOLDEN_GATE_BRIDGE");
        testGoldenGateBridge();
        
        System.out.println("    OLD_FAITHFUL");
        testOldFaithful();
        
        System.out.println("    CONEY_ISLAND");
        testConeyIsland();
        
        System.out.println("    THE_ALAMO");
        testTheAlamo();
        
        System.out.println("    HOOVER_DAM");
        testHooverDam();
        
        System.out.println("    LINCOLN_MEMORIAL");
        testLincolnMemorial();
        
        System.out.println("    MIAMI_BEACH");
        testMiamiBeach();
        
        System.out.println("    MT_RUSHMORE");
        testMtRushmore();
    }
    
    public void testNiagraFalls()
    {
        DestinationCard instance = new DestinationCard(DestinationID.NIAGRA_FALLS, CardColor.RED);
        DestinationID expResult = DestinationID.NIAGRA_FALLS;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testGoldenGateBridge()
    {
        DestinationCard instance = new DestinationCard(DestinationID.GOLDEN_GATE_BRIDGE, CardColor.RED);
        DestinationID expResult = DestinationID.GOLDEN_GATE_BRIDGE;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testOldFaithful()
    {
        DestinationCard instance = new DestinationCard(DestinationID.OLD_FAITHFUL, CardColor.RED);
        DestinationID expResult = DestinationID.OLD_FAITHFUL;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testConeyIsland()
    {
        DestinationCard instance = new DestinationCard(DestinationID.CONEY_ISLAND, CardColor.RED);
        DestinationID expResult = DestinationID.CONEY_ISLAND;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testTheAlamo()
    {
        DestinationCard instance = new DestinationCard(DestinationID.THE_ALAMO, CardColor.RED);
        DestinationID expResult = DestinationID.THE_ALAMO;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testHooverDam()
    {
        DestinationCard instance = new DestinationCard(DestinationID.HOOVER_DAM, CardColor.RED);
        DestinationID expResult = DestinationID.HOOVER_DAM;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testLincolnMemorial()
    {
        DestinationCard instance = new DestinationCard(DestinationID.LINCOLN_MEMORIAL, CardColor.RED);
        DestinationID expResult = DestinationID.LINCOLN_MEMORIAL;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testMiamiBeach()
    {
        DestinationCard instance = new DestinationCard(DestinationID.MIAMI_BEACH, CardColor.RED);
        DestinationID expResult = DestinationID.MIAMI_BEACH;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testMtRushmore()
    {
        DestinationCard instance = new DestinationCard(DestinationID.MT_RUSHMORE, CardColor.RED);
        DestinationID expResult = DestinationID.MT_RUSHMORE;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetIsNorth()
    {
        System.out.println("getIsNorth");
        
        System.out.println("    NIAGRA_FALLS");
        testisNorthNiagraFalls();
        
        System.out.println("    CONEY_ISLAND");
        testIsNorthConeyIsland();
        
        System.out.println("    MT_RUSHMORE");
        testIsNorthMtRushmore();
        
        System.out.println("    OLD_FAITHFUL");
        testIsNorthOldFaithful();
        
        System.out.println("    GOLDEN_GATE_BRIDGE");
        testIsNorthGoldenGateBridge();
        
        System.out.println("    HOOVER_DAM");
        testIsNorthHooverDam();
        
        System.out.println("    THE_ALAMO");
        testIsNorthTheAlamo();
        
        System.out.println("    LINCOLN_MEMORIAL");
        testIsNorthLincolnMemorial();
        
        System.out.println("    MIAMI_BEACH");
        testIsNorthMiamiBeach();
    }
    
    public void testisNorthNiagraFalls()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.NIAGRA_FALLS, CardColor.RED);
        boolean expResult = true;
        boolean result = instance.getIsNorth();
        assertEquals(expResult, result);
    }
    
    public void testIsNorthConeyIsland()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.CONEY_ISLAND, CardColor.RED);
        boolean expResult = true;
        boolean result = instance.getIsNorth();
        assertEquals(expResult, result);
    }
    
    public void testIsNorthMtRushmore()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.MT_RUSHMORE, CardColor.RED);
        boolean expResult = true;
        boolean result = instance.getIsNorth();
        assertEquals(expResult, result);
    }
    
    public void testIsNorthOldFaithful()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.OLD_FAITHFUL, CardColor.RED);
        boolean expResult = true;
        boolean result = instance.getIsNorth();
        assertEquals(expResult, result);
    }
    
    public void testIsNorthGoldenGateBridge()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.GOLDEN_GATE_BRIDGE, CardColor.RED);
        boolean expResult = false;
        boolean result = instance.getIsNorth();
        assertEquals(expResult, result);
    }
    
    public void testIsNorthHooverDam()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.HOOVER_DAM, CardColor.RED);
        boolean expResult = false;
        boolean result = instance.getIsNorth();
        assertEquals(expResult, result);
    }
    
    public void testIsNorthTheAlamo()
    {
        DestinationCard instance = new DestinationCard(DestinationID.THE_ALAMO, CardColor.RED);
        boolean expResult = false;
        boolean result = instance.getIsNorth();
        assertEquals(expResult, result);
    }
    
    public void testIsNorthLincolnMemorial()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.LINCOLN_MEMORIAL, CardColor.RED);
        boolean expResult = false;
        boolean result = instance.getIsNorth();
        assertEquals(expResult, result);
    }
    
    public void testIsNorthMiamiBeach()
    {
        DestinationCard instance = new DestinationCard(DestinationID.MIAMI_BEACH, CardColor.RED);
        boolean expResult = false;
        boolean result = instance.getIsNorth();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIsWest()
    {
        System.out.println("getIsWest");
        
        System.out.println("    NIAGRA_FALLS");
        testisWestNiagraFalls();
        
        System.out.println("    CONEY_ISLAND");
        testIsWestConeyIsland();
        
        System.out.println("    MT_RUSHMORE");
        testIsWestMtRushmore();
        
        System.out.println("    OLD_FAITHFUL");
        testIsWestOldFaithful();
        
        System.out.println("    GOLDEN_GATE_BRIDGE");
        testIsWestGoldenGateBridge();
        
        System.out.println("    HOOVER_DAM");
        testIsWestHooverDam();
        
        System.out.println("    THE_ALAMO");
        testIsWestTheAlamo();
        
        System.out.println("    LINCOLN_MEMORIAL");
        testIsWestLincolnMemorial();
        
        System.out.println("    MIAMI_BEACH");
        testIsWestMiamiBeach();
    }
    
    public void testisWestNiagraFalls()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.NIAGRA_FALLS, CardColor.RED);
        boolean expResult = false;
        boolean result = instance.getIsWest();
        assertEquals(expResult, result);
    }
    
    public void testIsWestConeyIsland()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.CONEY_ISLAND, CardColor.RED);
        boolean expResult = false;
        boolean result = instance.getIsWest();
        assertEquals(expResult, result);
    }
    
    public void testIsWestMtRushmore()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.MT_RUSHMORE, CardColor.RED);
        boolean expResult = true;
        boolean result = instance.getIsWest();
        assertEquals(expResult, result);
    }
    
    public void testIsWestOldFaithful()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.OLD_FAITHFUL, CardColor.RED);
        boolean expResult = true;
        boolean result = instance.getIsWest();
        assertEquals(expResult, result);
    }
    
    public void testIsWestGoldenGateBridge()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.GOLDEN_GATE_BRIDGE, CardColor.RED);
        boolean expResult = true;
        boolean result = instance.getIsWest();
        assertEquals(expResult, result);
    }
    
    public void testIsWestHooverDam()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.HOOVER_DAM, CardColor.RED);
        boolean expResult = true;
        boolean result = instance.getIsWest();
        assertEquals(expResult, result);
    }
    
    public void testIsWestTheAlamo()
    {
        DestinationCard instance = new DestinationCard(DestinationID.THE_ALAMO, CardColor.RED);
        boolean expResult = true;
        boolean result = instance.getIsWest();
        assertEquals(expResult, result);
    }
    
    public void testIsWestLincolnMemorial()
    {
        DestinationCard instance = 
                new DestinationCard(DestinationID.LINCOLN_MEMORIAL, CardColor.RED);
        boolean expResult = false;
        boolean result = instance.getIsWest();
        assertEquals(expResult, result);
    }
    
    public void testIsWestMiamiBeach()
    {
        DestinationCard instance = new DestinationCard(DestinationID.MIAMI_BEACH, CardColor.RED);
        boolean expResult = false;
        boolean result = instance.getIsWest();
        assertEquals(expResult, result);
    }
}
