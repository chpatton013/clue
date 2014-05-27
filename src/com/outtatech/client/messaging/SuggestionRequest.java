package com.outtatech.client.messaging;

import com.outtatech.common.Solution;

/**
 * Version-latenightpizzaparty
 * Message sent from the client to the server when they would like to make a
 * suggestion.
 *
 * @author jbilous
 */
public class SuggestionRequest extends ClientRequest
{
    private Solution suggestion;

    /**
     * Version-latenightpizzaparty
     *
     * @param suggestion
     */
    public SuggestionRequest(Solution suggestion)
    {
        this.suggestion = suggestion;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return
     */
    public Solution getSuggestion()
    {
        return this.suggestion;
    }

}
