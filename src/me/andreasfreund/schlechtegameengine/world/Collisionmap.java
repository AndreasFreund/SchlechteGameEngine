package me.andreasfreund.schlechtegameengine.world;

public class Collisionmap {
	private boolean[][] collisionmap;
	private int sx, sy;

	public Collisionmap(int sx, int sy) {
		this.sx = sx;
		this.sy = sy;
		this.collisionmap = new boolean[sx][sy];
	}

	public boolean getOccupied(int x, int y, Shape shape) {
		int mappedx = x + (int) Math.floor(this.sx / 2);
		int mappedy = y + (int) Math.floor(this.sy / 2);
		boolean[][] space = shape.getShape();
		for (int cx = 0; cx < space.length; cx++) {
			boolean[] line = space[cx];
			for (int cy = 0; cy < line.length; cx++) {
				if (line[cy]) {
					if (mappedx + cx >= this.sx || mappedx + cx < 0
							|| mappedy + cy >= this.sy || mappedy + cy < 0) {
						return this.collisionmap[mappedx + cx][mappedy + cy];
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	public void setOccupied(int x, int y, Shape shape, boolean b) {
		int mappedx = x + (int) Math.floor(this.sx / 2);
		int mappedy = y + (int) Math.floor(this.sy / 2);
		boolean[][] space = shape.getShape();
		for (int cx = 0; cx < space.length; cx++) {
			boolean[] line = space[cx];
			for (int cy = 0; cy < line.length; cy++) {
				if (mappedx + cx <= this.sx || mappedx + cx < 0
						|| mappedy + cy >= this.sy || mappedy + cy < 0) {
					this.collisionmap[mappedx + cx][mappedy + cy] = line[cy];
				}
			}
		}
	}

	public boolean isPointInWorld(int x, int y) {
		return (x > 0 && x < sx && y > 0 && y < sy);
	}
}
