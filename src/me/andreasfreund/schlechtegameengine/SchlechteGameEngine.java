package me.andreasfreund.schlechtegameengine;

import org.lwjgl.opengl.GL11;

import me.andreasfreund.schlechtegameengine.display.Window;
import me.andreasfreund.schlechtegameengine.world.World;

public class SchlechteGameEngine {
	private Generator generator;
	private World world;
	
	private Window window;

	public SchlechteGameEngine(Generator g, String windowTitle) {
		this.generator = g;
		world = new World();
		g.generateWorld(world);
		
		Window.setUpLWJGL();
		window = new Window(windowTitle);
		window.display();
		
		mainloop();
	}
	
	public SchlechteGameEngine(Generator g, String windowTitle, int windowWidth, int windowHeight) {
		this.generator = g;
		world = new World();
		g.generateWorld(world);
		
		Window.setUpLWJGL();
		window = new Window(windowTitle, windowWidth, windowHeight);
		window.display();
		
		mainloop();
	}
	
	public Window getWindow()
	{
		return window;
	}
	
	private void mainloop()
	{
		while(!window.isCloseRequested())
		{
			GL11.glClearColor(0, 0, 0, 0);
			//world.update();
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(-0.5f, -0.5f);
			GL11.glVertex2f(-0.5f, 0.5f);
			GL11.glVertex2f(0.5f, 0.5f);
			GL11.glVertex2f(0.5f, -0.5f);
			GL11.glEnd();
			window.update();
		}
		
		window.close();
	}
}
