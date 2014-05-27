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

    /**
     * 
     * Version-latenightpizzaparty
     * @return value
     */
    public int getPlayerId()
    {
        return playerId;
    }

    /**
     *Version-latenightpizzaparty
     * @return return value
     */
    public DestinationID getLocation()
    {
        return location;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param location method parameter
     */
    public void setLocation(DestinationID location)
    {
        this.location = location;
    }

    /**
     *Version-latenightpizzaparty
     * @param name method parameter
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the notes of this player.
     *
     * @return The notes of this player. return value
     */
    public Object getNotes()
    {
        return notes;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the notes of this player.
     *
     * @param notes The notes of this player. method parameter
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
     * @return The color associated with this player. return value
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the color associated with this player.
     *
     * @param color The color of the player. method parameter
     */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the action cards hand of this player.
     *
     * @return The action cards hand of this player. return value
     */
    public List<ActionCard> getActionCardsHand()
    {
        return actionCardsHand;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the hint cards hand of this player.
     *
     * @return The hint cards hand of this player. return value
     */
    public List<HintCard> getHintCardsHand()
    {
        return hintCardsHand;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the action cards hand of this player.
     *
     * @param actionCardsHand of the player. method parameter
     */
    public void setActionCardsHand(List<ActionCard> actionCardsHand)
    {

        this.actionCardsHand = actionCardsHand;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the hint cards hand of this player.
     *
     * @param hintCardsHand of the player. method parameter
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
