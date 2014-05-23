package com.outtatech.server;

import com.outtatech.common.*;
import java.awt.Color;
import java.util.*;
import com.outtatech.client.messaging.*;

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

    /**
     * Construct an AI instance, requires instantiated instances of Difficulty
     * and ServerController.
     *
     * @param difficulty the Difficulty instance to drive the AI
     * @param ctrl the Server Controller instance needing an AI
     */
    public AI(int playerId,
            Object notes,
            String name,
            Color color,
            List<HintCard> hintCardsHand,
            List<ActionCard> actionCardsHand,
            Difficulty difficulty, 
            ServerController ctrl)
    {
        super(playerId, notes, name, color, hintCardsHand, actionCardsHand);
        this.difficulty = difficulty;
        this.ctrl = ctrl;
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
        boolean all;
        
        
           
        // typeCardRequired = type of card required // E.g. male suspect, southern location, etc.
        // numCardsToShow = number of cards to show // can either be 1 or all cards of the type
        
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
                           if ((VehicleCard)curHintCard.//isAirVehicle;)
                                   playableCards.add(curHintCard);
                       }
                   case BLUE_CARD:
                       if (curHintType == HintCardType.VEHICLE)
                       {
                           if((VehicleCard)curHintCard.getCardColor() == CardColor.BLUE) {
                               
                           }
                       }
               }
               
               // AIR_VEHICLE, BLUE_CARD, FEMALE_SUSPECT, MALE_SUSPECT, SOUTHERN_DESTINATION,
   // WESTERN_DESTINATION;
            }
        }
        
        if (playableCards.size() > 0)
            return playableCards;
        else
            return null;
  

    }

    /**
     * Method invoked when it is AI's turn to play an action card.
     */

    public void aiTurn()
    {
        // If not time to make an accusation, play an action card randomly determined.
        if (!aiMakeAccusation()) 
        {
           ctrl.reactToRobot(actionCardsHand.get((int)(Math.random())), this);     
        }

        ctrl.reactToRobot(new EndTurnRequest(), this);
        
    }

    /**
     * Method invoked when another player or bot makes a suggestion.
     *
     * @param sc The suspect in the suggestion.
     * @param vc The vehicle in the suggestion.
     * @param dc The location in the suggestion.
     * @return Card The card that refutes the suggestion.
     */

    public Card aiRefuteSuggestion(SuspectCard sc, VehicleCard vc,
            DestinationCard dc)
    {   
        for (int hintCard = 0; hintCard < hintCardsHand.size(); hintCard++ ) 
        {
            if (hintCardsHand.get(hintCard) == sc || hintCardsHand.get(hintCard) == vc ||
                    hintCardsHand.get(hintCard) == dc)
            {
                return hintCardsHand.get(hintCard);
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
        // if knowledge < riskiness of AI
        // 	return false
        // else {
        // 	for each category {
        // 		while true {
        // 			pick random array index
        // 		    check if flip array bit
        // 		    if bit at array index still 0
        // 		    	add card to list
        // 		    	break
        // 		}
        // 	reactToServer(list)
         	return true;
        // }
    }
}
