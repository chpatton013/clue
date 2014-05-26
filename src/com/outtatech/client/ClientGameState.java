/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.client;

import com.outtatech.common.Card;
import com.outtatech.common.DestinationID;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * The ClientGameState class holds logic for the players State in the Indication
 * Game. The class mediates game logic between the server and the player.
 *
 * @author dmangin
 */
public class ClientGameState extends State
{
    private int playerID;
    private Object notes;
    private List<Card> hand;
    private boolean revealStatus;
    private List<Card> revealed;
    private boolean newAccusation;
    private boolean accusationStatus;
    private Deque<String> gameLog;

    private Integer deckCardCount;
    private List<Integer> playerTurnOrder;
    private Integer currentActivePlayer;

    /**
     * Map holds the set of DestinationIds and a corresponding playerId.
     */
    private Map<DestinationID, Integer> destToPlayerId;

    public ClientGameState(int playerID, List<Card> hand)
    {
        this.playerID = playerID;
        this.hand = hand;
        this.revealed = new ArrayList<Card>();
        this.revealStatus = false;
        this.newAccusation = false;
        this.accusationStatus = false;
        this.gameLog = new LinkedList<String>();
    }

    /**
     * Sets a flag that indicates whether or not a new accusation has been made
     * since last update.
     */
    public void setNewAccusation()
    {
        newAccusation = true;
    }

    /**
     * Getter for a field that indicates whether or not a new accusation has
     * been made since last check.
     *
     * @return whether or not a new accusation has been made
     */
    public boolean getAccusationStatus()
    {
        return accusationStatus;
    }

    /**
     * Returns a field that indicates whether the current accusation is correct,
     * sets the field that indicates whether or not there was a new accusation
     * to false after access.
     *
     * @return whether or not the accusation was correct.
     */
    public boolean getAccusation()
    {
        newAccusation = false;
        return accusationStatus;
    }

    /**
     * Returns the player id associated with the ClientGameState instance.
     *
     * @return playerID
     */
    public int getPlayerId()
    {
        return playerID;
    }

    /**
     * Getter method for the cards that have been revealed to the client.
     *
     * @return a list that contains cards that have been revealed to the client.
     */
    public List<Card> getRevealed()
    {
        return revealed;
    }

    /**
     * Setter method for the list of cards that have been revealed to the
     * client.
     *
     * @param revealed the list of cards that have been revealed to the client.
     */
    public void setRevealed(List<Card> revealed)
    {
        this.revealed = revealed;
    }

    /**
     * Gets the field that indicates whether or not new cards have been revealed
     * to the client since last state check, set to false after access.
     */
    public boolean getRevealStatus()
    {
        boolean curRevealStatus = revealStatus;
        revealStatus = false;
        return curRevealStatus;
    }

    /**
     * Gets the field that indicates whether or not new cards have been revealed
     * to the client since last state check.
     *
     * @param revealStatus
     */
    public void setRevealStatus(boolean revealStatus)
    {
        this.revealStatus = revealStatus;
    }

    /**
     * Change the player id associated to the instance of ClientGameState
     *
     * @param playerID integer id of the player
     */
    public void setPlayerId(int playerID)
    {
        this.playerID = playerID;
    }

    /**
     * Returns an Object representing the players notes.
     *
     * @return Object
     */
    public Object getNotes()
    {
        return notes;
    }

    /**
     * Returns a list of the current Indication cards held by the calling
     * instance.
     *
     * @return List of Card Objects
     */
    public List<Card> getHand()
    {
        return hand;
    }

    /**
     * Returns a map representing a set of Destinations and its corresponding
     * playerID.
     *
     * @return Map of DestinationID Objects to Integer Playerids
     */
    public Map<DestinationID, Integer> getDestToPlayerId()
    {
        return destToPlayerId;
    }

    public Integer getDeckCardCount()
    {
        return this.deckCardCount;
    }

    public List<Integer> getPlayerTurnOrder()
    {
        return this.playerTurnOrder;
    }

    public Integer getCurrentActivePlayer()
    {
        return this.currentActivePlayer;
    }

    public void setDeckCardCount(Integer deckCardCount)
    {
        this.deckCardCount = deckCardCount;
    }

    public void setPlayerTurnOrder(List<Integer> playerTurnOrder)
    {
        this.playerTurnOrder = playerTurnOrder;
    }

    public void setCurrentActivePlayer(Integer currectActivePlayer)
    {
        this.currentActivePlayer = currentActivePlayer;
    }

    public void pushGameLog(String message)
    {
        this.gameLog.addLast(message);
    }

    public String pollGameLog()
    {
        return this.gameLog.poll();
    }
}
