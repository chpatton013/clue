/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.client;

import java.util.List;
import java.util.ArrayList;

import com.outtatech.common.*;
import com.outtatech.client.*;
import com.outtatech.client.messaging.*;
import com.outtatech.server.*;
import com.outtatech.server.messaging.*;

/**
 * The ClientController class facilitates changes to the clients State,
 * facilitates sending requests to the Networking classes, and reacts to
 * responses received from the Networking classes.
 *
 * @author bschache TODO: make a notification class to send to the GUI contains
 * message triggers display of message and loading animation
 * @author jbilous added accusation methods
 */
public class ClientController
{
    private State state;
    private ClientNetwork network;
    private boolean creator = false;

    /**
     * Constructor for the ClientController. Requires an initialized State
     * object and an initialized ClientNetwork object
     *
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
     *
     * @return the Player's state
     */
    public State getState()
    {
        return this.state;
    }

    /**
     * Set the player's current state
     *
     * @param state an initialized instance of State
     */
    public void setState(State state)
    {
        this.state = state;
    }

    /**
     * Start the single player game mode.
     */
    public void startSinglePlayerGame()
    {
        this.forwardMessage(new SinglePlayerGameRequest());
    }

    /**
     * Sends a LobbyListRequest to the game server.
     */
    public void searchForGames()
    {
        this.forwardMessage(new LobbyListRequest());
    }

    /**
     * Start the single player game mode.
     */
    public void startMultiPlayerGame(String lobbyName)
    {
        this.forwardMessage(new LobbyCreateRequest(lobbyName));
    }

    /**
     * Sends a Lobby Join request to the game server.
     *
     * @param lobbyId Integer the id of the lobby to join
     */
    public void joinGame(Integer lobbyId)
    {
        this.forwardMessage(new LobbyJoinRequest(lobbyId));
    }

    /**
     * Sends a request to the game server to add an AI player.
     *
     * @param difficulty Difficulty the difficulty for this AI player
     */
    public void addAIPlayer(Difficulty difficulty, Integer lobbyId)
    {
        this.forwardMessage(new AddAIRequest(difficulty, lobbyId));
    }

    /**
     * Sends a request to the game server to remove yourself from the lobby.
     */
    public void leaveLobby()
    {
        this.forwardMessage(new LobbyLeaveRequest());
    }

    /**
     * Sends a request to the game server to remove a player from the lobby.
     *
     * @param Integer playerId the id of the player to kick
     */
    public void kickPlayer(Integer playerId)
    {
        this.forwardMessage(new KickPlayerRequest(playerId));
    }

    /**
     * Sends a request to the game server to start the game.
     */
    public void startGame()
    {
        this.forwardMessage(new GameStartRequest());
    }

    /**
     * Initiates a message to the server that indicates the client has ended
     * their current turn.
     */
    public void endTurn() {
        this.forwardMessage(new EndTurnRequest());
    }

    /**
     * Called when the client would like to make an accusation during their
     * turn.
     *
     * @param accusationCards list containing the Destination, Vehicle and
     * Suspect card required to make an accusation.
     */
    public void makeAccusation(Solution accusation) {
        this.forwardMessage(new AccusationRequest(accusation));
    }

    /**
     * React to a message from the ClientNetwork.
     *
     * @param obj Object message from the ClientNetwork
     */
    public void reactToMessage(ServerResponse obj)
    {
        if (obj instanceof LobbyDiscoveryResponse)
        {
            this.reactToLobbyDiscoveryResponse((LobbyDiscoveryResponse) obj);
        }
        else if (obj instanceof LobbyCreateResponse)
        {
            this.reactToLobbyCreateResponse((LobbyCreateResponse) obj);
        }
        else if (obj instanceof LobbyJoinResponse)
        {
            this.reactToLobbyJoinResponse((LobbyJoinResponse) obj);
        }
        else if (obj instanceof LobbyLeaveResponse)
        {
            this.reactToLobbyLeaveResponse((LobbyLeaveResponse) obj);
        }
        else if (obj instanceof KickPlayerResponse)
        {
            this.reactToKickPlayerResponse((KickPlayerResponse) obj);
        }
        else if (obj instanceof GameStateResponse)
        {
            this.reactToGameStateResponse((GameStateResponse) obj);
        }
        else if (obj instanceof CardDealResponse)
        {
            this.reactToCardDealResponse((CardDealResponse) obj);
        }
        else if (obj instanceof ActionResponse)
        {
            this.reactToActionResponse((ActionResponse) obj);
        }
        else if (obj instanceof AccusationResponse)
        {
            this.reactToAccusationResponse((AccusationResponse) obj);
        }
    }

    private void reactToLobbyDiscoveryResponse(LobbyDiscoveryResponse rsp)
    {
        this.setState(new ClientLobbyDiscoveryState(rsp.getLobbies()));
    }

    private void reactToLobbyCreateResponse(LobbyCreateResponse rsp)
    {
        this.creator = true;
        this.joinGame(rsp.getLobby().getLobbyId());
    }

    private void reactToLobbyJoinResponse(LobbyJoinResponse rsp)
    {
        if (this.state instanceof ClientLobbyDiscoveryState) {
            Player me = rsp.getPlayer();
            List<Player> players = new ArrayList<Player>();
            players.add(me);

            this.setState(new ClientLobbyState(me, players, this.creator));
            this.creator = false;
        }
        else if (!(this.state instanceof ClientLobbyState))
        {
            System.err.println("Received LobbyJoinResponse while not in " +
                    "ClientLobbyDiscoveryState or ClientLobbyState.");
        }
        else
        {
            ((ClientLobbyState)this.state).addPlayer(rsp.getPlayer());
        }
    }

    private void reactToLobbyLeaveResponse(LobbyLeaveResponse rsp)
    {
        if (!(this.state instanceof ClientLobbyState))
        {
            System.err.println("Received LobbyLeaveResponse while not in " +
                    "ClientLobbyState.");
            return;
        }

        this.removePlayerFromClientLobbyState(rsp.getPlayerId());
    }

    private void reactToKickPlayerResponse(KickPlayerResponse rsp)
    {
       // remove player from state
        if (!(this.state instanceof ClientLobbyState))
        {
            System.err.println("Received KickPlayerResponse while not in " +
                    "ClientLobbyState.");
            return;
        }

        this.removePlayerFromClientLobbyState(rsp.getPlayerId());
    }

    private void reactToGameStateResponse(GameStateResponse rsp)
    {
        // override game state
    }

    private void reactToCardDealResponse(CardDealResponse rsp)
    {
        // add dealt card to hand
    }

    private void reactToActionResponse(ActionResponse rsp)
    {
        // prepare RevealCardRequest
        // this.promptViews(rsp);
    }

    private void reactToAccusationResponse(AccusationResponse rsp)
    {
    }

    private void removePlayerFromClientLobbyState(Player player) {
        ClientLobbyState state = (ClientLobbyState)this.state;

        Integer playerId = rsp.getPlayerId();
        if (playerId == state.getPlayer().getPlayerId()) {
            this.searchForGames();
        }

        state.getPlayers().remove(rsp.getPlayerId());
    }

    /**
     * Send a message via the ClientNetwork instance.
     *
     * @param obj ClientRequest the message object to send via the ClientNetwork
     * instance.
     */
    public void forwardMessage(ClientRequest obj)
    {
        this.network.sendMessageToServer(obj);
    }
}
