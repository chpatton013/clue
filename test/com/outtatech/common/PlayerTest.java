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
public class PlayerTest
{
    
    /**
     *
     */
    public PlayerTest()
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
     * Test of getPlayerId method, of class Player.
     */
    @Test
    public void testGetPlayerId()
    {
        System.out.println("getPlayerId");
        Player instance = new PlayerImpl();
        int expResult = 0;
        int result = instance.getPlayerId();
        assertEquals(expResult, result);
    }

    /**
     *
     */
    public class PlayerImpl implements Player
    {   
        @Override
        public int getPlayerId()
        {
            return 0;
        }

        /**
         *
         * @return
         */
        @Override
        public String getName()
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
