package com.outtatech.client.messaging;

import com.outtatech.server.Difficulty;

/**
 * Message sent from the client to the server when an AI is added to a lobby.
 *
 * @author jbilous
 */
public class AddAIRequest extends ClientRequest
{

    private Difficulty difficulty;
    private Integer lobbyId;

    /**
     * Creates a new AddAIRequest object.
     *
     * @param difficulty the difficulty of the new AI player
     * @param lobbyId
     */
    public AddAIRequest(Difficulty difficulty, Integer lobbyId)
    {
        this.difficulty = difficulty;
        this.lobbyId = lobbyId;
    }

    /**
     * Returns the difficulty of the AI player.
     *
     * @return the difficulty of the AI player
     */
    public Difficulty getDifficulty()
    {
        return difficulty;
    }

    /**
     * Sets the difficulty of the AI player.
     *
     * @param difficulty
     */
    public void setDifficulty(Difficulty difficulty)
    {
        this.difficulty = difficulty;
    }

    /**
     * Sets the difficulty of the AI player.
     * @return 
     */

    public Integer getLobbyId()
    {
        return lobbyId;
    }

    /**
     * Sets the difficulty of the AI player.
     * @param lobbyId
     */

    public void setLobbyId(Integer lobbyId)
    {
        this.lobbyId = lobbyId;
    }
}
