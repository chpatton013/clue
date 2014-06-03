package com.outtatech.server.messaging;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.outtatech.common.*;

/**
 *
 * @author dmangin
 */
public class GameStateResponseTest {
    /**
     * Test of getDeckCardCount method, of class GameStateResponse.
     */
    @Test
    public void testGetDeckCardCount() {
        
        Integer deck = new Integer("10");
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        Integer activePlayer = new Integer("4");
        Map<Integer, String> players = new HashMap<Integer, String>();
        players.put(5, "player1");
        List<HintCard> hc = new ArrayList<HintCard>();
        hc.add(new HintCard(HintCardType.SUSPECT));
        List<ActionCard> ac = new ArrayList<ActionCard>();
        ac.add(new ActionCard(ActionCardType.ALL_SNOOP));
        Map<DestinationID, Integer> destToPlayer = new HashMap<DestinationID, Integer>();
        destToPlayer.put(DestinationID.NIAGRA_FALLS, 5);
        
        GameStateResponse instance = new GameStateResponse(deck, temp, activePlayer,
                players, hc, ac, destToPlayer);
                
        Integer expResult = 10;
        Integer result = instance.getDeckCardCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerTurnOrder method, of class GameStateResponse.
     */
    @Test
    public void testGetPlayerTurnOrder() {
        
        Integer deck = new Integer("10");
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        Integer activePlayer = new Integer("4");
        Map<Integer, String> players = new HashMap<Integer, String>();
        players.put(5, "player1");
        List<HintCard> hc = new ArrayList<HintCard>();
        hc.add(new HintCard(HintCardType.SUSPECT));
        List<ActionCard> ac = new ArrayList<ActionCard>();
        ac.add(new ActionCard(ActionCardType.ALL_SNOOP));
        Map<DestinationID, Integer> destToPlayer = new HashMap<DestinationID, Integer>();
        destToPlayer.put(DestinationID.NIAGRA_FALLS, 5);
        
        GameStateResponse instance = new GameStateResponse(deck, temp, activePlayer,
                players, hc, ac, destToPlayer);
        
        List<Integer> expResult = temp;
        List<Integer> result = instance.getPlayerTurnOrder();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentActivePlayer method, of class GameStateResponse.
     */
    @Test
    public void testGetCurrentActivePlayer() {
        
        Integer deck = new Integer("10");
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        Integer activePlayer = new Integer("4");
        Map<Integer, String> players = new HashMap<Integer, String>();
        players.put(5, "player1");
        List<HintCard> hc = new ArrayList<HintCard>();
        hc.add(new HintCard(HintCardType.SUSPECT));
        List<ActionCard> ac = new ArrayList<ActionCard>();
        ac.add(new ActionCard(ActionCardType.ALL_SNOOP));
        Map<DestinationID, Integer> destToPlayer = new HashMap<DestinationID, Integer>();
        destToPlayer.put(DestinationID.NIAGRA_FALLS, 5);
        
        GameStateResponse instance = new GameStateResponse(deck, temp, activePlayer,
                players, hc, ac, destToPlayer);
        
        Integer expResult = activePlayer;
        Integer result = instance.getCurrentActivePlayer();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getCurrentActivePlayer method, of class GameStateResponse.
     */
    @Test
    public void testGetPlayers() {
        Integer deck = new Integer("10");
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        Integer activePlayer = new Integer("4");
        Map<Integer, String> players = new HashMap<Integer, String>();
        players.put(5, "player1");
        List<HintCard> hc = new ArrayList<HintCard>();
        hc.add(new HintCard(HintCardType.SUSPECT));
        List<ActionCard> ac = new ArrayList<ActionCard>();
        ac.add(new ActionCard(ActionCardType.ALL_SNOOP));
        Map<DestinationID, Integer> destToPlayer = new HashMap<DestinationID, Integer>();
        destToPlayer.put(DestinationID.NIAGRA_FALLS, 5);
        
        GameStateResponse instance = new GameStateResponse(deck, temp, activePlayer,
                players, hc, ac, destToPlayer);
        
        Map<Integer, String> expResult = players;
        Map<Integer, String> result = instance.getPlayers();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getCurrentActivePlayer method, of class GameStateResponse.
     */
    @Test
    public void testGetHintCards() {
        Integer deck = new Integer("10");
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        Integer activePlayer = new Integer("4");
        Map<Integer, String> players = new HashMap<Integer, String>();
        players.put(5, "player1");
        List<HintCard> hc = new ArrayList<HintCard>();
        hc.add(new HintCard(HintCardType.SUSPECT));
        List<ActionCard> ac = new ArrayList<ActionCard>();
        ac.add(new ActionCard(ActionCardType.ALL_SNOOP));
        Map<DestinationID, Integer> destToPlayer = new HashMap<DestinationID, Integer>();
        destToPlayer.put(DestinationID.NIAGRA_FALLS, 5);
        
        GameStateResponse instance = new GameStateResponse(deck, temp, activePlayer,
                players, hc, ac, destToPlayer);
        
        List<HintCard> expResult = hc;
        List<HintCard> result = instance.getHintCards();
        assertEquals(expResult, result);
    }
}
