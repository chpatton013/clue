/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     */
    public Suggestion(SuggestionType type)
    {
        super(ActionCardType.SUGGESTION);
        this.type = type;
    }
    
    public SuggestionType getType()
    {
        return type;
    }
}
