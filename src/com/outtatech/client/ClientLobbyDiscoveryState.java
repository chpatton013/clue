/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.client;

import com.outtatech.server.Lobby;
import java.util.List;

/**
 * Class ClientLobbyState holds a list of games available on the connected game
 * server. After a client connects to have server and sends a lobby list
 * request, the ClientLobbyState will be instantiated and include a list of
 * available games.
 *
 * @author dmangin
 */
public class ClientLobbyDiscoveryState extends State
{
    private List<Lobby> lobbyList;

    /**
     * Constructor requires a List of Integer Objects that represents a list of
     * available games that the client, player, is able to join.
     *
     * @param gameList List of games in the lobby
     */
    public ClientLobbyDiscoveryState(List<Lobby> lobbyList)
    {
        this.lobbyList = lobbyList;
    }

    ClientLobbyDiscoveryState()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get the current list of lobbies associated with the instance of
     * ClientLobbyState.
     *
     * @return List of Lobby Objects representing unstarted games
     */
    public List<Lobby> getLobbyList()
    {
        return lobbyList;
    }

    /**
     * Sets the lobby list of the state
     *
     * @param newLobbyList the lobby list of the state
     */
    public void setLobbyList(List<Lobby> newLobbyList)
    {
        this.lobbyList = newLobbyList;
    }
}
