package com.outtatech.server.messaging;

import com.outtatech.common.Player;
import com.outtatech.server.Lobby;
import java.util.List;
import java.util.Map;

/**
 * Version-latenightpizzaparty
 * Message sent from the server to the client when a new user joins a lobby that
 * a client is part of.
 *
 * @author jbilous
 */
public class LobbyJoinResponse extends ServerResponse
{
    private Lobby lobby;
    private final Integer playerId;
    private final Map<Integer, String> players;

    /**
     * Version-latenightpizzaparty
     * Used to respond to a human player request.
     *
     * @param lobby method parameter
     * @param playerId method parameter
     * @param players method parameter
     */
    public LobbyJoinResponse(Lobby lobby, Integer playerId,
            Map<Integer, String> players)
    {
        this.lobby = lobby;
        this.playerId = playerId;
        this.players = players;
    }

    /**
     * Version-latenightpizzaparty
     * Getter method that returns the id of the player who has just joined a
     * lobby.
     *
     * @return the id of the player who has joined the lobby return value
     */
    public Lobby getLobby()
    {
        return lobby;
    }

    /**
     * Version-latenightpizzaparty
     * Get the player object created by the game server.
     *
     * @return return value
     */
    public Integer getPlayerId()
    {
        return playerId;
    }

    /**
     * Version-latenightpizzaparty
     * Get the list of player objects in this lobby.
     *
     * @return return value
     */
    public Map<Integer, String> getPlayers()
    {
        return players;
    }
}
