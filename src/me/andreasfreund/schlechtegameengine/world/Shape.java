package me.andreasfreund.schlechtegameengine.world;

public class Shape {
	private int sx, sy;
	private boolean[][] shape;

	public Shape(int sx, int sy) {
		this.sx = sx;
		this.sy = sy;
		this.shape = new boolean[this.sx][this.sy];
	}
	
	public int getSizeX(){
		return this.sx;
	}
	
	public int getSizeY(){
		return this.sy;
	}
	
	public boolean[][] getShape(){
		return this.shape;
	}
}
