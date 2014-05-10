package server;

import server.ServerPlayer;
import java.util.List;
import java.util.Map;

public class Game {

    private List<ServerPlayer> player;
    private ServerPlayer current;
    private List<ActionCard> drawPile;
    private List<ActionCard> discardPile;
    private List<HintCard> solution;
    private Map<DestinationID, int> DesToPlayerId;

    public Game() 
    {
    }

    /**
     * Current ServerPlayer of the Game instance 
     * 
     * @return current ServerPlayer
     */
    public ServerPlayer getCurrentServerPlayer() 
    {
        return current;
    }
    
    public List<ActionCard> getDrawPile() 
    {
        return drawPile;
    }
    
    public List<ActionCard> getDiscardPile() 
    {
        return discardPile;
    }
    
    public List<ActionCard> getSolution() 
    {
        return solution;
    }
}