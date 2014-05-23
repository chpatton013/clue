/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client.messaging;

import com.outtatech.common.ActionCard;
import com.outtatech.common.Card;
import com.outtatech.common.CardType;
import com.outtatech.common.*;
import java.util.List;
import java.util.ArrayList;
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
public class ActionRequestTest
{
    
    public ActionRequestTest()
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
     * Test of getActionCard method, of class ActionRequest.
     */
    @Test
    public void testGetActionCard()
    {
        System.out.println("getActionCard");
        
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        Snoop s = new Snoop();
        
        ActionRequest instance = new ActionRequest(s, list, 2);
        ActionCard expResult = s;
        ActionCard result = instance.getActionCard();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCards method, of class ActionRequest.
     */
    @Test
    public void testGetCards()
    {
        System.out.println("getCards");
        
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        Snoop s = new Snoop();
        
        ActionRequest instance = new ActionRequest(s, list, 2);
        List<Card> expResult = list;
        List<Card> result = instance.getCards();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getPlayerId method, of class ActionRequest.
     */
    @Test
    public void testGetPlayerId()
    {
        System.out.println("getCards");
        
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        Snoop s = new Snoop();
        
        ActionRequest instance = new ActionRequest(s, list, 2);
        Integer expResult = 2;
        Integer result = instance.getPlayerId();
        assertEquals(expResult, result);
    }
}
