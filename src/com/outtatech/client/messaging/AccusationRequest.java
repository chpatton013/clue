/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.client.messaging;

import com.outtatech.common.Card;
import java.util.List;

/**
 * Message sent from the client to the server when an accusation has been made
 * by the client.
 *
 * @author jbilous
 */
public class AccusationRequest extends ClientRequest
{
    List<Card> accusationCards;

    /**
     * Creates an AccusationRequest object.
     *
     * @param accusationCards list that contains the three cards that are
     * required for an accusation.
     */
    public AccusationRequest(List<Card> accusationCards)
    {
        // Ensure that accusationCards contains a Suspect, Vehicle and
        // Destination card.
        this.accusationCards = accusationCards;
    }

    /**
     * Getter method for the list of cards that were given by the client in
     * order to make an accusation.
     *
     * @return the list of cards that were given by the client in order to make
     * an accusation.
     */
    public List<Card> getAccusationCards()
    {
        return accusationCards;
    }
}
