package com.outtatech.server;

import com.outtatech.client.messaging.*;
import com.outtatech.common.*;
import com.outtatech.server.messaging.*;
import java.awt.Color;
import java.util.*;
import java.util.Random;

/**
 * AI Class can be used to replace a human player. An AI instance will have its
 * own level of Difficulty
 *
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class AI extends ServerPlayer
{
    private Difficulty difficulty;
    private ServerController ctrl;
    private Game game;

    /**
     * Construct an AI instance, requires instantiated instances of Difficulty
     * and ServerController.
     *
     * @param difficulty the Difficulty instance to drive the AI
     * @param ctrl the Server Controller instance needing an AI
     */
    public AI(Difficulty difficulty, ServerController ctrl, Game game)
    {
        super();
        this.difficulty = difficulty;
        this.ctrl = ctrl;
        this.game = game;
    }

    /**
     * Gets the difficulty associated with this AI.
     *
     * @return The difficulty associated with this AI.
     */
    public Difficulty getDifficulty()
    {
        return difficulty;
    }

    /**
     * Sets the difficulty associated with this AI.
     *
     * @param difficulty The difficulty level of the AI.
     */
    public void setDifficulty(Difficulty difficulty)
    {
        this.difficulty = difficulty;
    }
    
   /**
     * Gets the ServerController associated with this AI.
     *
     * @return ctrl The ServerController of this AI.
     */
    public ServerController getServerController()
    {
        return ctrl;
    }

    /**
     * Sets the ServerController associated with this AI.
     *
     * @param ctrl The ServerController of this AI.
     */
    public void setServerController(ServerController ctrl)
    {
        this.ctrl = ctrl;
    }

    /**
     * Method invoked when AI needs to respond to Action cards requiring it's
     * participation.
     *
     * @param card The card to respond to.
     * @return playableCards The list of cards to show or null if there are no compatible cards found.
     */
    public ArrayList<HintCard> aiRespond(ActionCard card)
    { 
        // List playableCards to return
        ArrayList<HintCard> playableCards = new ArrayList();
        SuperSleuth sleuthCard;
        PrivateTip privateTipCard;
        
        if (card instanceof SuperSleuth)
        {
            sleuthCard = (SuperSleuth)card;
            SuperSleuthType sleuthType = sleuthCard.getType();
            
            for (int cardInHand = 0; cardInHand < hintCardsHand.size(); cardInHand++) 
            {
                HintCard curHintCard = hintCardsHand.get(cardInHand);
                HintCardType curHintType = hintCardsHand.get(cardInHand).getHintType();
                
               switch (sleuthType)
               {
                   case AIR_VEHICLE:
                       if (curHintType == HintCardType.VEHICLE) 
                       {
                           if (((VehicleCard)curHintCard).getIsAir())
                                   playableCards.add(curHintCard);
                       }
                       break;
                   case BLUE_CARD:
                       if (curHintType == HintCardType.VEHICLE) 
                       {
                           VehicleCard vehicleHint = (VehicleCard)curHintCard;
                            if(vehicleHint.getCardColor() == CardColor.BLUE) 
                            {
                                 playableCards.add(curHintCard);
                            }
                       }
                   break;
                   case FEMALE_SUSPECT:
                       if (curHintType == HintCardType.SUSPECT) 
                       {
                           if (((SuspectCard)curHintCard).getGender() == Gender.FEMALE)
                                   playableCards.add(curHintCard);
                       }
                    case MALE_SUSPECT:
                       if (curHintType == HintCardType.SUSPECT) 
                       {
                           if (((SuspectCard)curHintCard).getGender() == Gender.MALE)
                                   playableCards.add(curHintCard);
                       }
                    break;
                     case SOUTHERN_DESTINATION:
                       if (curHintType == HintCardType.DESTINATION) 
                       {
                           if (!((DestinationCard)curHintCard).getIsNorth())
                                   playableCards.add(curHintCard);

                       }
                      case WESTERN_DESTINATION:
                       if (curHintType == HintCardType.DESTINATION) 
                       {
                          if (((DestinationCard)curHintCard).getIsWest())
                                   playableCards.add(curHintCard);
                       }
                      break;
                }
               
            }
        }
        
        if (card instanceof PrivateTip)
        {
            privateTipCard = (PrivateTip)card;
            PrivateTipType privateTipType = privateTipCard.getType();
 
            
            for (int cardInHand = 0; cardInHand < hintCardsHand.size(); cardInHand++) 
            {
                HintCard curHintCard = hintCardsHand.get(cardInHand);
                HintCardType curHintType = hintCardsHand.get(cardInHand).getHintType();
                
               switch (privateTipType)
               {
                   case ALL_DESTINATIONS:
                       if (curHintType == HintCardType.DESTINATION) 
                       {
                          playableCards.add(curHintCard);
                       }
                   break;
                   case ALL_VEHICLES:
                       if (curHintType == HintCardType.VEHICLE)
                       {
                               playableCards.add(curHintCard);
                       }
                   break;
                   case ALL_SUSPECTS:
                       if (curHintType == HintCardType.SUSPECT) 
                       {
                          playableCards.add(curHintCard);
                       }
                   break;
                    case ONE_FEMALE_SUSPECT:
                       if (curHintType == HintCardType.DESTINATION) 
                       {
                           if (((SuspectCard)curHintCard).getGender() == Gender.FEMALE)
                                   playableCards.add(curHintCard);
                       }
                    break;
                     case ONE_NORTHERN_DESTINATION:
                       if (curHintType == HintCardType.DESTINATION) 
                       {
                           if (((DestinationCard)curHintCard).getIsNorth())
                                   playableCards.add(curHintCard);

                       }
                     break;
                      case ONE_RED_VEHICLE:
                       if (curHintType == HintCardType.VEHICLE) 
                       {
                          if (((VehicleCard)curHintCard).getCardColor() == CardColor.RED)
                                   playableCards.add(curHintCard);
                       }
                      break;
               }
               
            }
        }
        
       return playableCards;
  
 }

    /**
     * Method invoked when it is AI's turn to play an action card.
     */

    public void aiTurn()
    {         
        if (!aiMakeAccusation())
        {
            ActionCard cardToPlay = actionCardsHand.get((int)Math.random());
            
            if (cardToPlay.getActionType() == ActionCardType.SUGGESTION)
                aiMakeSuggestion(cardToPlay);
            else if (cardToPlay.getActionType() == ActionCardType.SNOOP || 
                   cardToPlay.getActionType() == ActionCardType.PRIVATE_TIP )
            {
                ctrl.reactToRobot(new ActionRequest(cardToPlay, null, getRandomPlayerID()), this);
            }
               
            else
                ctrl.reactToRobot(new ActionRequest(cardToPlay, null), this);     
        }

        ctrl.reactToRobot(new EndTurnRequest(), this);
        
    }
    
    /**
     * Returns ID of random player in game.
     * @return playerID ID of random player in game. 
     */
    private Integer getRandomPlayerID()
    {
        Integer playerID = -1;
      
        while (playerID == this.getPlayerId())
        {
           int index = (int)Math.random() * game.getServerPlayersList().size();
           playerID = game.getServerPlayersList().get(index).getPlayerId();
        }
        
      return playerID;
    }
    
    private void aiMakeSuggestion(ActionCard card)
    {
        SuspectID choice1;
        VehicleID choice2;
        DestinationID choice3;
        
        if (((Suggestion)card).getType() == SuggestionType.ANY)
        {
            choice1 = getSuspectChoice(suspectCardsSeen);
            choice2 = getVehicleChoice(vehicleCardsSeen);
            choice3 = (getLocationChoice(locationsSeen));
            
            ctrl.reactToRobot(new SuggestionRequest(
                    new Solution(choice3, choice2, choice1)), this);
            
        }
        else 
        {
            choice1 = getSuspectChoice(suspectCardsSeen);
            choice2 = (getVehicleChoice(vehicleCardsSeen));
            
            ctrl.reactToRobot(new SuggestionRequest(
                    new Solution(this.getLocation(), choice2, choice1)), this);
        }
        
    }

    /**
     * Method invoked when another player or bot makes a suggestion.
     *
     * @param suspect The ID of suspect in the suggestion.
     * @param vehicle The ID of vehicle in the suggestion.
     * @param destination The ID of location in the suggestion.
     * @return HintCard The card that refutes the suggestion.
     */

    public HintCard aiRefuteSuggestion(SuspectID suspect, VehicleID vehicle,
            DestinationID destination)
    {   
        
        for (int hintCard = 0; hintCard < hintCardsHand.size(); hintCard++ ) 
        {
            HintCard card = hintCardsHand.get(hintCard);
            
            if (card instanceof SuspectCard)
            {
                if (((SuspectCard)card).getSuspect() == suspect)
                    return card;
            }
            else if (card instanceof DestinationCard)
            {
                if (((DestinationCard)card).getDestination() == destination)
                    return card;
            }
            else if (card instanceof VehicleCard)
            {
                if (((VehicleCard)card).getVehicle() == vehicle)
                    return card;
            }
        }
        return null;
    }

    /**
     * Method invoked each time AI plays a turn in order to determine whether or
     * not to make an accusation based on the AI difficulty level.
     *
     * @return boolean Returns true if accusation has been made, false if it
     * hasn't.
     */
    private boolean aiMakeAccusation()
    { // void for sake of complitation w/pseudocde. should return a boolean
        // knowledge = (add number of known cards in each category / number of cards in each category) / 3
        float knowledge = (suspectCardsSeen.size()/6 + 
                vehicleCardsSeen.size()/6 + 
                locationsSeen.size()/9) / 3;
        // if knowledge < riskiness of AI
        if((knowledge * 5) < difficulty.getRiskiness())
            //  return false
            return false;
        // else {
        //  for each category {
        //    while true {
        //      pick random array index
        //        check if flip array bit
        //        if bit at array index still 0
        //          add card to list
        //          break
        //    }
        //  reactToServer(list)
        else {
            SuspectID choice1 = getSuspectChoice(suspectCardsSeen);
            VehicleID choice2 = (getVehicleChoice(vehicleCardsSeen));
            DestinationID choice3 = (getLocationChoice(locationsSeen));
            ctrl.reactToRobot(new AccusationRequest(
                    new Solution(choice3, choice2, choice1)), this);
        }
        return true;
        // }
    }
    //Tim minshim
    private SuspectID getSuspectChoice(EnumSet cards) {
        EnumSet complement = EnumSet.complementOf(cards);
        boolean flag = false;
        while(!flag) {
            double choice = Math.random();
            if(choice * (cards.size() + complement.size()) > cards.size()) {
                if(difficulty.getIntelligence() < Math.random() * 5) {
                    return (SuspectID) complement.toArray()[(int)choice - cards.size()];
                }
            }
            else
            {
                if(difficulty.getIntelligence() < Math.random() * 5) {
                    return (SuspectID) 
                            cards.toArray()[(int)choice - cards.size()];
                }
            }
        }
        return (SuspectID) cards.toArray()[0];
    }
    
    private VehicleID getVehicleChoice(EnumSet cards) {
        EnumSet complement = EnumSet.complementOf(cards);
        boolean flag = false;
        while(!flag) {
            double choice = Math.random();
            if(choice * (cards.size() + complement.size()) > cards.size()) {
                if(difficulty.getIntelligence() < Math.random() * 5) {
                    return (VehicleID) 
                            complement.toArray()[(int)choice - cards.size()];
                }
            }
            else
            {
                if(difficulty.getIntelligence() < Math.random() * 5) {
                    return (VehicleID) 
                            cards.toArray()[(int)choice - cards.size()];
                }
            }
        }
        return (VehicleID) cards.toArray()[0];
    }
    
    private DestinationID getLocationChoice(EnumSet cards) {
        EnumSet complement = EnumSet.complementOf(cards);
        boolean flag = false;
        while(!flag) {
            double choice = Math.random();
            if(choice * (cards.size() + complement.size()) > cards.size()) {
                if(difficulty.getIntelligence() < Math.random() * 5) {
                    return (DestinationID) 
                            complement.toArray()[(int)choice - cards.size()];
                }
            }
            else
            {
                if(difficulty.getIntelligence() < Math.random() * 5) {
                    return (DestinationID) 
                            cards.toArray()[(int)choice - cards.size()];
                }
            }
        }
        return (DestinationID) cards.toArray()[0];
    }
    
    public void reactToServer(Object obj) 
    {
        if(obj instanceof AccusationResponse) 
        {
            //?
        }
//        if(obj instanceof ActionResponse) 
//        {
//            ActionResponse card = (ActionResponse)obj;
//            aiRespond(card.getActionCard());
//        }
        if(obj instanceof CardDealResponse) 
        {
            CardDealResponse rsp = (CardDealResponse)obj;
            for(Card temp : rsp.getCards()) {
                if(temp.getCardType() == CardType.ACTION)
                {
                    actionCardsHand.add((ActionCard)temp);
                }
                if(temp.getCardType() == CardType.HINT)
                {
                    hintCardsHand.add((HintCard)temp);
                }
            }
        }
        if(obj instanceof GameStateResponse) 
        {
            //?
        }
        if(obj instanceof KickPlayerResponse) 
        {
            System.out.println("lol dont give a fuck");
        }
        if(obj instanceof RevealCardResponse) 
        {
            RevealCardResponse rsp = (RevealCardResponse)obj;
            for(Card temp : rsp.getCards()) 
            {
                if(((HintCard)temp).getHintType() == HintCardType.SUSPECT)
                {
                    suspectCardsSeen.add(((SuspectCard)temp).getSuspect());
                }
                if(((HintCard)temp).getHintType() == HintCardType.VEHICLE)
                {
                    vehicleCardsSeen.add(((VehicleCard)temp).getVehicle());
                }
                if(((HintCard)temp).getHintType() == HintCardType.DESTINATION)
                {
                    locationsSeen.add(((DestinationCard)temp).getDestination());
                }
            }
        }
    }
}
