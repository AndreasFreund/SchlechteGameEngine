package me.andreasfreund.schlechtegameengine.display;

import me.andreasfreund.schlechtegameengine.world.Element;

public class Camera {
	private Element lock;
	private int x, y;

	public Camera(Element lock) {
		this.lock = lock;
	}
	
	public Camera(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		lock = null;
	}

	public void setCameraLockedTo(Element lock) {
		this.lock = lock;
	}

	public void releaseCamera() {
		if (this.lock != null) {
			this.x = this.lock.getX();
			this.y = this.lock.getY();
		}
		this.lock = null;
	}

	public int getX() {
		if (this.lock != null) {
			return this.lock.getX();
		}
		return x;
	}

	public int getY() {
		if (this.lock != null) {
			return this.lock.getY();
		}
		return y;
	}
}
