package me.andreasfreund.schlechtegameengine.world;

import org.lwjgl.opengl.GL11;

import me.andreasfreund.schlechtegameengine.SchlechteGameEngine;
import me.andreasfreund.schlechtegameengine.display.Sprite;

public abstract class Element {
	private int x = 0, y = 0, layer = LAYER_DEFAULT, rotation = 0;
	private int displayX, displayY;
	private boolean animation;
	private float animationframe;
	private float animationspeed;

	private Shape shape;

	public static final int LAYER_BACKGROUND = 5;
	public static final int LAYER_DEFAULT = 3;
	public static final int LAYER_FOREGROUND = 2;
	public static final int LAYER_OVERLAY = 0;

	private Sprite[] sprites;
	private World world;

	private boolean inWorld;

	protected Element(Sprite[] sprites, World world) {
		this(sprites, null, world);
	}

	protected Element(Sprite[] sprites, Shape shape, World world) {
		this.setSprites(sprites);
		this.world = world;
		this.shape = shape;
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
		if (this.animation) {
			this.animationframe = this.animationframe
					% this.sprites[this.rotation].getFrameCount();
			this.sprites[this.rotation].bindFrame((int) (this.animationframe));
			this.animationframe += this.animationspeed;
		} else {
			this.sprites[this.rotation].bindFrame(0);
		}
		GL11.glPushMatrix();
		GL11.glTranslatef(this.displayX, this.displayY, this.getLayer() / 10f);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(-0.5f, -0.5f);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(-0.5f, 0.5f);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(0.5f, 0.5f);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(0.5f, -0.5f);
		GL11.glEnd();
		GL11.glPopMatrix();
	}

	public void setAnimationEnabled(boolean anim) {
		this.animation = anim;
	}

	public void setAnimationSpeed(float animationspeed) {
		this.animationspeed = animationspeed;
	}

	public int getRotation() {
		return this.rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = (rotation % 4) + 4;
	}

	public void setInWorld(boolean inWorld) {
		this.inWorld = inWorld;
		if (this.getCollidable()) {
			if (this.inWorld) {
				this.world.getCollisionmap().setOccupied(this.x, this.y,
						this.shape, true);
			} else {
				this.world.getCollisionmap().setOccupied(this.x, this.y,
						this.shape, false);
			}
		}
	}

	public int getY() {
		return y;
	}

	public boolean setY(int y) {
		if (this.inWorld && this.getCollidable()) {
			if (!this.world.getCollisionmap().getOccupied(this.x, y, this.shape)) {
				this.world.getCollisionmap().setOccupied(this.x, this.y, this.shape,
						false);
				this.y = y;
				this.world.getCollisionmap().setOccupied(this.x, this.y, this.shape,
						false);
				return true;
			} else {
				return false;
			}
		} else {
			this.y = y;
			return true;
		}
	}

	public int getX() {
		return this.x;
	}

	public boolean setX(int x) {
		if (this.inWorld && this.getCollidable()) {
			if (!this.world.getCollisionmap().getOccupied(x, this.y, this.shape)) {
				this.world.getCollisionmap().setOccupied(this.x, this.y, this.shape,
						false);
				this.x = x;
				this.world.getCollisionmap().setOccupied(this.x, this.y, this.shape,
						false);
				return true;
			} else {
				return false;
			}
		} else {
			this.x = x;
			return true;
		}
	}

	public int getLayer() {
		return this.layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public String toString() {
		return this.getClass().getName();
	}

	public void tick(SchlechteGameEngine engine) {

	}

	public void updatePosition() {
		this.displayX = this.x;
		this.displayY = this.y;
	}

	public int getDisplayX() {
		return this.displayX;
	}

	public int getDisplayY() {
		return this.displayY;
	}

	public boolean getCollidable() {
		return false;
	}
}
