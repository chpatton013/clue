package com.outtatech.server.messaging;

import com.outtatech.common.Card;
import java.util.List;

/**
 * Version-latenightpizzaparty
 * Message sent from the server to the client when a card is dealt to them.
 *
 * @author jbilous
 */
public class CardDealResponse extends ServerResponse
{
    private final List<Card> cards;

    /**
     * Version-latenightpizzaparty
     * Creates a new CardDealResponse object.
     *
     * @param cards list of cards that have been dealt.
     */
    public CardDealResponse(List<Card> cards)
    {
        this.cards = cards;
    }

    /**
     * Version-latenightpizzaparty
     * Getter methods for the cards dealt to the player.
     *
     * @return cards dealt to the player.
     */
    public List<Card> getCards() {
        return cards;
    }
}
