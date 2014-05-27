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
     * @param lobbyList
     */
    public ClientLobbyDiscoveryState(List<Lobby> lobbyList)
    {
        this.lobbyList = lobbyList;
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
