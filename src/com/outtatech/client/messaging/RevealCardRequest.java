/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client.messaging;

import com.outtatech.common.Card;
import java.util.List;

/**
 * Message sent from the client to the server when they choose a card
 * that is required from them by another player, such as through an action
 * card play.
 * 
 * @author jbilous
 */
public class RevealCardRequest extends ClientRequest {
    
    private Integer revealToId;
    private List<Card> cards;
    
    /**
     * Creates a new RevealCardRequest object.
     * 
     * @param playerId the id of the player the cards are being revealed to.
     * @param cards the cards that will be revealed to the other player.
     */
    public RevealCardRequest(Integer playerId, List<Card> cards) 
    {
        this.revealToId = revealToId;
        this.cards = cards;
    }
    
    /**
     * Returns the id of the player the cards will be revealed to.
     * 
     * @return the id of the player the cards will be revealed to
     */
    public Integer getPlayerId() 
    {
        return revealToId;
    }
    
    /**
     * Returns the cards that will be revealed to the other player.
     * 
     * @return the cards that will be revealed to the other play 
     */
    public List<Card> getCards() 
    {
        return cards;
    }
}
