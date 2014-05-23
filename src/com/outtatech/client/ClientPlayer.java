package com.outtatech.server;

import java.awt.Color;
import com.outtatech.common.*;

/**
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
     * Construct a client player to keep track of players in the game
     *
     * @param playerId int representing the player
     * @param name String representation of player
     * @param color Color object to help differentiate players
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
     * Gets the Id of this player.
     *
     * @return The Id of this player.
     */
    public int getPlayerId()
    {
        return playerId;
    }

    /**
     * Sets the Id of this player.
     *
     * @param playerId The Id of the player.
     */
    public void setPlayerId(int playerId)
    {
        this.playerId = playerId;
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
}
