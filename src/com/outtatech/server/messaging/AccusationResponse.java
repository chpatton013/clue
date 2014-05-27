package com.outtatech.server.messaging;

import com.outtatech.common.*;

/**
 * Version-latenightpizzaparty
 * Message sent from the server to the client when an accusation is made.
 *
 * @author jbilous
 */
public class AccusationResponse extends ServerResponse
{
    private Solution solution;
    private boolean correctAccusation;

    /**
     * Version-latenightpizzaparty
     * Creates a new AccusationResponse object
     *
     * @param solution method parameter
     * @param correctAccusation method parameter
     */
    public AccusationResponse(Solution solution, boolean correctAccusation)
    {
        this.solution = solution;
        this.correctAccusation = correctAccusation;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public Solution getSolution()
    {
        return this.solution;
    }

    /**
     * Version-latenightpizzaparty
     * Returns whether or not the accusation was correct.
     *
     * @return whether or not the accusation was correct return value
     */
    public boolean getCorrectAccusation()
    {
        return this.correctAccusation;
    }
}
