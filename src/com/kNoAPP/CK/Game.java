package com.kNoAPP.CK;

import javax.swing.JFrame;

public class Game {

	public static void main(String args[]) {
		JFrame window = new JFrame("Cloud Kingdom");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
}
