package me.andreasfreund.schlechtegameengine.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.andreasfreund.schlechtegameengine.display.Sprite;

public abstract class Object {
	private int x = 0, y = 0, rotation = 0;

	private Sprite[] sprites;

	protected Object(Sprite[] sprites) {
		this.setSprites(sprites);
	}

	public void tick() {

	}

	protected void setSprites(Sprite[] sprites) {
		if (sprites.length != 4) {
			throw new IllegalArgumentException("No Valid Sprites Supplied");
		}
		for (Sprite sprite : sprites) {
			if (sprite == null) {
				throw new IllegalArgumentException("No Valid Sprite Supplied");
			}
		}
		this.sprites = sprites;
	}

	public void draw(Graphics g) {
		BufferedImage texture = this.sprites[rotation].getFrame(0);
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = (rotation % 4) + 4;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}
