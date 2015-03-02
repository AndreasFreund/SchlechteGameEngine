package me.andreasfreund.schlechtegameengine;

import org.lwjgl.opengl.GL11;

import me.andreasfreund.schlechtegameengine.display.Camera;
import me.andreasfreund.schlechtegameengine.display.Window;
import me.andreasfreund.schlechtegameengine.world.World;

public class SchlechteGameEngine {
	private Generator generator;
	private World world;

	private Window window;
	private Camera camera;

	public SchlechteGameEngine(Generator g, String windowTitle) {
		this(g);
		this.window = new Window(windowTitle);
		this.window.display();
		mainloop();
	}

	public SchlechteGameEngine(Generator g, String windowTitle,
			int windowWidth, int windowHeight) {
		this(g);
		this.window = new Window(windowTitle, windowWidth, windowHeight);
		this.window.display();
		mainloop();
	}
	
	private SchlechteGameEngine(Generator g){
		this.generator = g;
		this.world = new World();
		g.generateWorld(this.world);

		Window.setUpLWJGL();
	}

	public Camera getCamera() {
		return this.camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public Window getWindow() {
		return this.window;
	}

	private void mainloop() {
		while (!this.window.isCloseRequested()) {
			GL11.glClearColor(0, 0, 0, 0);
			// world.update();
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(-0.5f, -0.5f);
			GL11.glVertex2f(-0.5f, 0.5f);
			GL11.glVertex2f(0.5f, 0.5f);
			GL11.glVertex2f(0.5f, -0.5f);
			GL11.glEnd();
			this.window.update();
		}

		window.close();
	}
}
