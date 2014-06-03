package com.outtatech.server;

import com.outtatech.common.*;
import com.outtatech.common.ActionCard;
import com.outtatech.common.DestinationID;
import com.outtatech.common.HintCard;
import com.outtatech.common.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The Game class contains functions that provide information on the state of an
 * Indication Game and provide functions that can change the state of the Game.
 *
 * @author Steven Chiu, Brian Schacherer, James Bilous
 * @version 1.0 - May 11, 2014
 */
public class Game
{
    private static Integer gameIdCounter = 0;
    private Integer gameId;
    private Map<Integer, ServerPlayer> players;
    private ServerPlayer current;
    private List<ActionCard> drawPile;
    private List<DestinationID> destinationPile;
    private List<ActionCard> discardPile;
    private List<HintCard> listHintCards;
    private Solution solution;
    private Map<DestinationID, Integer> destToPlayerId;
    private Map<Integer, DestinationID> playerIdToDest;
    private List<ServerPlayer> playerTurnOrder;
    private int curPlayerTurn;

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
            Map<DestinationID, Integer> destToPlayerId,
            List<ServerPlayer> playerTurnOrder)
    {
        this.players = players;
        this.current = current;
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.solution = solution;
        this.destToPlayerId = destToPlayerId;
        this.gameId = ++gameIdCounter;
        this.playerTurnOrder = playerTurnOrder;
    }

    public Game()
    {
        this.players = new ConcurrentHashMap<Integer, ServerPlayer>();
        this.current = null;
        this.discardPile = new CopyOnWriteArrayList<ActionCard>();
        this.destToPlayerId = null;
        this.gameId = ++gameIdCounter;
    }
    
    /**
     * Sets the players for this game
     * @param players the players for this game
     */
    public void setPlayers(ConcurrentHashMap<Integer, ServerPlayer> players)
    {
        this.players = players;
    }

    public void initialize()
    {
        playerTurnOrder = new ArrayList(players.values());
        curPlayerTurn = 0;
        Collections.shuffle(playerTurnOrder);
        drawPile = this.initializeDrawPile();
        listHintCards = this.initializeHintCards();
        this.solution = pickSolution();
        initDestinations();
    }
    
    /**
     * Move the given player to the given destination.
     * 
     * @param playerId the id of the player to move
     * @param dest the destination to move the player to.
     * 
     * @return the ID of the player whose destination was changed
     */
    public Integer swapLocations(Integer playerId, DestinationID dest)
    {
        //Get the players current destination
        DestinationID curLoc = playerIdToDest.get(playerId);
        destToPlayerId.remove(curLoc);

        //Find out who has the other destination
        Integer otherPlayerID = destToPlayerId.get(dest);

        if (otherPlayerID != null) 
        {
            destToPlayerId.remove(dest);
            destToPlayerId.put(curLoc, otherPlayerID);
        }               
        destToPlayerId.put(dest, playerId);
        
        playerIdToDest.remove(playerId);
        playerIdToDest.put(playerId, dest);
        if (otherPlayerID != null)
        {
            playerIdToDest.remove(otherPlayerID);
            playerIdToDest.put(otherPlayerID, curLoc);
        }
        
        return otherPlayerID;
    }

    /**
     * Method that shuffles the destinations and assigns one to each player
     */
    private void initDestinations()
    {
        destToPlayerId = new ConcurrentHashMap<DestinationID, Integer>();
        playerIdToDest = new ConcurrentHashMap<Integer, DestinationID>();
        destinationPile = new ArrayList<DestinationID>(Arrays.asList(
                DestinationID.CONEY_ISLAND, DestinationID.GOLDEN_GATE_BRIDGE,
                DestinationID.HOOVER_DAM, DestinationID.LINCOLN_MEMORIAL,
                DestinationID.MIAMI_BEACH, DestinationID.MT_RUSHMORE,
                DestinationID.NIAGRA_FALLS,
                DestinationID.OLD_FAITHFUL, DestinationID.THE_ALAMO));

        Collections.shuffle(destinationPile);

        for (int playerIndex = 0; playerIndex < players.values().size();
                playerIndex++)
        {
            destToPlayerId.put(destinationPile.get(0), players.get(playerIndex).
                    getPlayerId());
            playerIdToDest.put(players.get(playerIndex).getPlayerId(),
                    destinationPile.remove(0));
        }
    }

    /**
     * Advances the games turn to the next player.
     *
     * @return the next player whose turn it is
     */
    public ServerPlayer advanceTurn()
    {
        curPlayerTurn = (curPlayerTurn + 1) % playerTurnOrder.size();
        System.out.println("advancing turn index to " + curPlayerTurn);
        return this.getCurrentPlayer();
    }

    /**
     * Get the current player whose turn it is.
     *
     * @return the current player whose turn it is.
     */
    public ServerPlayer getCurrentPlayer()
    {
        return playerTurnOrder.get(curPlayerTurn);
    }

    /**
     * Returns the id for the player array for the currently active player.
     *
     * @return the id of the currently active player;
     */
    public Integer getCurrentPlayerIndex()
    {
        return curPlayerTurn;
    }

    /**
     * Returns the player turn order for this game
     *
     * @return the player turn order.
     */
    public List<ServerPlayer> getPlayerTurnOrder()
    {
        return playerTurnOrder;
    }

    /**
     * Returns the ids of the player turn order for this game
     *
     * @return the player turn order.
     */
    public List<Integer> getPlayerIdTurnOrder()
    {
        List<Integer> ids = new ArrayList<Integer>();
        for (ServerPlayer player : playerTurnOrder)
        {
            ids.add(player.getPlayerId());
        }
        return ids;
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

    public List<Player> getPlayers()
    {
        List<Player> players = new ArrayList<Player>();
        for (Player player : this.getServerPlayers().values())
        {
            players.add(player);
        }
        return players;
    }

    public String getPlayerName(Integer playerId)
    {
        return this.players.get(playerId).getName();
    }

    public Map<Integer, String> getPlayerIdNames()
    {
        Map<Integer, String> names = new ConcurrentHashMap<Integer, String>();
        for (Integer playerId : this.players.keySet())
        {
            names.put(playerId, this.players.get(playerId).getName());
        }
        return names;
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
     * Add an action card to the discard pile.  
     * After using an action card a player must discard the Action card.
     * @param card 
     */
    public void discardActionCard(ActionCard card)
    {
        if(discardPile != null)
        {
            this.discardPile.add(card);
        }
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
    public Map<Integer, DestinationID> getPlayerIdToDest()
    {
        return playerIdToDest;
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

        for (int index = 0; index < countSuggestionANY; index++)
        {
            drawPileT.add(new Suggestion(SuggestionType.ANY));
        }

        for (int index = 0; index < countSuggestionCURRENT; index++)
        {
            drawPileT.add(new Suggestion(SuggestionType.CURRENT));
        }

        for (int index = 0; index < countSnoop; index++)
        {
            drawPileT.add(new Snoop());
        }

        for (int index = 0; index < countAllSnoopLEFT; index++)
        {
            drawPileT.add(new AllSnoop(!right));
        }

        for (int index = 0; index < countAllSnoopRIGHT; index++)
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

        if (drawPile.isEmpty() && this.discardPile.size() > 0)
        {
            while(this.discardPile.size() > 0)
            {
                drawPile.add(this.discardPile.remove(0));
            }
            Collections.shuffle(drawPile);
        }
        
        if (drawPile.size() > 0)
        {
            ac = drawPile.remove(0);
        }

        return ac;
    }

    /**
     * Creates a list of HintCards for the game to first pick a solution then
     * for the game to deal.
     *
     * @param hintCards
     */
    private List<HintCard> initializeHintCards()
    {
        List<HintCard> hintCards = new CopyOnWriteArrayList<HintCard>();
        

        //6 Suspect cards, 6 Vehicle cards, and 9 Destination cards.
        hintCards.add(new SuspectCard(SuspectID.GREEN));
        hintCards.add(new SuspectCard(SuspectID.MUSTARD));
        hintCards.add(new SuspectCard(SuspectID.PLUM));
        hintCards.add(new SuspectCard(SuspectID.PEACOCK));
        hintCards.add(new SuspectCard(SuspectID.SCARLET));
        hintCards.add(new SuspectCard(SuspectID.WHITE));
        
        CardColor dc = CardColor.BLUE;
        hintCards.add(new VehicleCard(VehicleID.HOT_AIR_BALLOON, dc));
        hintCards.add(new VehicleCard(VehicleID.LIMOUSINE, dc));
        hintCards.add(new VehicleCard(VehicleID.SEAPLANE, dc));
        dc = CardColor.RED;
        hintCards.add(new VehicleCard(VehicleID.AIRLINER, dc));
        hintCards.add(new VehicleCard(VehicleID.AUTOMOBILE, dc));
        hintCards.add(new VehicleCard(VehicleID.TRAIN, dc));

        hintCards.add(new DestinationCard(DestinationID.CONEY_ISLAND));
        hintCards.add(
                new DestinationCard(DestinationID.GOLDEN_GATE_BRIDGE));
        hintCards.add(new DestinationCard(DestinationID.HOOVER_DAM));
        hintCards.add(new DestinationCard(DestinationID.LINCOLN_MEMORIAL));
        hintCards.add(new DestinationCard(DestinationID.MIAMI_BEACH));
        hintCards.add(new DestinationCard(DestinationID.MT_RUSHMORE));
        hintCards.add(new DestinationCard(DestinationID.NIAGRA_FALLS));
        hintCards.add(new DestinationCard(DestinationID.OLD_FAITHFUL));
        hintCards.add(new DestinationCard(DestinationID.THE_ALAMO));

        Collections.shuffle(hintCards);
        return hintCards;
    }

    /**
     * Get the number of hint cards to be dealt
     *
     * @return List of HintCards
     */
    public Integer getHintCardsSize()
    {
        return this.listHintCards.size();
    }

    /**
     * Return the first Hint Card in the List
     *
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
     *
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
            for (HintCard hc : listHintCards)
            {
                if (hc.getHintType() == HintCardType.DESTINATION && !hasDid)
                {
                    did = ((DestinationCard) hc).getDestination();
                    listHintCards.remove(hc);
                    hasDid = true;
                }

                if (hc.getHintType() == HintCardType.VEHICLE && !hasVid)
                {
                    vid = ((VehicleCard) hc).getVehicle();
                    listHintCards.remove(hc);
                    hasVid = true;
                }

                if (hc.getHintType() == HintCardType.SUSPECT && !hasSid)
                {
                    sid = ((SuspectCard) hc).getSuspect();
                    listHintCards.remove(hc);
                    hasSid = true;
                }
            }

            solution = new Solution(did, vid, sid);
        }

        return solution;
    }
}
