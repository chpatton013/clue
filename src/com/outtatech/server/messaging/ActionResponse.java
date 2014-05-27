package com.outtatech.server.messaging;

import com.outtatech.common.ActionCard;

/**
 * Message sent from the server to one or more client in response to a player
 * playing an action card.
 *
 * @author jbilous
 */
public class ActionResponse extends ServerResponse
{

    private ActionCard actionCard;
    private Integer playerId;

    /**
     * Creates a new ActionResponse object
     */
    public ActionResponse(ActionCard actionCard, Integer playerId)
    {
        this.actionCard = actionCard;
        this.playerId = playerId;
    }

    /**
     * Returns the action card that was played by the client.
     *
     * @return the action card that was played by the client.
     */
    public ActionCard getActionCard()
    {
        return actionCard;
    }

    /**
     * Returns the ID of the player who played the action card
     *
     * @return the ID of the player who played the action card.
     */
    public Integer getPlayerId()
    {
        return playerId;
    }

}
