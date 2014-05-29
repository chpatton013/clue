package com.outtatech.common;

/**
 * Version-latenightpizzaparty
 * The Suggestion class represents a type of ActionCard that represents an
 * Suggestion action. A Suggestion action allows you to make a guess of the
 * Suspect, Vehicle, and Destination and starting at the player to your left
 * players show you hint cards to prove your suggestion wrong.
 *
 * @author bennettschalich
 */
public class Suggestion extends ActionCard
{
    private SuggestionType type;

    /**
     * Version-latenightpizzaparty
     * Constructs a new Suggestion ActionCard.
     * @param type method parameter
     */
    public Suggestion(SuggestionType type)
    {
        super(ActionCardType.SUGGESTION);
        this.type = type;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public SuggestionType getType()
    {
        return type;
    }

    public String toString()
    {
        return (this.type == SuggestionType.ANY) ? "SUGGESTION_ANYWHERE" :
            "SUGGESTION";
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Suggestion)) {
            return false;
        }

        Suggestion other = (Suggestion)obj;
        return this.type == other.type;
    }
}
