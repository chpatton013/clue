/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.common;

/**
 * The AllSnoop class represents a type of ActionCard that represents an 
 * All Snoop action.
 * @author bennettschalich
 */
public class AllSnoop extends ActionCard
{
    /* Whether or not the All Snoop action occurs to the right
     To the right if true; otherwise false*/
    private boolean right;
    
    /**
     * Constructs a new AllSnoop ActionCard.
     * @param right The direction the All Snoop action will take. If true- 
     * right; otherwise left.
     */
    public AllSnoop(boolean right)
    {
        super(ActionCardType.ALL_SNOOP);
        this.right = right;
    }
}
