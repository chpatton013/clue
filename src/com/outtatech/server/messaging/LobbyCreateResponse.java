package com.outtatech.server.messaging;

import com.outtatech.server.Lobby;

/**
 * Version-latenightpizzaparty
 * Message sent from the server to the client when the client requests a new
 * game be created on their behalf.
 *
 * @author jbilous
 */
public class LobbyCreateResponse extends ServerResponse
{

    private Lobby lobby;

    /**
     * Version-latenightpizzaparty
     * Creates a LobbyCreateResponse
     *
     * @param lobby the lobby that was newly created. method parameter
     */
    public LobbyCreateResponse(Lobby lobby)
    {
        this.lobby = lobby;
    }

    /**
     * Version-latenightpizzaparty
     * Returns a newly created lobby object.
     *
     * @return the newly created lobby return value
     */
    public Lobby getLobby()
    {
        return lobby;
    }
}
