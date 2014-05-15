/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.common;

/**
 * The PrivateTip class represents a type of ActionCard that represents an 
 * Private Tip action.
 * @author bennettschalich
 */
public class PrivateTip extends ActionCard
{    
    /**
     * Constructs a new PrivatTip ActionCard.
     */ 
    public PrivateTip()
    {
        super(ActionCardType.PRIVATE_TIP);
    }
}
