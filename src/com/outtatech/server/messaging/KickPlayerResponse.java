package com.outtatech.server.messaging;

/**
 * Version-latenightpizzaparty
 * Message sent from the server to the client in response to a request to have a
 * player kicked.
 *
 * @author jbilous
 */
public class KickPlayerResponse extends ServerResponse
{
    private int playerId;

    /**
     * Version-latenightpizzaparty
     * Creates a new KickPlayerResponse object.
     *
     * @param playerId The Id of the player kicked from the game method parameter
     */
    public KickPlayerResponse(int playerId)
    {
        this.playerId = playerId;
    }

    /**
     * Version-latenightpizzaparty
     * Getter method for the Id of the player kicked
     *
     * @return Id of the player kicked return value
     */
    public int getPlayerId()
    {
        return playerId;
    }
}
