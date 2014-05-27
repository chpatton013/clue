package com.outtatech.client.messaging;

import com.outtatech.common.Solution;

/**
 * Message sent from the client to the server when they would like to make a
 * suggestion.
 *
 * @author jbilous
 */
public class SuggestionRequest extends ClientRequest
{
    private Solution suggestion;

    public SuggestionRequest(Solution suggestion)
    {
        this.suggestion = suggestion;
    }

    public Solution getSuggestion()
    {
        return this.suggestion;
    }

}
