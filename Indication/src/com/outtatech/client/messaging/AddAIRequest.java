/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client.messaging;

import com.outtatech.server.Difficulty;

/**
 * Message sent from the client to the server when an AI is added to a lobby.
 * 
 * @author jbilous
 */
public class AddAIRequest extends ClientRequest {
    
    private Difficulty difficulty;
    
    private Integer lobbyId;
    
    /**
     * Creates a new AddAIRequest object.
     * 
     * @param difficulty the difficulty of the new AI player
     */
    public AddAIRequest(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    
    /**
     * Sets the lobby ID for this AI player.
     * 
     * @param lobbyId the lobby ID this AI player belongs to
     */
    public void setLobbyId(Integer lobbyId) {
        this.lobbyId = lobbyId;
    }
    
    /**
     * Returns the difficulty of the AI player.
     * @return the difficulty of the AI player
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }
}