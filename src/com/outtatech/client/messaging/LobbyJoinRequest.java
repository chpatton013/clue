package com.outtatech.client.messaging;

/**
 * Version-latenightpizzaparty
 * Message sent from the client to the server when the client joins a lobby.
 *
 * @author jbilous
 */
public class LobbyJoinRequest extends ClientRequest
{
    private Integer lobbyId;

    /**
     * Version-latenightpizzaparty
     * Creates a new ClientRequest object
     * @param lobbyId method parameter
     */
    public LobbyJoinRequest(Integer lobbyId)
    {
        this.lobbyId = lobbyId;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the lobby id.
     *
     * @return the lobby id return value
     */
    public Integer getLobbyId()
    {
        return lobbyId;
    }
}
