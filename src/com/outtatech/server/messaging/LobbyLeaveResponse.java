package com.outtatech.server.messaging;

/**
 * Version-latenightpizzaparty
 * Message passed from the server to the client in response to a player joining
 * an existing lobby.
 *
 * @author jbilous
 */
public class LobbyLeaveResponse extends ServerResponse
{
    private Integer playerId;

    /**
     * Version-latenightpizzaparty
     *
     * @param playerId
     */
    public LobbyLeaveResponse(Integer playerId)
    {
        this.playerId = playerId;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return
     */
    public Integer getPlayerId()
    {
        return this.playerId;
    }
}
