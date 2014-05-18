/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.util.List;
import java.util.Map;
import com.outtatech.common.Card;
import com.outtatech.common.DestinationID;

/**
 *
 * @author dmangin
 */
public class ClientGameState {
    private int playerID;
    private Object notes;
    private List<Card> hand;
    private Map<DestinationID, Integer> destToPlayerId;
    
    public ClientGameState(int playerID, Object notes, List<Card> hand, 
            Map<DestinationID, Integer> destToPlayerId)
    {
        this.playerID = playerID;
        this.notes = notes;
        this.hand = hand;
        this.destToPlayerId = destToPlayerId;
    }
    
    public int getPlayerId() 
    {
        return playerID;
    }
    
    public void setPlayerId (int playerID) 
    {
        this.playerID = playerID;
    }
    
    public Object getNotes() 
    {
        return notes;
    }
    
    public List<Card> getHand() 
    {
        return hand;
    }
    
    public Map<DestinationID, Integer> getDestToPlayerId() 
    {
        return destToPlayerId;
    }
}
