/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client;

import com.outtatech.server.Lobby;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Thomas
 */
public class GUIController implements Observer{
    
    IntroScreen introScreen;
    OptionsScreen optionsScreen;
    InstructionsScreen instructionScreen;
    GameSelectScreen gameSelectScreen;
    LobbyScreen lobbyScreen;
    RevealedCardsScreen revealedCardsScreen;
    AccusationScreen accusationScreen;
    MainGameScreen mainGameScreen;
    
    ClientController clientController;
    State gameState;
    
    int imageIndex = 0;
    
    String[] imagePaths = {
        "images\\greece\\",
        "images\\whiteHouse\\",
        "images\\pirate\\"};
    
    private enum CurrentWindow {
        INTRO, GAMESELECT, LOBBY, MAINGAME
    }
    
    private CurrentWindow state = CurrentWindow.INTRO;
    
    public GUIController(ClientController cCtrl){
        clientController = cCtrl;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
    
    public void initWindows(GUIController ctrl){
        introScreen = new IntroScreen(ctrl);
        optionsScreen = new OptionsScreen(ctrl);
        instructionScreen = new InstructionsScreen();
        gameSelectScreen = new GameSelectScreen(ctrl);
        lobbyScreen = new LobbyScreen(ctrl);
        revealedCardsScreen = new RevealedCardsScreen();
        accusationScreen = new AccusationScreen(ctrl);
        mainGameScreen = new MainGameScreen(ctrl);
    }
    
    public void update(Observable obs, Object obj) {
        //check the state
        
        //if state is GAMESELECT
        if(obs instanceof ClientLobbyDiscoveryState) {
            //  clear all lobbies
            gameSelectScreen.clearGames();
            //  add each lobby back
            List<Lobby> lobList = ((ClientLobbyDiscoveryState)obs).getLobbyList();
            for(int indx = 0; indx < lobList.size(); indx++) {
                gameSelectScreen.addGame(lobList.get(indx).getLobbyName(), lobList.get(indx).getLobbyId());
            }
        }
        
        //if state is LOBBY
        //  clear all players
        //  add each player back
        
        //if state is MAINGAME
        //  call mainGameScreen's clearFields method
        //  add each hand card and location back
        //  if it is the client's turn, call startTurn and clearGameLog methods
        //  add any applicable messages to game log through updateGameLog method
        //  check client controller's reveal flag
        //
        //  if set
        //    add applicable card to revealCardsScreen
        //    show revealCardsScreen
        //  
        //  check clientController's correctAccusation flag
        //
        //  if set
        //    add applicable message to mainGameScreen's game log
        //  
        //  check clientController's falseAccusation flag
        //    
        //  if set
        //    add applicable message to mainGameScreen's game log
    }
    
    /**
     *Returns user to the starting screen
     */
    public void exitWindow() {
        //hide all windows except intro screen
        introScreen.setVisible(true);
        optionsScreen.setVisible(false);
        instructionScreen.setVisible(false);
        gameSelectScreen.setVisible(false);
        lobbyScreen.setVisible(false);
        revealedCardsScreen.setVisible(false);
        accusationScreen.setVisible(false);
        mainGameScreen.setVisible(false);
        
        //set state to INTRO
        state = CurrentWindow.INTRO;
    }
    
    /**
     *Shows the instructions screen
     */
    public void showInstructions() {
        //make the instructions window visible
        instructionScreen.setVisible(true);
    }
    
    /**
     *Shows the options screen
     */
    public void showOptions() {
        //make the options window visible
        optionsScreen.setVisible(true);
    }
    
    /**
     *Notifies client controller that player selected to start a single player game
     */
    public void singlePlayerSelected() {
        //call Client Controller's setState method with 
        //a parameter of new ClientLobbyState()
        
        lobbyScreen.clearPlayers();
        
        //set state to LOBBY
        state = CurrentWindow.LOBBY;
        
        //hide the Intro screen and display the lobby screen
        introScreen.setVisible(false);
        lobbyScreen.setVisible(true);
    }
    
    /**
     *Notifies client controller that player selected to start a multiplayer game
     */
    public void multiplayerSelected() {
        //call Client Controller's setState method with 
        //a parameter of new ClientLobbyDiscoveryState()
        
        //populate the GameSelectScreen's text box with the lobbies from the
        //state
        gameSelectScreen.clearGames();
        
        //set state to GAMESELECT
        state = CurrentWindow.GAMESELECT;
        
        //hide the intro screen and show the game select screen
        introScreen.setVisible(false);
        gameSelectScreen.setVisible(true);
    }
    
    /**
     *Notifies client controller that player wants to create a game
     */
    public void createGame() {
        //call Client Controller's setState method with 
        //a parameter of new ClientLobbyState()
        
        //populate the lobby screen
        lobbyScreen.clearPlayers();
        
        //Set state to LOBBY
        state = CurrentWindow.LOBBY;
        
        //hide the game select screen and display the lobby screen
        gameSelectScreen.setVisible(false);
        lobbyScreen.setVisible(true);
    }
    
    /**
     *Notifies client controller that player wants to join a game
     * @param lobbyId
     */
    public void joinGame(int lobbyId) {
        //call Client controller's joinLobby method with the selected lobby's
        //id
        
        //populate the lobby screen with the appropriate player names
        lobbyScreen.clearPlayers();
        
        //Set state to LOBBY
        state = CurrentWindow.LOBBY;
        
        //hide the game select screen and display the lobby screen
        gameSelectScreen.setVisible(false);
        lobbyScreen.setVisible(true);
    }
    
    public void startGame() {
        state = CurrentWindow.MAINGAME;
        
        lobbyScreen.setVisible(false);
        mainGameScreen.setVisible(true);
    }
    
    /**
     *Notifies client controller that player wants to create an AI player
     */
    public void createAI() {
        //call Client Controller's addAIPlayer method
    }
    
    /**
     *Notifies client controller that player wants to remove a player from the lobby
     * @param playerId
     */
    public void kickPlayer(int playerId) {
        //call Client Controller kickPlayer method with the id of the selected
        //player
        if(playerId >= 0) {
        }
    }
    
    /**
     *Begins the accusation process
     */
    public void accuse(){
        //show the accusation window
        accusationScreen = new AccusationScreen(this);
        accusationScreen.setVisible(true);
    }
    
    /**
     *Notifies client controller that player has made an accusation
     * @param cardType1
     * @param cardType2
     * @param cardType3
     */
    public void makeAccusation(int cardType1, int cardType2, int cardType3) {
        //call client controller's makeAccusation method with the 3 cards
        //specified
        
    }
    
    /**
     *Notifies client controller that player has played a card
     * @param cardType
     */
    public void playCard(int cardType) {
        //check type of card
        
        //call client controller's requestUse method with an action card of 
        //type cardType and selected playerId from game window if 
        //it is a snoop card
    }
    
    /**
     *Notifies client controller that player has ended their turn
     */
    public void endTurn() {
        revealedCardsScreen.setVisible(false);
        accusationScreen.setVisible(false);
        
        //call client controller's end turn method
    }
    
    public void setImageIndex(int indx){
        imageIndex = indx;
    }
    
    public int getImageIndex() {
        return imageIndex;
    }
    
    public String getImagePath(){
        return imagePaths[imageIndex];
    }
    
    public String getImagePath(int indx){
        if(indx < 3) 
            return imagePaths[indx];
        else return null;
    }
}
