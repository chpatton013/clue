package com.outtatech.common;

/**
 * A HintCard is a type of Card that players hold in there hand and can have
 * three different types (Destination, Vehicle, Suspect).
 *
 * @author bennettschalich
 */
public class HintCard extends Card
{
    /*The type of HintCard this card is.*/
    private HintCardType type;

    /**
     * Constructs a new HintCard with a type.
     *
     * @param type The type of HintCard this Card is.
     */
    public HintCard(HintCardType type)
    {
        super(CardType.HINT);
        this.type = type;
    }

    /**
     * Returns the type of HintCard this Card is.
     *
     * @return The type of HintCard.
     */
    public HintCardType getHintType()
    {
        return type;
    }
}
