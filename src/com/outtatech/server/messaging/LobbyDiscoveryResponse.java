package com.outtatech.server.messaging;

import com.outtatech.server.Lobby;
import java.util.List;

/**
 * Version-latenightpizzaparty
 * Message sent from the server to the client when the client requests a list of
 * Lobbies
 *
 * @author jbilous
 */
public class LobbyDiscoveryResponse extends ServerResponse
{
    private List<Lobby> lobbies;

    /**
     * Version-latenightpizzaparty
     * Constructs a new lobby discovery response message.
     *
     * @param lobbies list of currently active lobbies. method parameter
     */
    public LobbyDiscoveryResponse(List<Lobby> lobbies)
    {
        this.lobbies = lobbies;
    }

    /**
     * Version-latenightpizzaparty
     * Returns a list of currently active lobbies.
     *
     * @return list of currently active lobbies. return value
     */
    public List<Lobby> getLobbies()
    {
        return lobbies;
    }
}
