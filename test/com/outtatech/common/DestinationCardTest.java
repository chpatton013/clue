/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class DestinationCardTest {
    
    public DestinationCardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
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
        
        System.out.println("NIAGRA_FALLS");
        testNiagraFalls();
        
        System.out.println("GOLDEN_GATE_BRIDGE");
        testGoldenGateBridge();
        
        System.out.println("OLD_FAITHFUL");
        testOldFaithful();
        
        System.out.println("CONEY_ISLAND");
        testConeyIsland();
        
        System.out.println("THE_ALAMO");
        testTheAlamo();
        
        System.out.println("HOOVER_DAM");
        testHooverDam();
        
        System.out.println("LINCOLN_MEMORIAL");
        testLincolnMemorial();
        
        System.out.println("MIAMI_BEACH");
        testMiamiBeach();
        
        System.out.println("MT_RUSHMORE");
        testMtRushmore();
    }
    
    public void testNiagraFalls()
    {
        DestinationCard instance = new DestinationCard(DestinationID.NIAGRA_FALLS);
        DestinationID expResult = DestinationID.NIAGRA_FALLS;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testGoldenGateBridge()
    {
        DestinationCard instance = new DestinationCard(DestinationID.GOLDEN_GATE_BRIDGE);
        DestinationID expResult = DestinationID.GOLDEN_GATE_BRIDGE;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testOldFaithful()
    {
        DestinationCard instance = new DestinationCard(DestinationID.OLD_FAITHFUL);
        DestinationID expResult = DestinationID.OLD_FAITHFUL;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testConeyIsland()
    {
        DestinationCard instance = new DestinationCard(DestinationID.CONEY_ISLAND);
        DestinationID expResult = DestinationID.CONEY_ISLAND;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testTheAlamo()
    {
        DestinationCard instance = new DestinationCard(DestinationID.THE_ALAMO);
        DestinationID expResult = DestinationID.THE_ALAMO;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testHooverDam()
    {
        DestinationCard instance = new DestinationCard(DestinationID.HOOVER_DAM);
        DestinationID expResult = DestinationID.HOOVER_DAM;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testLincolnMemorial()
    {
        DestinationCard instance = new DestinationCard(DestinationID.LINCOLN_MEMORIAL);
        DestinationID expResult = DestinationID.LINCOLN_MEMORIAL;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testMiamiBeach()
    {
        DestinationCard instance = new DestinationCard(DestinationID.MIAMI_BEACH);
        DestinationID expResult = DestinationID.MIAMI_BEACH;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
    
    public void testMtRushmore()
    {
        DestinationCard instance = new DestinationCard(DestinationID.MT_RUSHMORE);
        DestinationID expResult = DestinationID.MT_RUSHMORE;
        DestinationID result = instance.getDestination();
        assertEquals(expResult, result);
    }
}
