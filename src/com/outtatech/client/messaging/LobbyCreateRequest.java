package com.outtatech.client.messaging;

/**
 * Version-latenightpizzaparty
 * An encapsulated message used by the client to request that the game server
 * creates a new game.
 *
 * @author jbilous
 */
public class LobbyCreateRequest extends ClientRequest
{
    private String lobbyName;

    /**
     * Version-latenightpizzaparty
     * Creates a new LobbyCreateRequest object.
     *
     * @param lobbyName the name of the lobby to create method parameter
     */
    public LobbyCreateRequest(String lobbyName)
    {
        this.lobbyName = lobbyName;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the name of the lobby.
     *
     * @return the name of the lobby. return value
     */
    public String getLobbyName()
    {
        return this.lobbyName;
    }

}
