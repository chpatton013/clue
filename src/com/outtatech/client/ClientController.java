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
    private boolean accused = false;

    /**
     * Constructor for the ClientController.
     */
    public ClientController()
    {
        this.setState(new ClientMenuState());
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
     * @param newState an initialized instance of State
     */
    public void setState(State newState)
    {
        if (this.state != null)
        {
            newState.addOldStatesObservers(this.state.getObservers());
            this.state = newState;
            this.state.triggerChange();
        }
        else
        {
            this.state = newState;
        }
    }
    
    private void triggerChange()
    {
        this.state.triggerChange();
    }

    /**
     * Start the single player game mode.
     */
    public void startSinglePlayerGame()
    {
        this.creator = true;
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
     * Start the multi player game mode.
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
    public void endTurn()
    {
        this.forwardMessage(new EndTurnRequest());
    }

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
     * Called when the client would like to make an accusation during their
     * turn.
     *
     * @param accusationCards list containing the Destination, Vehicle and
     * Suspect card required to make an accusation.
     */
    public void makeAccusation(Solution accusation)
    {
        this.accused = true;
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
//        else if (obj instanceof ActionResponse)
//        {
//            this.reactToActionResponse((ActionResponse) obj);
//        }
        else if (obj instanceof RevealCardResponse)
        {
            this.reactToRevealCardRequest((RevealCardResponse) obj);
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
        if (this.state instanceof ClientMenuState ||
                this.state instanceof ClientLobbyDiscoveryState)
        {
            Integer myId = rsp.getPlayerId();
            Map<Integer, String> players = rsp.getPlayers();

            this.setState(new ClientLobbyState(myId, players, this.creator,
                    rsp.getLobby().getLobbyId()));
            this.creator = false;
        }
        else if (this.state instanceof ClientLobbyState)
        {
            ((ClientLobbyState) this.state).setPlayers(rsp.getPlayers());
        }
        else
        {
            System.err.println("Received LobbyJoinResponse while not in " +
                    "ClientMenuState, ClientLobbyDiscoveryState, or " +
                    "ClientLobbyState.");
        }
    }

    private void reactToLobbyLeaveResponse(LobbyLeaveResponse rsp)
    {
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
        if (!(this.state instanceof ClientGameState))
        {
            System.err.println("Received GameStateResponse while not in " +
                    "ClientGameState.");
            return;
        }

        ClientGameState state = (ClientGameState) this.state;
        state.setDeckCardCount(rsp.getDeckCardCount());
        state.setPlayers(rsp.getPlayers());
        state.setPlayerTurnOrder(rsp.getPlayerTurnOrder());
        state.setCurrentActivePlayer(rsp.getCurrentActivePlayer());

        state.pushGameLog("Game state updated:" + "\n   Deck Card Count: " +
                rsp.getDeckCardCount() + "\n   Player Turn Order: " +
                rsp.getDeckCardCount() + "\n   Current Active Player: " +
                rsp.getCurrentActivePlayer());
    }

    private void reactToCardDealResponse(CardDealResponse rsp)
    {
        if (this.state instanceof ClientLobbyState)
        {
            ClientLobbyState state = (ClientLobbyState) this.state;
            Integer me = state.getPlayerId();
            List<Card> newStateCards = new ArrayList(rsp.getCards());
            this.setState(new ClientGameState(me, newStateCards,
                    state.getPlayers()));

            ((ClientGameState) this.state).pushGameLog("Game Started");

            this.forwardMessage(new GameStateRequest());
        }
        else if (!(this.state instanceof ClientGameState))
        {
            System.err.println("Received CardDealResponse while not in "
                    + "ClientGameState.");
        }
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
        if (!(this.state instanceof ClientGameState))
        {
            System.err.println("Received RevealCardRequest while not in "
                    + "ClientGameState.");
            return;
        }

        ClientGameState state = (ClientGameState) this.state;

        ActionCardType type = rsp.getActionCard().getActionType();
        if (type == ActionCardType.SUGGESTION)
        {
            List<Card> cards = rsp.getCards();
            // TODO: GUI
            // tell GUI to present cards
        }
        else if (type == ActionCardType.SNOOP || type
                == ActionCardType.ALL_SNOOP)
        {
            List<Card> hints = new ArrayList<Card>(state.getHand());
            int index = 0;
            while (index < hints.size())
            {
                if (hints.get(index) instanceof ActionCard)
                {
                    hints.remove(index);
                }
                else
                {
                    ++index;
                }
            }
            Collections.shuffle(hints);
            Card card = hints.get(0);

            // TODO: GUI
            // tell GUI card was shown to user rsp.getPlayerId()
        }
        else if (type == ActionCardType.SUPER_SLEUTH)
        {
            // get condition from this card
            // TODO: GUI
            // prompt GUI to present user with choice of cards that match
            //  condition
        }
        else if (type == ActionCardType.PRIVATE_TIP)
        {
            // get condition from this card
            // TODO: GUI
            // prompt GUI to present user with choice of cards that match
            //  condition
        }
    }

    private void reactToAccusationResponse(AccusationResponse rsp)
    {
        Solution solution = rsp.getSolution();

        if (this.accused)
        {
            if (rsp.getCorrectAccusation())
            {
                // you win!
                // TODO: GUI
                // show correct solution
            }
            else
            {
                // you lose! you get nothing! good day sir!
                // TODO: GUI
                // show wrong solution
                // remove from game
            }

            return;
        }

        if (rsp.getCorrectAccusation())
        {
            // you lose! you get nothing! good day sir!
            // TODO: GUI
            // show correct solution
            // give option to leave game
        }
        else
        {
            // TODO: GUI
            // show wrong solution
        }
    }

    private void removePlayerFromClientLobbyState(Integer playerId)
    {
        ClientLobbyState state = (ClientLobbyState) this.state;

        state.getPlayers().remove(playerId);

        if (playerId == state.getPlayerId())
        {
            this.searchForGames();
        }
    }

    /**
     * Send a message via the ClientNetwork instance.
     *
     * @param obj ClientRequest the message object to send via the ClientNetwork
     * instance.
     */
    private void forwardMessage(Object obj)
    {
        this.network.sendMessageToServer(obj);
    }
}