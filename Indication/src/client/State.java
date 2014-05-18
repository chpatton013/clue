/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.util.Observable;

/**
 * The state for the client
 * @author dmangin
 */
public class State extends Observable 
{
    private String hostname;
    
    public String getHostName() 
    {
        return hostname;
    }
    
    public void setHostName(String hostname) 
    {
        this.hostname = hostname;
    }
}
