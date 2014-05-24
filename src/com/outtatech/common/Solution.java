/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.common;

/**
 * Object that represents a solution set to a clue game.
 * 
 * @author jbilous
 */
public class Solution
{
    private DestinationID destSolution;
    private VehicleID vehicleSolution;
    private SuspectID suspectSolution;
    
    /**
     * Creates a new Solution object.
     */
    public Solution(DestinationID dest, VehicleID vehicle, SuspectID suspect) 
    {
        this.destSolution = dest;
        this.vehicleSolution = vehicle;
        this.suspectSolution = suspect;
    }
    
    /**
     * Getter method for the solutions destination ID.
     * @return the destination ID of this solution.
     */
    public DestinationID getDestination() {
        return destSolution;
    }
    
    /**
     * Getter method for the solutions vehicle ID.
     * @return the vehicle ID of this solution.
     */
    public VehicleID getVehicle() {
        return vehicleSolution;
    }
    
    /**
     * Getter method for the solutions suspect ID.
     * @return the suspect ID of this solution.
     */
    public SuspectID getSuspect() {
        return suspectSolution;
    }
    
    /**
     * Equals method that determines whether another solution is equal to this
     * one.
     * @param obj the object to be compared.
     * @return whether or not the solutions are equal.
     */
    public boolean equals(Object obj) 
    {
        if(obj instanceof Solution) {
            Solution otherSol = (Solution)obj;
            
            return destSolution.equals(otherSol.getDestination())
                    && vehicleSolution.equals(otherSol.getVehicle())
                    && suspectSolution.equals(otherSol.getSuspect());
        }
        
        return false;
    }
}
