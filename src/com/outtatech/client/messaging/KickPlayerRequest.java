/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.client.messaging;

/**
 * Message sent from the client to the server when they would like a player
 * kicked from the current lobby.
 *
 * @author jbilous
 */
public class KickPlayerRequest extends ClientRequest
{

    private Integer playerId;

    /**
     * Construct a new KickPlayerRequest object
     *
     * @param playerId the id of the player to be kicked.
     */
    public KickPlayerRequest(Integer playerId)
    {
        this.playerId = playerId;
    }

    /**
     * Getter method for the ID of the player to kick.
     *
     * @return the ID of the player to kick.
     */
    public Integer getPlayerId()
    {
        return playerId;
    }
}
