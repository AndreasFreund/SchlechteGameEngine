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
		for (int x = -9; x < 10; x++) {
			for (int y = -9; y < 10; y++) {
				Grass grass = new Grass(world);
				grass.setX(x);
				grass.setY(y);
				grass.setLayer(Element.LAYER_BACKGROUND);
				world.addElement(grass);
			}
		}
		Wall wall = new Wall(world);
		wall.setX(0);
		wall.setY(1);
		world.addElement(wall);
		for (int i = 0; i < 10; i++) {
			Coin coin = new Coin(world);
			coin.setX((int) (Math.random() * 19) - 9);
			coin.setY((int) (Math.random() * 19) - 9);
			// coin.setLayer(Element.LAYER_FOREGROUND);
			world.addElement(coin);
		}
		Player p = new Player(world);
		p.setAnimationEnabled(true);
		p.setAnimationSpeed(0.1f);
		engine.getCamera().setCameraLockedTo(p);
		world.addElement(p);
		Ghost ghost = new Ghost(world);
		ghost.setX(9);
		world.addElement(ghost);
	}

	@Override
	public int[] getWorldSize() {
		return new int[] { 19, 19 };
	}
}
