package com.outtatech.common;

/**
 * Version-latenightpizzaparty
 * A DestinationCard represents a HintCard that specifies a certain Destination
 * ID.
 *
 * @author bennettschalich
 */
public class DestinationCard extends HintCard
{
    /*A unique destination*/
    DestinationID destination;
    boolean north;
    boolean west;

    /**
     * Version-latenightpizzaparty
     * Constructs a unique Destination Card.
     *
     * @param destination A unique destination ID.
     */
    public DestinationCard(DestinationID destination)
    {
        super(HintCardType.DESTINATION);
        this.destination = destination;

        // Guard against this
        if (this.destination == DestinationID.NIAGRA_FALLS || this.destination
                == DestinationID.CONEY_ISLAND || this.destination
                == DestinationID.MT_RUSHMORE || this.destination
                == DestinationID.OLD_FAITHFUL)
        {
            north = true;
        }

        // Otherwise...
        else
        {
            north = false;
        }

        // Guard against this
        if (this.destination == DestinationID.MT_RUSHMORE || this.destination
                == DestinationID.OLD_FAITHFUL || this.destination
                == DestinationID.GOLDEN_GATE_BRIDGE || this.destination
                == DestinationID.HOOVER_DAM || this.destination
                == DestinationID.THE_ALAMO)
        {
            west = true;
        }

        // Otherwise...
        else
        {
            west = false;
        }
    }

    /**
     * Version-latenightpizzaparty
     * Returns the unique destination of this DestinationCard.
     *
     * @return A unique destination.
     */
    public DestinationID getDestination()
    {
        return destination;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return
     */
    public boolean getIsNorth()
    {
        return north;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return
     */
    public boolean getIsWest()
    {
        return west;
    }
}
