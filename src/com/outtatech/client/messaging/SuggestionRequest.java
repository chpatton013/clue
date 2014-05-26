/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client.messaging;

import com.outtatech.common.Solution;

/**
 * Message sent from the client to the server when they would like to make
 * a suggestion.
 * 
 * @author jbilous
 */
public class SuggestionRequest extends ClientRequest
{
    private Solution suggestion;
    
    public SuggestionRequest(Solution suggestion) 
    {
        this.suggestion = suggestion;
    }
    
    public Solution getSuggestion()
    {
        return this.suggestion;
    }
    
}
