package com.outtatech.server.messaging;

import com.outtatech.common.ActionCard;
import com.outtatech.common.Card;
import java.util.List;

/**
 * Version-latenightpizzaparty
 * Message sent from the server to the client when a card is dealt to them.
 *
 * @author jbilous
 */
public class CardDealResponse extends ServerResponse
{
    private final ActionCard card;

    /**
     * Version-latenightpizzaparty
     * Creates a new CardDealResponse object.
     *
     * @param cards list of cards that have been dealt. method parameter
     */
    public CardDealResponse(ActionCard card)
    {
        this.card = card;
    }

    /**
     * Version-latenightpizzaparty
     * Getter methods for the cards dealt to the player.
     *
     * @return card dealt to the player. return value
     */
    public ActionCard getCard()
    {
        return card;
    }
}
