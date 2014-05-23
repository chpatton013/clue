/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server.messaging;

import com.outtatech.common.Card;
import java.util.List;

/**
 * Message sent from the server to the client when a card is dealt to them.
 *
 * @author jbilous
 */
public class CardDealResponse extends ServerResponse
{
    List<Card> cards;

    /**
     * Creates a new CardDealResponse object.
     *
     * @param cards list of cards that have been dealt.
     */
    public CardDealResponse(List<Card> cards)
    {
        this.cards = cards;
    }
    
    /**
     * Getter methods for the cards dealt to the player.
     * 
     * @return cards dealt to the player.
     */
    public List<Card> getCards() {
        return cards;
    }
}
