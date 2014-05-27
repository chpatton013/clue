package com.outtatech.client.messaging;

import com.outtatech.common.DestinationID;
import com.outtatech.common.Solution;
import com.outtatech.common.SuspectID;
import com.outtatech.common.VehicleID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bschache
 */
public class AccusationRequestTest {
    
    /**
     *
     */
    public AccusationRequestTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of getSolution method, of class AccusationRequest.
     */
    @Test
    public void testGetSolution() {
        System.out.println("getSolution");
        DestinationID dest = DestinationID.OLD_FAITHFUL;
        VehicleID vehicle = VehicleID.AIRLINER;
        SuspectID suspect = SuspectID.MUSTARD;
        Solution solution = new Solution(dest, vehicle, suspect);
        
        AccusationRequest instance = new AccusationRequest(solution);
        Solution expResult = solution;
        Solution result = instance.getSolution();
        assertEquals(expResult.getDestination(), result.getDestination());
        assertEquals(expResult.getSuspect(), result.getSuspect());
        assertEquals(expResult.getVehicle(), result.getVehicle());
    }
}