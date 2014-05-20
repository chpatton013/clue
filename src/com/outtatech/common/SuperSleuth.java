/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.common;


/**
 * The SuperSleuth class represents a type of ActionCard that represents an 
 * SuperSleuth action. A SuperSleuth action does on of the following:
 * A player of your choice:
 *   "Shows you one female Suspect Card." (1)
 *   "Show you one male Suspect Card." (1)
 *   "Shows you one flying Vehicle Card." (1)
 *   "Shows you one blue Vehicle Card." (1)
 *   "Shows you one southern Destination Card." (1)
 *   "Shows you one western Destination Card." (1)
 * @author bennettschalich
 */
public class SuperSleuth extends ActionCard
{
    /**
     * Constructs a new SuperSleuth ActionCard.
     */ 
    public SuperSleuth()
    {
        super(ActionCardType.SUPER_SLEUTH);
    }
}
