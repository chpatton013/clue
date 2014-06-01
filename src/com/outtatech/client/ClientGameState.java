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
 * The ClientGameState class holds logic for the players State in the Indication
 * Game. The class mediates game logic between the server and the player.
 *
 * @author dmangin
 */
public class ClientGameState extends State
{
    private Integer playerID;
    private Object notes;
    private List<Card> hand;
    private boolean revealStatus;
    private List<Card> revealed;
    private boolean newAccusation;
    private boolean accusationStatus;
    private Deque<String> gameLog;
    private Map<Integer, String> players;

    private Integer deckCardCount;
    private List<Integer> playerTurnOrder;
    private Integer currentActivePlayer;
    private boolean myTurn = false;
    private boolean loser = false;
    private boolean gameOver = false;

    /**
     * Map holds the set of DestinationIds and a corresponding playerId.
     */
    private Map<DestinationID, Integer> destToPlayerId;

    public ClientGameState(int playerID, List<Card> hand, Map<Integer, String> players)
    {
        this.players = players;
        this.playerID = playerID;
        this.hand = hand;
        this.revealed = new ArrayList<Card>();
        this.revealStatus = false;
        this.newAccusation = false;
        this.loser = false;
        this.gameOver = false;
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
        triggerChange();
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
     * Returns a boolean that indicates whether or not the game is over.
     * 
     * @return true if game is over, false if its not.
     */
    public boolean getGameOverStatus()
    {
        return gameOver;
    }
    
    /**
     * Provides a boolean that indicates whether or not the player has lost.
     * 
     * @return true if the player has lost, false if they have not
     */
    public boolean getLoserStatus()
    {
        return loser;
    }
    
    /**
     * Set this players loser status
     * @param loser true if the player has lost, false if they haven't
     */
    public void setLoserStatus(boolean loser)
    {
        this.loser = loser;
    }
    
    /**
     * Set whether or not the game is over
     * @param gameOver boolean that represents whether or not the game is over.
     */
    public void setGameOverStatus(boolean gameOver)
    {
        this.gameOver = gameOver;
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
    public Integer getPlayerId()
    {
        return playerID;
    }

    /**
     * Setter method that sets the mapping from destination IDs to player IDs
     * @param map
     */
    public void setDestToPlayerId(Map<DestinationID, Integer> map)
    {
        this.destToPlayerId = map;
        triggerChange();
    }


    /**
     * Sets the players in this game
     *
     * @param players the players in this game.
     */
    public void setPlayers(Map<Integer, String> players)
    {
        this.players = players;
        triggerChange();
    }

    /**
     * Returns the list of players in this game
     *
     * @return the list of players in this game
     */
    public Map<Integer, String> getPlayers()
    {
        return players;
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
     * method parameter
     */
    public void setRevealed(List<Card> revealed)
    {
        this.revealed = revealed;
        triggerChange();
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
        triggerChange();
    }

    /**
     * Change the player id associated to the instance of ClientGameState
     *
     * @param playerID integer id of the player
     */
    public void setPlayerId(int playerID)
    {
        this.playerID = playerID;
        triggerChange();
    }

    /**
     * Sets this players hand.
     *
     * @param hand
     */
    public void setPlayerHand(List<Card> hand)
    {
        this.hand = hand;
        triggerChange();
    }

    /**
     * Adds the given card to the player's hand.
     *
     * @param cards to add to hand
     */
    public void addToHand(Card card)
    {
        this.hand.add(card);
        triggerChange();
    }

    /**
     * Removes the given card from the player's hand.
     *
     * @param cards to remove from hand
     */
    public void removeFromHand(Card card)
    {
        this.hand.remove(card);
        triggerChange();
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
     * Sets this players notes.
     *
     * @param notes
     */
    public void setNotes(Object notes)
    {
        this.notes = notes;
        triggerChange();
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

    public Integer getPlayerIdAtIndex(Integer index)
    {
        return this.playerTurnOrder.get(index);
    }

    public Integer getCurrentPlayerId()
    {
        return this.getPlayerIdAtIndex(this.getCurrentActivePlayer());
    }

    public String getPlayerName(Integer playerId)
    {
        return this.players.get(playerId);
    }

    public List<String> getPlayerNames(List<Integer> playerIds)
    {
        List<String> names = new ArrayList<String>();
        for (Integer playerId : playerIds)
        {
            names.add(this.players.get(playerId));
        }
        return names;
    }

    public Integer getCurrentActivePlayer()
    {
        return this.currentActivePlayer;
    }

    public void setDeckCardCount(Integer deckCardCount)
    {
        this.deckCardCount = deckCardCount;
        triggerChange();
    }

    public void setPlayerTurnOrder(List<Integer> playerTurnOrder)
    {
        this.playerTurnOrder = playerTurnOrder;
        triggerChange();
    }

    public void setCurrentActivePlayer(Integer currentActivePlayer)
    {
        this.currentActivePlayer = currentActivePlayer;
        triggerChange();
    }

    public void advancePlayer()
    {
        int next = (this.currentActivePlayer + 1) % this.playerTurnOrder.size();
        this.setCurrentActivePlayer(next);
    }

    public void pushGameLog(String message)
    {
        this.gameLog.addLast(message);
        this.triggerChange();
    }

    public String pollGameLog()
    {
        return this.gameLog.poll();
    }

    public boolean isMyTurn()
    {
        return this.myTurn;
    }

    public void setMyTurn(boolean myTurn)
    {
        this.myTurn = myTurn;
        this.triggerChange();
    }
}
