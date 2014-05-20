/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.common;

/**
 * The Snoop class represents a type of ActionCard that represents an 
 * Snoop action. The Snoop action allows you to look at the hint cards of the player of your 
 * choice.
 * @author bennettschalich
 */
public class Snoop extends ActionCard
{
    /**
     * Constructs a new AllSnoop ActionCard.
     */
    public Snoop()
    {
        super(ActionCardType.SNOOP);
    }
}
