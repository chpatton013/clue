package com.outtatech.common;

/**
 * Version-latenightpizzaparty
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
     * Version-latenightpizzaparty
     * Constructs a new SuspectCard
     *
     * @param suspect A unique suspect ID method parameter
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
     * Version-latenightpizzaparty
     * Returns the suspect this HintCard has.
     *
     * @return A suspect ID. return value
     */
    public SuspectID getSuspect()
    {
        return suspect;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public Gender getGender()
    {
        return gender;
    }

}
