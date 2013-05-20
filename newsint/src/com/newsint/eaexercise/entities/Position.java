package com.newsint.eaexercise.entities;
/**
 * The Position class represents  a pair of coordinates in 2D
 * 
 * @author elvinali
 *
 */
public class Position {

	int x;
	int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void incrementX() {
		
		this.x++;
		
	}
	
	public void decrementX() {
		
		this.x--;
		
	}
	
	public void incrementY ()	{
		
		this.y++;
		
	}
	
	public void decrementY() {
		
		this.y--;
		
	}

	public String toString() {
		
		
		return this.x + " " + this.y;
		
	}

	public int getX() {
		
		return x;
	}
	
	public int getY() {
		
		return y;
	}
	
	public Position copy() {
	
		return new Position(this.x, this.y);
	}	
}
