package server;

import java.awt.Color;
import java.util.List;

public class ServerPlayer {

	private int playerId;
	private Object notes;
	private String name;
	private Color color;
	private List<Card> hand;

	public ServerPlayer() 
        {
        }
        
	public Object getNotes() 
        {
            return notes;
        }
        
	public void setNotes(Ojbect notes) 
        {
            this.notes = notes;
        }
        
	public String getName() 
        {
            return name;
        }
	
        public void setName(String name) 
        {
            this.name = name;
        }
	
        public Color getColor() 
        {
            return color;
        }
	
        public void setColor(Color color) 
        {
            this.color = color;
        }
	
        public List<Card> getHand() 
        {
            return hand;
        }
	
        public void setHand(List<Card> hand) 
        {
            this.hand = hand;
        }
}