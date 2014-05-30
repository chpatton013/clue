package com.outtatech.common;

/*
 * ActionCard
 * @author bennettschalich
 * @version 1.01
 * date: 5/1/14
 */
/**
 * Version-latenightpizzaparty
 * An ActionCard is a playable card that describes an action that can take place
 * that can effect one or more players.
 *
 * @author bennettschalich
 */
public class ActionCard extends Card
{
    private ActionCardType type;

    /**
     * Version-latenightpizzaparty
     * Constructs a new ActionCard.
     *
     * @param type The type of action the card will perform once played. method parameter
     */
    public ActionCard(ActionCardType type)
    {
        super(CardType.ACTION);
        this.type = type;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the type of action this ActionCard corresponds to.
     *
     * @return The type of action this ActionCard corresponds to. return value
     */
    public ActionCardType getActionType()
    {
        return type;
    }
}
