package me.andreasfreund.schlechtesgame;

import me.andreasfreund.schlechtegameengine.display.*;
import me.andreasfreund.schlechtegameengine.world.*;

public class Wall extends Element{

	public Wall(World world) {
		super(TextureLoader.getTextureLoader().fetchSprites("wall"), world);
	}
	
	public boolean getCollidable(){
		return true;
	}
	
}
