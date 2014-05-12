package com.outtatech.server;

/**
 * The Difficulty class models the intelligence of an AI and the likeliness an AI is to take risks.
 * @author Steven Chiu
 * @version 1.0 - May 11, 2014
 */
public class Difficulty 
{
    private int intelligence;
    private int riskiness;
    
    /**
     * Constructs a Difficulty with intelligence and riskiness.
     * @param intelligence The intelligence of an AI.
     * @param riskiness The likeliness an AI is to take risks.
     */
    public Difficulty(int intelligence, int riskiness) 
    {
	this.intelligence = intelligence;
	this.riskiness = riskiness;
    }
        
    /**
     * Gets the intelligence of this difficulty.
     * @return The intelligence of this difficulty.
     */
    public int getIntelligence() 
    {
        return intelligence;
    }
    
    /**
     * Sets the intelligence of this difficulty.
     * @param intelligence The likeliness an AI is to take risks.
     */	
    public void setIntelligence(int intelligence) 
    {
        this.intelligence = intelligence;
    }
    
    /**
     * Gets the riskiness of this difficulty.
     * @return the riskiness of this difficulty.
     */
    public int getRiskiness() 
    {
        return riskiness;
    }

    /**
     * Sets the riskiness of this difficulty.
     * @param riskiness The likeliness an AI is to take risks.
     */
    public void setRiskiness(int riskiness) 
    {
        this.riskiness = riskiness;
    }
}