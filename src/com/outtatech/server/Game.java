package com.outtatech.server;

import com.outtatech.common.*;
import com.outtatech.common.ActionCard;
import com.outtatech.common.DestinationID;
import com.outtatech.common.HintCard;
import com.outtatech.common.Solution;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The Game class contains functions that provide information on the state of an
 * Indication Game and provide functions that can change the state of the Game.
 *
 * @author Steven Chiu, Brian Schacherer
 * @version 1.0 - May 11, 2014
 */
public class Game
{
    private static Integer gameIdCounter = 0;
    private Integer gameId;
    private Map <Integer, ServerPlayer> players;
    private ServerPlayer current;
    private List<ActionCard> drawPile;
    private List<ActionCard> discardPile;
    private List<HintCard> listHintCards;
    private Solution solution;
    private Map<DestinationID, Integer> destToPlayerId;

    /**
     * Constructor for a Game instance.
     *
     * @param player List of Player Objects.
     * @param current ServerPlayer representing the player currently taking a
     * turn.
     * @param drawPile List of ActionCard Objects
     * @param discardPile List of ActionCard Objects
     * @param solution List of HintCard Objects
     * @param destToPlayerId Map of DestinationID to Integer represents which
     * player is on which DestinationID
     */
    public Game(Map<Integer, ServerPlayer> players,
            ServerPlayer current,
            List<ActionCard> drawPile,
            List<ActionCard> discardPile,
            Solution solution,
            Map<DestinationID, Integer> destToPlayerId)
    {
        this.players = players;
        this.current = current;
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.solution = solution;
        this.destToPlayerId = destToPlayerId;
        this.gameId = ++gameIdCounter;
    }
    
    
    public Game()
    {
        this.players = new ConcurrentHashMap<Integer, ServerPlayer>();
        this.current = null;
        this.drawPile = initializeDrawPile();
        this.discardPile = new CopyOnWriteArrayList<ActionCard>();
        this.listHintCards = initializeHintCards();
        this.solution = pickSolution();
        this.destToPlayerId = null;
        this.gameId = ++gameIdCounter;
    }

    /**
     * Add a ServerPlayer to the List of ServerPlayers in this game.
     *
     * @param newPlayer The ServerPlayer to add to the Game
     */
    public void addServerPlayer(ServerPlayer newPlayer)
    {
        players.put(newPlayer.getPlayerId(), newPlayer);
    }
    
    /**
     * Gets the Map of ServerPlayers in this game.
     *
     * @return The Map of ServerPlayers in this game.
     */
    public Map<Integer, ServerPlayer> getServerPlayers()
    {
        return players;
    }
    
    public List<ServerPlayer> getServerPlayersList()
    {
        return new ArrayList(players.values());
    }
    
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<Player>();
        for (Player player : this.getServerPlayers().values()) {
           players.add(player);
        }
        return players;
    }

    /**
     * Sets the current ServerPlayer in this game.
     *
     * @param current The ServerPlayer to make current in the Game
     */
    public void setCurrentServerPlayer(ServerPlayer current)
    {
        this.current = current;
    }
    
    /**
     * Gets the current ServerPlayer associated with this game.
     *
     * @return The current ServerPlayer associated with this game.
     */
    public ServerPlayer getCurrentServerPlayer()
    {
        return current;
    }
    
    /**
     * Sets the drawPile of this game.
     *
     * @param drawPile The new drawPile for this Game
     */
    public void setDrawPile(List<ActionCard> drawPile)
    {
        this.drawPile = drawPile;
    }

    /**
     * Gets the drawPile of this game.
     *
     * @return The drawPile of this game.
     */
    public List<ActionCard> getDrawPile()
    {
        return drawPile;
    }
    
    /**
     * Sets the discardPile of this game.
     *
     * @param discardPile The new discardPile for this Game
     */
    public void setDiscardPile(List<ActionCard> discardPile)
    {
        this.discardPile = discardPile;
    }
    
    /**
     * Gets the solution of this game.
     *
     * @return The discardPile of this game.
     */
    public List<ActionCard> getDiscardPile()
    {
        return discardPile;
    }

    /**
     * Sets the solution of this game.
     *
     * @param solution The new solution for this game
     */
    public void setSolution(Solution solution)
    {
        this.solution = solution;
    }

    /**
     * Gets the solution of this game.
     *
     * @return The solution of this game.
     */
    public Solution getSolution()
    {
        return solution;
    }

    /**
     * Sets the Map between destination Ids and playerIds for this game.
     *
     * @param destToPlayerId The new Map of destination Ids and PlayerIds for 
     * this game
     */
    public void setDestToPlayerId(Map<DestinationID, Integer> destToPlayerId)
    {
        this.destToPlayerId = destToPlayerId;
    }
    
    /**
     * Gets the Map between destination Ids and playerIds for this game.
     *
     * @return The Map of destination Ids and PlayerIds for this game
     */
    public Map<DestinationID, Integer> getDestToPlayerId()
    {
        return destToPlayerId;
    }
    
    public Integer getGameId() 
    {
        return gameId;
    }
    
    private List<ActionCard> initializeDrawPile() 
    {
        List<ActionCard> drawPileT = new CopyOnWriteArrayList<ActionCard>();
        int countSuggestionANY = 10;
        int countSuggestionCURRENT = 9;
        int countSnoop = 4;
        int countAllSnoopLEFT = 2;
        int countAllSnoopRIGHT = 2;
        boolean right = true;
        
        for(int index = 0; index < countSuggestionANY; index++)
        {
            drawPileT.add(new Suggestion(SuggestionType.ANY));
        }
        
        for(int index = 0; index < countSuggestionCURRENT; index++)
        {
            drawPileT.add(new Suggestion(SuggestionType.CURRENT));   
        }
        
        for(int index = 0; index < countSnoop; index++)
        {
            drawPileT.add(new Snoop());
        }
        
        for(int index = 0; index < countAllSnoopLEFT; index++)
        {
            drawPileT.add(new AllSnoop(!right));
        }
        
        for(int index = 0; index < countAllSnoopRIGHT; index++)
        {
            drawPileT.add(new AllSnoop(right));
        }
                
        drawPileT.add(new SuperSleuth(SuperSleuthType.FEMALE_SUSPECT));
        drawPileT.add(new SuperSleuth(SuperSleuthType.MALE_SUSPECT));
        drawPileT.add(new SuperSleuth(SuperSleuthType.AIR_VEHICLE));
        drawPileT.add(new SuperSleuth(SuperSleuthType.BLUE_CARD));
        drawPileT.add(new SuperSleuth(SuperSleuthType.SOUTHERN_DESTINATION));
        drawPileT.add(new SuperSleuth(SuperSleuthType.WESTERN_DESTINATION));

        drawPileT.add(new PrivateTip(PrivateTipType.ALL_SUSPECTS));
        drawPileT.add(new PrivateTip(PrivateTipType.ALL_VEHICLES));
        drawPileT.add(new PrivateTip(PrivateTipType.ALL_DESTINATIONS));
        drawPileT.add(new PrivateTip(PrivateTipType.ONE_FEMALE_SUSPECT));
        drawPileT.add(new PrivateTip(PrivateTipType.ONE_RED_VEHICLE));
        drawPileT.add(new PrivateTip(PrivateTipType.ONE_NORTHERN_DESTINATION));
        
        Collections.shuffle(drawPileT);
        return drawPileT;
    }
    
    public ActionCard popActionCard()
    {
        ActionCard ac = null;
        
        if(drawPile.size() > 0)
        {
            ac = drawPile.remove(0);
        }
            
        return ac;
    }
    
    /**
     * Creates a list of HintCards for the game to 
     * first pick a solution then for the game to deal.
     * @param hintCards 
     */
    private List<HintCard> initializeHintCards()
    {
        List<HintCard> hintCards = new CopyOnWriteArrayList<HintCard>();
        CardColor dc = CardColor.BLUE;
        
        //6 Suspect cards, 6 Vehicle cards, and 9 Destination cards.
        hintCards.add(new SuspectCard(SuspectID.GREEN, dc));
        hintCards.add(new SuspectCard(SuspectID.MUSTARD, dc));
        hintCards.add(new SuspectCard(SuspectID.PEACOCK, dc));
        hintCards.add(new SuspectCard(SuspectID.PLUM, dc));
        hintCards.add(new SuspectCard(SuspectID.SCARLET, dc));
        hintCards.add(new SuspectCard(SuspectID.WHITE, dc));
        
        hintCards.add(new VehicleCard(VehicleID.AIRLINER, dc));
        hintCards.add(new VehicleCard(VehicleID.AUTOMOBILE, dc));
        hintCards.add(new VehicleCard(VehicleID.HOT_AIR_BALLOON, dc));
        hintCards.add(new VehicleCard(VehicleID.LIMOUSINE, dc));
        hintCards.add(new VehicleCard(VehicleID.SEAPLANE, dc));
        hintCards.add(new VehicleCard(VehicleID.TRAIN, dc));
        
        hintCards.add(new DestinationCard(DestinationID.CONEY_ISLAND, dc));
        hintCards.add(
                new DestinationCard(DestinationID.GOLDEN_GATE_BRIDGE, dc));
        hintCards.add(new DestinationCard(DestinationID.HOOVER_DAM, dc));
        hintCards.add(new DestinationCard(DestinationID.LINCOLN_MEMORIAL, dc));
        hintCards.add(new DestinationCard(DestinationID.MIAMI_BEACH, dc));
        hintCards.add(new DestinationCard(DestinationID.MT_RUSHMORE, dc));
        hintCards.add(new DestinationCard(DestinationID.NIAGRA_FALLS, dc));
        hintCards.add(new DestinationCard(DestinationID.OLD_FAITHFUL, dc));
        hintCards.add(new DestinationCard(DestinationID.THE_ALAMO, dc));
        
        Collections.shuffle(hintCards);
        return hintCards;
    }
    
    /**
     * Get the number of hint cards to be dealt
     * @return List of HintCards
     */
    public Integer getHintCardsSize()
    {
        return this.listHintCards.size();
    }
    
    /**
     * Return the first Hint Card in the List
     * @return HintCard
     */
    public HintCard popHintCard()
    {
        HintCard hintCard = null;
                
        if (listHintCards.size() > 0)
        {
            hintCard = listHintCards.remove(0);
        }
        
        return hintCard;
    }
    
    /**
     * Pre condition listHintCards has been shuffled.
     * @param hintCards
     * @return 
     */
    private Solution pickSolution()
    {
        Solution solution = null;
        DestinationID did = null;
        VehicleID vid = null;
        SuspectID sid = null;
        boolean hasDid = false;
        boolean hasVid = false;
        boolean hasSid = false;
                
        if (listHintCards != null)
        {
            for(HintCard hc : listHintCards)
            {
                if(hc.getHintType() == HintCardType.DESTINATION && !hasDid)
                {
                    did = ((DestinationCard)hc).getDestination();
                    listHintCards.remove(hc);
                    hasDid = true;
                }
                
                if(hc.getHintType() == HintCardType.VEHICLE && !hasVid)
                {
                    vid = ((VehicleCard)hc).getVehicle();
                    listHintCards.remove(hc);
                    hasVid = true;
                }
                
                if(hc.getHintType() == HintCardType.SUSPECT && !hasSid)
                {
                    sid = ((SuspectCard)hc).getSuspect();
                    listHintCards.remove(hc);
                    hasSid = true;
                }
            }
            
            solution = new Solution(did, vid, sid);
        }
        
        return solution;
    }
}
