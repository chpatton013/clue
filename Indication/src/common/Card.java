

package common;
/**
 * Card
 * @author Bennett Schalich
 * @version 1.01
 * date: 5/1/14
 * 
 * The Card models represents a clue card. A card has a unique id number that 
 * uniquely identifies it. A card has a type that specifies whether it is an 
 * action card or a suggestion card
 */
public class Card 
{
    private static int id = -1;
    CardType cardType;
    
    public Card(CardType cardType)
    {
        this.cardType = cardType;
        this.id++;
    }
    
    public CardType getCardType()
    {
        return cardType;
    }
    
    public int getID()
    {
        return id;
    }
}
