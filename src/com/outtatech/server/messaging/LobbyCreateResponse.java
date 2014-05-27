package com.outtatech.server.messaging;

import com.outtatech.server.Lobby;

/**
 * Message sent from the server to the client when the client requests a new
 * game be created on their behalf.
 *
 * @author jbilous
 */
public class LobbyCreateResponse extends ServerResponse
{

    private Lobby lobby;

    /**
     * Creates a LobbyCreateResponse
     *
     * @param lobby the lobby that was newly created.
     */
    public LobbyCreateResponse(Lobby lobby)
    {
        this.lobby = lobby;
    }

    /**
     * Returns a newly created lobby object.
     *
     * @return the newly created lobby
     */
    public Lobby getLobby()
    {
        return lobby;
    }
}
