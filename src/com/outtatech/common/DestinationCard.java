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
    private DestinationID destination;
    private boolean north;
    private boolean west;

    /**
     * Version-latenightpizzaparty
     * Constructs a unique Destination Card.
     *
     * @param destination A unique destination ID. method parameter
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
     * @return A unique destination. return value
     */
    public DestinationID getDestination()
    {
        return destination;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public boolean getIsNorth()
    {
        return north;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public boolean getIsWest()
    {
        return west;
    }

    public String toString()
    {
       if (this.destination == DestinationID.NIAGRA_FALLS)
       {
           return "NIAGRA_FALLS";
       }
       else if (this.destination == DestinationID.GOLDEN_GATE_BRIDGE)
       {
           return "GOLDEN_GATE_BRIDGE";
       }
       else if (this.destination == DestinationID.OLD_FAITHFUL)
       {
           return "OLD_FAITHFUL";
       }
       else if (this.destination == DestinationID.CONEY_ISLAND)
       {
           return "CONEY_ISLAND";
       }
       else if (this.destination == DestinationID.THE_ALAMO)
       {
           return "THE_ALAMO";
       }
       else if (this.destination == DestinationID.HOOVER_DAM)
       {
           return "HOOVER_DAM";
       }
       else if (this.destination == DestinationID.LINCOLN_MEMORIAL)
       {
           return "LINCOLN_MEMORIAL";
       }
       else if (this.destination == DestinationID.MIAMI_BEACH)
       {
           return "MIAMI_BEACH";
       }
       else if (this.destination == DestinationID.MT_RUSHMORE)
       {
           return "MT_RUSHMORE";
       }
       else
       {
           return super.toString();
       }
    }
}
