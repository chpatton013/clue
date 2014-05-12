/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client.messaging;

import com.outtatech.common.ActionCard;
import com.outtatech.common.Card;
import java.util.List;

/**
 * Message sent from the client to the server when an action card
 * is played or an accusation is made.
 * 
 * @author jbilous
 */
public class ActionRequest extends ClientRequest {
   private ActionCard actionCard;
   private List<Card> cards;
   
   /**
    * Returns a new ActionRequest object.
    * 
    * @param actionCard the action card that the client is playing
    * @param cards the cards involved in the action
    */
   public ActionRequest(ActionCard actionCard, List<Card> cards) {
       
   }
   
   /**
    * Returns the action card involved in the user action.
    * 
    * @return the action card involved in the user action.
    */
   public ActionCard getActionCard() {
       return actionCard;
   }
   
   /**
    * Returns the cards involved in the clients action.
    * 
    * @return the cards involved in the clients action.
    */
   public List<Card> getCards() {
       return cards;
   }
}
