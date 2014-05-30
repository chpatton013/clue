/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client;

import com.outtatech.common.ActionCard;
import com.outtatech.common.ActionCardType;
import com.outtatech.common.Card;
import com.outtatech.common.CardColor;
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

/**
 *
 * @author Thomas
 */
public class CardTranslator {
    
    GUIController controller;
    
    private String[][] nameList = 
    {
        {
            "Green", "Mustard", "Peacock", "Plum", "Scarlet", "White"
        },
        {
            "Airliner", "Automobile", "HotAirBalloon", "Limosine", 
            "Seaplane", "Train"
        },
        {
            "ConeyIsland", "GoldenGateBridge", "HooverDam", "LincolnMemorial",
            "MiamiBeach", "MTRushmore", "NiagraFalls", "OldFaithful", 
            "TheAlamo"
        }
    };
    
    private Card[][] cardList = 
    {
        {
            new SuspectCard(SuspectID.GREEN),
            new SuspectCard(SuspectID.MUSTARD),
            new SuspectCard(SuspectID.PEACOCK),
            new SuspectCard(SuspectID.PLUM),
            new SuspectCard(SuspectID.SCARLET),
            new SuspectCard(SuspectID.WHITE)
        },
        {
            new VehicleCard(VehicleID.AIRLINER, CardColor.BLUE),
            new VehicleCard(VehicleID.AUTOMOBILE, CardColor.BLUE),
            new VehicleCard(VehicleID.HOT_AIR_BALLOON, CardColor.BLUE),
            new VehicleCard(VehicleID.LIMOUSINE, CardColor.RED),
            new VehicleCard(VehicleID.SEAPLANE, CardColor.RED),
            new VehicleCard(VehicleID.TRAIN, CardColor.RED)
        },
        {
            new DestinationCard(DestinationID.CONEY_ISLAND),
            new DestinationCard(DestinationID.GOLDEN_GATE_BRIDGE),
            new DestinationCard(DestinationID.HOOVER_DAM),
            new DestinationCard(DestinationID.LINCOLN_MEMORIAL),
            new DestinationCard(DestinationID.MIAMI_BEACH),
            new DestinationCard(DestinationID.MT_RUSHMORE),
            new DestinationCard(DestinationID.NIAGRA_FALLS),
            new DestinationCard(DestinationID.OLD_FAITHFUL),
            new DestinationCard(DestinationID.THE_ALAMO),
        }
    };
    
    public CardTranslator(GUIController ctrl) 
    {
        controller = ctrl;
    }
    
    public String getPath(Card card) 
    {
        String path;
        
        if (card.getCardType() == CardType.ACTION)
        {
            path = "./images/actionCards/" + getActionType((ActionCard)card);
        }
        else
        {
            path = controller.getImagePath() + getHintType((HintCard)card);
        }
        
        return path;
    }
    
    private String getActionType(ActionCard card) 
    {
        if (((ActionCard) card).getActionType()
                        == ActionCardType.ALL_SNOOP)
                {
                    return "Action-AllSnoop.jpg";
                }
        else if (((ActionCard) card).getActionType()
                        == ActionCardType.PRIVATE_TIP)
                {
                    return getPrivateTipType((PrivateTip)card);
                }
        else if (((ActionCard) card).getActionType()
                        == ActionCardType.SNOOP)
                {
                    return "Action-Snoop.jpg";
                }
        else if (((ActionCard) card).getActionType()
                        == ActionCardType.SUGGESTION)
                {
                    return getSuggestionType((Suggestion)card);
                }
        else if (((ActionCard) card).getActionType()
                        == ActionCardType.SUPER_SLEUTH)
                {
                    return getSuperSleuthType((SuperSleuth)card);
                }
        else
        {
            return "";
        }
    }
    
    private String getPrivateTipType(PrivateTip card)
    {
        if(card.getType() == PrivateTipType.ALL_DESTINATIONS)
        {
            return "Action-PrivateTipAllDestination.jpg";
        }
        else if(card.getType() == PrivateTipType.ALL_SUSPECTS)
        {
            return "Action-PrivateTipAllSuspect.jpg";
        }
        else if(card.getType() == PrivateTipType.ALL_VEHICLES)
        {
            return "Action-PrivateTipAllVehicle.jpg";
        }
        else if(card.getType() == PrivateTipType.ONE_FEMALE_SUSPECT)
        {
            return "Action-PrivateTipFemale.jpg";
        }
        else if(card.getType() == PrivateTipType.ONE_NORTHERN_DESTINATION)
        {
            return "Action-PrivateTipNorthern.jpg";
        }
        else if(card.getType() == PrivateTipType.ONE_RED_VEHICLE)
        {
            return "Action-PrivateTipRed.jpg";
        }
        else 
        {
            return "";
        }
    }
    
    private String getSuggestionType(Suggestion card)
    {
        if(card.getType() == SuggestionType.ANY)
        {
            return "Action-SuggestionAny.jpg";
        }
        else if(card.getType() == SuggestionType.CURRENT)
        {
            return "Action-SuggestionCurrent.jpg";
        }
        else
        {
            return "";
        }
    }
    
    private String getSuperSleuthType(SuperSleuth card)
    {
        if(card.getType() == SuperSleuthType.AIR_VEHICLE) 
        {
            return "Action-SuperSleuthAir.jpg";
        }
        else if(card.getType() == SuperSleuthType.BLUE_CARD) 
        {
            return "Action-SuperSleuthBlue.jpg";
        }
        else if(card.getType() == SuperSleuthType.FEMALE_SUSPECT) 
        {
            return "Action-SuperSleuthFemale.jpg";
        }
        else if(card.getType() == SuperSleuthType.MALE_SUSPECT) 
        {
            return "Action-SuperSleuthMale.jpg";
        }
        else if(card.getType() == SuperSleuthType.SOUTHERN_DESTINATION) 
        {
            return "Action-SuperSleuthSouth.jpg";
        }
        else if(card.getType() == SuperSleuthType.WESTERN_DESTINATION) 
        {
            return "Action-SuperSleuthWest.jpg";
        }
        else 
        {
            return "";
        }
    }
    
    private String getHintType(HintCard card) 
    {
        if(card.getHintType() == HintCardType.DESTINATION)
        {
            return getDestinationType((DestinationCard)card);
        }
        else if(card.getHintType() == HintCardType.SUSPECT)
        {
            return getSuspectType((SuspectCard)card);
        }
        else if(card.getHintType() == HintCardType.VEHICLE)
        {
            return getVehicleType((VehicleCard)card);
        }
        else
        {
            return "";
        }
    }
    
    private String getDestinationType(DestinationCard card)
    {
        if(card.getDestination() == DestinationID.CONEY_ISLAND)
        {
            return "Location-1.jpg";
        }
        else if(card.getDestination() == DestinationID.GOLDEN_GATE_BRIDGE)
        {
            return "Location-2.jpg";
        }
        else if(card.getDestination() == DestinationID.HOOVER_DAM)
        {
            return "Location-3.jpg";
        }
        else if(card.getDestination() == DestinationID.LINCOLN_MEMORIAL)
        {
            return "Location-4.jpg";
        }
        else if(card.getDestination() == DestinationID.MIAMI_BEACH)
        {
            return "Location-5.jpg";
        }
        else if(card.getDestination() == DestinationID.MT_RUSHMORE)
        {
            return "Location-6.jpg";
        }
        else if(card.getDestination() == DestinationID.NIAGRA_FALLS)
        {
            return "Location-7.jpg";
        }
        else if(card.getDestination() == DestinationID.OLD_FAITHFUL)
        {
            return "Location-8.jpg";
        }
        else if(card.getDestination() == DestinationID.THE_ALAMO)
        {
            return "Location-9.jpg";
        }
        else
        {
            return "";
        }
    }
    
    private String getSuspectType(SuspectCard card)
    {
        if(card.getSuspect() == SuspectID.GREEN)
        {
            return "GREEN.jpg";
        }
        else if(card.getSuspect() == SuspectID.MUSTARD)
        {
            return "MUSTARD.jpg";
        }
        else if(card.getSuspect() == SuspectID.PEACOCK)
        {
            return "PEACOCK.jpg";
        }
        else if(card.getSuspect() == SuspectID.PLUM)
        {
            return "PLUM.jpg";
        }
        else if(card.getSuspect() == SuspectID.SCARLET)
        {
            return "SCARLET.jpg";
        }
        else if(card.getSuspect() == SuspectID.WHITE)
        {
            return "WHITE.jpg";
        }
        else
        {
            return "";
        }
    }
    
    private String getVehicleType(VehicleCard card)
    {
        if(card.getVehicle() == VehicleID.AIRLINER)
        {
            return "AIRLINER.jpg";
        }
        else if(card.getVehicle() == VehicleID.AUTOMOBILE)
        {
            return"AUTOMOBILE.jpg";
        }
        else if(card.getVehicle() == VehicleID.HOT_AIR_BALLOON)
        {
            return"HOTAIRBALLOON.jpg";
        }
        else if(card.getVehicle() == VehicleID.LIMOUSINE)
        {
            return"LIMOSINE.jpg";
        }
        else if(card.getVehicle() == VehicleID.SEAPLANE)
        {
            return"SEAPLANE.jpg";
        }
        else if(card.getVehicle() == VehicleID.TRAIN)
        {
            return"TRAIN.jpg";
        }
        else
        {
            return "";
        }
    }

    public String getName(String type, int num)
    {
        if(type.equals("suspect") && num < 6 && num >= 0)
        {
            return nameList[0][num];
        }
        else if(type.equals("vehicle") && num < 6 && num >= 0)
        {
            return nameList[1][num];
        }
        else if(type.equals("location") && num < 9 && num >= 0)
        {
            return nameList[2][num];
        }
        else
        {
            return "";
        }
    }
    
    public Card getCard(String type, int num)
    {
        if(type.equals("suspect") && num < 6 && num >= 0)
        {
            return cardList[0][num];
        }
        else if(type.equals("vehicle") && num < 6 && num >= 0)
        {
            return cardList[1][num];
        }
        else if(type.equals("location") && num < 9 && num >= 0)
        {
            return cardList[2][num];
        }
        else
        {
            return null;
        }
    }
}
