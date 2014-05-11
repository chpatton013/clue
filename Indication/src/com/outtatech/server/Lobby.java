/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.server;

/**
 * Represents a game that is waiting for players to join in order to be started.
 * 
 * @author jbilous
 */
public class Lobby {
    String lobbyName;
    Integer gameId;
    
    /**
     * Constructs a new Lobby 
     * @param lobbyName
     * @param gameId 
     */
    public Lobby(String lobbyName, Integer gameId) {
        
    }
    
    /**
     * Returns the name of the lobby.
     * 
     * @return the name of the lobby
     */
    public String getLobbyName() {
        return lobbyName;
    }
    
    /**
     * Returns the ID of the game that this lobby represents
     * @return the ID of the game this lobby represents
     */
    public Integer getGameId() {
        return gameId;
    }
    
}
