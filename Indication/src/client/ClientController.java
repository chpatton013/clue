/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.util.List;

import com.outtatech.common.*;
import com.outtatech.client.messaging.*;
import com.outtatech.server.messaging.*;

/**
 * The ClientController class facilitates changes to the clients
 * State, facilitates sending requests to the Networking classes,
 * and reacts to responses received from the Networking classes.
 *
 * @author bschache
 * TODO: make a notification class to send to the GUI
 *       contains message
 *       triggers display of message and loading animation
 */
public class ClientController
{
    private State state;
    private ClientNetwork network;
    private ClientRequest staged;

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
        this.staged = null;
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
    public void startSinglePlayerGame()
    {
        // create new SinglePlayerGameRequest
        // send request to server
        // signal to GUI that we are waiting for a response
    }

    /**
     * Sends a LobbyListRequest to the game server.
     */
    public void searchForGames()
    {
        // create new LobbyListRequest
        // send request to server
        // signal to GUI that we are waiting for a response
    }

    /**
     * Sends a Lobby Join request to the game server.
     * @param lobbyId Integer the id of the lobby to join
     */
    public void joinGame(Integer lobbyId)
    {
        // create new LobbyJoinRequest
        // send request to server
        // signal to GUI that we are waiting for a response
    }

    /**
     * Sends a request to the game server to start the game.
     */
    public void startGame()
    {
        // create new GameStartRequest
        // send request to server
        // signal to GUI that we are waiting for a response
    }

    /**
     * Sends a request to the game server to add an AI player.
     */
    public void addAIPlayer()
    {
        // create new AddAIRequest
        // send request to server
        // signal to GUI that we are waiting for a response
    }

    /**
     * A hook allowing a client extension to message into the controller,
     * ie an object from a GUI.
     * @param obj Object from a client extension
     */
    public void requestUse(Object obj)
    {
        if (obj instanceof ActionCard)
        {
            // this.forwardMessage(new ActionRequest((ActionCard)obj));
        }
        else if (obj instanceof List)
        {
            // this.forwardMessage(new RevealCardRequest((List<Card>)obj);

        }
    }

    /**
     * A hook to prompt a client extension, Controller sends a message out.
     * ie. the Controller will prompt a GUI extension.
     * @param obj Object that requiring examination
     */
    public void promptViews(Object obj)
    {
        if (obj instanceof ActionResponse)
        {
            // switch response.actionCard.type
            // case SUGGESTION
            //     if (playing this card)
            //     {
            //         present all hint cards
            //     }
            //     else
            //     {
            //         calculate (hand intersect desired)
            //         present intersection to user
            //     }
            // case SNOOP
            //     open window with all players
            //     ...
            //     open window with player's hand face down
            // case ALL_SNOOP
            //     open window with all player's hands
            //     ...
            //     open window with selected cards face up
            // case SUPER_SLEUTH
            //     N/A
            // case PRIVATE_TIP
            //     open window with all players
        }
    }

    /**
     * React to a message from the ClientNetwork.
     * @param obj Object message from the ClientNetwork
     */
    public void reactToMessage(Object obj)
    {
        if (obj instanceof ActionResponse)
        {
           this.reactToActionResponse((ActionResponse)obj);
        }
        else if (obj instanceof CardDealResponse)
        {
           this.reactToCardDealResponse((CardDealResponse)obj);
        }
        else if (obj instanceof GameStateResponse)
        {
           this.reactToGameStateResponse((GameStateResponse)obj);
        }
        else if (obj instanceof LobbyCreateResponse)
        {
           this.reactToLobbyCreateResponse((LobbyCreateResponse)obj);
        }
        else if (obj instanceof LobbyDiscoveryResponse)
        {
           this.reactToLobbyDiscoveryResponse((LobbyDiscoveryResponse)obj);
        }
        else if (obj instanceof LobbyUpdateResponse)
        {
           this.reactToLobbyUpdateResponse((LobbyUpdateResponse)obj);
        }
    }

    private void reactToActionResponse(ActionResponse rsp)
    {
        // prepare RevealCardRequest
        // this.promptViews(rsp);
    }

    private void reactToCardDealResponse(CardDealResponse rsp)
    {
        // add dealt card to hand
    }

    private void reactToGameStateResponse(GameStateResponse rsp)
    {
        // override game state
    }

    private void reactToLobbyCreateResponse(LobbyCreateResponse rsp)
    {
        // change state to new ClientPreGameState
    }

    private void reactToLobbyDiscoveryResponse(LobbyDiscoveryResponse rsp)
    {
        // push list of lobbies to GUI
    }

    private void reactToLobbyUpdateResponse(LobbyUpdateResponse rsp)
    {
        // add new player to player list
    }

    /**
     * Send a message via the ClientNetwork instance.
     * @param obj Object the message object to send via the Client network
     * instance.
     */
    public void forwardMessage(Object obj)
    {
        this.network.sendMessageToServer(obj);
    }
}
