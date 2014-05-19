/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client.messaging;

import com.outtatech.common.Card;
import com.outtatech.common.CardType;
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
public class RevealCardRequestTest
{
    public RevealCardRequestTest()
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
     * Test of getPlayerId method, of class RevealCardRequest.
     */
    @Test
    public void testGetPlayerId()
    {
        System.out.println("getPlayerId");
        
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        list.add(new Card(CardType.ACTION));
        
        RevealCardRequest instance = new RevealCardRequest(new Integer(5), list);
        Integer expResult = new Integer(5);
        Integer result = instance.getPlayerId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCards method, of class RevealCardRequest.
     */
    @Test
    public void testGetCards()
    {
        System.out.println("getCards");
        
        List<Card> list = new ArrayList<Card>();
        list.add(new Card(CardType.HINT));
        list.add(new Card(CardType.ACTION));
        
        RevealCardRequest instance = new RevealCardRequest(new Integer(4), list);
        List<Card> expResult = list;
        List<Card> result = instance.getCards();
        assertEquals(expResult, result);
    }
}
