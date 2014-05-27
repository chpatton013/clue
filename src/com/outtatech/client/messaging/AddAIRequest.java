package com.outtatech.client.messaging;

import com.outtatech.server.Difficulty;

/**
 * Version-latenightpizzaparty
 * Message sent from the client to the server when an AI is added to a lobby.
 *
 * @author jbilous
 */
public class AddAIRequest extends ClientRequest
{

    private Difficulty difficulty;
    private Integer lobbyId;

    /**
     * Version-latenightpizzaparty
     * Creates a new AddAIRequest object.
     *
     * @param difficulty the difficulty of the new AI player method parameter
     * @param lobbyId method parameter
     */
    public AddAIRequest(Difficulty difficulty, Integer lobbyId)
    {
        this.difficulty = difficulty;
        this.lobbyId = lobbyId;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the difficulty of the AI player.
     *
     * @return the difficulty of the AI player return value
     */
    public Difficulty getDifficulty()
    {
        return difficulty;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the difficulty of the AI player.
     *
     * @param difficulty method parameter
     */
    public void setDifficulty(Difficulty difficulty)
    {
        this.difficulty = difficulty;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the difficulty of the AI player.
     * @return return value
     */

    public Integer getLobbyId()
    {
        return lobbyId;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the difficulty of the AI player.
     * @param lobbyId method parameter
     */

    public void setLobbyId(Integer lobbyId)
    {
        this.lobbyId = lobbyId;
    }
}
