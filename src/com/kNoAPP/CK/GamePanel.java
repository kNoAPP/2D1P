package com.kNoAPP.CK;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.kNoAPP.CK.GameState.GameStateManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {

	//Settings
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	public static final int SCALE = 6;
	
	//Window Stuffs
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	//Image
	private BufferedImage image;
	private Graphics2D g;
	
	//GSM
	private GameStateManager gsm;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	private void init() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;
		
		gsm = new GameStateManager();
	}
	
	public void run() {
		init(); //Begins the Program
		
		long start;
		long elapsed;
		long wait;
		
		//Game Loop
		while(running) {
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed/100000;
			if(wait < 0) wait = 5;
			
			try{
				Thread.sleep(wait);
			} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	private void update() {
		gsm.update();
	}
	
	private void draw() {
		gsm.draw(g);
	}
	
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key) {

	}
	
	public void keyPressed(KeyEvent key) {
		gsm.keyPressed(key.getKeyCode());
	}
	
	public void keyReleased(KeyEvent key) {
		gsm.keyReleased(key.getKeyCode());
	}
	
	public static double[] center() {
		return new double[]{WIDTH/2, HEIGHT/2};
	}
}
