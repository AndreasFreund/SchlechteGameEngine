package me.andreasfreund.schlechtegameengine.world;

public class Collisionmap {
	private boolean[][] collisionmap;
	private int sx, sy;

	public Collisionmap(int sx, int sy) {
		this.sx = sx;
		this.sy = sy;
		this.collisionmap = new boolean[sx + 2][sy + 2];
	}
}
