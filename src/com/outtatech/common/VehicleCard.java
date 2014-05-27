package com.outtatech.common;

/**
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
     * Constructs a new VehicleCard
     *
     * @param vehicle A unique vehicle ID
     * @param cardColor
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
     * Returns the Vehicle ID this VehicleCard has.
     *
     * @return A vehicle ID.
     */
    public VehicleID getVehicle()
    {
        return vehicle;
    }

    /**
     *
     * @return
     */
    public boolean getIsAir()
    {
        return isAir;
    }

    /**
     *
     * @return
     */
    public CardColor getCardColor()
    {
        return color;
    }
}
