/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.server.messaging;

/**
 * Response object to encapsulate the results of 
 * a kick player request.
 * @author bschache
 */
public class KickPlayerResponse 
{
    private final boolean playerKicked;
    
    public KickPlayerResponse(boolean playerKicked)
    {
        this.playerKicked = playerKicked;
    }
    
    /**
     * Verify if player was kicked from the game
     * @return boolean true if player was kicked.
     */
    public boolean wasPlayerKicked()
    {
        return playerKicked;
    }
    
}
