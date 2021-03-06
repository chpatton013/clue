package com.outtatech.server;

import com.outtatech.common.*;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MarkFeldman
 */
public class AITest {
    
    /**
     *
     */
    public AITest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getDifficulty and setDifficulty methods, of class AI.
     */
    @Test
    public void testGetSetDifficulty() {
        System.out.println("Testing getDifficulty and setDifficulty");
        Difficulty expResult = new Difficulty (2,3);
        ServerController cntrl = new ServerController(new ServerNetwork(5555));
        AI newAI = new AI(expResult, cntrl, new Game());
        
        Difficulty result = newAI.getDifficulty();
        assertEquals(expResult, result);
        
        Difficulty expResult2 = new Difficulty(1,4);
        newAI.setDifficulty(expResult2);
        Difficulty result2 = newAI.getDifficulty();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setServerController method, of class AI.
     */
    @Test
    public void testGetSetServerController() {
        System.out.println("Testing getServerController and setServerController");
        ServerController ctrl = new ServerController(new ServerNetwork(5555));
        Difficulty difficulty = new Difficulty(2,1);
        AI ai = new AI(difficulty, ctrl, new Game());
        
        ServerController expResult = ai.getServerController();
        assertEquals(expResult, ctrl);
        
        ServerController ctrl2 = new ServerController(new ServerNetwork(5555));
        ai.setServerController(ctrl2);
        
        ServerController expResult2 = ai.getServerController();
        assertEquals(expResult2, ctrl2);
    }

    /**
     * Test of aiRefuteSuggestion method, of class AI.
     */
    @Test
    public void testAiRefuteSuggestion() {
        System.out.println("aiRefuteSuggestion");
        
        ServerController ctrl = new ServerController(new ServerNetwork(5555));
        AI ai = new AI(new Difficulty(2,1), ctrl, new Game());
       
        SuspectID suspect = SuspectID.PEACOCK;
        VehicleID vehicle = VehicleID.LIMOUSINE;
        DestinationID destination = DestinationID.CONEY_ISLAND;
       
        ArrayList<HintCard> hintCards = new ArrayList();
        hintCards.add(new SuspectCard(SuspectID.PEACOCK));
        hintCards.add(new VehicleCard(VehicleID.HOT_AIR_BALLOON, CardColor.BLUE));
        ai.setHintCardsHand(hintCards);   
        
        SuspectID expResult = SuspectID.PEACOCK;
        HintCard result = ai.aiRefuteSuggestion(suspect, vehicle, destination);
        
        assertEquals(expResult, ((SuspectCard)result).getSuspect());

    }
    
}