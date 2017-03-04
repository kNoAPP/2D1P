package com.kNoAPP.CK.GameState;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.kNoAPP.CK.Entity.Player;
import com.kNoAPP.CK.TileMap.Background;
import com.kNoAPP.CK.TileMap.TileMap;

public class Level1State extends GameState {
	
	private TileMap tileMap;
	private Background bg;
	
	private Player player;
	
	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	public void init() {
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("/Maps/level1-1.map");
		tileMap.setPosition(0, 0);
		
		bg = new Background("/Backgrounds/grassbg1.gif", 0.1);
		
		player = new Player(tileMap);
		player.setPosition(100, 100);
	}

	public void update() {
		player.update();
	}

	public void draw(Graphics2D g) {
		bg.draw(g);
		
		tileMap.draw(g);
		
		player.draw(g);
	}

	public void keyPressed(int k) {
		if(k == KeyEvent.VK_A) {
			player.setLeft(true);
		}
		if(k == KeyEvent.VK_D) {
			player.setRight(true);
		}
		if(k == KeyEvent.VK_W) {
			player.setUp(true);
		}
		if(k == KeyEvent.VK_S) {
			player.setDown(true);
		}
		if(k == KeyEvent.VK_SPACE) {
			player.setJumping(true);
		}
		if(k == KeyEvent.VK_CONTROL) {
			player.setGliding(true);
		}
		if(k == KeyEvent.VK_E) {
			player.setScratching();
		}
		if(k == KeyEvent.VK_R) {
			player.setFiring();
		}
	}

	public void keyReleased(int k) {
		if(k == KeyEvent.VK_A) {
			player.setLeft(false);
		}
		if(k == KeyEvent.VK_D) {
			player.setRight(false);
		}
		if(k == KeyEvent.VK_W) {
			player.setUp(false);
		}
		if(k == KeyEvent.VK_S) {
			player.setDown(false);
		}
		if(k == KeyEvent.VK_SPACE) {
			player.setJumping(false);
		}
		if(k == KeyEvent.VK_CONTROL) {
			player.setGliding(false);
		}
	}

}
