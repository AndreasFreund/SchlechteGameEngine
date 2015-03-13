package me.andreasfreund.schlechtegameengine.test;

import me.andreasfreund.schlechtegameengine.Generator;
import me.andreasfreund.schlechtegameengine.SchlechteGameEngine;
import me.andreasfreund.schlechtegameengine.world.*;
import me.andreasfreund.schlechtesgame.*;

public class TestWorld implements Generator {
	private SchlechteGameEngine engine;

	public static void main(String[] args) {
		TestWorld testworld = new TestWorld();
		testworld.engine = new SchlechteGameEngine(testworld, "Fenstertitel");
		testworld.engine.getWindow().getContext();
		testworld.engine.getWindow().setScale(32);
		testworld.engine.start();
	}

	@Override
	public void generateWorld(World world, SchlechteGameEngine engine) {
		world.setSize(50, 50);
		/*
		 * for (int x = -3; x < 4; x++) { for (int y = -4; y < 4; y++) { Wall
		 * wall = new Wall(); wall.setX(x); wall.setY(y);
		 * wall.setLayer(Element.LAYER_BACKGROUND); world.addElement(wall); } }
		 */
		for (int x = -19; x < 20; x++) {
			for (int y = -19; y < 20; y++) {
				Grass wall = new Grass();
				wall.setX(x);
				wall.setY(y);
				wall.setLayer(Element.LAYER_BACKGROUND);
				world.addElement(wall);
			}
		}
		Player p = new Player();
		engine.getCamera().setCameraLockedTo(p);
		world.addElement(p);
		Ghost ghost = new Ghost();
		ghost.setX(15);
		world.addElement(ghost);
	}
}
