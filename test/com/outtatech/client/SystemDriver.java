package com.outtatech.client;

import com.outtatech.server.*;
import com.outtatech.client.*;
import com.outtatech.common.*;

import java.util.*;

/**
 *
 * @author bschache
 */
public class SystemDriver implements Observer
{

    /**
     *
     */
    public static final int port = 55555;

    /**
     *
     */
    public static final String host = "localhost";
    
    /** Variables for verifications **/
    public static ArrayList<Lobby> v_lobbies = new ArrayList<Lobby>();
    public static int game1Owner = 0;
    public static int totalPlayers = 0;
    public static int gameStateMsgCount = 0;
    public static ArrayList<ClientController> cQueue 
            = new ArrayList<>(); 
    private static ClientController client1;
    private static ClientController client2;
    private static ClientController client3;
    private static List<ActionCard> aCards
            = new ArrayList<>();
    private static boolean errorsAreOccuring = false;
    private static ArrayList<ClientController> clients
            = new ArrayList<>();
    private static int currentPlayer = 0;
    
    /**
     *
     */
    public SystemDriver()
    {
    }
    
    private void threadWait() throws Exception
    {
        System.out.println("Sleeping");
        synchronized(this){
            this.wait();
        }
        System.out.println("Notified to wake!");
    }
    
    private void start() throws Exception
    {
        // <editor-fold defaultstate="collapsed" desc=" Initialize Server and 3 clients ">
        ServerNetwork server = new ServerNetwork(port);

        System.out.println("Driver started, server listening.");
        ServerController gameController = new ServerController(server);
        server.setServerController(gameController);
        
        State state1;
        client1 = new ClientController();
        state1 = client1.getState();
        state1.addObserver(this);
        
        State state2;
        client2 = new ClientController();
        state2 = client2.getState();
        state2.addObserver(this);
        
        State state3;
        client3 = new ClientController();
        state3 = client3.getState();
        state3.addObserver(this);
        
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        
        
        // </editor-fold>
        

        // <editor-fold defaultstate="collapsed" desc=" Lobby Testing ">
        
        System.out.println("Testing lobby code");
        client1.searchForGames(); //should be zero
        cQueue.add(client1);
        threadWait();
        
        client1.startMultiPlayerGame("StarTREK");
        totalPlayers++;
        cQueue.add(client1);
        v_lobbies.add(new Lobby("StarTREK1", 1, true));
        threadWait();
        
        /** Test adding another lobby
        client2.startMultiPlayerGame("StarTREK");
        cQueue.add(client2);
        v_lobbies.add(0, new Lobby("StarTREK2", 2, true));
        threadWait();
        * */

        
        client2.searchForGames();
        cQueue.add(client2);
        threadWait();
        
        client3.searchForGames();
        cQueue.add(client3);
        threadWait();
        
        //client2.leaveLobby();
        //cQueue.add(client2);
        //threadWait();
        client2.joinGame(1);
        cQueue.add(client2);
        totalPlayers++;
        threadWait();
        
        /** Test Leaving and rejoining a lobby
        client2.leaveLobby();
        cQueue.add(client2);
        threadWait();
        
        //Rejoin the lobby
        client2.joinGame(1);
        cQueue.add(client2);
        totalPlayers++;
        threadWait();
        * */
        
        client3.joinGame(1);
        totalPlayers++;
        cQueue.add(client3);
        threadWait();

        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc=" Game Testing ">
        System.out.println("Sending start game.");
        client1.startGame();
        cQueue.add(client1);
        cQueue.add(client3);
        cQueue.add(client2);
        threadWait();
        threadWait();
        threadWait();
        
        System.out.println("ACTION CARD TIME.");

        if (aCards.size() > 0)
        {
            ActionCard temp = aCards.remove(0);
            System.out.println("playing action card: " 
                    + temp.getActionType().name());
            client1.playActionCard(temp, currentPlayer);
            threadWait();
        }
        else
        {
            System.out.println( " POSSIBLE DEFECT no action cards to play.");
        }
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc=" Test Tear Down ">
        client1 = null;
        client2 = null;
        client3 = null;
        
        server.close();
        gameController = null;
        
        // </editor-fold>
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        SystemDriver driver = new SystemDriver();
        
        try
        {
            driver.start();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    @Override
    public synchronized void update(Observable o, Object arg)
    {
        if (o instanceof ClientLobbyDiscoveryState)
        {
            verifyLobbies(((ClientLobbyDiscoveryState)o).getLobbyList());
            checkStates(cQueue.remove(0), o.getClass());
        }
        else if (o instanceof ClientLobbyState)
        {
            verifyGameOwner(((ClientLobbyState)o).getPlayerId(), 
                    ((ClientLobbyState)o).getGameOwner());
            if (errorsAreOccuring)
                checkPlayers(((ClientLobbyState)o).getPlayers());
            checkStates(cQueue.remove(0), o.getClass());
        }
        else if (o instanceof ClientGameState)
        {
            gameStateMsgCount++;
            
            //Are all the clients in the correct state.
            if(gameStateMsgCount == totalPlayers)
            {
                for (ClientController c : clients)
                   checkStates(c, o.getClass());  
            }
            
            checkGameState((ClientGameState)o, cQueue.remove(0));
            checkPlayerCount((ClientGameState)o);
            setActiveVariables((ClientGameState)o);
        }
        else 
        {
            System.out.println("Un-handled class instance:  " 
                    + o.getClass().getSimpleName());
        }
        System.out.println("raising notification");
        //this.notify();
        this.notifyAll();
    }
    
    private static void setActiveVariables(ClientGameState gameState)
    {
        if(gameState.isMyTurn())
        {
            for (Card c : gameState.getHand())
            {
                System.out.println("Checking ACTION CARDS");
                if (c instanceof ActionCard)
                    aCards.add((ActionCard)c);
            }
        }
    }
    
    private static void checkGameState(ClientGameState gameState
            , ClientController c)
    {      
        if (gameState.getCurrentActivePlayer() != currentPlayer
                || (gameState.getCurrentPlayerId() != currentPlayer
                && gameState.isMyTurn())) {
            
            System.out.println(" POSSIBLE DEFECT Player order does not match.");
            System.out.println("Printing turn order: ");
            for (Integer i : gameState.getPlayerTurnOrder())
                System.out.println(i);

        }
        
        if (!gameState.getCurrentActivePlayer().equals(
                gameState.getCurrentPlayerId()) && gameState.isMyTurn()) {
            
            System.out.println(" POSSIBLE DEFECT Player order does not match.");

        }
        
        if (!c.getState().equals(gameState))
            System.out.println("POSSIBLE DEFFECT in state setup or "
                + " in test driver");
        
        if (gameState.getPlayerTurnOrder().size() != totalPlayers)
            System.out.println( "POSSIBLE DEFFECT players in turn order " 
                    + gameState.getPlayerTurnOrder().size() 
                    + " expected " + totalPlayers);
    }
    
    private static void checkPlayerCount(ClientGameState gameState)
    {
        if (gameState.getPlayers().size() != totalPlayers)
            System.out.println(" POSSIBLE DEFECT expected "
                    + totalPlayers + " players found " 
                    + gameState.getPlayers().size());
    }
    
    private static void checkPlayers(Map<Integer, String> players)
    {
        if (players.size() != totalPlayers)
        {
            System.out.println("Printing Players: ");
            for(String s : players.values())
                System.out.println(s);
        }
    }
    
    private static void verifyGameOwner(int playerID, boolean isOwner) 
    {
        if(playerID == game1Owner && isOwner)
        {  
        }
        else if (playerID != game1Owner && !isOwner)
        {
        }
        else if (playerID == game1Owner && !isOwner)
        {
            System.out.println("POSSIBLE DEFECT: PlayerID: " 
                    + game1Owner + " is not set as the owner.");
            errorsAreOccuring = true;
        }
        else
        {
            System.out.println("POSSIBLE DEFECT: PlayerID: " 
                    + playerID + " is set as onwer, expected"
                    + "owner: " + game1Owner);
            errorsAreOccuring = true;
        }
        
        if (errorsAreOccuring)
        {
            System.out.println("Player id: " + playerID 
                    + " game owner: " +  isOwner);
        }
    }
    
    private static void checkStates(ClientController client, Class<?> c)
    {   
        if (!(c.isInstance(client.getState()))) 
        {
            System.out.println(" POSSIBLE DEFECT: "
                    + " Client " + " in incorrect state."
                    + " State is: " 
                    + client.getState().getClass().getSimpleName()
                    + " Expected: " + c.getSimpleName()); 
        }
    }
    
    private static void verifyLobbies(List<Lobby> lobbies)
    {
        int index = 0;
        String n1;
        String n2;
        
        for (index = 0; index < lobbies.size(); ++index)
        {
            try
            {
                n1 = lobbies.get(index).getLobbyName();
                n2 = v_lobbies.get(index).getLobbyName();

                if(!n1.equals(n2))
                {
                    System.out.println("POSSIBLE DEFECT:  lobbies not in sync:" 
                            + n1 +" " + n2);

                }
            }
            catch (ArrayIndexOutOfBoundsException aiex)
            {
                System.out.println("POSSIBLE DEFECT:  Unable to compare"
                        + " list have different sizes.");
            }
            
        }
    }
}
