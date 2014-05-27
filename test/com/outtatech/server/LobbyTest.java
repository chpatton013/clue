package com.outtatech.server;

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
public class LobbyTest
{
    
    /**
     * Test of getLobbyName method, of class Lobby.
     */
    @Test
    public void testGetLobbyName()
    {
        System.out.println("getLobbyName");
        
        Lobby instance = new Lobby("lobby", new Integer(5));
        String expResult = "lobby";
        String result = instance.getLobbyName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGameId method, of class Lobby.
     */
    @Test
    public void testGetGameId()
    {
        System.out.println("getGameId");
        Lobby instance = new Lobby("lobby", new Integer(5));
        Integer expResult = new Integer(5);
        Integer result = instance.getGameId();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getLobbyId method, of class Lobby.
     */
    @Test
    public void testGetLobbyId()
    {
        System.out.println("getLobbyId");
        
        Lobby instance = new Lobby("lobby", new Integer(5));
        Integer expResult = new Integer(2);
        Integer result = instance.getLobbyId();
        assertEquals(expResult, result);
    }
}
