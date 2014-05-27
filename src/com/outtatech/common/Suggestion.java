package com.outtatech.common;

/**
 * The Suggestion class represents a type of ActionCard that represents an
 * Suggestion action. A Suggestion action allows you to make a guess of the
 * Suspect, Vehicle, and Destination and starting at the player to your left
 * players show you hint cards to prove your suggestion wrong.
 *
 * @author bennettschalich
 */
public class Suggestion extends ActionCard
{
    SuggestionType type;

    /**
     * Constructs a new Suggestion ActionCard.
     * @param type
     */
    public Suggestion(SuggestionType type)
    {
        super(ActionCardType.SUGGESTION);
        this.type = type;
    }

    /**
     *
     * @return
     */
    public SuggestionType getType()
    {
        return type;
    }
}
