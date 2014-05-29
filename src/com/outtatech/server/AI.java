package com.outtatech.server;

import com.outtatech.client.messaging.*;
import com.outtatech.common.*;
import com.outtatech.server.messaging.*;
import java.awt.Color;
import java.util.*;
import java.util.Random;

/**
 * Version-latenightpizzaparty
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
     * Version-latenightpizzaparty
     * Construct an AI instance, requires instantiated instances of Difficulty
     * and ServerController.
     *
     * @param difficulty the Difficulty instance to drive the AI method parameter
     * @param ctrl the Server Controller instance needing an AI method parameter
     * @param game method parameter
     */
    public AI(Difficulty difficulty, ServerController ctrl, Game game)
    {
        super();
        this.difficulty = difficulty;
        this.ctrl = ctrl;
        this.game = game;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the difficulty associated with this AI.
     *
     * @return The difficulty associated with this AI. return value
     */
    public Difficulty getDifficulty()
    {
        return difficulty;
    }
    
    /**
     * Getter method for the AI's game
     * @return the AI's game
     */
    public Game getGame()
    {
        return game;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the difficulty associated with this AI.
     *
     * @param difficulty The difficulty level of the AI. method parameter
     */
    public void setDifficulty(Difficulty difficulty)
    {
        this.difficulty = difficulty;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the ServerController associated with this AI.
     *
     * @return ctrl The ServerController of this AI. return value
     */
    public ServerController getServerController()
    {
        return ctrl;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the ServerController associated with this AI.
     *
     * @param ctrl The ServerController of this AI. method parameter
     */
    public void setServerController(ServerController ctrl)
    {
        this.ctrl = ctrl;
    }

    /**
     * Version-latenightpizzaparty
     * Method invoked when AI needs to respond to Action cards requiring it's
     * participation.
     *
     * @param card The card to respond to. method parameter
     * @return playableCards The list of cards to show or null if there are no
     * return value
     * compatible cards found.
     */
    public ArrayList<HintCard> aiRespond(ActionCard card)
    {
        // List playableCards to return
        ArrayList<HintCard> playableCards = new ArrayList();
        SuperSleuth sleuthCard;
        PrivateTip privateTipCard;

        // Guard against this
        if (card instanceof SuperSleuth)
        {
            sleuthCard = (SuperSleuth) card;
            SuperSleuthType sleuthType = sleuthCard.getType();

            // Iterate over this set
            for (int cardInHand = 0; cardInHand < hintCardsHand.size();
                    cardInHand++)
            {
                HintCard curHintCard = hintCardsHand.get(cardInHand);
                HintCardType curHintType = 
                        hintCardsHand.get(cardInHand).getHintType();

                //Checks sleuthType
                switch (sleuthType)
                {
                    case AIR_VEHICLE:
                        // Guard against this
                        if (curHintType == HintCardType.VEHICLE)
                        {
                            // Guard against this
                            if (((VehicleCard) curHintCard).getIsAir())
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    case BLUE_CARD:
                        // Guard against this
                        if (curHintType == HintCardType.VEHICLE)
                        {
                            VehicleCard vehicleHint = (VehicleCard) curHintCard;
                            // Guard against this
                            if (vehicleHint.getCardColor() == CardColor.BLUE)
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    case FEMALE_SUSPECT:
                        // Guard against this
                        if (curHintType == HintCardType.SUSPECT)
                        {
                            // Guard against this
                            if (((SuspectCard) curHintCard).getGender()
                                    == Gender.FEMALE)
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    case MALE_SUSPECT:
                        // Guard against this
                        if (curHintType == HintCardType.SUSPECT)
                        {
                            // Guard against this
                            if (((SuspectCard) curHintCard).getGender()
                                    == Gender.MALE)
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    case SOUTHERN_DESTINATION:
                        // Guard against this
                        if (curHintType == HintCardType.DESTINATION)
                        {
                            // Guard against this
                            if (!((DestinationCard) curHintCard).getIsNorth())
                            {
                                playableCards.add(curHintCard);
                            }

                        }
                        break;
                    case WESTERN_DESTINATION:
                        // Guard against this
                        if (curHintType == HintCardType.DESTINATION)
                        {
                            // Guard against this
                            if (((DestinationCard) curHintCard).getIsWest())
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    default:
                        break;
                }

            }
        }

        // Guard against this
        if (card instanceof PrivateTip)
        {
            privateTipCard = (PrivateTip) card;
            PrivateTipType privateTipType = privateTipCard.getType();

            // Iterate over this set
            for (int cardInHand = 0; cardInHand < hintCardsHand.size();
                    cardInHand++)
            {
                HintCard curHintCard = hintCardsHand.get(cardInHand);
                HintCardType curHintType = 
                        hintCardsHand.get(cardInHand).getHintType();

                //Checks Destinations
                switch (privateTipType)
                {
                    case ALL_DESTINATIONS:
                        // Guard against this
                        if (curHintType == HintCardType.DESTINATION)
                        {
                            playableCards.add(curHintCard);
                        }
                        break;
                    case ALL_VEHICLES:
                        // Guard against this
                        if (curHintType == HintCardType.VEHICLE)
                        {
                            playableCards.add(curHintCard);
                        }
                        break;
                    case ALL_SUSPECTS:
                        // Guard against this
                        if (curHintType == HintCardType.SUSPECT)
                        {
                            playableCards.add(curHintCard);
                        }
                        break;
                    case ONE_FEMALE_SUSPECT:
                        // Guard against this
                        if (curHintType == HintCardType.DESTINATION)
                        {
                            // Guard against this
                            if (((SuspectCard) curHintCard).getGender()
                                    == Gender.FEMALE)
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    case ONE_NORTHERN_DESTINATION:
                        // Guard against this
                        if (curHintType == HintCardType.DESTINATION)
                        {
                            // Guard against this
                            if (((DestinationCard) curHintCard).getIsNorth())
                            {
                                playableCards.add(curHintCard);
                            }

                        }
                        break;
                    case ONE_RED_VEHICLE:
                        // Guard against this
                        if (curHintType == HintCardType.VEHICLE)
                        {
                            // Guard against this
                            if (((VehicleCard) curHintCard).getCardColor()
                                    == CardColor.RED)
                            {
                                playableCards.add(curHintCard);
                            }
                        }
                        break;
                    default:
                        break;
                }

            }
        }

        return playableCards;

    }

    /**
     * Version-latenightpizzaparty
     * Method invoked when it is AI's turn to play an action card.
     */
    public void aiTurn()
    {
        // Guard against this
        if (!aiMakeAccusation())
        {
            ActionCard cardToPlay = actionCardsHand.get((int) Math.random());

            // Guard against this
            if (cardToPlay.getActionType() == ActionCardType.SUGGESTION)
            {
                aiMakeSuggestion(cardToPlay);
            }
            // Otherwise...
            else if (cardToPlay.getActionType() == ActionCardType.SNOOP
                    || cardToPlay.getActionType() == ActionCardType.PRIVATE_TIP)
            {
                ctrl.reactToRobot(new ActionRequest(cardToPlay, null,
                        getRandomPlayerID()), this);
            }

            // Otherwise...
            else
            {
                ctrl.reactToRobot(new ActionRequest(cardToPlay, null), this);
            }
        }

    }

    /**
     * Version-latenightpizzaparty
     * Returns ID of random player in game.
     *
     * @return playerID ID of random player in game. return value
     */
    private Integer getRandomPlayerID()
    {
        Integer playerID = -1;

        // Iterate until false
        while (playerID == this.getPlayerId())
        {
            int index = (int) Math.random() * game.getServerPlayersList().size();
            playerID = game.getServerPlayersList().get(index).getPlayerId();
        }

        return playerID;
    }

    private void aiMakeSuggestion(ActionCard card)
    {
        SuspectID choice1;
        VehicleID choice2;
        DestinationID choice3;

        // Guard against this
        if (((Suggestion) card).getType() == SuggestionType.ANY)
        {
            choice1 = getSuspectChoice(suspectCardsSeen);
            choice2 = getVehicleChoice(vehicleCardsSeen);
            choice3 = (getLocationChoice(locationsSeen));

            ctrl.reactToRobot(new SuggestionRequest(
                    new Solution(choice3, choice2, choice1)), this);

        }
        // Otherwise...
        else
        {
            choice1 = getSuspectChoice(suspectCardsSeen);
            choice2 = (getVehicleChoice(vehicleCardsSeen));

            ctrl.reactToRobot(new SuggestionRequest(
                    new Solution(this.getLocation(), choice2, choice1)), this);
        }

    }

    /**
     * Version-latenightpizzaparty
     * Method invoked when another player or bot makes a suggestion.
     *
     * @param suspect The ID of suspect in the suggestion. method parameter
     * @param vehicle The ID of vehicle in the suggestion. method parameter
     * @param destination The ID of location in the suggestion. method parameter
     * @return HintCard The card that refutes the suggestion. return value
     */
    public HintCard aiRefuteSuggestion(SuspectID suspect, VehicleID vehicle,
            DestinationID destination)
    {

        // Iterate over this set
        for (int hintCard = 0; hintCard < hintCardsHand.size(); hintCard++)
        {
            HintCard card = hintCardsHand.get(hintCard);

            // Guard against this
            if (card instanceof SuspectCard)
            {
                // Guard against this
                if (((SuspectCard) card).getSuspect() == suspect)
                {
                    return card;
                }
            }
            // Otherwise...
            else if (card instanceof DestinationCard)
            {
                // Guard against this
                if (((DestinationCard) card).getDestination() == destination)
                {
                    return card;
                }
            }
            // Otherwise...
            else if (card instanceof VehicleCard)
            {
                // Guard against this
                if (((VehicleCard) card).getVehicle() == vehicle)
                {
                    return card;
                }
            }
        }
        return null;
    }

    /**
     * Version-latenightpizzaparty
     * Method invoked each time AI plays a turn in order to determine whether or
     * not to make an accusation based on the AI difficulty level.
     *
     * @return boolean Returns true if accusation has been made, false if it return value
     * hasn't.
     */
    private boolean aiMakeAccusation()
    { // void for sake of complitation w/pseudocde. should return a boolean
        // knowledge = (add number of known cards in each category 
        // number of cards in each category) / 3
        float knowledge = (suspectCardsSeen.size() / 6 + vehicleCardsSeen.size()
                / 6 + locationsSeen.size() / 9) / 3;
        // if knowledge < riskiness of AI
        // Guard against this
        if ((knowledge * 5) < difficulty.getRiskiness())
        //  return false
        {
            return false;
        }
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
        // Otherwise...
        else
        {
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

    private SuspectID getSuspectChoice(EnumSet cards)
    {
        EnumSet complement = EnumSet.complementOf(cards);
        boolean flag = false;
        // Iterate until false
        while (!flag)
        {
            double choice = Math.random();
            // Guard against this
            if (choice * (cards.size() + complement.size()) > cards.size())
            {
                // Guard against this
                if (difficulty.getIntelligence() < Math.random() * 5)
                {
                    return (SuspectID) complement.toArray()[(int) choice
                            - cards.size()];
                }
            }
            // Otherwise...
            else
            {
                // Guard against this
                if (difficulty.getIntelligence() < Math.random() * 5)
                {
                    return (SuspectID) cards.toArray()[(int) choice - 
                            cards.size()];
                }
            }
        }
        return (SuspectID) cards.toArray()[0];
    }

    private VehicleID getVehicleChoice(EnumSet cards)
    {
        EnumSet complement = EnumSet.complementOf(cards);
        boolean flag = false;
        // Iterate until false
        while (!flag)
        {
            double choice = Math.random();
            // Guard against this
            if (choice * (cards.size() + complement.size()) > cards.size())
            {
                // Guard against this
                if (difficulty.getIntelligence() < Math.random() * 5)
                {
                    return (VehicleID) complement.toArray()[(int) choice
                            - cards.size()];
                }
            }
            // Otherwise...
            else
            {
                // Guard against this
                if (difficulty.getIntelligence() < Math.random() * 5)
                {
                    return (VehicleID) cards.toArray()[(int) choice - 
                            cards.size()];
                }
            }
        }
        return (VehicleID) cards.toArray()[0];
    }

    private DestinationID getLocationChoice(EnumSet cards)
    {
        EnumSet complement = EnumSet.complementOf(cards);
        boolean flag = false;
        // Iterate until false
        while (!flag)
        {
            double choice = Math.random();
            // Guard against this
            if (choice * (cards.size() + complement.size()) > cards.size())
            {
                // Guard against this
                if (difficulty.getIntelligence() < Math.random() * 5)
                {
                    return (DestinationID) complement.toArray()[(int) choice
                            - cards.size()];
                }
            }
            // Otherwise...
            else
            {
                // Guard against this
                if (difficulty.getIntelligence() < Math.random() * 5)
                {
                    return (DestinationID) cards.toArray()[(int) choice -
                            cards.size()];
                }
            }
        }
        return (DestinationID) cards.toArray()[0];
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param obj method parameter
     */
    public void reactToServer(Object obj)
    {
        // Guard against this
        if (obj instanceof AccusationResponse)
        {
            //check if accusation is correct
            //if not, keep sending endturnrequests
        }
        // Guard against this
        if (obj instanceof CardDealResponse)
        {
            CardDealResponse rsp = (CardDealResponse) obj;
            Card temp = rsp.getCard();
            // Guard against this
            if (temp.getCardType() == CardType.ACTION)
            {
                // Guard against this
                if (temp.getCardType() == CardType.ACTION)
                {
                    actionCardsHand.add((ActionCard) temp);
                }
                // Guard against this
//                if (temp.getCardType() == CardType.HINT)
//                {
//                    hintCardsHand.add((HintCard) temp);
//                }
            }
            
            aiTurn();
            //playActionCard();
            ctrl.reactToRobot(new EndTurnRequest(), this);
        }
        // Guard against this
        if (obj instanceof GameStateResponse)
        {
            GameStateResponse gsr = (GameStateResponse) obj;
            actionCardsHand = gsr.getActionCards();
            hintCardsHand = gsr.getHintCards();
        }
        // Guard against this
        if (obj instanceof KickPlayerResponse)
        {

        }
        // Guard against this
        if (obj instanceof RevealCardResponse)
        {
            RevealCardResponse rsp = (RevealCardResponse) obj;
            // Iterate over this set
            for (Card temp : rsp.getCards())
            {
                // Guard against this
                if (((HintCard) temp).getHintType() == HintCardType.SUSPECT)
                {
                    suspectCardsSeen.add(((SuspectCard) temp).getSuspect());
                }
                // Guard against this
                if (((HintCard) temp).getHintType() == HintCardType.VEHICLE)
                {
                    vehicleCardsSeen.add(((VehicleCard) temp).getVehicle());
                }
                // Guard against this
                if (((HintCard) temp).getHintType() == HintCardType.DESTINATION)
                {
                    locationsSeen.add(((DestinationCard) temp).getDestination());
                }
            }
        }
    }
}
