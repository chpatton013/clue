package com.outtatech.client;

import com.outtatech.server.ClientPlayer;
import java.awt.Color;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a ClientPlayer object
 * 
 * @author rvquinla
 */
public class ClientPlayerTest {
    
    private int testPlayerId = 7;
    private String testPlayerName = "pname";
    private Color testPlayerColor = Color.red;
    
    /**
     * Test of set/getPlayerId methods of class ClientPlayer.
     */
    @Test
    public void testSetGetPlayerId()
    {
        System.out.println("Testing set/getPlayerId of ClientPlayer");
        
        ClientPlayer cp = new ClientPlayer(0, "", null);
        assertEquals(cp.getPlayerId(), 0);
        
        cp.setPlayerId(testPlayerId);
        assertEquals(cp.getPlayerId(), testPlayerId);
    }
    
    /**
     * Test of set/getName methods of class ClientPlayer.
     */
    @Test
    public void testSetGetName()
    {
        System.out.println("Testing set/getName of ClientPlayer");
        
        ClientPlayer cp = new ClientPlayer(0, "", null);
        assertEquals(cp.getName(), "");
        
        cp.setName(testPlayerName);
        assertEquals(cp.getName(), testPlayerName);
    }
    
    /**
     * Test of set/getColor methods of class ClientPlayer.
     */
    @Test
    public void testSetGetColor()
    {
        System.out.println("Testing set/getColor of ClientPlayer");
        
        ClientPlayer cp = new ClientPlayer(0, "", null);
        assertEquals(cp.getColor(), null);
        
        cp.setColor(testPlayerColor);
        assertEquals(cp.getColor(), testPlayerColor);
    }
}
