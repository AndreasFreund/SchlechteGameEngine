package me.andreasfreund.schlechtesgame;

import org.lwjgl.glfw.GLFW;

import me.andreasfreund.schlechtegameengine.SchlechteGameEngine;
import me.andreasfreund.schlechtegameengine.display.Sprite;
import me.andreasfreund.schlechtegameengine.display.TextureLoader;
import me.andreasfreund.schlechtegameengine.world.Element;
import me.andreasfreund.schlechtegameengine.world.Shape;
import me.andreasfreund.schlechtegameengine.world.World;

public class Player extends Element {

	private Sprite[] player, ghost;

	public Player(World world) {
		super(TextureLoader.getTextureLoader().fetchSprites("player"),
				new Shape(1, 1), world);
		this.setLayer(LAYER_FOREGROUND);
		this.setSize(4,4);
		this.setScale(4);
		this.player = TextureLoader.getTextureLoader()
				.fetchSprites("player");
		//this.setAnimationEnabled(true);
		//this.setAnimationSpeed(0.1f);
		this.ghost = TextureLoader.getTextureLoader().fetchSprites("ghost");
	}

	public void tick(SchlechteGameEngine engine) {
		if (engine.getKeyboard().isKeyDown(GLFW.GLFW_KEY_S)) {
			this.setY(this.getY() - 1);
		}
		if (engine.getKeyboard().isKeyDown(GLFW.GLFW_KEY_A)) {
			this.setX(this.getX() - 1);
		}
		if (engine.getKeyboard().isKeyDown(GLFW.GLFW_KEY_W)) {
			this.setY(this.getY() + 1);
		}
		if (engine.getKeyboard().isKeyDown(GLFW.GLFW_KEY_D)) {
			this.setX(this.getX() + 1);
		}
		if (engine.getKeyboard().isKeyDown(GLFW.GLFW_KEY_E)) {
			this.setGhost(false);
		}
	}

	public void setGhost(boolean ghost) {
		this.setSprites(ghost ? this.ghost : this.player);
	}

	public boolean getCollidable() {
		// return false;
		return true;
		// TODO: Specify Shape
	}

}
