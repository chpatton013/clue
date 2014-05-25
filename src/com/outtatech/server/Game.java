package com.outtatech.server;

import com.outtatech.common.ActionCard;
import com.outtatech.common.DestinationID;
import com.outtatech.common.HintCard;
import com.outtatech.common.Solution;
import com.outtatech.common.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * The Game class contains functions that provide information on the state of an
 * Indication Game and provide functions that can change the state of the Game.
 *
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class Game
{
    private static Integer gameIdCounter = 0;
    private Integer gameId;
    private List<ServerPlayer> players;
    private ServerPlayer current;
    private List<ActionCard> drawPile;
    private List<ActionCard> discardPile;
    private Solution solution;
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
            Solution solution,
            Map<DestinationID, Integer> destToPlayerId)
    {
        this.players = players;
        this.current = current;
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.solution = solution;
        this.destToPlayerId = destToPlayerId;
        this.gameId = ++gameIdCounter;
    }
    
    
    public Game()
    {
        this.players = new ArrayList<ServerPlayer>();
        this.current = null;
        this.drawPile = new ArrayList<ActionCard>();
        initializeDrawPile(drawPile);
        this.discardPile = new ArrayList<ActionCard>();
        this.solution = null;
        this.destToPlayerId = null;
        this.gameId = ++gameIdCounter;
    }

    /**
     * Add a ServerPlayer to the List of ServerPlayers in this game.
     *
     * @param newPlayer The ServerPlayer to add to the Game
     */
    public void addServerPlayer(ServerPlayer newPlayer)
    {
        players.add(newPlayer);
    }
    
    /**
     * Gets the List of ServerPlayers in this game.
     *
     * @return The List of ServerPlayers in this game.
     */
    public List<ServerPlayer> getServerPlayers()
    {
        return players;
    }

    /**
     * Sets the current ServerPlayer in this game.
     *
     * @param current The ServerPlayer to make current in the Game
     */
    public void setCurrentServerPlayer(ServerPlayer current)
    {
        this.current = current;
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
     * Sets the drawPile of this game.
     *
     * @param drawPile The new drawPile for this Game
     */
    public void setDrawPile(List<ActionCard> drawPile)
    {
        this.drawPile = drawPile;
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
     * Sets the discardPile of this game.
     *
     * @param discardPile The new discardPile for this Game
     */
    public void setDiscardPile(List<ActionCard> discardPile)
    {
        this.discardPile = discardPile;
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
     * Sets the solution of this game.
     *
     * @param solution The new solution for this game
     */
    public void setSolution(Solution solution)
    {
        this.solution = solution;
    }

    /**
     * Gets the solution of this game.
     *
     * @return The solution of this game.
     */
    public Solution getSolution()
    {
        return solution;
    }

    /**
     * Sets the Map between destination Ids and playerIds for this game.
     *
     * @param destToPlayerId The new Map of destination Ids and PlayerIds for 
     * this game
     */
    public void setDestToPlayerId(Map<DestinationID, Integer> destToPlayerId)
    {
        this.destToPlayerId = destToPlayerId;
    }
    
    /**
     * Gets the Map between destination Ids and playerIds for this game.
     *
     * @return The Map of destination Ids and PlayerIds for this game
     */
    public Map<DestinationID, Integer> getDestToPlayerId()
    {
        return destToPlayerId;
    }
    
    public Integer getGameId() 
    {
        return gameId;
    }
    
    private void initializeDrawPile(List<ActionCard> drawPile) 
    {
        int countSuggestionANY = 10;
        int countSuggestionCURRENT = 9;
        int countSnoop = 4;
        int countAllSnoopLEFT = 2;
        int countAllSnoopRIGHT = 2;
        boolean right = true;
        
        for(int index = 0; index < countSuggestionANY; index++)
        {
            drawPile.add(new Suggestion(SuggestionType.ANY));
        }
        
        for(int index = 0; index < countSuggestionCURRENT; index++)
        {
            drawPile.add(new Suggestion(SuggestionType.CURRENT));   
        }
        
        for(int index = 0; index < countSnoop; index++)
        {
            drawPile.add(new Snoop());
        }
        
        for(int index = 0; index < countAllSnoopLEFT; index++)
        {
            drawPile.add(new AllSnoop(!right));
        }
        
        for(int index = 0; index < countAllSnoopRIGHT; index++)
        {
            drawPile.add(new AllSnoop(right));
        }
                
        drawPile.add(new SuperSleuth(SuperSleuthType.FEMALE_SUSPECT));
        drawPile.add(new SuperSleuth(SuperSleuthType.MALE_SUSPECT));
        drawPile.add(new SuperSleuth(SuperSleuthType.AIR_VEHICLE));
        drawPile.add(new SuperSleuth(SuperSleuthType.BLUE_CARD));
        drawPile.add(new SuperSleuth(SuperSleuthType.SOUTHERN_DESTINATION));
        drawPile.add(new SuperSleuth(SuperSleuthType.WESTERN_DESTINATION));

        drawPile.add(new PrivateTip(PrivateTipType.ALL_SUSPECTS));
        drawPile.add(new PrivateTip(PrivateTipType.ALL_VEHICLES));
        drawPile.add(new PrivateTip(PrivateTipType.ALL_DESTINATIONS));
        drawPile.add(new PrivateTip(PrivateTipType.ONE_FEMALE_SUSPECT));
        drawPile.add(new PrivateTip(PrivateTipType.ONE_RED_VEHICLE));
        drawPile.add(new PrivateTip(PrivateTipType.ONE_NORTHERN_DESTINATION));
        
        Collections.shuffle(drawPile);
    }
}
