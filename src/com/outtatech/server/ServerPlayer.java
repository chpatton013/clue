package com.outtatech.server;

import com.outtatech.common.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.io.Serializable;

/**
 * The ServerPlayer class represents a player in a game... TODO!
 *
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class ServerPlayer implements Player, Serializable
{
    private static int playerIdCount = 0;
    private static Color nextColor = Color.RED;
    private int playerId;
    private Object notes;
    private String name;
    private Color color;
    private DestinationID location;
    public List<HintCard> hintCardsHand;
    public List<ActionCard> actionCardsHand;
    public EnumSet suspectCardsSeen = EnumSet.noneOf(SuspectID.class);
    public EnumSet locationsSeen = EnumSet.noneOf(DestinationID.class);
    public EnumSet vehicleCardsSeen = EnumSet.noneOf(VehicleID.class);

    
    /**
     * Construct a sever player to keep track of client and server player
     * actions.
     *
     * @param playerId int representing the player
     * @param notes Object representing notes for the player
     * @param name String representation of player
     * @param color Color object to help differentiate players
     * @param hintCardsHand List of Card Objects representing a players hand of
     * Hint Cards
     * @param actionCardsHand List of Card Objects representing a players hand
     * of Action Cards
     */
    public ServerPlayer()
    {
        this.playerId = playerIdCount++;
        this.notes = new String();
//        this.name = name;
        this.color = nextColor;
        changeNextColor();
        this.hintCardsHand = new ArrayList<HintCard>();
        this.actionCardsHand = new ArrayList<ActionCard>();
    }

    public void addActionCard(ActionCard card)
    {
        if (card == null)
        {
            return;
        }

        actionCardsHand.add(card);
    }

    public void removeActionCard(ActionCard card)
    {
        if (card == null)
        {
            return;
        }

        actionCardsHand.remove(card);
    }

    public int getPlayerId()
    {
        return playerId;
    }


    public DestinationID getLocation()
    {
        return location;
    }

    public void setLocation(DestinationID location)
    {
        this.location = location;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
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
     * Method to add a hint card to this players hand.
     *
     * @param card the hintcard to add to the players hand
     */
    public void addHintCard(HintCard card)
    {
        this.hintCardsHand.add(card);
    }
    
    /**
     * Removes a card from this players hand
     * @param card the card to remove from this player's hand.
     */
    public void playHintCard(HintCard card)
    {
        hintCardsHand.remove(card);
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

//    /**
//     * Gets the name of this player.
//     *
//     * @return The name of this player.
//     */
//    public String getName()
//    {
//        return name;
//    }
//
//    /**
//     * Sets the name of this player.
//     *
//     * @param name The name of the player.
//     */
//    public void setName(String name)
//    {
//        this.name = name;
//    }
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

    private void changeNextColor()
    {
        Random rand = new Random();
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);

        nextColor = new Color(red, green, blue);
    }
}
