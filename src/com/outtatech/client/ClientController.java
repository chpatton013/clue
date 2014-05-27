package com.outtatech.client;

import com.outtatech.client.messaging.*;
import com.outtatech.common.*;
import com.outtatech.server.*;
import com.outtatech.server.messaging.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Version-latenightpizzaparty
 * The ClientController class facilitates changes to the clients State,
 * facilitates sending requests to the Networking classes, and reacts to
 * responses received from the Networking classes.
 *
 * @author bschache
 * @author jbilous added accusation methods
 */
public class ClientController
{
    private State state;
    private ClientNetwork network;
    private boolean creator = false;
    private boolean accused = false;

    /**
     * Version-latenightpizzaparty
     * Constructor for the ClientController.
     */
    public ClientController()
    {
        this.setState(new ClientMenuState());
        // Just in case...
        try
        {
            this.network = new ClientNetwork("localhost", 55555);
        }
        catch (IOException ex)
        {
            System.err.println("Unable to connect to server");
            System.exit(1);
        }

        network.setClientController(this);
    }

    /**
     * Version-latenightpizzaparty
     * Get the Player's current State
     *
     * @return the Player's state return value
     */
    public State getState()
    {
        return this.state;
    }

    /**
     * Version-latenightpizzaparty
     * Set the player's current state
     *
     * @param newState an initialized instance of State method parameter
     */
    public void setState(State newState)
    {
        // Guard against this
        if (this.state != null)
        {
            newState.addOldStatesObservers(this.state.getObservers());
            this.state = newState;
            this.state.triggerChange();
        }
        // Otherwise...
        else
        {
            this.state = newState;
        }
    }

    /**
     * Version-latenightpizzaparty
     *
     */
    public void triggerChange()
    {
        this.state.triggerChange();
    }

    /**
     * Version-latenightpizzaparty
     * Start the single player game mode.
     */
    public void startSinglePlayerGame()
    {
        this.creator = true;
        this.forwardMessage(new SinglePlayerGameRequest());
    }

    /**
     * Version-latenightpizzaparty
     * Sends a LobbyListRequest to the game server.
     */
    public void searchForGames()
    {
        this.forwardMessage(new LobbyListRequest());
    }

    /**
     * Version-latenightpizzaparty
     * Start the multi player game mode.
     * @param lobbyName method parameter
     */
    public void startMultiPlayerGame(String lobbyName)
    {
        this.forwardMessage(new LobbyCreateRequest(lobbyName));
    }

    /**
     * Version-latenightpizzaparty
     * Sends a Lobby Join request to the game server.
     *
     * @param lobbyId Integer the id of the lobby to join method parameter
     */
    public void joinGame(Integer lobbyId)
    {
        this.forwardMessage(new LobbyJoinRequest(lobbyId));
    }

    /**
     * Version-latenightpizzaparty
     * Sends a request to the game server to add an AI player.
     *
     * @param difficulty Difficulty the difficulty for this AI player method parameter
     * @param lobbyId method parameter
     */
    public void addAIPlayer(Difficulty difficulty, Integer lobbyId)
    {
        this.forwardMessage(new AddAIRequest(difficulty, lobbyId));
    }

    /**
     * Version-latenightpizzaparty
     * Sends a request to the game server to remove yourself from the lobby.
     */
    public void leaveLobby()
    {
        this.forwardMessage(new LobbyLeaveRequest());
    }

    /**
     * Version-latenightpizzaparty
     * Sends a request to the game server to remove a player from the lobby.
     *
     * @param playerId method parameter
     */
    public void kickPlayer(Integer playerId)
    {
        this.forwardMessage(new KickPlayerRequest(playerId));
    }

    /**
     * Version-latenightpizzaparty
     * Sends a request to the game server to start the game.
     */
    public void startGame()
    {
        this.forwardMessage(new GameStartRequest());
    }

    /**
     * Version-latenightpizzaparty
     * Initiates a message to the server that indicates the client has ended
     * their current turn.
     */
    public void endTurn()
    {
        this.forwardMessage(new EndTurnRequest());
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param actionCard method parameter
     * @param cards method parameter
     * @param playerId method parameter
     */
    public void playActionCard(ActionCard actionCard, List<Card> cards,
            Integer playerId)
    {
        this.forwardMessage(new ActionRequest(actionCard, cards, playerId));
    }

//    public void revealCards(List<Card> cards)
//    {
//        this.forwardMessage(new RevealCardsRequest(cards));
//    }
    /**
     * Version-latenightpizzaparty
     * Called when the client would like to make an accusation during their
     * turn.
     *
     * @param accusation method parameter
     */
    public void makeAccusation(Solution accusation)
    {
        this.accused = true;
        this.forwardMessage(new AccusationRequest(accusation));
    }

    /**
     * Version-latenightpizzaparty
     * React to a message from the ClientNetwork.
     *
     * @param obj Object message from the ClientNetwork method parameter
     */
    public void reactToMessage(ServerResponse obj)
    {
        // Guard against this
        if (obj instanceof LobbyDiscoveryResponse)
        {
            this.reactToLobbyDiscoveryResponse((LobbyDiscoveryResponse) obj);
        }
        // Otherwise...
        else if (obj instanceof LobbyCreateResponse)
        {
            this.reactToLobbyCreateResponse((LobbyCreateResponse) obj);
        }
        // Otherwise...
        else if (obj instanceof LobbyJoinResponse)
        {
            this.reactToLobbyJoinResponse((LobbyJoinResponse) obj);
        }
        // Otherwise...
        else if (obj instanceof LobbyLeaveResponse)
        {
            this.reactToLobbyLeaveResponse((LobbyLeaveResponse) obj);
        }
        // Otherwise...
        else if (obj instanceof KickPlayerResponse)
        {
            this.reactToKickPlayerResponse((KickPlayerResponse) obj);
        }
        // Otherwise...
        else if (obj instanceof GameStateResponse)
        {
            this.reactToGameStateResponse((GameStateResponse) obj);
        }
        // Otherwise...
        else if (obj instanceof CardDealResponse)
        {
            this.reactToCardDealResponse((CardDealResponse) obj);
        }
//        else if (obj instanceof ActionResponse)
//        {
//            this.reactToActionResponse((ActionResponse) obj);
//        }
        // Otherwise...
        else if (obj instanceof RevealCardResponse)
        {
            this.reactToRevealCardRequest((RevealCardResponse) obj);
        }
        // Otherwise...
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
        // Guard against this
        if (this.state instanceof ClientMenuState
                || this.state instanceof ClientLobbyDiscoveryState)
        {
            Integer myId = rsp.getPlayerId();
            Map<Integer, String> players = rsp.getPlayers();

            this.setState(new ClientLobbyState(myId, players, this.creator,
                    rsp.getLobby().getLobbyId()));
            this.creator = false;
        }
        // Otherwise...
        else if (this.state instanceof ClientLobbyState)
        {
            ((ClientLobbyState) this.state).setPlayers(rsp.getPlayers());
        }
        // Otherwise...
        else
        {
            System.err.println("Received LobbyJoinResponse while not in "
                    + "ClientMenuState, ClientLobbyDiscoveryState, or "
                    + "ClientLobbyState.");
        }
    }

    private void reactToLobbyLeaveResponse(LobbyLeaveResponse rsp)
    {
        // Guard against this
        if (!(this.state instanceof ClientLobbyState))
        {
            System.err.println("Received LobbyLeaveResponse while not in "
                    + "ClientLobbyState.");
            return;
        }

        this.removePlayerFromClientLobbyState(rsp.getPlayerId());
    }

    private void reactToKickPlayerResponse(KickPlayerResponse rsp)
    {
        // Guard against this
        if (!(this.state instanceof ClientLobbyState))
        {
            System.err.println("Received KickPlayerResponse while not in "
                    + "ClientLobbyState.");
            return;
        }

        this.removePlayerFromClientLobbyState(rsp.getPlayerId());
    }

    private void reactToGameStateResponse(GameStateResponse rsp)
    {
        // Guard against this
        if (!(this.state instanceof ClientGameState))
        {
            System.err.println("Received GameStateResponse while not in "
                    + "ClientGameState.");
            return;
        }

        ClientGameState state = (ClientGameState) this.state;
        state.setPlayers(rsp.getPlayers());
        state.setCurrentActivePlayer(rsp.getCurrentActivePlayer());

        state.pushGameLog("Game state updated:" + "\n   Current Active Player: "
                + rsp.getCurrentActivePlayer());
    }

    private void reactToCardDealResponse(CardDealResponse rsp)
    {
        // Guard against this
        if (this.state instanceof ClientLobbyState)
        {
            ClientLobbyState state = (ClientLobbyState) this.state;
            Integer me = state.getPlayerId();
            this.setState(new ClientGameState(me, rsp.getCards(),
                    state.getPlayers()));

            ((ClientGameState) this.state).pushGameLog("Game Started");

            this.forwardMessage(new GameStateRequest());
        }
        // Otherwise...
        else if (!(this.state instanceof ClientGameState))
        {
            System.err.println("Received CardDealResponse while not in "
                    + "ClientGameState.");
        }
        // Otherwise...
        else
        {
            ((ClientGameState) this.state).getHand().addAll(rsp.getCards());

            ((ClientGameState) this.state).pushGameLog(
                    "Cards dealt: " + rsp.getCards());
        }
    }

//    private void reactToActionResponse(ActionResponse rsp)
//    {
//        if (!(this.state instanceof ClientGameState))
//        {
//            System.err.println("Received ActionResponse while not in "
//                    + "ClientGameState.");
//            return;
//        }
//
//        ((ClientGameState) this.state).pushGameLog(
//                "Player " + rsp.getPlayerId() + " played card " + rsp.
//                getActionCard());
//    }
    private void reactToRevealCardRequest(RevealCardResponse rsp)
    {
        // Guard against this
        if (!(this.state instanceof ClientGameState))
        {
            System.err.println("Received RevealCardRequest while not in "
                    + "ClientGameState.");
            return;
        }

        ClientGameState state = (ClientGameState) this.state;

        ActionCardType type = rsp.getActionCard().getActionType();
        // Guard against this
        if (type == ActionCardType.SUGGESTION)
        {
            List<Card> cards = rsp.getCards();
            // tell GUI to present cards
        }
        // Otherwise...
        else if (type == ActionCardType.SNOOP || type
                == ActionCardType.ALL_SNOOP)
        {
            List<Card> hints = new ArrayList<Card>(state.getHand());
            int index = 0;
            // Iterate until false
            while (index < hints.size())
            {
                // Guard against this
                if (hints.get(index) instanceof ActionCard)
                {
                    hints.remove(index);
                }
                // Otherwise...
                else
                {
                    ++index;
                }
            }
            Collections.shuffle(hints);
            Card card = hints.get(0);

            // tell GUI card was shown to user rsp.getPlayerId()
        }
        // Otherwise...
        else if (type == ActionCardType.SUPER_SLEUTH)
        {
            // get condition from this card
            // prompt GUI to present user with choice of cards that match
            //  condition
        }
        // Otherwise...
        else if (type == ActionCardType.PRIVATE_TIP)
        {
            // get condition from this card
            // prompt GUI to present user with choice of cards that match
            //  condition
        }
    }

    private void reactToAccusationResponse(AccusationResponse rsp)
    {
        Solution solution = rsp.getSolution();

        // Guard against this
        if (this.accused)
        {
            // Guard against this
            if (rsp.getCorrectAccusation())
            {
                // you win!
                // show correct solution
            }
            // Otherwise...
            else
            {
                // you lose! you get nothing! good day sir!
                // show wrong solution
                // remove from game
            }

            return;
        }

        // Guard against this
        if (rsp.getCorrectAccusation())
        {
            // you lose! you get nothing! good day sir!
            // show correct solution
            // give option to leave game
        }
        // Otherwise...
        else
        {
            // show wrong solution
        }
    }

    private void removePlayerFromClientLobbyState(Integer playerId)
    {
        ClientLobbyState state = (ClientLobbyState) this.state;

        state.getPlayers().remove(playerId);

        // Guard against this
        if (playerId == state.getPlayerId())
        {
            this.searchForGames();
        }
    }

    /**
     * Version-latenightpizzaparty
     * Send a message via the ClientNetwork instance.
     *
     * @param obj ClientRequest the message object to send via the ClientNetwork method parameter
     * instance.
     */
    private void forwardMessage(Object obj)
    {
        this.network.sendMessageToServer(obj);
    }
}
