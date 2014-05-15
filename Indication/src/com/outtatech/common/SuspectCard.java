/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.common;

/**
 * A SuspectCard represents a HintCard that specifies a certain Suspect 
 * ID.
 * @author bennettschalich
 */
public class SuspectCard extends HintCard
{
    /*A unique Suspect*/
    private SuspectID suspect;
    
    /**
     * Constructs a new SuspectCard
     * @param suspect A unique suspect ID
     */
    public SuspectCard(SuspectID suspect)
    {
        super(HintCardType.SUSPECT);
        this.suspect = suspect;
    }
    
    /**
     * Returns the suspect this HintCard has.
     * @return A suspect ID.
     */
    public SuspectID getSuspect()
    {
        return suspect;
    }
}
