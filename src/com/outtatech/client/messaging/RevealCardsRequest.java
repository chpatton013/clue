package com.outtatech.client.messaging;

import com.outtatech.common.Card;
import java.util.List;

/**
 * Message sent from the client to the server when the client is asked to show
 * one or more of their cards.
 */
public class RevealCardsRequest extends ClientRequest
{
    private List<Card> cards;

    /**
     * Creates a new RevealCardResponse object.
     *
     * @param cards the cards that will be revealed to the other player.
     */
    public RevealCardsRequest(List<Card> cards)
    {
        this.cards = cards;
    }

    /**
     * Returns the cards that will be revealed to the other player.
     *
     * @return the cards that will be revealed to the other play
     */
    public List<Card> getCards()
    {
        return cards;
    }
}

