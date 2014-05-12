/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client.messaging;

/**
 * Message sent from the client to the server when the client desires
 * a list of currently active games.
 * 
 * @author jbilous
 */
public class LobbyListRequest extends ClientRequest {
    
    /**
     * Creates a new LobbyListRequest object.
     */
    public LobbyListRequest() {
        
    }
}
