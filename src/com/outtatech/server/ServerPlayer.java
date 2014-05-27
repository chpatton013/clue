package com.outtatech.server;

import com.outtatech.common.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.io.Serializable;

/**
 * Version-latenightpizzaparty
 * The ServerPlayer class represents a player in a game.
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

    /**
     * Version-latenightpizzaparty
     *
     */
    public List<HintCard> hintCardsHand;

    /**
     * Version-latenightpizzaparty
     *
     */
    public List<ActionCard> actionCardsHand;

    /**
     * Version-latenightpizzaparty
     *
     */
    public EnumSet suspectCardsSeen = EnumSet.noneOf(SuspectID.class);

    /**
     * Version-latenightpizzaparty
     *
     */
    public EnumSet locationsSeen = EnumSet.noneOf(DestinationID.class);

    /**
     * Version-latenightpizzaparty
     *
     */
    public EnumSet vehicleCardsSeen = EnumSet.noneOf(VehicleID.class);

    /**
     * Version-latenightpizzaparty
     * Construct a sever player to keep track of client and server player
     * actions.
     *
     * @param name String representation of player
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

    public int getPlayerId()
    {
        return playerId;
    }

    public DestinationID getLocation()
    {
        return location;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param location
     */
    public void setLocation(DestinationID location)
    {
        this.location = location;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the notes of this player.
     *
     * @return The notes of this player.
     */
    public Object getNotes()
    {
        return notes;
    }

    /**
     * Version-latenightpizzaparty
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
     * Version-latenightpizzaparty
     * Gets the color associated with this player.
     *
     * @return The color associated with this player.
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the color associated with this player.
     *
     * @param color The color of the player.
     */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the action cards hand of this player.
     *
     * @return The action cards hand of this player.
     */
    public List<ActionCard> getActionCardsHand()
    {
        return actionCardsHand;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the hint cards hand of this player.
     *
     * @return The hint cards hand of this player.
     */
    public List<HintCard> getHintCardsHand()
    {
        return hintCardsHand;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the action cards hand of this player.
     *
     * @param actionCardsHand of the player.
     */
    public void setActionCardsHand(List<ActionCard> actionCardsHand)
    {

        this.actionCardsHand = actionCardsHand;
    }

    /**
     * Version-latenightpizzaparty
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
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);

        nextColor = new Color(r, g, b);
    }
}
