package com.mpgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import com.mpgame.entities.Player;
import com.mpgame.entities.Projectile;

public class GameView extends JPanel{
	public static int fps = 0;
	public static int playerWidth = 10;
	public static int playerHeight = 10;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		drawBackground(g2);
		//drawBoundaries(g2);
		//drawItems(g2);
		drawPlayers(g2);
		drawProjectiles(g2);
		drawHUD(g2);
	}

	public void drawBackground(Graphics2D g2) {
		g2.setColor(new Color(77, 255, 136));
		g2.fillRect(0, 0, 700, 700);
	}
	/*public void drawBoundaries(Graphics2D g2) {
		for(Boundary boundary : Game_Main.map.boundaries) {
			g2.setColor(boundary.color);
			g2.fill(boundary);
		}
	}*/
	public void drawHUD(Graphics2D g2) {
		//HUD
		g2.setColor(new Color(125, 26, 0 ,127));
		g2.fillRect(5, 5, 690, 50);
		
		int p_health = 100 * Game_Main.player.getHealth() / Game_Main.player.totalHealth;
		int p_ammo = 100; //* Game_mail.player.ammo.amount / Game_main.player.ammo.total;
		//HP
		g2.setColor(new Color(255, 0, 0, 127));
		g2.fillRect(50, 10, p_health, 10);
		g2.setColor(Color.WHITE);
		g2.drawRect(50, 10, 100, 10);
		g2.drawString("Health: ", 10, 20);
		
		//Ammo
		g2.setColor(new Color(255, 255, 0, 127));
		g2.fillRect(50, 30, p_ammo, 10);
		g2.setColor(Color.WHITE);
		g2.drawRect(50, 30, 100, 10);
		g2.drawString("Ammo: ", 10, 40);
		
		//FPS
		g2.drawString("FPS: " + fps, 640, 20);
		g2.drawString("Map: " /*+ Game_Main.map.name*/, 620, 40);
		//debug+
		g2.drawString("Wcisn¹³eœ dó³: " + Game_Main.player.down, 520, 20);
		g2.drawString("pozycja gracza: " + Game_Main.player.cPos, 350, 40);
		g2.drawString("pozycja pPos: " + Game_Main.player.pPos, 350, 50);
		g2.drawString("nickname: " + Game_Main.player.username, 350, 20);
		//g2.drawString("xvel: " + Game_Main.player.xVel, 300, 20);
		//g2.drawString("yvel: " + Game_Main.player.yVel, 300, 40);
		g2.drawString("iloœæ pocisków: " + Game_Main.player.liveAmmo.size(), 111, 40);
	}
	/*public void drawItems(Graphics2D g2) {
	for(Item item : Game_Main.map.items) {
		g2.setColor(item.color);
		g2.fill(item.image, item.cPos.x, item.cPos.y, this);
	}
	}*/
	public void drawPlayers(Graphics2D g2) {
		for(Player player : Game_Main.players) {
			g2.setColor(player.color);
			g2.fillRect(player.cPos.x, player.cPos.y, playerWidth, playerHeight);
			g2.setColor(Color.BLACK);
			g2.drawRect(player.cPos.x, player.cPos.y, playerWidth, playerHeight);
		}
	}
	public void drawProjectiles(Graphics2D g2) {
		for(Player player : Game_Main.players) {
			for(Projectile projectile : player.liveAmmo) {
				g2.setColor(projectile.color);
				g2.fillOval(projectile.cPos.x+3, projectile.cPos.y +3, projectile.sizeX, projectile.sizeY);
				g2.setColor(Color.BLACK);
				g2.drawOval(projectile.cPos.x+3, projectile.cPos.y +3, projectile.sizeX, projectile.sizeY);
			}
		}
	}
}
