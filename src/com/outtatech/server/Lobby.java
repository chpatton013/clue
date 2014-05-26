/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server;

import java.io.Serializable;
/**
 * Represents a game that is waiting for players to join in order to be started.
 *
 * @author jbilous
 */
public class Lobby implements Serializable
{
    //IMPORTANT: check if issue with lobbyID
    protected static Integer lobbyIdCounter = 0;
    String lobbyName;
    Integer gameId;
    Integer lobbyId;
    boolean visible;

    /**
     * Constructs a new Lobby
     *
     * @param lobbyName String designating the lobby name.
     * @param gameId Integer that differentiates one game from the next.
     */
    public Lobby(String lobbyName, Integer gameId, boolean visible)
    {
        this.lobbyName = lobbyName;
        this.gameId = gameId;
        this.lobbyId = lobbyIdCounter++;
        this.visible = visible;
    }

    /**
     * Returns the name of the lobby.
     *
     * @return the name of the lobby
     */
    public String getLobbyName()
    {
        return lobbyName;
    }

    /**
     * Returns the ID of the game that this lobby represents
     *
     * @return the ID of the game this lobby represents
     */
    public Integer getGameId()
    {
        return gameId;
    }

    /**
     * Returns the id of this lobby.
     *
     * @return the id of this lobby.
     */
    public Integer getLobbyId()
    {
        return lobbyId;
    }

    /**
     * Returns whether or not this lobby should be made visible.
     *
     * @return whether or not this lobby should be made visible.
     */
    public boolean isVisible()
    {
        return this.visible;
    }
}
