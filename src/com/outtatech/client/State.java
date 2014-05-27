package com.outtatech.client;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Version-latenightpizzaparty
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
     * Version-latenightpizzaparty
     * Get the host name associated with this instance.
     *
     * @return String host name. return value
     */
    public String getHostName()
    {
        return hostname;
    }

    /**
     * Version-latenightpizzaparty
     * Set the host name that the State instance will use.
     *
     * @param hostname String method parameter
     */
    public void setHostName(String hostname)
    {
        this.hostname = hostname;
    }

    /**
     * Version-latenightpizzaparty
     * Override parent method to enable storing observers.
     *
     * @param o method parameter
     */
    @Override
    public void addObserver(Observer o)
    {
        observers.add(o);
        super.addObserver(o);
    }

    /**
     * Version-latenightpizzaparty
     * Returns the list of Observer classes.
     *
     * @return observers return value
     */
    public CopyOnWriteArrayList<Observer> getObservers()
    {
        return observers;
    }

    /**
     * Version-latenightpizzaparty
     * Adds the observers from another State instance to this instance.
     *
     * @param observers method parameter
     */
    public void addOldStatesObservers(CopyOnWriteArrayList<Observer> observers)
    {
        // Iterate over this set
        for (Observer obs : observers)
        {
            this.addObserver(obs);
        }
    }

    /**
     * Version-latenightpizzaparty
     * Set the instance as changed, and notify observers.
     */
    public void triggerChange()
    {
        this.setChanged();
        this.notifyObservers();
    }
}
