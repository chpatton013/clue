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
public class SuspectCardTest
{
    
    /**
     *
     */
    public SuspectCardTest()
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
     * Test of getSuspect method, of class SuspectCard.
     */
    @Test
    public void testGetSuspect()
    {
        System.out.println("getSuspect");
        
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
    @Test
    public void testGetGender()
    {
        System.out.println("getGender");
        
        SuspectCard instance = new SuspectCard(SuspectID.WHITE);
        Gender expResult = Gender.FEMALE;
        Gender result = instance.getGender();
        assertEquals(expResult, result);
        
        instance = new SuspectCard(SuspectID.GREEN);
        expResult = Gender.MALE;
        result = instance.getGender();
        assertEquals(expResult, result);
        
        instance = new SuspectCard(SuspectID.MUSTARD);
        expResult = Gender.MALE;
        result = instance.getGender();
        assertEquals(expResult, result);
        
        instance = new SuspectCard(SuspectID.PEACOCK);
        expResult = Gender.FEMALE;
        result = instance.getGender();
        assertEquals(expResult, result);
        
        instance = new SuspectCard(SuspectID.PLUM);
        expResult = Gender.MALE;
        result = instance.getGender();
        assertEquals(expResult, result);
        
        instance = new SuspectCard(SuspectID.SCARLET);
        expResult = Gender.FEMALE;
        result = instance.getGender();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testWhite()
    {
        SuspectCard instance = new SuspectCard(SuspectID.WHITE);
        SuspectID expResult = SuspectID.WHITE;
        SuspectID result = instance.getSuspect();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testPeacock()
    {
        SuspectCard instance = new SuspectCard(SuspectID.PEACOCK);
        SuspectID expResult = SuspectID.PEACOCK;
        SuspectID result = instance.getSuspect();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testGreen()
    {
        SuspectCard instance = new SuspectCard(SuspectID.GREEN);
        SuspectID expResult = SuspectID.GREEN;
        SuspectID result = instance.getSuspect();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testMustard()
    {
        SuspectCard instance = new SuspectCard(SuspectID.MUSTARD);
        SuspectID expResult = SuspectID.MUSTARD;
        SuspectID result = instance.getSuspect();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testPlum()
    {
        SuspectCard instance = new SuspectCard(SuspectID.PLUM);
        SuspectID expResult = SuspectID.PLUM;
        SuspectID result = instance.getSuspect();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testScarlet()
    {
        SuspectCard instance = new SuspectCard(SuspectID.SCARLET);
        SuspectID expResult = SuspectID.SCARLET;
        SuspectID result = instance.getSuspect();
        assertEquals(expResult, result);
    }
    
}
