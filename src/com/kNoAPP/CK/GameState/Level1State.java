package com.kNoAPP.CK.GameState;

import java.awt.Color;
import java.awt.Graphics2D;

import com.kNoAPP.CK.GamePanel;
import com.kNoAPP.CK.TileMap.TileMap;

public class Level1State extends GameState {
	
	private TileMap tileMap;
	
	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	public void init() {
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("/Maps/level1-1.map");
		tileMap.setPosition(0, 0);
	}

	public void update() {
		
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		tileMap.draw(g);
	}

	public void keyPressed(int k) {
		
	}

	public void keyReleased(int k) {
		
	}

}
