package com.outtatech.common;

import java.io.Serializable;

/**
 * The Card models represents any Clue card.
 *
 * @author bennettschalich
 */
public class Card implements Serializable
{
    private static int id = -1;
    CardType cardType;

    /**
     * Constructs a new Card.
     *
     * @param cardType Describes whether the card is of the type Hint or Action.
     */
    public Card(CardType cardType)
    {
        this.cardType = cardType;
        this.id++;
    }

    /**
     * Returns the card type (Hint or Action).
     *
     * @return The card type (Hint or Action).
     */
    public CardType getCardType()
    {
        return cardType;
    }

    /**
     * Returns a unique id
     *
     * @return a unique id
     */
    public int getID()
    {
        return id;
    }
}
