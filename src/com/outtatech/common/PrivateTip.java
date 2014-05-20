/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.common;

/**
 * The PrivateTip class represents a type of ActionCard that represents an 
 * Private Tip action. A PrivateTip ActionCard results in one of the following:
 * A player or your choice:
 *      Shows you all their Suspect Cards."  (1)
 *      Shows you all their Vehicle Cards." (1)
 *      Shows you all their Destination Cards." (1)
 *      Shows you one female Suspect Card." (1)
 *      Shows you one red Vehicle Card." (1)
 *      Shows you one northern Destination Card." (1)"
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
