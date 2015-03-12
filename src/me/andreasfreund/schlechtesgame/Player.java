package me.andreasfreund.schlechtesgame;

import org.lwjgl.glfw.GLFW;

import me.andreasfreund.schlechtegameengine.SchlechteGameEngine;
import me.andreasfreund.schlechtegameengine.display.Sprite;
import me.andreasfreund.schlechtegameengine.display.TextureLoader;
import me.andreasfreund.schlechtegameengine.world.Element;

public class Player extends Element {

	private Sprite[] player, ghost;
	
	public Player() {
		super(TextureLoader.getTextureLoader().fetchSprites("player"));
		this.player = TextureLoader.getTextureLoader().fetchSprites("player");
		this.ghost = TextureLoader.getTextureLoader().fetchSprites("ghost");
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
	
	public void setGhost(boolean ghost) {
		this.setSprites(ghost?this.ghost:this.player);
	}

}
