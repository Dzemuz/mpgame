package com.mpgame.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import com.mpgame.entities.Player;

public class Game_Main {
	public static Frame window;
	public static Player player;
	public static ArrayList<Player> players;
	//public static Map map;

	public static int fps;
	/**
	 * Launch the application. 
	 */
	public static void main(String[] args) {
		/*deklaracja graczy+mapy*/
		
		String username = JOptionPane.showInputDialog(null, "What will your nickname be?");  //komunikat z wyborem imienia
		if(username.isEmpty())
			username = "player1";
			
		player = new Player(username, Color.BLACK);
		players = new ArrayList<Player>();
		players.add(player);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Frame();
					window.frame.setVisible(true);
					window.gameView.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			TimeUnit.SECONDS.sleep(1);
		}catch(InterruptedException e) {}
		gameLoop();
	}
	
	public static void tick() {
		//loop all the players if players has no health delete it and continue
		//Move the players
		//loop projectiles, move , loop items, loop boundary
		for(int i=0; i < players.size(); i++) {
			players.get(i).move();
		}
	}
	
	private static void paint() {
		try {
			//window.gameView.paintImmediately(0, 0, 700, 700);
			window.gameView.repaint();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void gameLoop() {
		long lastLoopTime = System.nanoTime();
		int targetFPS = 60;
		long optimalTime = 1000000000 / targetFPS;
		int lastFpsTime = 0;
		
		while(true) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			
			double timesPerFrame = updateLength / ((double)optimalTime);
			
			lastFpsTime += updateLength;
			fps++;
			if(lastFpsTime >= 1000000000) {
				GameView.fps = fps;
				lastFpsTime = 0;
				fps = 0;
			}
			
			tick();
			
			paint();
			try {
		    	  Thread.sleep( Math.abs((lastLoopTime-System.nanoTime() + optimalTime)/1000000));
		      } catch(Exception e) {
		    	  e.printStackTrace();
		      }
		}
	}
}
