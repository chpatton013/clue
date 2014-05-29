package com.outtatech.common;

import java.io.Serializable;

/**
 * Version-latenightpizzaparty
 * The Card models represents any Clue card.
 *
 * @author bennettschalich
 */
public class Card implements Serializable
{
    private static int id = -1;
    private CardType cardType;

    /**
     * Version-latenightpizzaparty
     * Constructs a new Card.
     *
     * @param cardType Describes whether the card is of the type Hint or Action.
     * method parameter
     */
    public Card(CardType cardType)
    {
        this.cardType = cardType;
        this.id++;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the card type (Hint or Action).
     *
     * @return The card type (Hint or Action). return value
     */
    public CardType getCardType()
    {
        return cardType;
    }

    /**
     * Version-latenightpizzaparty
     * Returns a unique id
     *
     * @return a unique id return value
     */
    public int getID()
    {
        return id;
    }
}
