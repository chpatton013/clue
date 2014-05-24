/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.client;

import java.util.List;

import com.outtatech.client.*;
import com.outtatech.common.*;

/**
 * ClientPreGameState instances will hold information about other players
 * waiting to join the same game of Indication.
 *
 * @author dmangin
 */
public class ClientLobbyState extends State
{
    private Player player;
    private List<Player> players;
    private boolean gameOwner;

    public ClientLobbyState(Player player, List<Player> players,
            boolean gameOwner)
    {
        this.player = player;
        this.players = players;
        this.gameOwner = gameOwner;
    }

    /**
     * Returns the player associated with this instance.
     *
     * @return Player
     */
    public Player getPlayer()
    {
        return this.player;
    }

    /**
     * Returns a list of players that are waiting for the same game of
     * indication to start.
     *
     * @return List of Integer Objects representing player ids.
     */
    public List<Player> getPlayers()
    {
        return this.players;
    }

    public void addPlayer(Player player)
    {
        this.players.add(player);
    }

    /**
     * Checks if the playerId associated with this instance is the game owner.
     * ie. created the game.
     *
     * @return boolean true if player is the game owner.
     */
    public boolean getGameOwner()
    {
        return gameOwner;
    }
}
