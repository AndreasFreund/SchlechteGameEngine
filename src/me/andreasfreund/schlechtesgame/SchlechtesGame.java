package me.andreasfreund.schlechtesgame;

import me.andreasfreund.schlechtegameengine.Generator;
import me.andreasfreund.schlechtegameengine.SchlechteGameEngine;
import me.andreasfreund.schlechtegameengine.display.TextureLoader;
import me.andreasfreund.schlechtegameengine.world.World;

public class SchlechtesGame implements Generator {

	private SchlechteGameEngine engine;

	public SchlechtesGame() {
		engine = new SchlechteGameEngine(this, "Schlechtes Game");
		engine.getWindow().setScale(20);
		engine.start();
	}

	public void generateWorld(World w, SchlechteGameEngine engine) {
		w.addElement(new me.andreasfreund.schlechtegameengine.world.Element(TextureLoader.getTextureLoader().fetchSprites("wall"))
		{
			
		});
	}

	public static void main(String[] args) {
		new SchlechtesGame();
	}

}
