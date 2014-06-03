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
    private GUIController guiCtrl;
    private CardTranslator translate;
    private boolean creator = false;
    private boolean accused = false;
    private boolean loser = false;

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
     * Returns whether or not the player has lost
     * @return whether or not the player has lost
     */
    public boolean isLost()
    {
        return loser;
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
     * Sets the GUI Controller for this client controller
     *
     * @param guiCtrl the gui controller
     */
    public void setGUICtrl(GUIController guiCtrl)
    {
        this.guiCtrl = guiCtrl;
        translate = new CardTranslator(guiCtrl);
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

    public void triggerChange()
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
        this.setState(new ClientLobbyListState());
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
     * @param lobbyId
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
        ((ClientGameState) this.state).setMyTurn(false);
        this.forwardMessage(new EndTurnRequest());
    }

    public boolean playActionCard(ActionCard card, Integer playerId)
    {
        ClientGameState state = (ClientGameState)this.state;

        boolean requiresSelectedPlayer = card instanceof Snoop ||
            card instanceof PrivateTip;
        if (requiresSelectedPlayer)
        {
            boolean playerSelected = playerId != null;
            if (!playerSelected)
            {
                return false;
            }

            Integer myPlayerId = state.getPlayerId();
            int numPlayers = state.getPlayerTurnOrder().size();
            boolean selectedSelf = myPlayerId.equals(playerId);
            boolean validSelection = playerId >= 0 && playerId < numPlayers;
            if (selectedSelf || !validSelection)
            {
                return false;
            }
        }

        this.forwardMessage(new ActionRequest(card, playerId));
        ((ClientGameState) this.state).removeFromHand(card);
        return true;
    }

    public boolean playSuggestionCard(Suggestion card, Solution solution)
    {
        this.forwardMessage(new SuggestionRequest(card, solution, solution.
                getDestination()));
        ((ClientGameState) this.state).removeFromHand(card);
        return true;
    }

    /**
     * Called when the client would like to make an accusation during their
     * turn.
     *
     * @param accusation list containing the Destination, Vehicle and Suspect
     * card required to make an accusation.
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
        else if (obj instanceof SuggestionResponse)
        {
            this.reactToSuggestionResponse((SuggestionResponse) obj);
        }
        else if (obj instanceof RevealCardResponse)
        {
            this.reactToRevealCardResponse((RevealCardResponse) obj);
        }
        else if (obj instanceof AccusationResponse)
        {
            this.reactToAccusationResponse((AccusationResponse) obj);
        }
    }

    private void reactToLobbyDiscoveryResponse(LobbyDiscoveryResponse rsp)
    {
        if(this.state instanceof ClientLobbyDiscoveryState
            || this.state instanceof ClientLobbyListState)
        {
            this.setState(new ClientLobbyDiscoveryState(rsp.getLobbies()));
        }
        else
        {
            System.out.println("Ignoring lobby discovery, does not matter"
                    + " in state: "  
                    + this.state.getClass().toString());
        }
    }

    private void reactToLobbyCreateResponse(LobbyCreateResponse rsp)
    {
        this.creator = true;
        this.joinGame(rsp.getLobby().getLobbyId());
    }

    private void reactToLobbyJoinResponse(LobbyJoinResponse rsp)
    {
        if (this.state instanceof ClientMenuState
                || this.state instanceof ClientLobbyDiscoveryState
                || this.state instanceof ClientLobbyListState)
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
            System.err.println("Received LobbyJoinResponse while not in "
                    + "ClientMenuState, ClientLobbyDiscoveryState, or "
                    + "ClientLobbyState.");
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
        if (this.state instanceof ClientLobbyState)
        {
            ClientLobbyState state = (ClientLobbyState) this.state;
            Integer me = state.getPlayerId();

            List<Card> newStateCards = new ArrayList(rsp.getHintCards());
            ClientGameState newState = new ClientGameState(me, newStateCards,
                    state.getPlayers());
            newStateCards.addAll(rsp.getActionCards());

            newState.pushGameLog("Game Started");
            newState.setDeckCardCount(rsp.getDeckCardCount());
            newState.setPlayers(rsp.getPlayers());
            newState.setPlayerTurnOrder(rsp.getPlayerTurnOrder());
            newState.setCurrentActivePlayer(rsp.getCurrentActivePlayer());
            newState.setDestToPlayerId(rsp.getDestToPlayerID());
            this.setState(newState);
        }
        else if (this.state instanceof ClientGameState)
        {
            ClientGameState state = (ClientGameState) this.state;
            state.setDeckCardCount(rsp.getDeckCardCount());
            state.setPlayers(rsp.getPlayers());
            state.setPlayerTurnOrder(rsp.getPlayerTurnOrder());
            state.setCurrentActivePlayer(rsp.getCurrentActivePlayer());
            state.setDestToPlayerId(rsp.getDestToPlayerID());

            state.pushGameLog("Game state updated:" + "\n   Deck Card Count: "
                    + rsp.getDeckCardCount() + "\n   Player Turn Order: "
                    + state.getPlayerNames(rsp.getPlayerTurnOrder())
                    + "\n   Current Active Player: " + state.getPlayerName(rsp.
                            getCurrentActivePlayer()));
        }
        else
        {
            System.err.println("Received GameStateResponse while not in "
                    + "ClientGameState.");
            return;
        }
    }

    private void reactToCardDealResponse(CardDealResponse rsp)
    {
        if (loser)
        {
            guiCtrl.endTurn();
            return;
        }
        
        if (!(this.state instanceof ClientGameState))
        {
            System.err.println("Received CardDealResponse while not in "
                    + "ClientGameState.");
            return;
        }

        ClientGameState state = (ClientGameState) this.state;
        state.setMyTurn(true);
        state.pushGameLog("Turn started");

        Card card = rsp.getCard();
        if (card != null)
        {
            state.addToHand(rsp.getCard());
            state.pushGameLog("Card dealt: " + translate.translateName(
                    rsp.getCard().toString()));
        }
        else
        {
            this.triggerChange();
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
    private void reactToRevealCardResponse(RevealCardResponse rsp)
    {
        if (!(this.state instanceof ClientGameState))
        {
            System.err.println("Received RevealCardRequest while not in "
                    + "ClientGameState.");
            return;
        }

        System.out.println("The following cards were revealed to you: ");

        for (Card c : rsp.getCards())
        {
            if (c instanceof HintCard)
            {
                HintCard hintCard = (HintCard) c;
                translate.translateName(hintCard.toString());
            }
        }

        ClientGameState state = (ClientGameState) this.state;
        state.setRevealed(rsp.getCards());
        state.setRevealStatus(true);

//         ActionCardType type = rsp.getActionCard().getActionType();
//         if (type == ActionCardType.SUGGESTION)
//         {
//             List<Card> cards = rsp.getCards();
//             // TODO: GUI
//             // tell GUI to present cards
//         }
//         else if (type == ActionCardType.SNOOP || type
//                 == ActionCardType.ALL_SNOOP)
//         {
//             List<Card> hints = new ArrayList<Card>(state.getHand());
//             int index = 0;
//             while (index < hints.size())
//             {
//                 if (hints.get(index) instanceof ActionCard)
//                 {
//                     hints.remove(index);
//                 }
//                 else
//                 {
//                     ++index;
//                 }
//             }
//             Collections.shuffle(hints);
//             Card card = hints.get(0);
//             // TODO: GUI
//             // tell GUI card was shown to user rsp.getPlayerId()
//         }
//         else if (type == ActionCardType.SUPER_SLEUTH)
//         {
//             // get condition from this card
//             // TODO: GUI
//             // prompt GUI to present user with choice of cards that match
//             //  condition
//         }
//         else if (type == ActionCardType.PRIVATE_TIP)
//         {
//             // get condition from this card
//             // TODO: GUI
//             // prompt GUI to present user with choice of cards that match
//             //  condition
//         }
    }

    private void reactToAccusationResponse(AccusationResponse rsp)
    {
        Solution solution = rsp.getSolution();

        if (this.accused)
        {
            if (state instanceof ClientGameState)
            {
                ClientGameState gameState = (ClientGameState) state;
                Solution sol = rsp.getSolution();

                if (rsp.getCorrectAccusation())
                {
                    gameState.pushGameLog("You win!");
                    gameState.pushGameLog("Solution: " + 
                            translate.translateName(sol.getSuspect().toString())
                            + " at " + 
                            translate.translateName(
                                    sol.getDestination().toString()) + " with "
                            + translate.translateName(sol.
                            getVehicle().toString()));
                    gameState.setGameOverStatus(true);
                }
                else
                {
                    gameState.pushGameLog("You lose! Incorrect accusation!");
                    loser = true;
                    gameState.setLoserStatus(true);
                    gameState.setGameOverStatus(true);
                    
                    guiCtrl.endTurn();
                    guiCtrl.disableAccusation();
                }
            }
        }
        else
        {
            if (state instanceof ClientGameState)
            {
                ClientGameState gameState = (ClientGameState) state;
                Solution sol = rsp.getSolution();

                if (rsp.getCorrectAccusation())
                {
                    gameState.pushGameLog("Player " + rsp.getPlayerId()
                            + " wins!");
                    gameState.pushGameLog("Solution: " + 
                            translate.translateName(sol.getSuspect().toString())
                            + " at " + 
                            translate.translateName(
                                    sol.getDestination().toString()) + " with "
                            + translate.translateName(sol.
                            getVehicle().toString()));
                    gameState.setLoserStatus(true);
                    gameState.setGameOverStatus(true);
                }
                else
                {
                    gameState.pushGameLog("Player " + rsp.getPlayerId()
                            + " loses due to an incorrect accusation!");
                    gameState.pushGameLog("Their guess: " + 
                            translate.translateName(sol.getSuspect().toString())
                            + " at " + 
                            translate.translateName(
                                    sol.getDestination().toString()) + " with "
                            + translate.translateName(sol.
                            getVehicle().toString()));
                }
            }
        }
    }

    private void removePlayerFromClientLobbyState(Integer playerId)
    {
        ClientLobbyState state = (ClientLobbyState) this.state;

        state.removePlayer(playerId);

        if (playerId.equals(state.getPlayerId()))
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

    private void reactToSuggestionResponse(SuggestionResponse rsp)
    {
        if (!(this.state instanceof ClientGameState))
        {
            System.err.println("Received SuggestionResponse while not in " +
                    "ClientGameState.");
            return;
        }

        ClientGameState state = (ClientGameState) this.state;

        HintCard refutingCard = rsp.getRefutingCard();
        Solution solution = rsp.getSuggestion();
        Integer refutingID = rsp.getRefutingPlayerID();
        Integer suggID = rsp.getSuggestorID();

        if (!state.getPlayerId().equals(suggID))
        {
            state.pushGameLog(state.getPlayerName(suggID) +
                    " suggested " + translate.translateName(
                            solution.getSuspect().toString()) +
                    " got to " + translate.translateName(
                            solution.getDestination().toString()) +
                    " using a " + translate.translateName(
                            solution.getVehicle().toString()));
        }
        else
        {
            if (refutingCard == null)
            {
                state.pushGameLog("Your suggestion could not be refuted.");
            }
            else
            {
                List<Card> revealed = new ArrayList<Card>();
                revealed.add(refutingCard);
                state.setRevealed(revealed);
                state.setRevealStatus(true);

                state.pushGameLog(state.getPlayerName(refutingID) +
                        " refuted your suggestion with " +
                        translate.translateName(refutingCard.toString()));
            }
        }
    }
}
