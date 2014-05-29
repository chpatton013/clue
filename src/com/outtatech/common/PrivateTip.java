package com.outtatech.common;

/**
 * Version-latenightpizzaparty
 * The PrivateTip class represents a type of ActionCard that represents an
 * Private Tip action. A PrivateTip ActionCard results in one of the following:
 * A player of your choice: Shows you all their Suspect Cards." (1) Shows you
 * all their Vehicle Cards." (1) Shows you all their Destination Cards." (1)
 * Shows you one female Suspect Card." (1) Shows you one red Vehicle Card." (1)
 * Shows you one northern Destination Card." (1)"
 *
 * @author bennettschalich
 */
public class PrivateTip extends ActionCard
{
    private PrivateTipType type;

    /**
     * Version-latenightpizzaparty
     * Constructs a new PrivatTip ActionCard.
     * @param type method parameter
     */
    public PrivateTip(PrivateTipType type)
    {
        super(ActionCardType.PRIVATE_TIP);
        this.type = type;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public PrivateTipType getType()
    {
        return type;
    }

    public String toString()
    {
        return "PRIVATETIP";
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof PrivateTip)) {
            return false;
        }

        PrivateTip other = (PrivateTip)obj;
        return this.type == other.type;
    }
}
