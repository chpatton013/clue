/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.util.List;
import java.util.Map;

/**
 *
 * @author dmangin
 */
public class ClientGameState {
    private int playerID;
    private Object notes;
    private List<Card> hand;
    private Map<DestinationID, int> destToPlayerId;
    
    public int getPlayerId() {
        return playerID;
    }
    
    public void setPlayerId (int playerID) {
        
    }
    
    public Object getNotes() {
        
    }
    
    public List<Card> getHand() {
        
    }
    
    public Map<DestinationID, int> getDestToPlayerId() {
        
    }
}
