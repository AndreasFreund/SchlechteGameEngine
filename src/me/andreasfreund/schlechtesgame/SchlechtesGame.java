package me.andreasfreund.schlechtesgame;

import me.andreasfreund.schlechtegameengine.Generator;
import me.andreasfreund.schlechtegameengine.SchlechteGameEngine;
import me.andreasfreund.schlechtegameengine.world.World;

public class SchlechtesGame implements Generator{
	
	private SchlechteGameEngine engine;
	
	public SchlechtesGame()
	{
		engine = new SchlechteGameEngine(this, "Schlechtes Game");
	}
	
	public void generateWorld(World w) {
		
	}
	
	public static void main(String[] args)
	{
		new SchlechtesGame();
	}

}
