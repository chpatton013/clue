package com.outtatech.common;

/**
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
     * Constructs a unique Destination Card.
     *
     * @param destination A unique destination ID.
     */
    public DestinationCard(DestinationID destination)
    {
        super(HintCardType.DESTINATION);
        this.destination = destination;

        if (this.destination == DestinationID.NIAGRA_FALLS || this.destination
                == DestinationID.CONEY_ISLAND || this.destination
                == DestinationID.MT_RUSHMORE || this.destination
                == DestinationID.OLD_FAITHFUL)
        {
            north = true;
        }

        else
        {
            north = false;
        }

        if (this.destination == DestinationID.MT_RUSHMORE || this.destination
                == DestinationID.OLD_FAITHFUL || this.destination
                == DestinationID.GOLDEN_GATE_BRIDGE || this.destination
                == DestinationID.HOOVER_DAM || this.destination
                == DestinationID.THE_ALAMO)
        {
            west = true;
        }

        else
        {
            west = false;
        }
    }

    /**
     * Returns the unique destination of this DestinationCard.
     *
     * @return A unique destination.
     */
    public DestinationID getDestination()
    {
        return destination;
    }

    /**
     *
     * @return
     */
    public boolean getIsNorth()
    {
        return north;
    }

    /**
     *
     * @return
     */
    public boolean getIsWest()
    {
        return west;
    }
}
