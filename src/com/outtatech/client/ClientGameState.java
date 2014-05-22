/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.client;

import java.util.List;
import java.util.Map;
import com.outtatech.common.Card;
import com.outtatech.common.DestinationID;

/**
 * The ClientGameState class holds logic for the players State in the Indication
 * Game. The class mediates game logic between the server and the player.
 *
 * @author dmangin
 */
public class ClientGameState
{
    private int playerID;
    private Object notes;
    private List<Card> hand;
    private boolean newReveal;

    /**
     * Map holds the set of DestinationIds and a corresponding playerId.
     */
    private Map<DestinationID, Integer> destToPlayerId;

    public ClientGameState(int playerID, Object notes, List<Card> hand,
            Map<DestinationID, Integer> destToPlayerId)
    {
        this.playerID = playerID;
        this.notes = notes;
        this.hand = hand;
        this.destToPlayerId = destToPlayerId;
        this.newReveal = false;
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
     * Gets the field that indicates whether or not new cards have been revealed
     * to the client since last state check, set to false after access.
     */
    public boolean getNewReveal()
    {
        boolean curReveal = newReveal;
        newReveal = false;
        return curReveal;
    }

    /**
     * Gets the field that indicates whether or not new cards have been revealed
     * to the client since last state check.
     *
     * @param revealStatus
     */
    public void setNewReveal(boolean revealStatus)
    {
        newReveal = revealStatus;
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
}
