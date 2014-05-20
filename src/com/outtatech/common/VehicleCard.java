/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.common;

/**
 * A VehicleCard represents a HintCard that specifies a certain Vehicle 
 * ID.
 * @author bennettschalich
 */
public class VehicleCard extends HintCard
{
    /*A unique Vehicle*/
    VehicleID vehicle;
    
    /**
     * Constructs a new VehicleCard
     * @param vehicle A unique vehicle ID
     */ 
    public VehicleCard(VehicleID vehicle)
    {
        super(HintCardType.VEHICLE);
        this.vehicle = vehicle;
    }
    
    /**
     * Returns the Vehicle ID this VehicleCard has.
     * @return A vehicle ID.
     */
    public VehicleID getVehicle()
    {
        return vehicle;
    }
}