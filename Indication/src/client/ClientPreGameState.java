/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.util.List;

/**
 * ClientPreGameState instances will hold information about other players
 * waiting to join the same game of Indication.
 * @author dmangin
 */
public class ClientPreGameState extends State
{
    private int playerId;
    private List<Integer> playerIdList;
    private boolean gameOwner;
    
    /**
     * ClientPreGameState uses the default constructor
     */
    public ClientPreGameState()
    {
        
    }
    
    /**
     * Returns the playerId associated with this instance.
     * @return int playerId
     */
    public int getPlayerId() 
    {
        return playerId;
    }
    
    /**
     * Sets the playerId of this instance.
     * @param id int playerId
     */
    public void setPlayerId(int id) {
        
    }
    
    /**
     * Returns a list of players that are waiting for 
     * the same game of indication to start.
     * @return List of Integer Objects representing player ids.
     */
    public List<Integer> getPlayerIdList() 
    {
        return playerIdList;
    }
    
    /**
     * Checks if the playerId associated with this instance
     * is the game owner. ie. created the game.
     * @return boolean true if player is the game owner.
     */
    public boolean getGameOwner() 
    {
        return gameOwner;
        
    }
    
    /**
     * Make the playerId that created this game the game owner.
     * @param owner boolean true sets the owner to the instances
     * player id.
     */
    public void setGameOwner(boolean owner) 
    {
        
    }
}
