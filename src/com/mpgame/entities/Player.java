package com.mpgame.entities;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class Player {
	public String username;
	public Color color;
	
	private int health;
	public int ammo;
	public int totalHealth;
	
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	
	
	public int speed;
	public int xVel;
	public int yVel;
	
	public Point cPos;
	public Point pPos;
	
	
	public Player(String username, Color color) {
		this.username = username;
		this.color = color;
		this.health = 100;
		this.totalHealth = 100;
		
		cPos = new Point(300,300);
		pPos = new Point(300,300);
		
		speed = 2;
		xVel = 0;
		yVel = 0;
		up = false;
		down = false;
		left = false;
		right = false;
	}


	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	//metody
	public void move() {	//do poprawy(przy krawêdziach siê nie porusza)
		Point p = new Point(cPos.x + xVel, cPos.y + yVel);
		if(p.x < 690 && p.y < 690 && p.x >= 0 && p.y >= 0 /*&& !Util.inBoundaries(Game_Main.map.boundaries, new Rectangle(p.x, p.y, 10, 10))*/){
			pPos = cPos;
			cPos = p;
		}
	}
	
	
	public void stop() {
		up = false;
		down = false;
		left = false;
		right = false;
		updateMovement();
	}
	private void updateMovement() {
		xVel = 0;
		yVel = 0;
		if(down) yVel = speed;
		if(up) yVel = -speed;
		if(left) xVel = -speed;
		if(right) xVel = speed;
		
	}
	
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_S:
			down = true;
			break;
		case KeyEvent.VK_W:
			up = true;
			break;
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_D:
			right = true;
			break;
		}
		updateMovement();
	}
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_S:
			down = false;
			break;
		case KeyEvent.VK_W:
			up = false;
			break;
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_D:
			right = false;
			break;
		}
		updateMovement();
	}	
}
