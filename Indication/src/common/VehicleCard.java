/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

/**
 *
 * @author bennettschalich
 */
public class VehicleCard extends HintCard
{
    VehicleID vehicle;
    
    public VehicleCard(VehicleID vehicle)
    {
        super(HintCardType.VEHICLE);
        this.vehicle = vehicle;
    }
    
    public VehicleID getVehicle()
    {
        return vehicle;
    }
}
