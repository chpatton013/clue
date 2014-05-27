package com.outtatech.server.messaging;

import com.outtatech.common.HintCard;
import com.outtatech.common.Solution;

/**
 * Version-latenightpizzaparty
 * Message sent from the server to the client in response to a suggestion they
 * made.
 *
 * @author jbilous
 */
public class SuggestionResponse extends ServerResponse
{
    private boolean correctAccusation;
    private HintCard refutingCard;

    /**
     * Version-latenightpizzaparty
     * Constructs a new SuggestionResponse object
     *
     * @param correctAccusation whether or not the accusation was correct. 
     * method parameter
     */
    public SuggestionResponse(boolean correctAccusation)
    {
        this.correctAccusation = correctAccusation;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public HintCard getRefutingCard()
    {
        return this.refutingCard;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param refutingCard method parameter
     */
    public void setRefutingCard(HintCard refutingCard)
    {
        this.refutingCard = refutingCard;
    }
}
