package com.outtatech.server.messaging;

import com.outtatech.common.HintCard;
import com.outtatech.common.Solution;

/**
 * Version-latenightpizzaparty Message sent from the server to the client in
 * response to a suggestion they made.
 *
 * @author jbilous
 */
public class SuggestionResponse extends ServerResponse
{
    private Integer suggestorID;
    private Integer refutingPlayerID;
    private HintCard refutingCard;
    private Solution solution;

    /**
     * Version-latenightpizzaparty Constructs a new SuggestionResponse object
     *
     * @param correctAccusation whether or not the accusation was correct.
     * method parameter
     */
    public SuggestionResponse(Integer suggestorID, Integer refutingPlayerID,
            HintCard refutingCard, Solution suggestion)
    {
        this.suggestorID = suggestorID;
        this.refutingPlayerID = refutingPlayerID;
        this.refutingCard = refutingCard;
        this.solution = solution;
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
     * Getter method for the suggestion that was made
     *
     * @return the suggestion that was made
     */
    public Solution getSuggestion()
    {
        return this.solution;
    }

    /**
     * Returns the ID of the player who refuted the suggestion.
     *
     * @return the ID of the player refuting the suggestion.
     */
    public Integer getRefutingPlayerID()
    {
        return refutingPlayerID;
    }

    /**
     * Returns the ID of the person making this suggestion.
     *
     * @return the id of the person making the suggestion.
     */
    public Integer getSuggestorID()
    {
        return this.suggestorID;
    }

}
