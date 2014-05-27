package com.outtatech.client.messaging;

/**
 * Message sent from the client to the server when the client joins a lobby.
 *
 * @author jbilous
 */
public class LobbyJoinRequest extends ClientRequest
{
    Integer lobbyId;

    /**
     * Creates a new ClientRequest object
     * @param lobbyId
     */
    public LobbyJoinRequest(Integer lobbyId)
    {
        this.lobbyId = lobbyId;
    }

    /**
     * Returns the lobby id.
     *
     * @return the lobby id
     */
    public Integer getLobbyId()
    {
        return lobbyId;
    }
}
