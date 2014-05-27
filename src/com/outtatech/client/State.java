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
     *
     * @param o
     */
    @Override
    public void addObserver(Observer o)
    {
        observers.add(o);
        super.addObserver(o);
    }

    /**
     * Returns the list of Observer classes.
     *
     * @return observers
     */
    public CopyOnWriteArrayList<Observer> getObservers()
    {
        return observers;
    }

    /**
     * Adds the observers from another State instance to this instance.
     *
     * @param observers
     */
    public void addOldStatesObservers(CopyOnWriteArrayList<Observer> observers)
    {
        // Iterate over this set
        for (Observer o : observers)
        {
            this.addObserver(o);
        }
    }

    /**
     * Set the instance as changed, and notify observers.
     */
    public void triggerChange()
    {
        this.setChanged();
        this.notifyObservers();
    }
}
