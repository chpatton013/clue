package com.outtatech.client.messaging;

import com.outtatech.common.ActionCard;
import com.outtatech.common.Card;
import java.util.List;

/**
 * Version-latenightpizzaparty
 * Message sent from the client to the server when an action card is played or
 * an accusation is made.
 *
 * @author jbilous
 */
public class ActionRequest extends ClientRequest
{
    private ActionCard actionCard;
    private List<Card> cards;
    private Integer playerId;

    /**
     * Version-latenightpizzaparty
     * Returns a new ActionRequest object.
     *
     * @param actionCard the action card that the client is playing
     * @param cards the cards involved in the action
     * @param playerID the id of the player the action is targeting
     */
    public ActionRequest(ActionCard actionCard, List<Card> cards, int playerId)
    {
        this.actionCard = actionCard;
        this.cards = cards;
        this.playerId = playerId;
    }

    /**
     * Version-latenightpizzaparty
     * Returns a new ActionRequest object.
     *
     * @param actionCard the action card that the client is playing
     * @param cards the cards involved in the action
     */
    public ActionRequest(ActionCard actionCard, List<Card> cards)
    {
        this.actionCard = actionCard;
        this.cards = cards;
        this.playerId = playerId;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the action card involved in the user action.
     *
     * @return the action card involved in the user action.
     */
    public ActionCard getActionCard()
    {
        return actionCard;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the cards involved in the clients action.
     *
     * @return the cards involved in the clients action.
     */
    public List<Card> getCards()
    {
        return cards;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the Id of the player requested
     *
     * @return the integer ID of the player
     */
    public Integer getPlayerId()
    {
        return playerId;
    }
}
