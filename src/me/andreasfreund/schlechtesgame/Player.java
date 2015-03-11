package me.andreasfreund.schlechtesgame;

import org.lwjgl.glfw.GLFW;

import me.andreasfreund.schlechtegameengine.SchlechteGameEngine;
import me.andreasfreund.schlechtegameengine.display.TextureLoader;
import me.andreasfreund.schlechtegameengine.world.Element;

public class Player extends Element {

	public Player() {
		super(TextureLoader.getTextureLoader().fetchSprites("player"));
	}
	
	public void tick(SchlechteGameEngine engine)
	{
		if(engine.getKeyboard().isKeyDown(GLFW.GLFW_KEY_S))
		{
			this.setY(this.getY() - 1);
		}
		if(engine.getKeyboard().isKeyDown(GLFW.GLFW_KEY_A))
		{
			this.setX(this.getX() - 1);
		}
		if(engine.getKeyboard().isKeyDown(GLFW.GLFW_KEY_W))
		{
			this.setY(this.getY() + 1);
		}
		if(engine.getKeyboard().isKeyDown(GLFW.GLFW_KEY_D))
		{
			this.setX(this.getX() + 1);
		}
	}

}
