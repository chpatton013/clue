package common;

/**
 * ActionCard
 * @author bennettschalich
 * @version 1.01
 * date: 5/1/14
 * 
 * The ActionCard class ...
 */

public class ActionCard extends Card
{   
    ActionCardType type;
    
    public ActionCard(ActionCardType type)
    {
        super(CardType.ACTION);
        this.type = type;
    }
    
    public ActionCardType getActionType()
    {
        return type;
    }
    
    public void play()
    {
        
    }
}
