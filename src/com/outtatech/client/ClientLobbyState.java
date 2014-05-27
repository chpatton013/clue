package com.outtatech.client;

import java.util.Map;

import com.outtatech.client.*;
import com.outtatech.common.*;

/**
 * ClientPreGameState instances will hold information about other players
 * waiting to join the same game of Indication.
 *
 * @author dmangins
 */
public class ClientLobbyState extends State
{
    private Integer playerId;
    private Map<Integer, String> players;
    private boolean gameOwner;
    private int id;

    /**
     *
     * @param playerId
     * @param players
     * @param gameOwner
     * @param lobbyId
     */
    public ClientLobbyState(Integer playerId, Map<Integer, String> players,
            boolean gameOwner, int lobbyId)
    {
        this.playerId = playerId;
        this.players = players;
        this.gameOwner = gameOwner;
        this.id = lobbyId;
    }

    /**
     * Returns the player associated with this instance.
     *
     * @return Player
     */
    public Integer getPlayerId()
    {
        return this.playerId;
    }

    /**
     *
     * @return
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * Returns a list of players that are waiting for the same game of
     * indication to start.
     *
     * @return List of Integer Objects representing player ids.
     */
    public Map<Integer, String> getPlayers()
    {
        return this.players;
    }

    /**
     *
     * @param playerId
     * @param name
     */
    public void addPlayer(Integer playerId, String name)
    {
        this.players.put(playerId, name);
        this.triggerChange();
    }

    /**
     *
     * @param players
     */
    public void setPlayers(Map<Integer, String> players)
    {
        this.players = players;
        this.triggerChange();
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
