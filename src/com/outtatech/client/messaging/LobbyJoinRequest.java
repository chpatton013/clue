/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.client.messaging;

/**
 * Message sent from the client to the server when the client joins a lobby.
 *
 * @author jbilous
 */
public class LobbyJoinRequest extends ClientRequest
{
    Integer lobbyId;

    /**
     * Creates a new ClientRequest object
     */
    public LobbyJoinRequest(Integer lobbyId)
    {
        this.lobbyId = lobbyId;
    }

    /**
     * Returns the lobby id.
     *
     * @return the lobby id
     */
    public Integer getLobbyId()
    {
        return lobbyId;
    }
}
