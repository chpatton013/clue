/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    /**
     * Constructs a unique Destination Card.
     *
     * @param destination A unique destination ID.
     */
    public DestinationCard(DestinationID destination)
    {
        super(HintCardType.DESTINATION);
        this.destination = destination;
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
}
