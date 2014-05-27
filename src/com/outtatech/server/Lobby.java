package com.outtatech.server;

import java.io.Serializable;

/**
 * Version-latenightpizzaparty
 * Represents a game that is waiting for players to join in order to be started.
 *
 * @author jbilous
 */
public class Lobby implements Serializable
{
    //IMPORTANT: check if issue with lobbyID

    /**
     * Version-latenightpizzaparty
     *
     */
    protected static Integer lobbyIdCounter = 0;
    String lobbyName;
    Integer gameId;
    Integer lobbyId;
    boolean visible;

    /**
     * Version-latenightpizzaparty
     * Constructs a new Lobby
     *
     * @param lobbyName String designating the lobby name.
     * @param gameId Integer that differentiates one game from the next.
     * @param visible
     */
    public Lobby(String lobbyName, Integer gameId, boolean visible)
    {
        this.lobbyName = lobbyName;
        this.gameId = gameId;
        this.lobbyId = gameId;
        this.visible = visible;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the name of the lobby.
     *
     * @return the name of the lobby
     */
    public String getLobbyName()
    {
        return lobbyName;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the ID of the game that this lobby represents
     *
     * @return the ID of the game this lobby represents
     */
    public Integer getGameId()
    {
        return gameId;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the id of this lobby.
     *
     * @return the id of this lobby.
     */
    public Integer getLobbyId()
    {
        return lobbyId;
    }

    /**
     * Version-latenightpizzaparty
     * Returns whether or not this lobby should be made visible.
     *
     * @return whether or not this lobby should be made visible.
     */
    public boolean isVisible()
    {
        return this.visible;
    }
}
