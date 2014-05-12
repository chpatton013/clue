package com.outtatech.server;


import java.util.List;
import java.util.Map;
import com.outtatech.common.ActionCard;
import com.outtatech.common.HintCard;
import com.outtatech.common.DestinationID;

/**
 * The Game class ... TODO!
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class Game {

    private List<ServerPlayer> player;
    private ServerPlayer current;
    private List<ActionCard> drawPile;
    private List<ActionCard> discardPile;
    private List<HintCard> solution;
    private Map<DestinationID, Integer> desToPlayerId;

    public Game(List<ServerPlayer> player,
		ServerPlayer current,
		List<ActionCard> drawPile,
		List<ActionCard> discardPile,
		List<HintCard> solution,
		Map<DestinationID, Integer> desToPlayerId) 
    {
	this.player = player;
	this.current = current;
	this.drawPile = drawPile;
	this.discardPile = discardPile;
	this.solution = this.solution;
	this.desToPlayerId = desToPlayerId;
    }

    /**
     * Gets the current ServerPlayer associated with this game.
     * @return The current ServerPlayer associated with this game.
     */
    public ServerPlayer getCurrentServerPlayer() 
    {
        return current;
    }
    
    /**
     * Gets the drawPile of this game.
     * @return The drawPile of this game.
     */
    public List<ActionCard> getDrawPile() 
    {
        return drawPile;
    }
    
    /**
     * Gets the solution of this game.
     * @return The discardPile of this game.
     */ 
    public List<ActionCard> getDiscardPile() 
    {
        return discardPile;
    }
    
    /**
     * Gets the discardPile of this game.
     * @return The solution of this game.
     */    
    public List<HintCard> getSolution() 
    {
        return solution;
    }
}