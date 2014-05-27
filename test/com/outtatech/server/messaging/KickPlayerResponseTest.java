package com.outtatech.server.messaging;
import com.outtatech.server.messaging.KickPlayerResponse;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a KickPlayerResponse object
 *
 * @author rvquinla
 */
public class KickPlayerResponseTest {
    
    private int testPlayerId = 13;
    
    /**
     * Test of getPlayerId method of KickPlayerResponse
     */
    @Test
    public void testGetPlayerId()
    {
        System.out.println("Testing getPlayerId of KickPlayerResponse");
        
        KickPlayerResponse kpr = new KickPlayerResponse(testPlayerId);
        assertEquals(kpr.getPlayerId(), testPlayerId);
    }
}
