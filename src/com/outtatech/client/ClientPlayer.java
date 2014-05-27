package com.outtatech.server;

import java.awt.Color;
import com.outtatech.common.*;

/**
 * Version-latenightpizzaparty
 * The ClientPlayer class represents a player in a game.
 *
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class ClientPlayer implements Player
{
    private int playerId;
    private String name;
    private Color color;

    /**
     * Version-latenightpizzaparty
     * Construct a client player to keep track of players in the game
     *
     * @param playerId int representing the player method parameter
     * @param name String representation of player method parameter
     * @param color Color object to help differentiate players method parameter
     */
    public ClientPlayer(int playerId,
            String name,
            Color color)
    {
        this.playerId = playerId;
        this.name = name;
        this.color = color;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the Id of this player.
     *
     * @return The Id of this player. return value
     */
    public int getPlayerId()
    {
        return playerId;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the Id of this player.
     *
     * @param playerId The Id of the player. method parameter
     */
    public void setPlayerId(int playerId)
    {
        this.playerId = playerId;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the name of this player.
     *
     * @return The name of this player. return value
     */
    public String getName()
    {
        return name;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the name of this player.
     *
     * @param name The name of the player. method parameter
     */
    public void setName(String name)
    {
        this.name = name;
    }

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
}
