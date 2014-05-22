package com.outtatech.server;

import java.util.List;
import java.util.Map;
import com.outtatech.common.ActionCard;
import com.outtatech.common.HintCard;
import com.outtatech.common.DestinationID;

/**
 * The Game class contains functions that provide information on the state of an
 * Indication Game and provide functions that can change the state of the Game.
 *
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class Game
{

    private List<ServerPlayer> players;
    private ServerPlayer current;
    private List<ActionCard> drawPile;
    private List<ActionCard> discardPile;
    private List<HintCard> solution;
    private Map<DestinationID, Integer> destToPlayerId;

    /**
     * Constructor for a Game instance.
     *
     * @param player List of Player Objects.
     * @param current ServerPlayer representing the player currently taking a
     * turn.
     * @param drawPile List of ActionCard Objects
     * @param discardPile List of ActionCard Objects
     * @param solution List of HintCard Objects
     * @param destToPlayerId Map of DestinationID to Integer represents which
     * player is on which DestinationID
     */
    public Game(List<ServerPlayer> players,
            ServerPlayer current,
            List<ActionCard> drawPile,
            List<ActionCard> discardPile,
            List<HintCard> solution,
            Map<DestinationID, Integer> destToPlayerId)
    {
        this.players = players;
        this.current = current;
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.solution = solution;
        this.destToPlayerId = destToPlayerId;
    }

    public List<ServerPlayer> getServerPlayers()
    {
        return players;
    }

    /**
     * Gets the current ServerPlayer associated with this game.
     *
     * @return The current ServerPlayer associated with this game.
     */
    public ServerPlayer getCurrentServerPlayer()
    {
        return current;
    }

    /**
     * Gets the drawPile of this game.
     *
     * @return The drawPile of this game.
     */
    public List<ActionCard> getDrawPile()
    {
        return drawPile;
    }

    /**
     * Gets the solution of this game.
     *
     * @return The discardPile of this game.
     */
    public List<ActionCard> getDiscardPile()
    {
        return discardPile;
    }

    /**
     * Gets the discardPile of this game.
     *
     * @return The solution of this game.
     */
    public List<HintCard> getSolution()
    {
        return solution;
    }

    public Map<DestinationID, Integer> getDestToPlayerId()
    {
        return destToPlayerId;
    }
}
