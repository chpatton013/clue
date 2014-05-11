/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package common;


/**
 *
 * @author bennettschalich
 */
public class HintCard extends Card
{
    private HintCardType type;
    
    public HintCard(HintCardType type)
    {
        super(CardType.HINT);
        this.type = type;
    }
    
    public HintCardType getHintType()
    {
        return type;
    }
}
