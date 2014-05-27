package com.outtatech.client;

import com.outtatech.server.*;
import com.outtatech.client.*;
import com.outtatech.client.ClientController;
import com.outtatech.client.ClientController;
import com.outtatech.client.ClientLobbyDiscoveryState;
import com.outtatech.client.ClientLobbyDiscoveryState;
import com.outtatech.client.ClientNetwork;
import com.outtatech.client.ClientNetwork;
import com.outtatech.client.State;
import com.outtatech.client.State;
import com.outtatech.common.*;

import java.util.*;

/**
 *
 * @author bschache
 */
public class SystemDriver implements Observer
{
    public static final int port = 4444;
    public static final String host = "localhost";
 
    public SystemDriver()
    {
    }
    
    private void start()
    {
        // <editor-fold defaultstate="collapsed" desc=" Initialize Network and Controllers ">
        ServerNetwork server = new ServerNetwork(port);
        try   
        {
            server.listen();
        }
        catch (Exception e)
        {
            System.out.println("ouch");
            System.out.println(e.getMessage());
        }
        System.out.println("Driver started, server listening.");
        ServerController gameController = new ServerController(server);
        server.setServerController(gameController);
        ClientNetwork client = null;
        try
        {
            client = new ClientNetwork(host, port);
            client.openConnection();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        State state = new State();
        state.addObserver(this);
        ClientController ctrl = new ClientController(state, client);
        client.setClientController(ctrl);
        
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc=" Lobby Testing ">
        ctrl.searchForGames();
        System.out.println("sent search for games request.");
        
        ctrl.startMultiPlayerGame("StarTREK");
        System.out.println("sent add game request.");
        
        ctrl.searchForGames();
        
        //while(true);

        // </editor-fold>
    }
    
    public static void main(String[] args)
    {
        SystemDriver driver = new SystemDriver();
        driver.start();
    }
    
    
    
    @Override
    public void update(Observable o, Object arg)
    {
        if (o instanceof ClientLobbyDiscoveryState)
            printLobbies(((ClientLobbyDiscoveryState)o).getLobbyList());
    }
    
    private static void printLobbies(List<Lobby> lobbies)
    {
        System.out.println("printing lobbies");
        for (Lobby l : lobbies)
        {
            System.out.println(l.getLobbyName());
        }
    }
}
