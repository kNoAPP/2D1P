package com.kNoAPP.CK.GameState;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager {

	private static ArrayList<GameState> gameStates;
	private static int currentState;
	
	public static final int MENUSTATE = 0;
	public static final int LEVEL1STATE = 1;
	
	public GameStateManager() {
		gameStates = new ArrayList<GameState>();
		
		currentState = MENUSTATE;
		gameStates.add(new MenuState(this));
		gameStates.add(new Level1State(this));
	}
	
	public void setState(int state) {
		currentState = state;
		getCurrent().init();
	}
	
	public void update() {
		getCurrent().update();
	}
	
	public void draw(Graphics2D g) {
		getCurrent().draw(g);
	}
	
	public void keyPressed(int k) {
		getCurrent().keyPressed(k);
	}
	
	public void keyReleased(int k) {
		getCurrent().keyReleased(k);
	}
	
	public static GameState getCurrent() {
		return gameStates.get(currentState);
	}
}
