package me.andreasfreund.schlechtegameengine.test;

import org.lwjgl.opengl.GL11;

import me.andreasfreund.schlechtegameengine.display.Window;
import me.andreasfreund.schlechtegameengine.world.*;
import me.andreasfreund.schlechtesgame.*;

public class TestWorld {
	public static void main(String[] args) {
		Window.setUpLWJGL();
		Window window = new Window("TestWorld");
		window.getContext();
		window.setScale(16);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		World world = new World();
		//Grass grass = new Grass();
		for(int x = -4;x<4;x++) {
			for(int y = -4;y<4;y++){
				Wall wall = new Wall();
				wall.setX(x);
				wall.setY(y);
				world.addElement(wall);
			}
		}
		for(int x = -10;x<10;x++){
			Grass wall = new Grass();
			wall.setX(x);
			wall.setY(-5);
			world.addElement(wall);
		}
		
		
		//world.addElement(grass);
		
		while (!window.isCloseRequested()) {
			world.draw();
			window.update();
		}
	}
}
