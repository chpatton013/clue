package com.outtatech.server.messaging;

/**
 * Message passed from the server to the client in response to a player joining
 * an existing lobby.
 *
 * @author jbilous
 */
public class LobbyLeaveResponse extends ServerResponse
{
    private Integer playerId;

    /**
     *
     * @param playerId
     */
    public LobbyLeaveResponse(Integer playerId)
    {
        this.playerId = playerId;
    }

    /**
     *
     * @return
     */
    public Integer getPlayerId()
    {
        return this.playerId;
    }
}
