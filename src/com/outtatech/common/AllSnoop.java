package com.outtatech.common;

/**
 * Version-latenightpizzaparty
 * The AllSnoop class represents a type of ActionCard that represents an All
 * Snoop action. The AllSnoop action has every player look at a HintCard of
 * another player to either the right or left (depending on the direction
 * specified on the card.
 *
 * @author bennettschalich
 */
public class AllSnoop extends ActionCard
{
    /* Whether or not the All Snoop action occurs to the right
     To the right if true; otherwise false*/
    private boolean right;

    /**
     * Version-latenightpizzaparty
     * Constructs a new AllSnoop ActionCard.
     *
     * @param right The direction the All Snoop action will take. 
     * If true- method parameter
     * right; otherwise left.
     */
    public AllSnoop(boolean right)
    {
        super(ActionCardType.ALL_SNOOP);
        this.right = right;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the direction the AllSnoop action
     *
     * @return the direction of the Allsnoop action. True is right, false is return value
     * left.
     */
    public boolean getDirection()
    {
        return right;
    }

    public String toString()
    {
        return "ALLSNOOP";
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof AllSnoop)) {
            return false;
        }

        AllSnoop other = (AllSnoop)obj;
        return this.right == other.right;
    }
}
