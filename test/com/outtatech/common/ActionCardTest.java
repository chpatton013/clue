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
public class ActionCardTest 
{
    
    /**
     *
     */
    public ActionCardTest() 
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
     * Test of getActionType method, of class ActionCard.
     */
    @Test
    public void testGetActions() 
    {
        System.out.println("General ActionCard");
        testGeneralActionCard();
        
        System.out.println("Snoop");
        testSnoop();
        
        System.out.println("AllSnoop");
        testAllSnoop();
        
        System.out.println("PrivateTip");
        testPrivateTip();
        
        System.out.println("SuperSleuth");
        testSuperSleuth();
        
        System.out.println("Suggestion");
        testSuggestion();
    }
    
    /**
     *
     */
    @Test
    public void testGeneralActionCard()
    {
        ActionCard instance = new ActionCard(ActionCardType.SNOOP);
        ActionCardType expResult = ActionCardType.SNOOP;
        ActionCardType result = instance.getActionType();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testSnoop()
    {
        ActionCard instance = new Snoop();
        ActionCardType expResult = ActionCardType.SNOOP;
        ActionCardType result = instance.getActionType();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testAllSnoop()
    {
        ActionCard instance = new AllSnoop(true);
        ActionCardType expResult = ActionCardType.ALL_SNOOP;
        ActionCardType result = instance.getActionType();
        assertEquals(expResult, result);
        
        boolean expDirResult = true;
        boolean dirResult = ((AllSnoop)instance).getDirection();
        assertEquals(expDirResult, dirResult);
    }
    
    /**
     *
     */
    public void testPrivateTip()
    {
        ActionCard instance = new PrivateTip(PrivateTipType.ALL_DESTINATIONS);
        ActionCardType expResult = ActionCardType.PRIVATE_TIP;
        ActionCardType result = instance.getActionType();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testSuperSleuth()
    {
        ActionCard instance = new SuperSleuth(SuperSleuthType.FEMALE_SUSPECT);
        ActionCardType expResult = ActionCardType.SUPER_SLEUTH;
        ActionCardType result = instance.getActionType();
        assertEquals(expResult, result);
    }
    
    /**
     *
     */
    public void testSuggestion()
    {
        ActionCard instance = new Suggestion(SuggestionType.ANY);
        ActionCardType expResult = ActionCardType.SUGGESTION;
        ActionCardType result = instance.getActionType();
        assertEquals(expResult, result);
    }
}
