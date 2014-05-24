/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server.messaging;

/**
 * Message sent from the server to the client in response to a request to 
 * have a player kicked.
 *
 * @author jbilous
 */
public class KickPlayerResponse extends ServerResponse
{
    private int playerId;
    
    /**
     * Creates a new KickPlayerResponse object.
     *
     * @param playerId The Id of the player kicked from the game
     */
    public KickPlayerResponse(int playerId)
    {
        this.playerId = playerId;
    }
    
    /**
     * Getter method for the Id of the player kicked
     * 
     * @return Id of the player kicked
     */
    public int getPlayerId() {
        return playerId;
    }
}
