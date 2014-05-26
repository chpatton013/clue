/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server.messaging;

import com.outtatech.common.Player;
import com.outtatech.server.Lobby;

import java.util.List;

/**
 * Message sent from the server to the client when a new user joins a lobby that
 * a client is part of.
 *
 * @author jbilous
 */
public class LobbyJoinResponse extends ServerResponse
{
    private Lobby lobby;
    private final Integer playerId;
    private final List<Player> players;

    /**
     * Used to respond to a human player request.
     * @param lobby
     * @param player
     */
    public LobbyJoinResponse(Lobby lobby, Integer playerId, List<Player> players)
    {
        this.lobby = lobby;
        this.playerId = playerId;
        this.players = players;
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
    public Integer getPlayerId()
    {
        return playerId;
    }

    /**
     * Get the list of player objects in this lobby.
     * @return
     */
    public List<Player> getPlayers()
    {
        return players;
    }
}
