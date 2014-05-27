package com.outtatech.client;

import com.outtatech.common.Card;
import com.outtatech.common.DestinationID;
import com.outtatech.common.Player;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Version-latenightpizzaparty
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
    private Map<Integer, String> players;

    private Integer currentActivePlayer;

    /**
     * Version-latenightpizzaparty
     * Map holds the set of DestinationIds and a corresponding playerId.
     */
    private Map<DestinationID, Integer> destToPlayerId;

    /**
     * Version-latenightpizzaparty
     *
     * @param playerID method parameter
     * @param hand method parameter
     * @param players method parameter
     */
    public ClientGameState(int playerID, List<Card> hand,
            Map<Integer, String> players)
    {
        this.players = players;
        this.playerID = playerID;
        this.hand = hand;
        this.revealed = new ArrayList<Card>();
        this.revealStatus = false;
        this.newAccusation = false;
        this.accusationStatus = false;
        this.gameLog = new LinkedList<String>();
    }

    /**
     * Version-latenightpizzaparty
     * Sets a flag that indicates whether or not a new accusation has been made
     * since last update.
     */
    public void setNewAccusation()
    {
        newAccusation = true;
        triggerChange();
    }

    /**
     * Version-latenightpizzaparty
     * Getter for a field that indicates whether or not a new accusation has
     * been made since last check.
     *
     * @return whether or not a new accusation has been made return value
     */
    public boolean getAccusationStatus()
    {
        return accusationStatus;
    }

    /**
     * Version-latenightpizzaparty
     * Returns a field that indicates whether the current accusation is correct,
     * sets the field that indicates whether or not there was a new accusation
     * to false after access.
     *
     * @return whether or not the accusation was correct. return value
     */
    public boolean getAccusation()
    {
        newAccusation = false;
        return accusationStatus;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the player id associated with the ClientGameState instance.
     *
     * @return playerID return value
     */
    public int getPlayerId()
    {
        return playerID;
    }

    /**
     * Version-latenightpizzaparty
     * Setter method that sets the mapping from destination IDs to player IDs
     *
     * @param map method parameter
     */
    public void setDestToPlayerId(Map<DestinationID, Integer> map)
    {
        this.destToPlayerId = map;
        triggerChange();
    }

    /**
     * Version-latenightpizzaparty
     * Sets the players in this game
     *
     * @param players the players in this game. method parameter
     */
    public void setPlayers(Map<Integer, String> players)
    {
        this.players = players;
        triggerChange();
    }

    /**
     * Version-latenightpizzaparty
     * Returns the list of players in this game
     *
     * @return the list of players in this game return value
     */
    public Map<Integer, String> getPlayers()
    {
        return players;
    }

    /**
     * Version-latenightpizzaparty
     * Getter method for the cards that have been revealed to the client.
     *
     * @return a list that contains cards that have been revealed to the client.
     * return value
     */
    public List<Card> getRevealed()
    {
        return revealed;
    }

    /**
     * Version-latenightpizzaparty
     * Setter method for the list of cards that have been revealed to the
     * client.
     *
     * @param revealed the list of cards that have been revealed to the client. 
     * method parameter
     */
    public void setRevealed(List<Card> revealed)
    {
        this.revealed = revealed;
        triggerChange();
    }

    /**
     * Version-latenightpizzaparty
     * Gets the field that indicates whether or not new cards have been revealed
     * to the client since last state check, set to false after access.
     * @return return value
     */
    public boolean getRevealStatus()
    {
        boolean curRevealStatus = revealStatus;
        revealStatus = false;
        return curRevealStatus;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the field that indicates whether or not new cards have been revealed
     * to the client since last state check.
     *
     * @param revealStatus method parameter
     */
    public void setRevealStatus(boolean revealStatus)
    {
        this.revealStatus = revealStatus;
        triggerChange();
    }

    /**
     * Version-latenightpizzaparty
     * Change the player id associated to the instance of ClientGameState
     *
     * @param playerID integer id of the player method parameter
     */
    public void setPlayerId(int playerID)
    {
        this.playerID = playerID;
        triggerChange();
    }

    /**
     * Version-latenightpizzaparty
     * Sets this players hand.
     *
     * @param hand method parameter
     */
    public void setPlayerHand(List<Card> hand)
    {
        this.hand = hand;
        triggerChange();
    }

    /**
     * Version-latenightpizzaparty
     * Returns an Object representing the players notes.
     *
     * @return Object return value
     */
    public Object getNotes()
    {
        return notes;
    }

    /**
     * Version-latenightpizzaparty
     * Sets this players notes.
     *
     * @param notes method parameter
     */
    public void setNotes(Object notes)
    {
        this.notes = notes;
        triggerChange();
    }

    /**
     * Version-latenightpizzaparty
     * Returns a list of the current Indication cards held by the calling
     * instance.
     *
     * @return List of Card Objects return value
     */
    public List<Card> getHand()
    {
        return hand;
    }

    /**
     * Version-latenightpizzaparty
     * Returns a map representing a set of Destinations and its corresponding
     * playerID.
     *
     * @return Map of DestinationID Objects to Integer Playerids return value
     */
    public Map<DestinationID, Integer> getDestToPlayerId()
    {
        return destToPlayerId;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public Integer getCurrentActivePlayer()
    {
        return this.currentActivePlayer;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param currentActivePlayer method parameter
     */
    public void setCurrentActivePlayer(Integer currentActivePlayer)
    {
        this.currentActivePlayer = currentActivePlayer;
        triggerChange();
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param message method parameter
     */
    public void pushGameLog(String message)
    {
        this.gameLog.addLast(message);
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public String pollGameLog()
    {
        return this.gameLog.poll();
    }
}
