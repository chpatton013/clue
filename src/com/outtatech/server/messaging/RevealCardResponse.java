package com.outtatech.server.messaging;

import com.outtatech.common.Card;
import com.outtatech.common.ActionCard;
import java.util.List;

/**
 * Message sent from the server to a client when a card is played that requires
 * them to show one or more of their cards.
 *
 * @author jbilous
 */
public class RevealCardResponse extends ServerResponse
{

    private ActionCard actionCard;
    private List<Card> cards;

    /**
     * Creates a new RevealCardRequest object.
     *
     * @param playerId the id of the player the cards are being revealed to.
     * @param actionCard the card that has triggered this reveal action.
     * @param cards the list of cards that this reveal action may want.
     */
    public RevealCardResponse(ActionCard actionCard,
          List<Card> cards)
    {
        this.actionCard = actionCard;
        this.cards = cards;
    }

    /**
     * Returns the cards that has triggered this reveal action.
     *
     * @return the card that has triggered this reveal action.
     */
    public ActionCard getActionCard()
    {
        return this.actionCard;
    }

    /**
     * Returns the list of cards this reveal action may want.
     *
     * @return the list of cards this reveal action may want.
     */
    public List<Card> getCards()
    {
        return this.cards;
    }
}
