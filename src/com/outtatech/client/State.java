/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outtatech.client;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * State is basic class composed of functions to get and set a host name.
 * Classes that extend State inherit the get and set functions for a host name
 * and also inherit the properties of the class Observable.
 *
 * @author dmangin
 */
public class State extends Observable
{
    private String hostname;
    private CopyOnWriteArrayList<Observer> observers
            = new CopyOnWriteArrayList<Observer>();
    
    /**
     * Get the host name associated with this instance.
     *
     * @return String host name.
     */
    public String getHostName()
    {
        return hostname;
    }

    /**
     * Set the host name that the State instance will use.
     *
     * @param hostname String
     */
    public void setHostName(String hostname)
    {
        this.hostname = hostname;
    }
    
    /**
     * Override parent method to enable storing observers.
     * @param o 
     */
    @Override
    public void addObserver(Observer o)
    {
        observers.add(o);
        super.addObserver(o);
    }
    
    public CopyOnWriteArrayList<Observer> getObservers()
    {
        return observers;
    }
    
    public void addOldStatesObservers(CopyOnWriteArrayList<Observer> observers)
    {
        for(Observer o : observers)
           this.addObserver(o);
    }
    
    public void triggerChange()
    {
        this.setChanged();
        this.notifyObservers();
    }
}
