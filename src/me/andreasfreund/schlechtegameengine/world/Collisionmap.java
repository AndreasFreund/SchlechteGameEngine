package me.andreasfreund.schlechtegameengine.world;

public class Collisionmap {
	private boolean[][] collisionmap;
	private int sx, sy;

	public Collisionmap(int sx, int sy) {
		this.sx = sx;
		this.sy = sy;
		this.collisionmap = new boolean[sx][sy];
	}

	public boolean getOccupied(int x, int y) {
		int mappedx = x + (int) Math.floor(this.sx / 2);
		int mappedy = y + (int) Math.floor(this.sy / 2);
		if(mappedx >= this.sx || mappedx < 0 || mappedy >= this.sy || mappedy < 0){
			return true;
		}
		return this.collisionmap[mappedx][mappedy];
	}

	public void setOccupied(int x, int y, boolean b) {
		int mappedx = x + (int) Math.floor(this.sx / 2);
		int mappedy = y + (int) Math.floor(this.sy / 2);
		this.collisionmap[mappedx][mappedy] = b;
	}
}
