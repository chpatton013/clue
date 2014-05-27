/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.server.messaging;

import com.outtatech.common.Player;
import java.util.List;

/**
 * Message sent from the server to the client that encapsulates the server's
 * representation of a game.
 *
 * @author jbilous
 */
public class GameStateResponse extends ServerResponse
{

    private Integer deckCardCount;
    private List<Integer> playerTurnOrder;
    private Integer currentActivePlayer;
    private List<Player> players;

    /**
     * Constructs a new GameStateResponse object
     *
     * @param deckCardCount the number of cards in the game's deck
     * @param playerTurnOrder list of player ID's that represents turn order
     * @param currentActivePlayer id of the currently active player
     */
    public GameStateResponse(Integer deckCardCount,
            List<Integer> playerTurnOrder, Integer currentActivePlayer, 
            List<Player> players)
    {
        this.deckCardCount = deckCardCount;
        this.players = players;
        this.playerTurnOrder = playerTurnOrder;
        this.currentActivePlayer = currentActivePlayer;
    }

    /**
     * Returns the number of cards in the Game's deck.
     *
     * @return the number of cards in the Game's deck
     */
    public Integer getDeckCardCount()
    {
        return deckCardCount;
    }
    
    public List<Player> getPlayers()
    {
        return players;
    }

    /**
     * Returns a list representing the order in which players take their turns.
     *
     * @return a list representing the order in which players take their turns.
     */
    public List<Integer> getPlayerTurnOrder()
    {
        return playerTurnOrder;
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
