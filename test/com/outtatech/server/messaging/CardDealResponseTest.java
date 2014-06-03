package com.outtatech.server.messaging;

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
 * Tests a CardDealResponse object
 * 
 * @author jbilous
 */
public class CardDealResponseTest
{
    /**
     * Test of getCards method, of class ActionRequest.
     */
    @Test
    public void testGetCards()
    {
        System.out.println("Testing getCards of CardDealResponse ");
        
        ActionCard card = new ActionCard(ActionCardType.ALL_SNOOP);
        
        CardDealResponse response = new CardDealResponse(card);
        ActionCard expResult = card;
        ActionCard result = response.getCard();
        assertEquals(expResult, result);
    }
}
