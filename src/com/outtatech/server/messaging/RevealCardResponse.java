package com.outtatech.server.messaging;

import com.outtatech.common.Card;
import com.outtatech.common.ActionCard;
import java.util.List;

/**
 * Version-latenightpizzaparty
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
     * Version-latenightpizzaparty
     * Creates a new RevealCardRequest object.
     *
     * @param actionCard the card that has triggered this reveal action. method parameter
     * @param cards the list of cards that this reveal action may want. method parameter
     */
    public RevealCardResponse(ActionCard actionCard,
            List<Card> cards)
    {
        this.actionCard = actionCard;
        this.cards = cards;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the cards that has triggered this reveal action.
     *
     * @return the card that has triggered this reveal action. return value
     */
    public ActionCard getActionCard()
    {
        return this.actionCard;
    }

    /**
     * Version-latenightpizzaparty
     * Returns the list of cards this reveal action may want.
     *
     * @return the list of cards this reveal action may want. return value
     */
    public List<Card> getCards()
    {
        return this.cards;
    }
}
