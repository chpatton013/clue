package com.outtatech.common;

/**
 * The SuperSleuth class represents a type of ActionCard that represents an
 * SuperSleuth action. A SuperSleuth action does on of the following: A player
 * of your choice: "Shows you one female Suspect Card." (1) "Show you one male
 * Suspect Card." (1) "Shows you one flying Vehicle Card." (1) "Shows you one
 * blue Vehicle Card." (1) "Shows you one southern Destination Card." (1) "Shows
 * you one western Destination Card." (1)
 *
 * @author bennettschalich
 */
public class SuperSleuth extends ActionCard
{
    SuperSleuthType type;
    /**
     * Constructs a new SuperSleuth ActionCard.
     */
    public SuperSleuth(SuperSleuthType type)
    {
        super(ActionCardType.SUPER_SLEUTH);
        this.type = type;
    }
    
    public SuperSleuthType getType()
    {
        return type;
    }
}
