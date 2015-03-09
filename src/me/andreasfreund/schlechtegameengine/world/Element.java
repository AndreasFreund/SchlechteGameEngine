package me.andreasfreund.schlechtegameengine.world;

import org.lwjgl.opengl.GL11;

import me.andreasfreund.schlechtegameengine.SchlechteGameEngine;
import me.andreasfreund.schlechtegameengine.display.Sprite;

public abstract class Element {
	private int x = 0, y = 0, rotation = 0;

	private Sprite[] sprites;

	protected Element(Sprite[] sprites) {
		this.setSprites(sprites);
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

	public void draw() {
		this.sprites[rotation].bindFrame(0);
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, 0);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(0, 0);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(0, 1);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(1, 1);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(1, 0);
		GL11.glEnd();
		GL11.glPopMatrix();
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
	
	public String toString(){
		return this.getClass().getName();
	}
	
	public void tick(SchlechteGameEngine engine){
		
	}
}
