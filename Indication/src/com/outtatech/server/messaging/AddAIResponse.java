/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.server.messaging;
import com.outtatech.common.Player;
import java.util.List;

/**
 * Response Object that provides the properties of
 * an AddAIRequest
 * @author bschache
 */
public class AddAIResponse 
{
    private final List<Player> AIPlayers;
    
    /**
     * Construct a response with the list of 
     * all AI players in the game.
     * @param AIPlayers 
     */
    public AddAIResponse (List<Player> AIPlayers)
    {
        this.AIPlayers = AIPlayers;
    }
    
    /**
     * Provides the list of AI Players
     * @return List<Player> AI Players assigned to the game.
     */
    public List<Player> getAIPlayers()
    {
        return AIPlayers;
    }
}
