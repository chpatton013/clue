package com.outtatech.server.messaging;

import com.outtatech.common.Player;
import java.util.List;
import java.util.Map;

/**
 * Message sent from the server to the client that encapsulates the server's
 * representation of a game.
 *
 * @author jbilous
 */
public class GameStateResponse extends ServerResponse
{

    private Integer currentActivePlayer;
    private Map<Integer, String> players;

    /**
     * Constructs a new GameStateResponse object
     *
     * @param currentActivePlayer id of the currently active player
     */
    public GameStateResponse(Integer currentActivePlayer,
            Map<Integer, String> players)
    {
        this.players = players;
        this.currentActivePlayer = currentActivePlayer;
    }

    public Map<Integer, String> getPlayers()
    {
        return players;
    }

    /**
     * Returns the id of the player whose turn is currently active.
     *
     * @return the id of the player whose turn is currently active.
     */
    public Integer getCurrentActivePlayer()
    {
        return currentActivePlayer;
    }
}
