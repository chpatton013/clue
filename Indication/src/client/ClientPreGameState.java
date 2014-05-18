/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.util.List;

/**
 *
 * @author dmangin
 */
public class ClientPreGameState extends State
{
    private int playerId;
    private List<Integer> playerIdList;
    private boolean gameOwner;
    
    public ClientPreGameState(int playerId, List<Integer> playerIdList, 
            boolean gameOwner)
    {
        this.playerId = playerId;
        this.playerIdList = playerIdList;
        this.gameOwner = gameOwner;
    }
    
    public int getPlayerId() 
    {
        return playerId;
    }
    
    public void setPlayerId(int id) 
    {
        this.playerId = id;
    }
    
    public List<Integer> getPlayerIdList() 
    {
        return playerIdList;
    }
    
    public boolean getGameOwner() 
    {
        return gameOwner;
        
    }
    
    public void setGameOwner(boolean owner) 
    {
        this.gameOwner = owner;
    }
}
