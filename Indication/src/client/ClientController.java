/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

/**
 * The ClientController class facilitates changes to the clients
 * State, facilitates sending requests to the Networking classes, 
 * and reacts to responses received from the Networking classes.
 * 
 * @author bschache
 */
public class ClientController 
{
    private State state;
    private ClientNetwork network;
    
    /**
     * Constructor for the ClientController.  Requires an initialized
     * State object and an initialized ClientNetwork object
     * @param state State of the client
     * @param network ClientNetwork instance to handle communication
     */
    public ClientController(State state, ClientNetwork network)
    {
        this.state = state;
        this.network = network;
    }
    
    /**
     * Get the Player's current State
     * @return the Player's state
     */
    public State getState()
    {
        return this.state;
    }
    
    /**
     * Set the player's current state
     * @param state an initialized instance of State
     */
    public void setState(State state)
    {
        this.state = state;
    }
    
    /**
     * Get the ClientNetwork that the ClientController is using.
     * @return ClientNetwork instance that is currently in use.
     */
    public ClientNetwork getNetwork()
    {
        return network;
    }
    
    /**
     * Start the single player game mode.
     * Alerts game server.
     * Changes to Client to next logical state
     */
    public void startSingPlayerGame()
    {
    }
    
    /**
     * Sends a LobbyListRequest to the game server.
     */
    public void searchForGames()
    {
    }
    
    /**
     * Sends a Lobby Join request to the game server.
     */
    public void joinGame()
    {
    }
    
    /**
     * Sends a request to the game server to start the game
     */
    public void startGame()
    {
    }
    
    /**
     * A hook allowing a client extension to message into the controller,
     * ie an object from a GUI.
     * @param obj Object from a client extension
     */
    public void use(Object obj)
    {
    }
    
    /**
     * A hook to prompt a client extension, Controller sends a message out.
     * ie. the Controller will prompt a GUI extension.
     * @param obj Object that requiring examination
     */
    public void prompt(Object obj)
    {
    }
    
    /**
     * React to a message from the ClientNetwork
     * @param obj Object message from the ClientNetwork
     */
    public void react(Object obj)
    {
        
    }
    
    /**
     * Send a message via the ClientNetwork instance
     * @param obj Object, the message object to send via
     * the Client network instance.
     */
    public void send(Object obj)
    {
    }
}
