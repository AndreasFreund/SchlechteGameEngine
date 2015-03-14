package me.andreasfreund.schlechtesgame;

import me.andreasfreund.schlechtegameengine.display.TextureLoader;
import me.andreasfreund.schlechtegameengine.world.Element;

public class Coin extends Element {
	
	public Coin() {
		super(TextureLoader.getTextureLoader().fetchSprites("coin"));
	}
	
}
