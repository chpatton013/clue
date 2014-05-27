package com.outtatech.server.messaging;

import com.outtatech.common.ActionCard;
import com.outtatech.common.Card;
import java.util.List;

/**
 * Message sent from the server to the client when a card is dealt to them.
 *
 * @author jbilous
 */
public class CardDealResponse extends ServerResponse
{
    private final List<ActionCard> cards;

    /**
     * Creates a new CardDealResponse object.
     *
     * @param cards list of cards that have been dealt.
     */
    public CardDealResponse(List<ActionCard> cards)
    {
        this.cards = cards;
    }
    
    /**
     * Getter methods for the cards dealt to the player.
     * 
     * @return cards dealt to the player.
     */
    public List<ActionCard> getCards() {
        return cards;
    }
}
