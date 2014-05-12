package server;

/**
 * AI Class can be used to replace a human player.
 * An AI instance will have its own level of Difficulty
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class AI 
{
    private Difficulty difficulty;
    private ServerController ctrl;

    /**
     * 
     * @param difficulty
     * @param ctrl 
     */
    public AI(Difficulty difficulty, ServerController ctrl) 
    {
        this.difficulty = difficulty;
        this.ctrl = ctrl;
    }

    /**
     * Gets the difficulty associated with this AI.
     * @return The difficulty associated with this AI.
     */
    public Difficulty getDifficulty() 
    {
        return difficulty;
    }
    
    /**
     * Sets the difficulty associated with this AI.
     * @param difficulty The difficulty level of the AI.
     */
    public void setDifficulty(Difficulty difficulty) 
    {
        this.difficulty = difficulty;
    }
	
    /**
     * Sets the ServerController associated with this AI.
     * @param ctrl The ServerController of this AI. 
     */
    public void setServerController(ServerController ctrl) 
    {
        this.ctrl = ctrl;
    }

    /**
     * Invoking this method will allow the AI to take a turn 
     * that will change the game's state. Based on the riskiness \
     * and difficulty of this AI instance the turn will either 
     * be simple, well calculated,  and/or out right risky.
     */
    public void play() 
    {
    }
}