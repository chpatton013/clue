package com.outtatech.client.messaging;

import com.outtatech.common.Card;
import com.outtatech.common.Solution;
import java.util.List;

/**
 * Version-latenightpizzaparty
 * Message sent from the client to the server when an accusation has been made
 * by the client.
 *
 * @author jbilous
 */
public class AccusationRequest extends ClientRequest
{
    Solution accusation;

    /**
     * Version-latenightpizzaparty
     * Creates an AccusationRequest object.
     *
     * @param accusationCards list that contains the three cards that are
     * required for an accusation.
     */
    public AccusationRequest(Solution accusation)
    {
        this.accusation = accusation;
    }

    /**
     * Version-latenightpizzaparty
     * Getter method for the solution that was given by the client in order to
     * make an accusation.
     *
     * @return the solution that was given by the client in order to make an
     * accusation.
     */
    public Solution getSolution()
    {
        return accusation;
    }
}
