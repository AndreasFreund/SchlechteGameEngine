package me.andreasfreund.schlechtesgame;

import me.andreasfreund.schlechtegameengine.display.*;
import me.andreasfreund.schlechtegameengine.world.*;

public class Grass extends Element{

	public Grass() {
		super(TextureLoader.getTextureLoader().fetchSprites("grass"));
	}
	
}
