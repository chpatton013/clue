package com.outtatech.server;

import java.awt.Color;
import java.util.List;
import com.outtatech.common.*;

/**
 * The ServerPlayer class represents a player in a game... TODO!
 *
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class ServerPlayer
{
    private int playerId;
    private Object notes;
    private String name;
    private Color color;
    public List<HintCard> hintCardsHand;
    public List<ActionCard> actionCardsHand;

    /**
     * Construct a sever player to keep track of client and server player
     * actions.
     *
     * @param playerId int representing the player
     * @param notes Object representing notes for the player
     * @param name String representation of player
     * @param color Color object to help differentiate players
     * @param hintCardsHand List of Card Objects representing a players hand of Hint Cards
     * @param actionCardsHand List of Card Objects representing a players hand of Action Cards
     */
    public ServerPlayer(int playerId,
            Object notes,
            String name,
            Color color,
            List<HintCard> hintCardsHand,
            List<ActionCard> actionCardsHand)
    {
        this.playerId = playerId;
        this.notes = notes;
        this.name = name;
        this.color = color;
        this.hintCardsHand = hintCardsHand;
        this.actionCardsHand = actionCardsHand;
    }

    public int getPlayerId()
    {
        return playerId;
    }

    /**
     * Gets the notes of this player.
     *
     * @return The notes of this player.
     */
    public Object getNotes()
    {
        return notes;
    }

    /**
     * Sets the notes of this player.
     *
     * @param notes The notes of this player.
     */
    public void setNotes(Object notes)
    {
        this.notes = notes;
    }

    /**
     * Gets the name of this player.
     *
     * @return The name of this player.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this player.
     *
     * @param name The name of the player.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the color associated with this player.
     *
     * @return The color associated with this player.
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * Sets the color associated with this player.
     *
     * @param color The color of the player.
     */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /**
     * Gets the action cards hand of this player.
     *
     * @return The action cards hand of this player.
     */
    public List<ActionCard> getActionCardsHand()
    {
        return actionCardsHand;
    }
     /**
     * Gets the hint cards hand of this player.
     *
     * @return The hint cards hand of this player.
     */
    public List<HintCard> getHintCardsHand()
    {
        return hintCardsHand;
    }

    /**
     * Sets the action cards hand of this player.
     *
     * @param actionCardsHand of the player.
     */
    public void setActionCardsHand(List<ActionCard> actionCardsHand)
    {
    
        this.actionCardsHand = actionCardsHand;
    }
    
     /**
     * Sets the hint cards hand of this player.
     *
     * @param hintCardsHand of the player.
     */
    public void setHintCardsHand(List<HintCard> hintCardsHand)
    {
    
        this.hintCardsHand = hintCardsHand;
    }
}
