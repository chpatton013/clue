package com.outtatech.server;

import com.outtatech.client.messaging.*;
import com.outtatech.common.*;
import com.outtatech.server.messaging.*;
import java.awt.Color;
import java.util.*;
import java.util.Random;

/**
 * Version-latenightpizzaparty AI Class can be used to replace a human player.
 * An AI instance will have its own level of Difficulty
 *
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class AI extends ServerPlayer
{
    private Difficulty difficulty;
    private ServerController ctrl;
    private Game game;
    private boolean Accused = false;

    /**
     * Version-latenightpizzaparty Construct an AI instance, requires
     * instantiated instances of Difficulty and ServerController.
     *
     * @param difficulty the Difficulty instance to drive the AI method
     * parameter
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
     * Version-latenightpizzaparty Gets the difficulty associated with this AI.
     *
     * @return The difficulty associated with this AI. return value
     */
    public Difficulty getDifficulty()
    {
        return difficulty;
    }

    /**
     * Getter method for the AI's game
     *
     * @return the AI's game
     */
    public Game getGame()
    {
        return game;
    }

    /**
     * Version-latenightpizzaparty Sets the difficulty associated with this AI.
     *
     * @param difficulty The difficulty level of the AI. method parameter
     */
    public void setDifficulty(Difficulty difficulty)
    {
        this.difficulty = difficulty;
    }

    /**
     * Version-latenightpizzaparty Gets the ServerController associated with
     * this AI.
     *
     * @return ctrl The ServerController of this AI. return value
     */
    public ServerController getServerController()
    {
        return ctrl;
    }

    /**
     * Version-latenightpizzaparty Sets the ServerController associated with
     * this AI.
     *
     * @param ctrl The ServerController of this AI. method parameter
     */
    public void setServerController(ServerController ctrl)
    {
        this.ctrl = ctrl;
    }

    /**
     * Version-latenightpizzaparty Method invoked when AI needs to respond to
     * Action cards requiring it's participation.
     *
     * @param card The card to respond to. method parameter
     * @return playableCards The list of cards to show or null if there are no
     * return value compatible cards found.
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
                HintCardType curHintType = hintCardsHand.get(cardInHand).
                        getHintType();

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
                HintCardType curHintType = hintCardsHand.get(cardInHand).
                        getHintType();

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
     * Version-latenightpizzaparty Method invoked when it is AI's turn to play
     * an action card.
     */
    public void aiTurn()
    {
        // Guard against this
        if (aiMakeAccusation())
        {
            return;
        }

        System.out.println("AI " + this.getPlayerId() + " is taking its turn");
        int choice = 0;
        if (difficulty.getIntelligence() <= 2)
        {
            choice = (int) (Math.random() * actionCardsHand.size());
        }
        else
        {
            choice = getBestCardToPlay();
        }
        System.out.println("Picking card: " + choice);
        ActionCard cardToPlay = actionCardsHand.get(choice);
        System.out.println("AI : I'm going to play the card " + cardToPlay.
                getActionType());

        // Guard against this
        if (cardToPlay.getActionType() == ActionCardType.SUGGESTION)
        {
            //System.out.println("Can play this fucking suggestion!");
            aiMakeSuggestion((Suggestion) cardToPlay);
        }
        // Otherwise...
        else if (cardToPlay.getActionType() == ActionCardType.SNOOP
                || cardToPlay.getActionType() == ActionCardType.PRIVATE_TIP)
        {
            int randomPlayer = getRandomPlayerID();
            System.out.println("AI chose playerID " + randomPlayer
                    + " as the target");
            ctrl.reactToRobot(new ActionRequest(cardToPlay,
                    getRandomPlayerID()), this);
        }
        // Otherwise...
        else
        {
            ctrl.reactToRobot(new ActionRequest(cardToPlay, null), this);
        }

    }

    private int getBestCardToPlay()
    {
        if (actionCardsHand.get(0) instanceof SuperSleuth)
        {
            return 0;
        }
        else if (actionCardsHand.get(1) instanceof SuperSleuth)
        {
            return 1;
        }
        return (int) (Math.random() * 2);
    }

    /**
     * Version-latenightpizzaparty Returns ID of random player in game.
     *
     * @return playerID ID of random player in game. return value
     */
    private Integer getRandomPlayerID()
    {
        Integer playerID = this.getPlayerId();

        // Iterate until false
        while (playerID == this.getPlayerId())
        {
            int index = (int) (Math.random() * game.getServerPlayersList().
                    size());
            playerID = game.getServerPlayersList().get(index).getPlayerId();
        }

        return playerID;
    }

    private void aiMakeSuggestion(Suggestion card)
    {
        SuspectID choice1;
        VehicleID choice2;
        DestinationID choice3;

        System.out.println("AI is making a suggestion of : ");
        // Guard against this
        if (((Suggestion) card).getType() == SuggestionType.ANY)
        {
            choice1 = getSuspectChoice(suspectCardsSeen);
            System.out.println("Suspect picked it: " + choice1);
            choice2 = getVehicleChoice(vehicleCardsSeen);
            System.out.println("Vehicle picked is: " + choice2);
            choice3 = getLocationChoice(locationsSeen);
            System.out.println("Location picked is: " + choice3);

            ctrl.reactToRobot(new SuggestionRequest(card,
                    new Solution(choice3, choice2, choice1), choice3), this);

        }
        // Otherwise...
        else
        {
            choice1 = getSuspectChoice(suspectCardsSeen);
            choice2 = (getVehicleChoice(vehicleCardsSeen));
            choice3 = game.getPlayerIdToDest().get(this.getPlayerId());
            System.out.println(choice3);

            ctrl.reactToRobot(new SuggestionRequest(card,
                    new Solution(this.getLocation(), choice2, choice1), choice3),
                    this);
        }

    }

    /**
     * Version-latenightpizzaparty Method invoked when another player or bot
     * makes a suggestion.
     *
     * @param suspect The ID of suspect in the suggestion. method parameter
     * @param vehicle The ID of vehicle in the suggestion. method parameter
     * @param destination The ID of location in the suggestion. method parameter
     * @return HintCard The card that refutes the suggestion. return value
     */
    public HintCard aiRefuteSuggestion(SuspectID suspect, VehicleID vehicle,
            DestinationID destination)
    {
        System.out.println("AI " + getPlayerId()
                + " is attempting to refute the suggetsion");
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
                    System.out.println("AI HAS suspect " + suspect);
                    return card;
                }
            }
            // Otherwise...
            else if (card instanceof DestinationCard)
            {
                // Guard against this
                if (((DestinationCard) card).getDestination() == destination)
                {
                    System.out.println("AI HAS destination " + destination);
                    return card;
                }
            }
            // Otherwise...
            else if (card instanceof VehicleCard)
            {
                // Guard against this
                if (((VehicleCard) card).getVehicle() == vehicle)
                {
                    System.out.println("AI HAS vehicle " + vehicle);
                    return card;
                }
            }
        }
        System.out.println("AI could not refute card.");
        return null;
    }

    /**
     * Version-latenightpizzaparty Method invoked each time AI plays a turn in
     * order to determine whether or not to make an accusation based on the AI
     * difficulty level.
     *
     * @return boolean Returns true if accusation has been made, false if it
     * return value hasn't.
     */
    private boolean aiMakeAccusation()
    { // void for sake of complitation w/pseudocde. should return a boolean
        // knowledge = (add number of known cards in each category 
        // number of cards in each category) / 3
        float knowledge = ((suspectCardsSeen.size() - 1) / 6.0f + (vehicleCardsSeen.
                size() - 1)
                / 6.0f + (locationsSeen.size() - 1) / 9.0f) / 3.0f;
        System.out.println("suspects seen: " + suspectCardsSeen.size());
        System.out.println("vehicles seen: " + vehicleCardsSeen.size());
        System.out.println("locations seen: " + locationsSeen.size());
        System.out.println("Knowledge coefficient of AI is: " + knowledge);
        System.out.println("AI riskiness variable is: " + difficulty.
                getRiskiness());
        // if knowledge < riskiness of AI
        // Guard against this
        if ((knowledge * 6) <= difficulty.getRiskiness() 
                || game.getDrawPile().size() <= 3)
        //  return false
        {
            System.out.println("Will not make an accusation!");
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
            System.out.println("Making a accusation!");
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
            System.out.println(choice);
            System.out.println(difficulty.getIntelligence());
            // Guard against this
            if (choice * (cards.size() + complement.size()) > cards.size())
            {
                // Guard against this
                System.out.println("standard suggestion");
                if (difficulty.getIntelligence() > Math.random() * 5)
                {
                    System.out.println("Picking card" + ((int) (choice * (cards.size() + complement.size())) - cards.size()));
                    return (SuspectID) complement.toArray()[(int) (choice * (cards.size() + complement.size()))
                            - cards.size()];
                }
            }
            // Otherwise...
            else
            {
                // Guard against this
                System.out.println("Dumb sugegstion");
                if (difficulty.getIntelligence() < Math.random() * 5)
                {
                    System.out.println("Picking a card");
                    return (SuspectID) cards.toArray()[(int) (choice * (cards.size() + complement.size()))
                            - cards.size()];
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
                if (difficulty.getIntelligence() > Math.random() * 5)
                {
                    return (VehicleID) complement.toArray()[(int) (choice * (cards.size() + complement.size()))
                            - cards.size()];
                }
            }
            // Otherwise...
            else
            {
                // Guard against this
                if (difficulty.getIntelligence() < Math.random() * 5)
                {
                    return (VehicleID) cards.toArray()[(int) (choice * (cards.size() + complement.size()))
                            - cards.size()];
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
                if (difficulty.getIntelligence() > Math.random() * 5)
                {
                    return (DestinationID) complement.toArray()[(int) (choice * (cards.size() + complement.size()))
                            - cards.size()];
                }
            }
            // Otherwise...
            else
            {
                // Guard against this
                if (difficulty.getIntelligence() < Math.random() * 5)
                {
                    return (DestinationID) cards.toArray()[(int) choice - cards.
                            size()];
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
        System.out.println("Server gave me a message!");
        // Guard against this
        if (obj instanceof AccusationResponse)
        {
            System.out.println("AI got an AccusationRepsonse!");
            AccusationResponse rsp = (AccusationResponse) obj;
            //check if accusation is correct
            //if not, keep sending endturnrequests
            if(getPlayerId() == rsp.getPlayerId() && 
                    !rsp.getCorrectAccusation()) 
            {
                Accused = true;
            }
        }
        // Guard against this
        else if (obj instanceof CardDealResponse)
        {
            System.out.println("AI got an CardDealRepsonse!");
            CardDealResponse rsp = (CardDealResponse) obj;
            Card temp = rsp.getCard();
            // Guard against this
            if (temp != null && temp.getCardType() == CardType.ACTION)
            {
                // Guard against this
                if (temp.getCardType() == CardType.ACTION)
                {
                    actionCardsHand.add((ActionCard) temp);
                }
            }
            if(!Accused) 
            {
                aiTurn();
            }
            //playActionCard();
            ctrl.reactToRobot(new EndTurnRequest(), this);
        }
        else if (obj instanceof SuggestionResponse) 
        {
            System.out.println("Got a response");
        }
        // Guard against this
        else if (obj instanceof GameStateResponse)
        {
            System.out.println("AI got an GameStateResponse!");
            GameStateResponse gsr = (GameStateResponse) obj;
            actionCardsHand = gsr.getActionCards();
            hintCardsHand = gsr.getHintCards();
            for (HintCard temp : hintCardsHand)
            {
                // Guard against this
                if (((HintCard) temp).getHintType() == HintCardType.SUSPECT)
                {
                    System.out.println("AI found " + ((SuspectCard) temp).
                            getSuspect());
                    suspectCardsSeen.add(((SuspectCard) temp).getSuspect());
                }
                // Guard against this
                else if (((HintCard) temp).getHintType() == HintCardType.VEHICLE)
                {
                    System.out.println("AI found " + ((VehicleCard) temp).
                            getVehicle());
                    vehicleCardsSeen.add(((VehicleCard) temp).getVehicle());
                }
                // Guard against this
                else if (((HintCard) temp).getHintType()
                        == HintCardType.DESTINATION)
                {
                    System.out.println("AI found " + ((DestinationCard) temp).
                            getDestination());
                    locationsSeen.add(((DestinationCard) temp).getDestination());
                }
            }
        }
        // Guard against this
        else if (obj instanceof KickPlayerResponse)
        {
            System.out.println("AI got an KickPlayerRepsonse!");
        }
        // Guard against this
        else if (obj instanceof RevealCardResponse)
        {
            System.out.println("AI got an RevealCardRepsonse!");
            System.out.println("AI got some cards!");
            RevealCardResponse rsp = (RevealCardResponse) obj;
            // Iterate over this set
            for (Card temp : rsp.getCards())
            {
                // Guard against this
                if (((HintCard) temp).getHintType() == HintCardType.SUSPECT)
                {
                    System.out.println("AI found " + ((SuspectCard) temp).
                            getSuspect());
                    suspectCardsSeen.add(((SuspectCard) temp).getSuspect());
                }
                // Guard against this
                else if (((HintCard) temp).getHintType() == HintCardType.VEHICLE)
                {
                    System.out.println("AI found " + ((VehicleCard) temp).
                            getVehicle());
                    vehicleCardsSeen.add(((VehicleCard) temp).getVehicle());
                }
                // Guard against this
                else if (((HintCard) temp).getHintType()
                        == HintCardType.DESTINATION)
                {
                    System.out.println("AI found " + ((DestinationCard) temp).
                            getDestination());
                    locationsSeen.add(((DestinationCard) temp).getDestination());
                }
            }
        }
    }
}
