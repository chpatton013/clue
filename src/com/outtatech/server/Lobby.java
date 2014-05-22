/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server;

/**
 * Represents a game that is waiting for players to join in order to be started.
 *
 * @author jbilous
 */
public class Lobby
{
    String lobbyName;
    Integer gameId;
    Integer lobbyId;

    /**
     * Constructs a new Lobby
     *
     * @param lobbyName String designating the lobby name.
     * @param gameId Integer that differentiates one game from the next.
     */
    public Lobby(String lobbyName, Integer gameId, Integer lobbyId)
    {
        this.lobbyName = lobbyName;
        this.gameId = gameId;
        this.lobbyId = lobbyId;
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
}
