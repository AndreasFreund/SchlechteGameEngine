package me.andreasfreund.schlechtesgame;

import me.andreasfreund.schlechtegameengine.display.TextureLoader;
import me.andreasfreund.schlechtegameengine.world.Element;
import me.andreasfreund.schlechtegameengine.world.World;

public class Coin extends Element {
	
	public Coin(World world) {
		super(TextureLoader.getTextureLoader().fetchSprites("coin"), world);
	}
	
}
