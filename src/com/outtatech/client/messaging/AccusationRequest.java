/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.client.messaging;

import com.outtatech.common.Card;
import com.outtatech.common.Solution;
import java.util.List;

/**
 * Message sent from the client to the server when an accusation has been made
 * by the client.
 *
 * @author jbilous
 */
public class AccusationRequest extends ClientRequest
{
    Solution accusation;

    /**
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
     * Getter method for the solution that was given by the client in
     * order to make an accusation.
     *
     * @return the solution that was given by the client in order to make
     * an accusation.
     */
    public Solution getSolution()
    {
        return accusation;
    }
}
