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
public class DestinationIDTest 
{
    
    /**
     *
     */
    public DestinationIDTest() 
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
     * Test of values method, of class DestinationID.
     */
    @Test
    public void testValues() 
    {
        System.out.println("Values");
        DestinationID[] expResult = {DestinationID.NIAGRA_FALLS, 
            DestinationID.GOLDEN_GATE_BRIDGE, DestinationID.OLD_FAITHFUL, 
            DestinationID.CONEY_ISLAND, DestinationID.THE_ALAMO, 
            DestinationID.HOOVER_DAM, DestinationID.LINCOLN_MEMORIAL, 
            DestinationID.MIAMI_BEACH, DestinationID.MT_RUSHMORE};
        DestinationID[] result = DestinationID.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class DestinationID.
     */
    @Test
    public void testValueOf() 
    {
        System.out.println("ValueOf");
        
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
    
    /**
     *
     */
    public void testNiagraFalls()
    {
        String name = "NIAGRA_FALLS";
        DestinationID expResult = DestinationID.NIAGRA_FALLS;
        DestinationID result = DestinationID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testGoldenGateBridge()
    {
        String name = "GOLDEN_GATE_BRIDGE";
        DestinationID expResult = DestinationID.GOLDEN_GATE_BRIDGE;
        DestinationID result = DestinationID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testOldFaithful()
    {
        String name = "OLD_FAITHFUL";
        DestinationID expResult = DestinationID.OLD_FAITHFUL;
        DestinationID result = DestinationID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testConeyIsland()
    {
        String name = "CONEY_ISLAND";
        DestinationID expResult = DestinationID.CONEY_ISLAND;
        DestinationID result = DestinationID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testTheAlamo()
    {
        String name = "THE_ALAMO";
        DestinationID expResult = DestinationID.THE_ALAMO;
        DestinationID result = DestinationID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testHooverDam()
    {
        String name = "HOOVER_DAM";
        DestinationID expResult = DestinationID.HOOVER_DAM;
        DestinationID result = DestinationID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testLincolnMemorial()
    {
        String name = "LINCOLN_MEMORIAL";
        DestinationID expResult = DestinationID.LINCOLN_MEMORIAL;
        DestinationID result = DestinationID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testMiamiBeach()
    {
        String name = "MIAMI_BEACH";
        DestinationID expResult = DestinationID.MIAMI_BEACH;
        DestinationID result = DestinationID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testMtRushmore()
    {
        String name = "MT_RUSHMORE";
        DestinationID expResult = DestinationID.MT_RUSHMORE;
        DestinationID result = DestinationID.valueOf(name);
        assertEquals(expResult, result);
    }
}
