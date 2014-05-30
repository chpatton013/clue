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
    private String lobbyName;
    private Integer gameId;
    private Integer lobbyId;
    private boolean visible;

    /**
     * Version-latenightpizzaparty
     * Constructs a new Lobby
     *
     * @param lobbyName String designating the lobby name. method parameter
     * @param gameId Integer that differentiates one game from the next. method parameter
     * @param visible method parameter
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
     * @return the name of the lobby return value
     */
    public String getLobbyName()
    {
        return lobbyName;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the ID of the game that this lobby represents
     *
     * @return the ID of the game this lobby represents return value
     */
    public Integer getGameId()
    {
        return gameId;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the id of this lobby.
     *
     * @return the id of this lobby. return value
     */
    public Integer getLobbyId()
    {
        return lobbyId;
    }

    /**
     * Version-latenightpizzaparty
     * Returns whether or not this lobby should be made visible.
     *
     * @return whether or not this lobby should be made visible. return value
     */
    public boolean isVisible()
    {
        return this.visible;
    }
}
