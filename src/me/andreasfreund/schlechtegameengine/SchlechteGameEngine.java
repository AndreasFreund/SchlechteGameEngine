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
		g.generateWorld(this.world);
	}

	public SchlechteGameEngine(Generator g, String windowTitle,
			int windowWidth, int windowHeight) {
		this(g);
		this.window = new Window(windowTitle, windowWidth, windowHeight);
		this.window.display();
		g.generateWorld(this.world);
	}
	
	private SchlechteGameEngine(Generator g){
		Window.setUpLWJGL();
		this.generator = g;
		this.world = new World();
		this.camera = new Camera(0, 0);
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
	
	public void start()
	{
		mainloop();
	}

	private void mainloop() {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		while (!this.window.isCloseRequested()) {
			GL11.glClearColor(0, 0, 0, 0);
			GL11.glLoadIdentity();
			GL11.glTranslatef(-this.camera.getX() - 0.5f, -this.camera.getY() - 0.5f, 0);
			this.world.draw();
			this.window.update();
		}

		window.close();
	}
}
