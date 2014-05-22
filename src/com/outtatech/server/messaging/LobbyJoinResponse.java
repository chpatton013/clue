/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server.messaging;

/**
 * Message sent from the server to the client when a new user joins a lobby that
 * a client is part of.
 *
 * @author jbilous
 */
public class LobbyJoinResponse extends ServerResponse
{
    private Integer joinedPlayerId;

    public LobbyJoinResponse(int joinedPlayerId)
    {
        this.joinedPlayerId = joinedPlayerId;
    }

    /**
     * Getter method that returns the id of the player who has just joined a
     * lobby.
     *
     * @return the id of the player who has joined the lobby
     */
    public Integer getJoinedPlayerId()
    {
        return joinedPlayerId;
    }
}
