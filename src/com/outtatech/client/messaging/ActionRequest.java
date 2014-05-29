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
    private Integer playerId;

    /**
     * Version-latenightpizzaparty
     * Returns a new ActionRequest object.
     *
     * @param actionCard the action card that the client is playing method 
     * parameter
     * @param playerId the id of the player the action is targeting method 
     * parameter
     */
    public ActionRequest(ActionCard actionCard, Integer playerId)
    {
        this.actionCard = actionCard;
        this.playerId = playerId;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the action card involved in the user action.
     *
     * @return the action card involved in the user action. return value
     */
    public ActionCard getActionCard()
    {
        return actionCard;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the Id of the player requested
     *
     * @return the integer ID of the player return value
     */
    public Integer getPlayerId()
    {
        return playerId;
    }
}
