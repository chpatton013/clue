package com.outtatech.server.messaging;

import com.outtatech.common.ActionCard;
import com.outtatech.common.PrivateTip;
import com.outtatech.common.PrivateTipType;
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
public class ActionResponseTest
{
    
    public ActionResponseTest()
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
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getActionCard method, of class ActionResponse.
     */
    @Test
    public void testGetActionCard()
    {
        System.out.println("getActionCard");
        
        ActionCard ac = new PrivateTip(PrivateTipType.ALL_DESTINATIONS);
        ActionResponse instance = new ActionResponse(ac, new Integer(3));
        ActionCard expResult = ac;
        ActionCard result = instance.getActionCard();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerId method, of class ActionResponse.
     */
    @Test
    public void testGetPlayerId()
    {
        System.out.println("getPlayerId");
        
        ActionCard ac = new PrivateTip(PrivateTipType.ALL_DESTINATIONS);
        ActionResponse instance = new ActionResponse(ac, new Integer(3));;
        Integer expResult = new Integer(3);
        Integer result = instance.getPlayerId();
        assertEquals(expResult, result);
    }
    
}
