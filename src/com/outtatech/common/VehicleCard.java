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
    private VehicleID vehicle;
    private boolean isAir;
    private CardColor color;

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

    public String toString()
    {
        if (this.vehicle == VehicleID.SEAPLANE)
        {
            return "SEAPLANE";
        }
        else if (this.vehicle == VehicleID.AUTOMOBILE)
        {
            return "AUTOMOBILE";
        }
        else if (this.vehicle == VehicleID.AIRLINER)
        {
            return "AIRLINER";
        }
        else if (this.vehicle == VehicleID.HOT_AIR_BALLOON)
        {
            return "HOT_AIR_BALLOON";
        }
        else if (this.vehicle == VehicleID.LIMOUSINE)
        {
            return "LIMOUSINE";
        }
        else if (this.vehicle == VehicleID.TRAIN)
        {
            return "TRAIN";
        }
        else
        {
            return super.toString();
        }
    }
}
