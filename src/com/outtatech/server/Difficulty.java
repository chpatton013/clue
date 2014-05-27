package com.outtatech.server;

import java.io.Serializable;

/**
 * Version-latenightpizzaparty
 * The Difficulty class models the intelligence of an AI and the likeliness an
 * AI is to take risks.
 *
 * @author Steven Chiu, Brian Schacherer
 * @version 1.0 - May 11, 2014
 */
public class Difficulty implements Serializable
{
    private int intelligence;
    private int riskiness;

    /**
     * Version-latenightpizzaparty
     * Constructs a Difficulty instance with the specified intelligence and
     * riskiness.
     *
     * @param intelligence The intelligence of an AI. method parameter
     * @param riskiness The likeliness an AI is to take risks. method parameter
     */
    public Difficulty(int intelligence, int riskiness)
    {
        this.intelligence = intelligence;
        this.riskiness = riskiness;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the intelligence of this difficulty instance.
     *
     * @return The intelligence of this difficulty. return value
     */
    public int getIntelligence()
    {
        return intelligence;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the intelligence of this difficulty.
     *
     * @param intelligence The likeliness an AI is to take risks. method parameter
     */
    public void setIntelligence(int intelligence)
    {
        this.intelligence = intelligence;
    }

    /**
     * Version-latenightpizzaparty
     * Gets the riskiness of this difficulty.
     *
     * @return the riskiness of this difficulty. return value
     */
    public int getRiskiness()
    {
        return riskiness;
    }

    /**
     * Version-latenightpizzaparty
     * Sets the riskiness of this difficulty.
     *
     * @param riskiness The likeliness an AI is to take risks. method parameter
     */
    public void setRiskiness(int riskiness)
    {
        this.riskiness = riskiness;
    }
}
