/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server.messaging;

import com.outtatech.common.Player;
import com.outtatech.server.Lobby;

/**
 * Message sent from the server to the client when a new user joins a lobby that
 * a client is part of.
 *
 * @author jbilous
 */
public class LobbyJoinResponse extends ServerResponse
{
    private Lobby lobby;
    private final Player player;

    /**
     * Used to respond to a human player request.
     * @param lobby
     * @param player 
     */
    public LobbyJoinResponse(Lobby lobby, Player player)
    {
        this.lobby = lobby;
        this.player = player;
    }

    /**
     * Getter method that returns the id of the player who has just joined a
     * lobby.
     *
     * @return the id of the player who has joined the lobby
     */
    public Lobby getLobby()
    {
        return lobby;
    }
    
    /**
     * Get the player object created by the game server.
     * @return 
     */
    public Player getPlayer()
    {
        return player;
    }
}
