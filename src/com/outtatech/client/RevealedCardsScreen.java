package com.outtatech.client;

import com.outtatech.common.ActionCard;
import com.outtatech.common.ActionCardType;
import com.outtatech.common.Card;
import com.outtatech.common.CardType;
import com.outtatech.common.DestinationCard;
import com.outtatech.common.DestinationID;
import com.outtatech.common.HintCard;
import com.outtatech.common.HintCardType;
import com.outtatech.common.PrivateTip;
import com.outtatech.common.PrivateTipType;
import com.outtatech.common.Suggestion;
import com.outtatech.common.SuggestionType;
import com.outtatech.common.SuperSleuth;
import com.outtatech.common.SuperSleuthType;
import com.outtatech.common.SuspectCard;
import com.outtatech.common.SuspectID;
import com.outtatech.common.VehicleCard;
import com.outtatech.common.VehicleID;
import java.awt.List;
import javax.swing.ImageIcon;

/**
 * Version-latenightpizzaparty
 *
 * @author Thomas
 */
public class RevealedCardsScreen extends javax.swing.JFrame
{

    private int curCards = 0;
    GUIController controller;

    /**
     * Version-latenightpizzaparty
     * Creates new form RevealedCardsScreen
     */
    public RevealedCardsScreen()
    {
        initComponents();
    }
    
    public RevealedCardsScreen(GUIController ctrl)
    {
        controller = ctrl;
        
        initComponents();
    }
    
     public void setCards(java.util.List<Card> cards)
    {
        String path = controller.getImagePath();
        String image;
        boolean[] filled =
        {
            false, false, false, false, false, false, false, false
        };
        Card card;
        // Iterate over this set
        for (int indx = 0; indx < cards.size(); indx++)
        {
            card = cards.get(indx);
            if (card.getCardType() == CardType.HINT)
            {
                // Guard against this
                if (((HintCard) card).getHintType() == HintCardType.DESTINATION)
                {
                    // Guard against this
                    if (((DestinationCard) card).getDestination()
                            == DestinationID.CONEY_ISLAND)
                    {
                        image = "Location-1.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.GOLDEN_GATE_BRIDGE)
                    {
                        image = "Location-2.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.HOOVER_DAM)
                    {
                        image = "Location-3.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.LINCOLN_MEMORIAL)
                    {
                        image = "Location-4.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.MIAMI_BEACH)
                    {
                        image = "Location-5.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.MT_RUSHMORE)
                    {
                        image = "Location-6.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.NIAGRA_FALLS)
                    {
                        image = "Location-7.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.OLD_FAITHFUL)
                    {
                        image = "Location-8.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.THE_ALAMO)
                    {
                        image = "Location-9.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                }
                // Otherwise...
                else if (((HintCard) card).getHintType() == HintCardType.SUSPECT)
                {
                    // Guard against this
                    if (((SuspectCard) card).getSuspect() == SuspectID.GREEN)
                    {
                        image = "GREEN.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((SuspectCard) card).getSuspect()
                            == SuspectID.MUSTARD)
                    {
                        image = "MUSTARD.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((SuspectCard) card).getSuspect()
                            == SuspectID.PEACOCK)
                    {
                        image = "PEACOCK.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((SuspectCard) card).getSuspect() == SuspectID.PLUM)
                    {
                        image = "PLUM.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((SuspectCard) card).getSuspect()
                            == SuspectID.SCARLET)
                    {
                        image = "SCARLET.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((SuspectCard) card).getSuspect()
                            == SuspectID.WHITE)
                    {
                        image = "WHITE.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                }
                // Otherwise...
                else if (((HintCard) card).getHintType() == HintCardType.VEHICLE)
                {
                    // Guard against this
                    if (((VehicleCard) card).getVehicle() == VehicleID.AIRLINER)
                    {
                        image = "AIRLINER.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((VehicleCard) card).getVehicle()
                            == VehicleID.AUTOMOBILE)
                    {
                        image = "AUTOMOBILE.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((VehicleCard) card).getVehicle()
                            == VehicleID.HOT_AIR_BALLOON)
                    {
                        image = "HOTAIRBALLOON.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((VehicleCard) card).getVehicle()
                            == VehicleID.LIMOUSINE)
                    {
                        image = "LIMOSINE.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((VehicleCard) card).getVehicle()
                            == VehicleID.SEAPLANE)
                    {
                        image = "SEAPLANE.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    // Otherwise...
                    else if (((VehicleCard) card).getVehicle()
                            == VehicleID.TRAIN)
                    {
                        image = "TRAIN.jpg";
                        // Guard against this
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        // Otherwise...
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                }
            }
        }
        if (!filled[2])
        {
            hintImage1.setIcon(new ImageIcon());
        }
        // Guard against this
        if (!filled[3])
        {
            hintImage2.setIcon(new ImageIcon());
        }
        // Guard against this
        if (!filled[4])
        {
            hintImage3.setIcon(new ImageIcon());
        }
        // Guard against this
        if (!filled[5])
        {
            hintImage4.setIcon(new ImageIcon());
        }
        // Guard against this
        if (!filled[6])
        {
            hintImage5.setIcon(new ImageIcon());
        }
        // Guard against this
        if (!filled[7])
        {
            hintImage6.setIcon(new ImageIcon());
        }
    }

    /**
     * Version-latenightpizzaparty
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        hintImage1 = new javax.swing.JLabel();
        hintImage2 = new javax.swing.JLabel();
        hintImage3 = new javax.swing.JLabel();
        hintImage4 = new javax.swing.JLabel();
        hintImage5 = new javax.swing.JLabel();
        hintImage6 = new javax.swing.JLabel();

        jLabel1.setText("These cards have been shown to you");

        jButton1.setText("Close");

        hintImage1.setText("I1");

        hintImage2.setText("I2");

        hintImage3.setText("I3");

        hintImage4.setText("I4");

        hintImage5.setText("I5");

        hintImage6.setText("I6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hintImage1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hintImage2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hintImage3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hintImage4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hintImage5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hintImage6)))
                        .addGap(0, 185, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hintImage1)
                    .addComponent(hintImage2)
                    .addComponent(hintImage3)
                    .addComponent(hintImage4)
                    .addComponent(hintImage5)
                    .addComponent(hintImage6))
                .addGap(97, 97, 97)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Version-latenightpizzaparty
     * @param args the command line arguments method parameter
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        // Just in case...
        try
        {
            // Iterate over this set
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                // Guard against this
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(RevealedCardsScreen.class.
                    getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(RevealedCardsScreen.class.
                    getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(RevealedCardsScreen.class.
                    getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(RevealedCardsScreen.class.
                    getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new RevealedCardsScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hintImage1;
    private javax.swing.JLabel hintImage2;
    private javax.swing.JLabel hintImage3;
    private javax.swing.JLabel hintImage4;
    private javax.swing.JLabel hintImage5;
    private javax.swing.JLabel hintImage6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
