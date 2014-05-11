package com.outtatech.server;


import com.outtatech.server.ServerController;

//import java.util.*;

public class AI {

	private Difficulty difficulty;
	private ServerController ctrl;

	public AI() 
        {
        }
	
        public Difficulty getDifficulty() 
        {
            return difficulty;
        }
	public void setDifficulty(Difficulty difficulty) 
        {
            this.difficulty = difficulty;
        }
	
        public void setServerController(ServerController ctrl) 
        {
            this.ctrl = ctrl;
        }
	
        public void play() 
        {
        }
}