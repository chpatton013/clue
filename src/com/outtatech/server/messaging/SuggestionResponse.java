/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server.messaging;

import com.outtatech.common.HintCard;
import com.outtatech.common.Solution;

/**
 * Message sent from the server to the client in response to a suggestion
 * they made.
 * 
 * @author jbilous
 */
public class SuggestionResponse extends ServerResponse
{
    private boolean correctAccusation;
    private HintCard refutingCard;

    /**
     * Constructs a new SuggestionResponse object
     * 
     * @param correctAccusation whether or not the accusation was correct.
     */
    public SuggestionResponse(boolean correctAccusation)
    {
        this.correctAccusation = correctAccusation;
    }
    
    public HintCard getRefutingCard()
    {
        return this.refutingCard;
    }
    
    public void setRefutingCard(HintCard refutingCard)
    {
        this.refutingCard = refutingCard;
    }
}
