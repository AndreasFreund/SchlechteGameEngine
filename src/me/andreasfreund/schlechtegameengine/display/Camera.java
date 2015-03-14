package me.andreasfreund.schlechtegameengine.display;

import me.andreasfreund.schlechtegameengine.world.Element;

public class Camera {
	private Element lock;
	private float x, y;
	
	public static final float CAMERA_MOVEMENT = 5;

	public Camera(Element lock) {
		this.lock = lock;
	}
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
	}

	public void setPosition(float x, float y) {
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

	public float getX() {
		if (this.lock != null && Math.abs(this.lock.getDisplayX() - x) < 0.01) {
			x = this.lock.getDisplayX();
		}
		else if(this.lock != null)
		{
			float dif = x - this.lock.getDisplayX();
			x -= dif / CAMERA_MOVEMENT;
		}
		return x;
	}

	public float getY() {
		if (this.lock != null && Math.abs(this.lock.getDisplayY() - y) < 0.01) {
			y = this.lock.getDisplayY();
		}
		else if(this.lock != null)
		{
			float dif = y - this.lock.getDisplayY();
			y -= dif / CAMERA_MOVEMENT;
		}
		return y;
	}
}
