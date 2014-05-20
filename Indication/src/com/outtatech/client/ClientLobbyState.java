/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client;

import java.util.List;

/**
 * Class ClientLobbyState holds a list of games available on the
 * connected game server.  After a client connects to have server
 * and sends a lobby list request, the ClientLobbyState will be 
 * instantiated and include a list of available games.
 * @author dmangin
 */
public class ClientLobbyState extends State
{
    private List<Integer> gameList;
    
    /**
     * Constructor requires a List of Integer Objects that represents a
     * list of available games that the client, player, is able
     * to join.
     * @param gameList List of games in the lobby
     */
    public ClientLobbyState(List<Integer> gameList)
    {
        this.gameList = gameList;
    }
    
    /**
     * Get the current list of games associated with the instance of
     * ClientLobbyState.
     * @return List of Integer Objects representing games
     */
    public List<Integer> getGameList() 
    {
        return gameList;
    }
}
