/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.server;

import com.outtatech.common.ActionCard;
import com.outtatech.common.HintCard;
import com.outtatech.common.Card;
import com.outtatech.common.DestinationCard;
import com.outtatech.common.*;
import java.awt.Color;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bennettschalich
 */
public class GameTest
{
    Game instance;
    ServerPlayer sp;
    List<ServerPlayer> players;
    List<ActionCard> drawPile;
    List<ActionCard> discardPile;
    List<HintCard> solution;
    Map<DestinationID, Integer> destToPlayerId;
    
    public GameTest()
    {
        List<HintCard> hintCardsHand = new ArrayList<HintCard>();
        hintCardsHand.add(new DestinationCard(DestinationID.CONEY_ISLAND, CardColor.RED));
        
        List<ActionCard> actionCardsHand = new ArrayList<ActionCard>();
        actionCardsHand.add(new Snoop());
        
        List<ActionCard> drawPile = new ArrayList<ActionCard>();
        drawPile.add(new Snoop());
        drawPile.add(new AllSnoop(true));
        
        List<ActionCard> discardPile = new ArrayList<ActionCard>();
        discardPile.add(new PrivateTip(PrivateTipType.ALL_DESTINATIONS));
        discardPile.add(new Suggestion(SuggestionType.ANY));
        
        ServerPlayer sp = new ServerPlayer(5, new Object(), "Bob", new Color(1, 1, 1), 
                hintCardsHand, actionCardsHand);
        
        List<ServerPlayer> players = new ArrayList<ServerPlayer>();
        players.add(sp);
        
        List<HintCard> solution = new ArrayList<HintCard>();
        solution.add(new DestinationCard(DestinationID.CONEY_ISLAND, CardColor.RED));
        solution.add(new SuspectCard(SuspectID.WHITE, CardColor.RED));
        solution.add(new VehicleCard(VehicleID.AIRLINER, CardColor.RED));
        
        Map<DestinationID, Integer> destToPlayerId = 
                new HashMap<DestinationID, Integer>();
        
        Game instance = new Game(players, sp, drawPile, discardPile, solution, destToPlayerId);
        
        this.instance = instance;
        this.sp = sp;
        this.players = players;
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.solution = solution;
        this.destToPlayerId = destToPlayerId;
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetServerPlayers()
    {
        System.out.println("getServerPlayers");
        
        List<ServerPlayer> expResult = players;
        List<ServerPlayer> result = instance.getServerPlayers();
        assertEquals(expResult, result);
    }
    /**
     * Test of getCurrentServerPlayer method, of class Game.
     */
    @Test
    public void testGetCurrentServerPlayer()
    {
        System.out.println("getCurrentServerPlayer");
        
        ServerPlayer expResult = sp;
        ServerPlayer result = instance.getCurrentServerPlayer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDrawPile method, of class Game.
     */
    @Test
    public void testGetDrawPile()
    {
        System.out.println("getDrawPile");
        
        List<ActionCard> expResult = drawPile;
        List<ActionCard> result = instance.getDrawPile();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDiscardPile method, of class Game.
     */
    @Test
    public void testGetDiscardPile()
    {
        System.out.println("getDiscardPile");
       
        List<ActionCard> expResult = discardPile;
        List<ActionCard> result = instance.getDiscardPile();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSolution method, of class Game.
     */
    @Test
    public void testGetSolution()
    {
        System.out.println("getSolution");
        
        List<HintCard> expResult = solution;
        List<HintCard> result = instance.getSolution();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDestToPlayerId()
    {
        System.out.println("getDestToPlayerId");
        
        Map<DestinationID, Integer> expResult = destToPlayerId;
        Map<DestinationID, Integer> result = instance.getDestToPlayerId();
        assertEquals(expResult, result);
    }
}
