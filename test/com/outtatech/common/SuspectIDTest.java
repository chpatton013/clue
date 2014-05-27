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
public class SuspectIDTest
{
    
    /**
     *
     */
    public SuspectIDTest()
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
     * Test of values method, of class SuspectID.
     */
    @Test
    public void testValues()
    {
        System.out.println("Values");
        SuspectID[] expResult = {SuspectID.WHITE, SuspectID.PEACOCK, 
            SuspectID.GREEN, SuspectID.MUSTARD, SuspectID.PLUM, 
            SuspectID.SCARLET};
        SuspectID[] result = SuspectID.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class SuspectID.
     */
    @Test
    public void testValueOf()
    {
        System.out.println("ValueOf");
        
        System.out.println("WHITE");
        testWhite();
        
        System.out.println("PEACOCK");
        testPeacock();
        
        System.out.println("GREEN");
        testGreen();
        
        System.out.println("MUSTARD");
        testMustard();
        
        System.out.println("PLUM");
        testPlum();
        
        System.out.println("SCARLET");
        testScarlet();
    }
    
    /**
     *
     */
    public void testWhite()
    {
        String name = "WHITE";
        SuspectID expResult = SuspectID.WHITE;
        SuspectID result = SuspectID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testPeacock()
    {
        String name = "PEACOCK";
        SuspectID expResult = SuspectID.PEACOCK;
        SuspectID result = SuspectID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testGreen()
    {
        String name = "GREEN";
        SuspectID expResult = SuspectID.GREEN;
        SuspectID result = SuspectID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testMustard()
    {
        String name = "MUSTARD";
        SuspectID expResult = SuspectID.MUSTARD;
        SuspectID result = SuspectID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testPlum()
    {
        String name = "PLUM";
        SuspectID expResult = SuspectID.PLUM;
        SuspectID result = SuspectID.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testScarlet()
    {
        String name = "SCARLET";
        SuspectID expResult = SuspectID.SCARLET;
        SuspectID result = SuspectID.valueOf(name);
        assertEquals(expResult, result);
    }
}
