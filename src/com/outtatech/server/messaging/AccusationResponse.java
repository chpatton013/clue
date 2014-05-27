package com.outtatech.server.messaging;

import com.outtatech.common.*;

/**
 * Message sent from the server to the client when an accusation is made.
 *
 * @author jbilous
 */
public class AccusationResponse extends ServerResponse
{
    private Solution solution;
    private boolean correctAccusation;

    /**
     * Creates a new AccusationResponse object
     *
     * @param solution
     * @param correctAccusation
     */
    public AccusationResponse(Solution solution, boolean correctAccusation)
    {
        this.solution = solution;
        this.correctAccusation = correctAccusation;
    }

    /**
     *
     * @return
     */
    public Solution getSolution()
    {
        return this.solution;
    }

    /**
     * Returns whether or not the accusation was correct.
     *
     * @return whether or not the accusation was correct
     */
    public boolean getCorrectAccusation()
    {
        return this.correctAccusation;
    }
}
