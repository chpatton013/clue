/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.util.Observable;

/**
 * State is basic class composed of functions to get
 * and set a host name.  Classes that extend State inherit
 * the get and set functions for a host name and also inherit
 * the properties of the class Observable.
 * @author dmangin
 */
public class State extends Observable 
{
    private String hostname;
    
    /**
     * Get the host name associated with this instance.
     * @return String host name.
     */
    private String getHostName() 
    {
        return hostname;
    }
    
    /**
     * Set the host name that the State instance will use.
     * @param hostname String
     */
    public void setHostName(String hostname) 
    {
        
    }
}
