package com.mpgame.entities;

import java.awt.Color;
import java.awt.Point;

public class Projectile {
	public Color color;
	public int speed;
	
	public Point cPos;
	public int sizeX;
	public int sizeY;
	public int lifeTime;
	
	public Projectile(Player player){
		color = Color.BLACK;
		speed = 4;
		cPos = player.cPos;
		sizeX = 2;
		sizeY = 2;
		lifeTime = 700;
	}
	
	public boolean move() {
		if(lifeTime > 0) {
			Point p = new Point(cPos.x + speed, cPos.y + speed);
			if(p.x < 700 && p.y < 700 && p.x > 0 && p.y > 0 ){
				cPos = p;
				lifeTime--;
			}
			return true;
		}
		return false;
	}
}
