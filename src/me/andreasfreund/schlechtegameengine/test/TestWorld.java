package me.andreasfreund.schlechtegameengine.test;

import org.lwjgl.opengl.GL11;

import me.andreasfreund.schlechtegameengine.Generator;
import me.andreasfreund.schlechtegameengine.SchlechteGameEngine;
import me.andreasfreund.schlechtegameengine.world.*;
import me.andreasfreund.schlechtesgame.*;

public class TestWorld implements Generator {
	public static void main(String[] args) {
		TestWorld testworld = new TestWorld();
		SchlechteGameEngine engine = new SchlechteGameEngine(testworld,
				"Fenstertitel");
		engine.getWindow().getContext();
		engine.getWindow().setScale(32);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		engine.start();
	}

	@Override
	public void generateWorld(World world) {
		for (int x = -3; x < 4; x++) {
			for (int y = -4; y < 4; y++) {
				Wall wall = new Wall();
				wall.setX(x);
				wall.setY(y);
				wall.setLayer(Element.LAYER_BACKGROUND);
				world.addElement(wall);
			}
		}
		for (int x = -9; x < 10; x++) {
			Grass wall = new Grass();
			wall.setX(x);
			wall.setY(-5);
			wall.setLayer(Element.LAYER_BACKGROUND);
			world.addElement(wall);
		}
		Grass g = new Grass();
		g.setX(0);
		g.setY(0);
		g.setLayer(Element.LAYER_OVERLAY);
		world.addElement(g);
		world.addElement(new Ghost());
	}
}
