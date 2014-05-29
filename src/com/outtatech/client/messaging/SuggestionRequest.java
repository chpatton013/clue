package com.outtatech.client.messaging;

import com.outtatech.common.Solution;
import com.outtatech.common.Suggestion;

/**
 * Version-latenightpizzaparty
 * Message sent from the client to the server when they would like to make a
 * suggestion.
 *
 * @author jbilous
 */
public class SuggestionRequest extends ClientRequest
{
    private Suggestion card;
    private Solution suggestion;

    /**
     * Version-latenightpizzaparty
     *
     * @param suggestion method parameter
     */
    public SuggestionRequest(Suggestion card, Solution suggestion)
    {
        this.card = card;
        this.suggestion = suggestion;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public Suggestion getCard()
    {
        return this.card;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public Solution getSuggestion()
    {
        return this.suggestion;
    }

}
