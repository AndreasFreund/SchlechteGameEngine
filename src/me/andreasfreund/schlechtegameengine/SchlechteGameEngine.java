package me.andreasfreund.schlechtegameengine;

import me.andreasfreund.schlechtegameengine.display.Window;
import me.andreasfreund.schlechtegameengine.world.World;

public class SchlechteGameEngine {
	private Generator generator;
	private World world;
	
	private Window window;

	public SchlechteGameEngine(Generator g) {
		this.generator = g;
		world = new World();
		g.generateWorld(world);
		
		Window.setUpLWJGL();
		window = new Window();
		
		mainloop();
	}
	
	private void mainloop()
	{
		while(!window.isCloseRequested())
		{
			//world.update();
			window.update();
		}
	}
}
