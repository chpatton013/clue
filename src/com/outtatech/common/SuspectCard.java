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

        // Guard against this
        if (suspect == SuspectID.WHITE || suspect == SuspectID.PEACOCK
                || suspect == SuspectID.SCARLET)
        {
            gender = Gender.FEMALE;
        }

        // Otherwise...
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

    /**
     *
     * @return
     */
    public Gender getGender()
    {
        return gender;
    }

}
