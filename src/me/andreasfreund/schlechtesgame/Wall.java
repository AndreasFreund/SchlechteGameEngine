package me.andreasfreund.schlechtesgame;

import me.andreasfreund.schlechtegameengine.display.*;
import me.andreasfreund.schlechtegameengine.world.Object;

public class Wall extends Object{

	public Wall() {
		super(TextureLoader.getTextureLoader().fetchSprites("wall"));
	}
	
}
