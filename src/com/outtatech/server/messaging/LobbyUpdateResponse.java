/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server.messaging;

import com.outtatech.server.*;

/**
 * Message passed from the server to the client in response to a player joining
 * or leaving an existing lobby.
 *
 * @author jbilous
 */
public class LobbyUpdateResponse extends ServerResponse
{
    private Lobby lobby;
    
    public LobbyUpdateResponse(Lobby lobby) {
        this.lobby = lobby;
    }
    
    public Lobby getLobby() {
        return lobby;
    }
}
