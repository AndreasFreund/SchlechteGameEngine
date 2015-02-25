package me.andreasfreund.schlechtegameengine.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.andreasfreund.schlechtegameengine.display.Sprite;

public abstract class Object {
	private int x = 0, y = 0, rotation = 0;

	private Sprite[] sprites;

	public Object(Sprite[] sprites) {
		if (sprites.length != 4) {
			throw new IllegalStateException("No Valid Sprites Supplied");
		}
		this.sprites = sprites;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		if (rotation >= 0 && rotation < 4) {
			this.rotation = rotation;
		} else {
			throw new IllegalStateException("A");
		}
	}

	public void draw(Graphics g) {
		BufferedImage texture = this.sprites[rotation].getFrame(0);
	}
}
