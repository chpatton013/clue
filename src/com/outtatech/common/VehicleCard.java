package com.outtatech.common;

/**
 * Version-latenightpizzaparty
 * A VehicleCard represents a HintCard that specifies a certain Vehicle ID.
 *
 * @author bennettschalich
 */
public class VehicleCard extends HintCard
{
    /*A unique Vehicle*/
    VehicleID vehicle;
    boolean isAir;
    CardColor color;

    /**
     * Version-latenightpizzaparty
     * Constructs a new VehicleCard
     *
     * @param vehicle A unique vehicle ID method parameter
     * @param cardColor method parameter
     */
    public VehicleCard(VehicleID vehicle, CardColor cardColor)
    {
        super(HintCardType.VEHICLE);
        this.vehicle = vehicle;
        this.color = cardColor;

        // Guard against this
        if (this.vehicle == VehicleID.SEAPLANE || this.vehicle
                == VehicleID.AIRLINER || this.vehicle
                == VehicleID.HOT_AIR_BALLOON)
        {
            isAir = true;
        }
        // Otherwise...
        else
        {
            isAir = false;
        }
    }

    /**
     * Version-latenightpizzaparty
     * Returns the Vehicle ID this VehicleCard has.
     *
     * @return A vehicle ID. return value
     */
    public VehicleID getVehicle()
    {
        return vehicle;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public boolean getIsAir()
    {
        return isAir;
    }

    /**
     * Version-latenightpizzaparty
     *
     * @return return value
     */
    public CardColor getCardColor()
    {
        return color;
    }
}
