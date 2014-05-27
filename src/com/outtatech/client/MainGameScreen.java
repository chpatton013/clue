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
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Thomas
 */
public class MainGameScreen extends javax.swing.JFrame
{

    private ArrayList playerIds = new ArrayList();

    int selectedPlayer = -1;

    GUIController controller;

    ActionCard[] actionCards =
    {
        null, null
    };

    /**
     * Creates new form MainGameScreen
     */
    public MainGameScreen()
    {
        initComponents();
    }

    /**
     * Alternate constructor to take a GUIController in
     *
     * @param ctrl
     */
    public MainGameScreen(GUIController ctrl)
    {
        //set controller to ctrl
        controller = ctrl;

        initComponents();

        locationImage1.setText("");
        locationImage2.setText("");
        locationImage3.setText("");
        locationImage4.setText("");
        locationImage5.setText("");
        locationImage6.setText("");
        locationImage7.setText("");
        locationImage8.setText("");
        locationImage9.setText("");

        updateLocation();

        actionImage1.setText("");
        actionImage2.setText("");

        hintImage1.setText("");
        hintImage2.setText("");
        hintImage3.setText("");
        hintImage4.setText("");
        hintImage5.setText("");
        hintImage6.setText("");

        endTurn();
    }

    public void updateLocation()
    {
        String path = controller.getImagePath();
        locationImage1.setIcon(new ImageIcon(path + "Location-1.jpg"));
        locationImage2.setIcon(new ImageIcon(path + "Location-2.jpg"));
        locationImage3.setIcon(new ImageIcon(path + "Location-3.jpg"));
        locationImage4.setIcon(new ImageIcon(path + "Location-4.jpg"));
        locationImage5.setIcon(new ImageIcon(path + "Location-5.jpg"));
        locationImage6.setIcon(new ImageIcon(path + "Location-6.jpg"));
        locationImage7.setIcon(new ImageIcon(path + "Location-7.jpg"));
        locationImage8.setIcon(new ImageIcon(path + "Location-8.jpg"));
        locationImage9.setIcon(new ImageIcon(path + "Location-9.jpg"));
    }

    public void updateHand(List<Card> cards)
    {
        String path = controller.getImagePath();
        String image;
        boolean[] filled =
        {
            false, false, false, false, false, false, false, false
        };
        Card card;
        actionCards[0] = null;
        actionCards[1] = null;
        for (int indx = 0; indx < cards.size(); indx++)
        {
            card = cards.get(indx);
            if (card.getCardType() == CardType.ACTION)
            {
                path = "./images/actionCards/";
                if (((ActionCard) card).getActionType()
                        == ActionCardType.PRIVATE_TIP)
                {
                    if (((PrivateTip) card).getType()
                            == PrivateTipType.ALL_DESTINATIONS)
                    {
                        image = "Action-PrivateTipAllDestination.jpg";
                        if (!filled[0])
                        {
                            filled[0] = true;
                            actionImage1.setIcon(new ImageIcon(path + image));
                            actionCards[0] = new PrivateTip(
                                    PrivateTipType.ALL_DESTINATIONS);
                        }
                        else if (!filled[1])
                        {
                            filled[1] = true;
                            actionImage2.setIcon(new ImageIcon(path + image));
                            actionCards[1] = new PrivateTip(
                                    PrivateTipType.ALL_DESTINATIONS);
                        }
                    }
                    else if (((PrivateTip) card).getType()
                            == PrivateTipType.ALL_SUSPECTS)
                    {
                        image = "Action-PrivateTipAllSuspect.jpg";
                        if (!filled[0])
                        {
                            filled[0] = true;
                            actionImage1.setIcon(new ImageIcon(path + image));
                            actionCards[0] = new PrivateTip(
                                    PrivateTipType.ALL_SUSPECTS);
                        }
                        else if (!filled[1])
                        {
                            filled[1] = true;
                            actionImage2.setIcon(new ImageIcon(path + image));
                            actionCards[1] = new PrivateTip(
                                    PrivateTipType.ALL_SUSPECTS);
                        }
                    }
                    else if (((PrivateTip) card).getType()
                            == PrivateTipType.ALL_VEHICLES)
                    {
                        image = "Action-PrivateTipAllVehicle.jpg";
                        if (!filled[0])
                        {
                            filled[0] = true;
                            actionImage1.setIcon(new ImageIcon(path + image));
                            actionCards[0] = new PrivateTip(
                                    PrivateTipType.ALL_VEHICLES);
                        }
                        else if (!filled[1])
                        {
                            filled[1] = true;
                            actionImage2.setIcon(new ImageIcon(path + image));
                            actionCards[1] = new PrivateTip(
                                    PrivateTipType.ALL_VEHICLES);
                        }
                    }
                    else if (((PrivateTip) card).getType()
                            == PrivateTipType.ONE_FEMALE_SUSPECT)
                    {
                        image = "Action-PrivateTipFemale.jpg";
                        if (!filled[0])
                        {
                            filled[0] = true;
                            actionImage1.setIcon(new ImageIcon(path + image));
                            actionCards[0] = new PrivateTip(
                                    PrivateTipType.ONE_FEMALE_SUSPECT);
                        }
                        else if (!filled[1])
                        {
                            filled[1] = true;
                            actionImage2.setIcon(new ImageIcon(path + image));
                            actionCards[1] = new PrivateTip(
                                    PrivateTipType.ONE_FEMALE_SUSPECT);
                        }
                    }
                    else if (((PrivateTip) card).getType()
                            == PrivateTipType.ONE_NORTHERN_DESTINATION)
                    {
                        image = "Action-PrivateTipNorthern.jpg";
                        if (!filled[0])
                        {
                            filled[0] = true;
                            actionImage1.setIcon(new ImageIcon(path + image));
                            actionCards[0] = new PrivateTip(
                                    PrivateTipType.ONE_NORTHERN_DESTINATION);
                        }
                        else if (!filled[1])
                        {
                            filled[1] = true;
                            actionImage2.setIcon(new ImageIcon(path + image));
                            actionCards[1] = new PrivateTip(
                                    PrivateTipType.ONE_NORTHERN_DESTINATION);
                        }
                    }
                    else if (((PrivateTip) card).getType()
                            == PrivateTipType.ONE_RED_VEHICLE)
                    {
                        image = "Action-PrivateTipRed.jpg";
                        if (!filled[0])
                        {
                            filled[0] = true;
                            actionImage1.setIcon(new ImageIcon(path + image));
                            actionCards[0] = new PrivateTip(
                                    PrivateTipType.ONE_RED_VEHICLE);
                        }
                        else if (!filled[1])
                        {
                            filled[1] = true;
                            actionImage2.setIcon(new ImageIcon(path + image));
                            actionCards[1] = new PrivateTip(
                                    PrivateTipType.ONE_RED_VEHICLE);
                        }
                    }
                }
                else if (((ActionCard) card).getActionType()
                        == ActionCardType.SUGGESTION)
                {
                    if (((Suggestion) card).getType() == SuggestionType.ANY)
                    {
                        image = "Action-SuggestionAny.jpg";
                        if (!filled[0])
                        {
                            filled[0] = true;
                            actionImage1.setIcon(new ImageIcon(path + image));
                            actionCards[0] = new Suggestion(SuggestionType.ANY);
                        }
                        else if (!filled[1])
                        {
                            filled[1] = true;
                            actionImage2.setIcon(new ImageIcon(path + image));
                            actionCards[1] = new Suggestion(SuggestionType.ANY);
                        }
                    }
                    else if (((Suggestion) card).getType()
                            == SuggestionType.CURRENT)
                    {
                        image = "Action-SuggestionCurrent.jpg";
                        if (!filled[0])
                        {
                            filled[0] = true;
                            actionImage1.setIcon(new ImageIcon(path + image));
                            actionCards[0] = new Suggestion(
                                    SuggestionType.CURRENT);
                        }
                        else if (!filled[1])
                        {
                            filled[1] = true;
                            actionImage2.setIcon(new ImageIcon(path + image));
                            actionCards[1] = new Suggestion(
                                    SuggestionType.CURRENT);
                        }
                    }
                }
                else if (((ActionCard) card).getActionType()
                        == ActionCardType.SNOOP)
                {
                    image = "Action-Snoop.jpg";
                    if (!filled[0])
                    {
                        filled[0] = true;
                        actionImage1.setIcon(new ImageIcon(path + image));
                        actionCards[0] = new ActionCard(ActionCardType.SNOOP);
                    }
                    else if (!filled[1])
                    {
                        filled[1] = true;
                        actionImage2.setIcon(new ImageIcon(path + image));
                        actionCards[1] = new ActionCard(ActionCardType.SNOOP);
                    }
                }
                else if (((ActionCard) card).getActionType()
                        == ActionCardType.ALL_SNOOP)
                {
                    image = "Action-AllSnoop.jpg";
                    if (!filled[0])
                    {
                        filled[0] = true;
                        actionImage1.setIcon(new ImageIcon(path + image));
                        actionCards[0]
                                = new ActionCard(ActionCardType.ALL_SNOOP);
                    }
                    else if (!filled[1])
                    {
                        filled[1] = true;
                        actionImage2.setIcon(new ImageIcon(path + image));
                        actionCards[1]
                                = new ActionCard(ActionCardType.ALL_SNOOP);
                    }
                }
            }
            else if (card.getCardType() == CardType.HINT)
            {
                if (((HintCard) card).getHintType() == HintCardType.DESTINATION)
                {
                    if (((DestinationCard) card).getDestination()
                            == DestinationID.CONEY_ISLAND)
                    {
                        image = "Location-1.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.GOLDEN_GATE_BRIDGE)
                    {
                        image = "Location-2.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.HOOVER_DAM)
                    {
                        image = "Location-3.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.LINCOLN_MEMORIAL)
                    {
                        image = "Location-4.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.MIAMI_BEACH)
                    {
                        image = "Location-5.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.MT_RUSHMORE)
                    {
                        image = "Location-6.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.NIAGRA_FALLS)
                    {
                        image = "Location-7.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.OLD_FAITHFUL)
                    {
                        image = "Location-8.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((DestinationCard) card).getDestination()
                            == DestinationID.THE_ALAMO)
                    {
                        image = "Location-9.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                }
                else if (((HintCard) card).getHintType() == HintCardType.SUSPECT)
                {
                    if (((SuspectCard) card).getSuspect() == SuspectID.GREEN)
                    {
                        image = "GREEN.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((SuspectCard) card).getSuspect()
                            == SuspectID.MUSTARD)
                    {
                        image = "MUSTARD.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((SuspectCard) card).getSuspect()
                            == SuspectID.PEACOCK)
                    {
                        image = "PEACOCK.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((SuspectCard) card).getSuspect() == SuspectID.PLUM)
                    {
                        image = "PLUM.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((SuspectCard) card).getSuspect()
                            == SuspectID.SCARLET)
                    {
                        image = "SCARLET.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((SuspectCard) card).getSuspect()
                            == SuspectID.WHITE)
                    {
                        image = "WHITE.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                }
                else if (((HintCard) card).getHintType() == HintCardType.VEHICLE)
                {
                    if (((VehicleCard) card).getVehicle() == VehicleID.AIRLINER)
                    {
                        image = "AIRLINER.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((VehicleCard) card).getVehicle()
                            == VehicleID.AUTOMOBILE)
                    {
                        image = "AUTOMOBILE.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((VehicleCard) card).getVehicle()
                            == VehicleID.HOT_AIR_BALLOON)
                    {
                        image = "HOTAIRBALLOON.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((VehicleCard) card).getVehicle()
                            == VehicleID.LIMOUSINE)
                    {
                        image = "LIMOSINE.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((VehicleCard) card).getVehicle()
                            == VehicleID.SEAPLANE)
                    {
                        image = "SEAPLANE.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                    else if (((VehicleCard) card).getVehicle()
                            == VehicleID.TRAIN)
                    {
                        image = "TRAIN.jpg";
                        if (!filled[2])
                        {
                            filled[2] = true;
                            hintImage1.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[3])
                        {
                            filled[3] = true;
                            hintImage2.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[4])
                        {
                            filled[4] = true;
                            hintImage3.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[5])
                        {
                            filled[5] = true;
                            hintImage4.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[6])
                        {
                            filled[6] = true;
                            hintImage5.setIcon(new ImageIcon(path + image));
                        }
                        else if (!filled[7])
                        {
                            filled[7] = true;
                            hintImage6.setIcon(new ImageIcon(path + image));
                        }
                    }
                }
            }
        }
        if (!filled[0])
        {
            actionImage1.setIcon(new ImageIcon());
        }
        if (!filled[1])
        {
            actionImage2.setIcon(new ImageIcon());
        }
        if (!filled[2])
        {
            hintImage1.setIcon(new ImageIcon());
        }
        if (!filled[3])
        {
            hintImage2.setIcon(new ImageIcon());
        }
        if (!filled[4])
        {
            hintImage3.setIcon(new ImageIcon());
        }
        if (!filled[5])
        {
            hintImage4.setIcon(new ImageIcon());
        }
        if (!filled[6])
        {
            hintImage5.setIcon(new ImageIcon());
        }
        if (!filled[7])
        {
            hintImage6.setIcon(new ImageIcon());
        }
    }

    /**
     * Adds a string to the game log
     *
     * @param updateString
     */
    public void updateGameLog(String updateString)
    {
        //set game log's text to the current text + updateString
        gameLog.setText(gameLog.getText() + "\n" + updateString);
    }

    /**
     * Clears the game log
     */
    public void clearGameLog()
    {
        //set game log's test to ""
        gameLog.setText("");
    }

    /**
     * Adds a player to the player list
     *
     * @param playerName
     * @param playerId
     */
    public void addPlayer(String playerName, int playerId, boolean isPlayer)
    {
        //set player list to current text + playerName
        String name = playerName;
        if (isPlayer)
        {
            name = name + "(You)";
        }
        playerList.setValueAt(name, playerIds.size(), 0);

        //add player id to playerIds
        playerIds.add(playerId);
    }

    /**
     * Removes a player from the player list
     *
     * @param playerId
     */
    public void clearPlayers()
    {
        //set player list to current text - playerName
        playerList.setValueAt("", 0, 0);
        playerList.setValueAt("", 1, 0);
        playerList.setValueAt("", 2, 0);
        playerList.setValueAt("", 3, 0);
        playerList.setValueAt("", 4, 0);

        //remove player id from playerIds
        playerIds.clear();
    }

    /**
     * Changes a player's location
     *
     * @param locationId
     * @param playerId
     */
    public void setPlayerLocation(int locationId, int playerId)
    {
        //sets the background of the specified location panel to the color
        //of the corresponding player
    }

    /**
     * Makes the window in play mode
     */
    public void startTurn()
    {
        //sets the endTurnButton and accuseButton to active
        endTurnButton.setEnabled(true);
        accuseButton.setEnabled(true);
    }

    /**
     * Makes the window in watch mode
     */
    public void endTurn()
    {
        //sets the endTurnButton and accuseButton to inactive
        endTurnButton.setEnabled(false);
        accuseButton.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameLog = new javax.swing.JTextArea();
        optionsButton = new javax.swing.JButton();
        instructionsButton = new javax.swing.JButton();
        accuseButton = new javax.swing.JButton();
        endTurnButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        playerList = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        leaveGameButton = new javax.swing.JButton();
        locationImage1 = new javax.swing.JLabel();
        locationImage2 = new javax.swing.JLabel();
        locationImage3 = new javax.swing.JLabel();
        locationImage4 = new javax.swing.JLabel();
        locationImage5 = new javax.swing.JLabel();
        locationImage6 = new javax.swing.JLabel();
        locationImage7 = new javax.swing.JLabel();
        locationImage8 = new javax.swing.JLabel();
        locationImage9 = new javax.swing.JLabel();
        actionImage1 = new javax.swing.JLabel();
        actionImage2 = new javax.swing.JLabel();
        hintImage1 = new javax.swing.JLabel();
        hintImage2 = new javax.swing.JLabel();
        hintImage3 = new javax.swing.JLabel();
        hintImage4 = new javax.swing.JLabel();
        hintImage5 = new javax.swing.JLabel();
        hintImage6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Game Log:");

        gameLog.setEditable(false);
        gameLog.setColumns(20);
        gameLog.setRows(5);
        jScrollPane1.setViewportView(gameLog);

        optionsButton.setText("Options");
        optionsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optionsButtonMouseClicked(evt);
            }
        });

        instructionsButton.setText("Instructions");
        instructionsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                instructionsButtonMouseClicked(evt);
            }
        });

        accuseButton.setText("Accuse!");
        accuseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accuseButtonMouseClicked(evt);
            }
        });

        endTurnButton.setText("End Turn");
        endTurnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endTurnButtonMouseClicked(evt);
            }
        });

        jLabel3.setText("Your Hand:");

        playerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Players:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        playerList.setGridColor(new java.awt.Color(255, 255, 255));
        playerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        playerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(playerList);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jCheckBox1.setText("jCheckBox1");

        jCheckBox2.setText("jCheckBox2");

        jCheckBox3.setText("jCheckBox3");

        jCheckBox4.setText("jCheckBox4");

        jCheckBox5.setText("jCheckBox5");

        jCheckBox6.setText("jCheckBox6");

        jCheckBox7.setText("jCheckBox7");

        jCheckBox8.setText("jCheckBox8");

        jCheckBox9.setText("jCheckBox9");

        jCheckBox10.setText("jCheckBox10");

        jCheckBox11.setText("jCheckBox11");

        jCheckBox12.setText("jCheckBox12");

        jCheckBox13.setText("jCheckBox13");

        jCheckBox14.setText("jCheckBox14");

        jCheckBox15.setText("jCheckBox15");

        jCheckBox16.setText("jCheckBox16");

        jCheckBox17.setText("jCheckBox17");

        jCheckBox18.setText("jCheckBox18");

        jCheckBox19.setText("jCheckBox19");

        jCheckBox20.setText("jCheckBox20");

        jCheckBox21.setText("jCheckBox21");

        leaveGameButton.setText("Leave Game");
        leaveGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leaveGameButtonMouseClicked(evt);
            }
        });

        locationImage1.setText("L1");

        locationImage2.setText("L2");

        locationImage3.setText("L3");

        locationImage4.setText("L4");

        locationImage5.setText("L5");

        locationImage6.setText("L6");

        locationImage7.setText("L7");

        locationImage8.setText("L8");

        locationImage9.setText("L9");

        actionImage1.setText("AC1");
        actionImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionImage1MouseClicked(evt);
            }
        });

        actionImage2.setText("AC2");
        actionImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionImage2MouseClicked(evt);
            }
        });

        hintImage1.setText("HC1");

        hintImage2.setText("HC2");

        hintImage3.setText("HC3");

        hintImage4.setText("HC4");

        hintImage5.setText("HC5");

        hintImage6.setText("HC6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(optionsButton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(instructionsButton))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(44, 44, 44)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(endTurnButton)
                                                .addComponent(accuseButton))))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(leaveGameButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jCheckBox1)
                                                            .addComponent(jCheckBox2)
                                                            .addComponent(jCheckBox3)
                                                            .addComponent(jCheckBox4)
                                                            .addComponent(jCheckBox5)
                                                            .addComponent(jCheckBox6))
                                                        .addGap(83, 83, 83))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jCheckBox7)
                                                            .addComponent(jCheckBox8)
                                                            .addComponent(jCheckBox9)
                                                            .addComponent(jCheckBox10)
                                                            .addComponent(jCheckBox11)
                                                            .addComponent(jCheckBox12))
                                                        .addGap(68, 68, 68)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jCheckBox21)
                                                    .addComponent(jCheckBox20)
                                                    .addComponent(jCheckBox18)
                                                    .addComponent(jCheckBox17)
                                                    .addComponent(jCheckBox16)
                                                    .addComponent(jCheckBox15)
                                                    .addComponent(jCheckBox14)
                                                    .addComponent(jCheckBox13)
                                                    .addComponent(jCheckBox19)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(actionImage1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(actionImage2)))
                                        .addGap(8, 8, 8)
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
                                        .addComponent(hintImage6))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(locationImage1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(locationImage2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(locationImage3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(locationImage4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(locationImage5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(locationImage6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(locationImage7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(locationImage8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(locationImage9)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optionsButton)
                            .addComponent(instructionsButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accuseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endTurnButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationImage1)
                    .addComponent(locationImage2)
                    .addComponent(locationImage3)
                    .addComponent(locationImage4)
                    .addComponent(locationImage5)
                    .addComponent(locationImage6)
                    .addComponent(locationImage7)
                    .addComponent(locationImage8)
                    .addComponent(locationImage9))
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actionImage1)
                    .addComponent(actionImage2)
                    .addComponent(hintImage1)
                    .addComponent(hintImage2)
                    .addComponent(hintImage3)
                    .addComponent(hintImage4)
                    .addComponent(hintImage5)
                    .addComponent(hintImage6))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox7)
                            .addComponent(jCheckBox20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox8)
                            .addComponent(jCheckBox21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox12))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(leaveGameButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void instructionsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructionsButtonMouseClicked
        //call controller's showInstructions method
        controller.showInstructions();
    }//GEN-LAST:event_instructionsButtonMouseClicked

    private void optionsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionsButtonMouseClicked
        //call controller's showOptions method
        controller.showOptions();
    }//GEN-LAST:event_optionsButtonMouseClicked

    private void accuseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accuseButtonMouseClicked
        //call controller's accuse method
        if (accuseButton.isEnabled())
        {
            controller.accuse();
        }
    }//GEN-LAST:event_accuseButtonMouseClicked

    private void endTurnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endTurnButtonMouseClicked
        if (endTurnButton.isEnabled())
        {
            //call controller's endTurn method
            endTurn();

            //call this's endTurn method
            controller.endTurn();
        }
    }//GEN-LAST:event_endTurnButtonMouseClicked

    private void playerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerListMouseClicked
        //set selectedPlayer to selected player's id
    }//GEN-LAST:event_playerListMouseClicked

    private void leaveGameButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leaveGameButtonMouseClicked
        //call controller's exitWindow method
        controller.exitWindow();
    }//GEN-LAST:event_leaveGameButtonMouseClicked

    private void actionImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actionImage1MouseClicked
        if (actionCards[0] != null)
        {
            if (actionCards[0].getActionType() == ActionCardType.SUGGESTION)
            {

            }
            else
            {
                controller.playCard(actionCards[0]);
            }
        }
    }//GEN-LAST:event_actionImage1MouseClicked

    private void actionImage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actionImage2MouseClicked
        if (actionCards[1] != null)
        {
            if (actionCards[1].getActionType() == ActionCardType.SUGGESTION)
            {

            }
            else
            {
                controller.playCard(actionCards[1]);
            }
        }
    }//GEN-LAST:event_actionImage2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainGameScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainGameScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainGameScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainGameScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainGameScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accuseButton;
    private javax.swing.JLabel actionImage1;
    private javax.swing.JLabel actionImage2;
    private javax.swing.JButton endTurnButton;
    private javax.swing.JTextArea gameLog;
    private javax.swing.JLabel hintImage1;
    private javax.swing.JLabel hintImage2;
    private javax.swing.JLabel hintImage3;
    private javax.swing.JLabel hintImage4;
    private javax.swing.JLabel hintImage5;
    private javax.swing.JLabel hintImage6;
    private javax.swing.JButton instructionsButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton leaveGameButton;
    private javax.swing.JLabel locationImage1;
    private javax.swing.JLabel locationImage2;
    private javax.swing.JLabel locationImage3;
    private javax.swing.JLabel locationImage4;
    private javax.swing.JLabel locationImage5;
    private javax.swing.JLabel locationImage6;
    private javax.swing.JLabel locationImage7;
    private javax.swing.JLabel locationImage8;
    private javax.swing.JLabel locationImage9;
    private javax.swing.JButton optionsButton;
    private javax.swing.JTable playerList;
    // End of variables declaration//GEN-END:variables
}
