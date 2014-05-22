/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server.messaging;

import com.outtatech.server.Lobby;
import java.util.List;

/**
 * Message sent from the server to the client when the client requests a list of
 * Lobbies
 *
 * @author jbilous
 */
public class LobbyDiscoveryResponse extends ServerResponse
{
    private List<Lobby> lobbies;

    /**
     * Constructs a new lobby discovery response message.
     *
     * @param lobbies list of currently active lobbies.
     */
    public LobbyDiscoveryResponse(List<Lobby> lobbies)
    {
        this.lobbies = lobbies;
    }

    /**
     * Returns a list of currently active lobbies.
     *
     * @return list of currently active lobbies.
     */
    public List<Lobby> getLobbies()
    {
        return lobbies;
    }
}
