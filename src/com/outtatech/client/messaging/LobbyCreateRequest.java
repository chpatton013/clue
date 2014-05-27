package com.outtatech.client.messaging;

/**
 * An encapsulated message used by the client to request that the game server
 * creates a new game.
 *
 * @author jbilous
 */
public class LobbyCreateRequest extends ClientRequest
{
    String lobbyName;

    /**
     * Creates a new LobbyCreateRequest object.
     *
     * @param lobbyName the name of the lobby to create
     */
    public LobbyCreateRequest(String lobbyName)
    {
        this.lobbyName = lobbyName;
    }

    /**
     * Returns the name of the lobby.
     *
     * @return the name of the lobby.
     */
    public String getLobbyName()
    {
        return this.lobbyName;
    }

}
