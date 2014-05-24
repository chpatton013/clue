/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server.messaging;

/**
 * Message passed from the server to the client in response to a player joining
 * an existing lobby.
 *
 * @author jbilous
 */
public class LobbyLeaveResponse extends ServerResponse
{
    private Integer playerId;

    public LobbyLeaveResponse(Integer playerId)
    {
        this.playerId = playerId;
    }

    public Integer getPlayerId()
    {
        return this.playerId;
    }
}
