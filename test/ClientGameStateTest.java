
import com.outtatech.client.ClientGameState;
import com.outtatech.common.Card;
import com.outtatech.common.DestinationID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Thomas
 */
public class ClientGameStateTest
{
    
    /**
     *
     */
    public ClientGameStateTest()
    {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass()
    {
    }

    /**
     * Test of setNewAccusation method, of class ClientGameState.
     */
    @Test
    public void testSetNewAccusation()
    {
        System.out.println("setNewAccusation");
        
        try
        {
            ClientGameState instance = new ClientGameState(0, null, null);
            instance.setNewAccusation();
        }
        catch (Exception ex)
        {
            fail();
        }
    }

    /**
     * Test of getAccusationStatus method, of class ClientGameState.
     */
    @Test
    public void testGetAccusationStatus()
    {
        System.out.println("getAccusationStatus");
        
        ClientGameState instance = new ClientGameState(0, null, null);
        boolean expResult = false;
        boolean result = instance.getAccusationStatus();
        assertEquals(expResult, result);
        
        try
        {
            instance.setNewAccusation();
        }
        catch (Exception ex)
        {
            fail("---Failed To Set New Accusation. Aborting.");
        }
        
        expResult = false;
        result = instance.getAccusationStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccusation method, of class ClientGameState.
     */
    @Test
    public void testGetAccusation()
    {
        System.out.println("getAccusation");
        
        ClientGameState instance = new ClientGameState(0, null, null);
        boolean expResult = false;
        boolean result = instance.getAccusation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerId method, of class ClientGameState.
     */
    @Test
    public void testGetPlayerId()
    {
        System.out.println("getPlayerId");
        
        ClientGameState instance = new ClientGameState(0, null, null);
        int expResult = 0;
        int result = instance.getPlayerId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRevealed method, of class ClientGameState.
     */
    @Test
    public void testGetRevealed()
    {
        System.out.println("getRevealed");
        
        ClientGameState instance = new ClientGameState(0, null, null);
        List<Card> expResult = new ArrayList<Card>();
        List<Card> result = instance.getRevealed();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRevealed method, of class ClientGameState.
     */
    @Test
    public void testSetRevealed()
    {
        System.out.println("setRevealed");
        
        List<Card> revealed = null;
        ClientGameState instance = new ClientGameState(0, null, null);
        try
        {
            instance.setRevealed(revealed);
        }
        catch (Exception ex)
        {
            fail();
        }
    }

    /**
     * Test of getRevealStatus method, of class ClientGameState.
     */
    @Test
    public void testGetRevealStatus()
    {
        System.out.println("getRevealStatus");
        
        ClientGameState instance = new ClientGameState(0, null, null);
        boolean expResult = false;
        boolean result = instance.getRevealStatus();
        assertEquals(expResult, result);
        
        expResult = true;
        try
        {
            instance.setRevealStatus(expResult);
        }
        catch (Exception ex)
        {
            fail("---Failed To Set New Reveal. Aborting.");
        }
        result = instance.getRevealStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRevealStatus method, of class ClientGameState.
     */
    @Test
    public void testSetRevealStatus()
    {
        System.out.println("setRevealStatus");
        
        boolean revealStatus = false;
        ClientGameState instance = new ClientGameState(0, null, null);
        
        try
        {
            instance.setRevealStatus(revealStatus);
        }
        catch (Exception ex)
        {
            fail();
        }
    }

    /**
     * Test of setPlayerId method, of class ClientGameState.
     */
    @Test
    public void testSetPlayerId()
    {
        System.out.println("setPlayerId");
        
        int playerID = 0;
        ClientGameState instance = new ClientGameState(0, null, null);
        
        try
        {
            instance.setPlayerId(playerID);
        }
        catch (Exception ex)
        {
            fail();
        }
    }

    /**
     * Test of getNotes method, of class ClientGameState.
     */
    @Test
    public void testGetNotes()
    {
        System.out.println("getNotes");
        
        String expResult = "Test";
        ClientGameState instance = new ClientGameState(0, null, null);
        instance.setNotes(expResult);
        Object result = instance.getNotes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHand method, of class ClientGameState.
     */
    @Test
    public void testGetHand()
    {
        System.out.println("getHand");
        
        List<Card> expResult = new ArrayList<Card>();
        ClientGameState instance = new ClientGameState(0, null, null);
        instance.setPlayerHand(expResult);
        List<Card> result = instance.getHand();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestToPlayerId method, of class ClientGameState.
     */
    @Test
    public void testGetDestToPlayerId()
    {
        System.out.println("getDestToPlayerId");
        
        Map<DestinationID, Integer> expResult
                = new HashMap<DestinationID, Integer>();
        expResult.put(DestinationID.THE_ALAMO, 5);
        ClientGameState instance = new ClientGameState(0, null, null);
        instance.setDestToPlayerId(expResult);
        Map<DestinationID, Integer> result = instance.getDestToPlayerId();
        assertEquals(expResult, result);
    }
    
}
