package com.outtatech.client;

import com.outtatech.common.ActionCard;
import com.outtatech.common.Player;
import com.outtatech.server.Difficulty;
import com.outtatech.server.Lobby;
import com.outtatech.server.ServerPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    
    int imageIndex = 0, curPlayerId = -1;
    
    boolean isTurn = false;
    
    String[] imagePaths = {
        "images/greece/",
        "images/whiteHouse/",
        "images/pirate/"};
    
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
        if(obs instanceof ClientLobbyState) {
            curPlayerId = ((ClientLobbyState)obs).getPlayerId();
            //  clear all players
            lobbyScreen.clearPlayers();
            //  add each player back
            Map<Integer, String> playMap = ((ClientLobbyState)obs).getPlayers();
            ArrayList playList = new ArrayList(playMap.keySet());
            lobbyScreen.setId(((ClientLobbyState)obs).getId());
            
            for(int indx = 0; indx < playList.size(); indx++) {
                lobbyScreen.addPlayer(playMap.get(((Integer)playList.get(indx))), ((Integer)playList.get(indx)), ((Integer)playList.get(indx)) == curPlayerId);
            }
            
            lobbyScreen.setLeader(((ClientLobbyState)obs).getGameOwner());
            //Set state to LOBBY
            state = CurrentWindow.LOBBY;

            //hide the game select screen and display the lobby screen
            gameSelectScreen.setVisible(false);
            lobbyScreen.setVisible(true);
        }
        
        //if state is MAINGAME
        if(obs instanceof ClientGameState) {
            curPlayerId = ((ClientGameState)obs).getPlayerId();
            //  call mainGameScreen's clearFields method
            mainGameScreen.clearPlayers();
            //  add each hand card and location back
            Map<Integer, String> playMap = ((ClientGameState)obs).getPlayers();
            ArrayList playList = new ArrayList(playMap.keySet());
            for(int indx = 0; indx < playList.size(); indx++) {
                mainGameScreen.addPlayer(playMap.get(((Integer)playList.get(indx))), ((Integer)playList.get(indx)));
            }
            
            mainGameScreen.updateHand(((ClientGameState)obs).getHand());
            
            //  add any applicable messages to game log through updateGameLog method
            String logUpdate = ((ClientGameState)obs).pollGameLog();
            
            while(logUpdate != null) {
                mainGameScreen.updateGameLog(logUpdate);
                logUpdate = ((ClientGameState)obs).pollGameLog();
            }
            
            //  if it is the client's turn, call startTurn and clearGameLog methods
            isTurn = false;
            Integer currentActive = ((ClientGameState)obs).getCurrentActivePlayer();
            if(currentActive != null && currentActive == curPlayerId) {
                mainGameScreen.startTurn();
                isTurn = true;
            }
            
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
            state = CurrentWindow.MAINGAME;
        
            lobbyScreen.setVisible(false);
            mainGameScreen.setVisible(true);
        }
        
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
        clientController.startSinglePlayerGame();
    }
    
    /**
     *Notifies client controller that player selected to start a multiplayer game
     */
    public void multiplayerSelected() {
        //call Client Controller's setState method with 
        //a parameter of new ClientLobbyDiscoveryState()
        clientController.searchForGames();
        
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
        clientController.startMultiPlayerGame("LOBBYGAME!!!");
    }
    
    /**
     *Notifies client controller that player wants to join a game
     * @param lobbyId
     */
    public void joinGame(int lobbyId) {
        //call Client controller's joinLobby method with the selected lobby's
        //id
        clientController.joinGame(lobbyId);
    }
    
    public void startGame() {
        clientController.startGame();
    }
    
    /**
     *Notifies client controller that player wants to create an AI player
     */
    public void createAI(int lobbyId) {
        //call Client Controller's addAIPlayer method
        clientController.addAIPlayer(new Difficulty(5, 5), lobbyId);
    }
    
    /**
     *Notifies client controller that player wants to remove a player from the lobby
     * @param playerId
     */
    public void kickPlayer(int playerId) {
        //call Client Controller kickPlayer method with the id of the selected
        //player
        if(playerId >= 0) {
            clientController.kickPlayer(playerId);
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
    public void playCard(ActionCard card) {
        if(isTurn) {
            //check type of card

            //call client controller's requestUse method with an action card of 
            //type cardType and selected playerId from game window if 
            //it is a snoop card
        }
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
