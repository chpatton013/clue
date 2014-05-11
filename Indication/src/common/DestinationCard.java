/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

/**
 *
 * @author bennettschalich
 */
public class DestinationCard extends HintCard
{
    DestinationID destination;
    
    public DestinationCard(DestinationID destination)
    {
        super(HintCardType.DESTINATION);
        this.destination = destination;
    }
    
    public DestinationID getDestination()
    {
        return destination;
    }
}
