package com.outtatech.server.messaging;

import com.outtatech.common.Card;
import com.outtatech.common.HintCard;
import com.outtatech.common.Player;
import java.util.List;
import java.util.Map;

/**
 * Message sent from the server to the client that encapsulates the server's
 * representation of a game.
 *
 * @author jbilous
 */
public class GameStateResponse extends ServerResponse
{

    private Integer deckCardCount;
    private List<Integer> playerTurnOrder;
    private Integer currentActivePlayer;
    private Map<Integer, String> players;
    private List<HintCard> hintCards;

    /**
     * Constructs a new GameStateResponse object
     *
     * @param deckCardCount the number of cards in the game's deck
     * @param playerTurnOrder list of player ID's that represents turn order
     * @param currentActivePlayer id of the currently active player
     */
    public GameStateResponse(Integer deckCardCount,
            List<Integer> playerTurnOrder, Integer currentActivePlayer, 
            Map<Integer, String> players, List<HintCard> hintCards)
    {
        this.deckCardCount = deckCardCount;
        this.players = players;
        this.hintCards = hintCards;
        this.playerTurnOrder = playerTurnOrder;
        this.currentActivePlayer = currentActivePlayer;
    }

    /**
     * Returns the number of cards in the Game's deck.
     *
     * @return the number of cards in the Game's deck
     */
    public Integer getDeckCardCount()
    {
        return deckCardCount;
    }
    
    public Map<Integer, String> getPlayers()
    {
        return players;
    }

    /**
     * Returns a list representing the order in which players take their turns.
     *
     * @return a list representing the order in which players take their turns.
     */
    public List<Integer> getPlayerTurnOrder()
    {
        return playerTurnOrder;
    }

    /**
     * Returns the id of the player whose turn is currently active.
     *
     * @return the id of the player whose turn is currently active.
     */
    public Integer getCurrentActivePlayer()
    {
        return currentActivePlayer;
    }
    
    /**
     * Returns a list of the players Hint Cards.
     * @return hintCards
     */
    public List<HintCard> getHintCards()
    {
        return hintCards;
    }
}
