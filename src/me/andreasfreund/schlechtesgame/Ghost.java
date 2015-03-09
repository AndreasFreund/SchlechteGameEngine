package me.andreasfreund.schlechtesgame;

import me.andreasfreund.schlechtegameengine.SchlechteGameEngine;
import me.andreasfreund.schlechtegameengine.display.TextureLoader;
import me.andreasfreund.schlechtegameengine.world.*;

public class Ghost extends AI {

	public Ghost() {
		super(TextureLoader.getTextureLoader().fetchSprites("ghost"));
	}

	public void tick(SchlechteGameEngine engine) {

	}

}
