package com.outtatech.client.messaging;

import com.outtatech.common.DestinationID;
import com.outtatech.common.Solution;
import com.outtatech.common.Suggestion;

/**
 * Version-latenightpizzaparty Message sent from the client to the server when
 * they would like to make a suggestion.
 *
 * @author jbilous
 */
public class SuggestionRequest extends ClientRequest
{
    private Suggestion card;
    private Solution suggestion;
    private DestinationID destination;

    /**
     * Version-latenightpizzaparty
     *
     * @param suggestion method parameter
     */
    public SuggestionRequest(Suggestion card, Solution suggestion,
            DestinationID destination)
    {
        this.card = card;
        this.suggestion = suggestion;
        this.destination = destination;
    }

    /**
     * Gets the players current / desired location from which they will make
     * the suggestion.
     * 
     * @return the destination from which the player will make the suggestion.
     */
    public DestinationID getDestination()
    {
        return destination;
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
