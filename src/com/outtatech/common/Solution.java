package com.outtatech.common;

import java.io.Serializable;

/**
 * Version-latenightpizzaparty
 * Object that represents a solution set to a clue game.
 *
 * @author jbilous
 */
public class Solution implements Serializable
{
    private DestinationID destSolution;
    private VehicleID vehicleSolution;
    private SuspectID suspectSolution;

    /**
     * Version-latenightpizzaparty
     * Creates a new Solution object.
     * @param dest method parameter
     * @param vehicle method parameter
     * @param suspect method parameter
     */
    public Solution(DestinationID dest, VehicleID vehicle, SuspectID suspect)
    {
        this.destSolution = dest;
        this.vehicleSolution = vehicle;
        this.suspectSolution = suspect;
    }

    /**
     * Version-latenightpizzaparty
     * Getter method for the solutions destination ID.
     *
     * @return the destination ID of this solution. return value
     */
    public DestinationID getDestination()
    {
        return destSolution;
    }

    /**
     * Version-latenightpizzaparty
     * Getter method for the solutions vehicle ID.
     *
     * @return the vehicle ID of this solution. return value
     */
    public VehicleID getVehicle()
    {
        return vehicleSolution;
    }

    /**
     * Version-latenightpizzaparty
     * Getter method for the solutions suspect ID.
     *
     * @return the suspect ID of this solution. return value
     */
    public SuspectID getSuspect()
    {
        return suspectSolution;
    }

    /**
     * Version-latenightpizzaparty
     * Equals method that determines whether another solution is equal to this
     * one.
     *
     * @param obj the object to be compared. method parameter
     * @return whether or not the solutions are equal. return value
     */
    public boolean equals(Object obj)
    {
        // Guard against this
        if (obj instanceof Solution)
        {
            Solution otherSol = (Solution) obj;

            return destSolution.equals(otherSol.getDestination())
                    && vehicleSolution.equals(otherSol.getVehicle())
                    && suspectSolution.equals(otherSol.getSuspect());
        }

        return false;
    }
}
