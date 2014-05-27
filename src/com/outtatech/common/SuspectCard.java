/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.common;

/**
 * A SuspectCard represents a HintCard that specifies a certain Suspect ID.
 *
 * @author bennettschalich
 */
public class SuspectCard extends HintCard
{
    /*A unique Suspect*/
    private SuspectID suspect;
    Gender gender;

    /**
     * Constructs a new SuspectCard
     *
     * @param suspect A unique suspect ID
     */
    public SuspectCard(SuspectID suspect)
    {
        super(HintCardType.SUSPECT);
        this.suspect = suspect;

        if (suspect == SuspectID.WHITE || suspect == SuspectID.PEACOCK
                || suspect == SuspectID.SCARLET)
        {
            gender = Gender.FEMALE;
        }

        else if (suspect == SuspectID.GREEN || suspect == SuspectID.MUSTARD
                || suspect == SuspectID.PLUM)
        {
            gender = Gender.MALE;
        }
    }

    /**
     * Returns the suspect this HintCard has.
     *
     * @return A suspect ID.
     */
    public SuspectID getSuspect()
    {
        return suspect;
    }

    public Gender getGender()
    {
        return gender;
    }
    
}
