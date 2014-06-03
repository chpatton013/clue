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
import java.util.HashMap;
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
            "GREEN", "MUSTARD", "PEACOCK", "PLUM", "SCARLET", "WHITE"
        },
        {
            "AIRLINER", "AUTOMOBILE", "HOT_AIR_BALLOON", "LIMOSINE", 
            "SEAPLANE", "TRAIN"
        },
        {
            "CONEY_ISLAND", "GOLDEN_GATE_BRIDGE", "HOOVER_DAM", 
            "LINCOLN_MEMORIAL", "MIAMI_BEACH", "MT_RUSHMORE", "NIAGRA_FALLS",
            "OLD_FAITHFUL", "THE_ALAMO"
        }
    };
    
    private HashMap greeceMap;
    private HashMap whiteMap;
    private HashMap pirateMap;
    
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
        
        greeceMap = new HashMap();
        
        //add characters
        greeceMap.put("GREEN", "Hermes");
        greeceMap.put("MUSTARD", "Ares");
        greeceMap.put("PEACOCK", "Artemis");
        greeceMap.put("PLUM", "Dionysus");
        greeceMap.put("SCARLET", "Aphrodite");
        greeceMap.put("WHITE", "Hera");
        
        //add vehicles
        greeceMap.put("AIRLINER", "Eros' Wings");
        greeceMap.put("AUTOMOBILE", "Apollo's Chariot");
        greeceMap.put("HOT_AIR_BALLOON", "Hermes Sandals");
        greeceMap.put("LIMOSINE", "Athena's Horse");
        greeceMap.put("SEAPLANE", "Poseidon's Ship");
        greeceMap.put("TRAIN", "Hades' Dogs");
        
        //add destinations
        greeceMap.put("CONEY_ISLAND", "Athena's Forest");
        greeceMap.put("GOLDEN_GATE_BRIDGE", "Athens");
        greeceMap.put("HOOVER_DAM", "Atlas' Sky");
        greeceMap.put("LINCOLN_MEMORIAL", "Dionysus' Vinyard");
        greeceMap.put("MIAMI_BEACH", "Hades' Underworld");
        greeceMap.put("MT_RUSHMORE", "Hephaestus' Volcano");
        greeceMap.put("NIAGRA_FALLS", "Mount Olympus");
        greeceMap.put("OLD_FAITHFUL", "Phoebe's Moon");
        greeceMap.put("THE_ALAMO", "Poseidon's Ocean");
        
        whiteMap = new HashMap();
        
        //add characters
        whiteMap.put("GREEN", "George W Bush");
        whiteMap.put("MUSTARD", "Dick Cheney");
        whiteMap.put("PEACOCK", "Ann Coulter");
        whiteMap.put("PLUM", "Karl Rove");
        whiteMap.put("SCARLET", "Condalisa Rice");
        whiteMap.put("WHITE", "Laura Bush");
        
        //add vehicles
        whiteMap.put("AIRLINER", "Air Force One");
        whiteMap.put("AUTOMOBILE", "Motorcade");
        whiteMap.put("HOT_AIR_BALLOON", "Blimp");
        whiteMap.put("LIMOSINE", "Humvee");
        whiteMap.put("SEAPLANE", "Chopper");
        whiteMap.put("TRAIN", "Motorcycle");
        
        //add destinations
        whiteMap.put("CONEY_ISLAND", "Dry Tortugas");
        whiteMap.put("GOLDEN_GATE_BRIDGE", "Everglades");
        whiteMap.put("HOOVER_DAM", "Grand Canyon");
        whiteMap.put("LINCOLN_MEMORIAL", "Joshua Tree");
        whiteMap.put("MIAMI_BEACH", "Olympic");
        whiteMap.put("MT_RUSHMORE", "Shenandoah");
        whiteMap.put("NIAGRA_FALLS", "Smokey Mountains");
        whiteMap.put("OLD_FAITHFUL", "Yosemite");
        whiteMap.put("THE_ALAMO", "Yellowstone");
        
        pirateMap = new HashMap();
        
        //add characters
        pirateMap.put("GREEN", "Callico Jack");
        pirateMap.put("MUSTARD", "Blackbeard");
        pirateMap.put("PEACOCK", "Sadie The Goat");
        pirateMap.put("PLUM", "William Kidd");
        pirateMap.put("SCARLET", "Anne Bonny");
        pirateMap.put("WHITE", "Granuldale");
        
        //add vehicles
        pirateMap.put("AIRLINER", "Tartane");
        pirateMap.put("AUTOMOBILE", "Sloop");
        pirateMap.put("HOT_AIR_BALLOON", "Galleon");
        pirateMap.put("LIMOSINE", "Merchantman");
        pirateMap.put("SEAPLANE", "Brig");
        pirateMap.put("TRAIN", "Barque");
        
        //add destinations
        pirateMap.put("CONEY_ISLAND", "Barbados");
        pirateMap.put("GOLDEN_GATE_BRIDGE", "Gibraltar");
        pirateMap.put("HOOVER_DAM", "Guadeloupe");
        pirateMap.put("LINCOLN_MEMORIAL", "Havana");
        pirateMap.put("MIAMI_BEACH", "Port Royale");
        pirateMap.put("MT_RUSHMORE", "San Juan");
        pirateMap.put("NIAGRA_FALLS", "Santiago");
        pirateMap.put("OLD_FAITHFUL", "Tortuga");
        pirateMap.put("THE_ALAMO", "Veracruz");
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

    public String translateName(String in)
    {
        HashMap useMap;
        if(controller.getImageIndex() == 0)
        {
            useMap = greeceMap;
        }
        else if(controller.getImageIndex() == 1)
        {
            useMap = whiteMap;
        }
        else if(controller.getImageIndex() == 2)
        {
            useMap = pirateMap;
        }
        else
            return in;
        
        if(useMap.containsKey(in))
        {
            return (String)useMap.get(in);
        }
        else
            return in;
    }
    
    public String getName(String type, int num)
    {
        if(type.equals("suspect") && num < 6 && num >= 0)
        {
            return translateName(nameList[0][num]);
        }
        else if(type.equals("vehicle") && num < 6 && num >= 0)
        {
            return translateName(nameList[1][num]);
        }
        else if(type.equals("location") && num < 9 && num >= 0)
        {
            return translateName(nameList[2][num]);
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
