package com.outtatech.common;

/**
 * Version-latenightpizzaparty
 * The Snoop class represents a type of ActionCard that represents an Snoop
 * action. The Snoop action allows you to look at the hint cards of the player
 * of your choice.
 *
 * @author bennettschalich
 */
public class Snoop extends ActionCard
{
    /**
     * Version-latenightpizzaparty
     * Constructs a new AllSnoop ActionCard.
     */
    public Snoop()
    {
        super(ActionCardType.SNOOP);
    }

    public String toString()
    {
        return "SNOOP";
    }

    public boolean equals(Object obj)
    {
        return obj instanceof Snoop;
    }
}
