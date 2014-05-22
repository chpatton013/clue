package com.outtatech.server;

import com.outtatech.common.*;

/**
 * AI Class can be used to replace a human player. An AI instance will have its
 * own level of Difficulty
 *
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class AI
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
    public AI(Difficulty difficulty, ServerController ctrl)
    {
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
     * @return playableCards The list of cards to show.
     */
    public void aiRespond(ActionCard card)
    { // void for sake of complitation w/pseudocde. should return a List
        // This method won't require knowledge of game state or any reasoning methods. 
        // List playableCards

            // typeCardToShow = type of card required // E.g. male suspect, southern location, etc.
        // numCardsToShow = number of cards to show // can either be 1 or all cards of the type
            // // Responses that require specific cards to be found in hand and shown to player(s).
        // if card is a super-sleuth card or private tip {
        // 	for each card cardInHand in hand {
        // 		if cardInHand matches the typeCardToShow {
        // 			add card to list playableCards
        // 			if numCardsToShow == 1
        // 				break
        // 		}
        // 	}
        // }
            // if playableCards is empty {
        // 	display “no such card in hand” message in log
        // 	return null
        // }
        // else 
        //  return playableCards;
    }

    /**
     * Method invoked when it is AI's turn to play an action card.
     */

    public void aiTurn()
    {

            // if aiMakeAccusation == false { //if not time to make accusation, play normally. otherwise function aiMakeAccusation will accuse
        // 	if number of actionCards in deck == 1
        // 		add next action card from deck to hand
            // 	if generate random number between 1 and 2 == 1
        // 		reactToRobot(first actionCard)
        // 	else
        // 		reactToRobot(second actionCard)
        // }
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

            // for each card in hand {
        // 	if card == suspectcard or card == locationcard or card == vehiclecard{
        // 		return Card
        // 	}
        // }
        return null;

    }

    /**
     * Method invoked each time AI plays a turn in order to determine whether or
     * not to make an accusation based on the AI difficulty level.
     *
     * @return boolean Returns true if accusation has been made, false if it
     * hasn't.
     */
    private void aiMakeAccusation()
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
        // 	return true
        // }
    }
}
