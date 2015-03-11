package me.andreasfreund.schlechtegameengine.display;

import static org.lwjgl.glfw.GLFW.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import me.andreasfreund.schlechtegameengine.Keyboard;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class Window {
	private long window;
	
	private Keyboard keyCallback = new Keyboard();

	public Window(String windowTitle) {
		this();
		long monitor = GLFW.glfwGetPrimaryMonitor();
		ByteBuffer vidMode = GLFW.glfwGetVideoMode(monitor);
		this.window = glfwCreateWindow(GLFWvidmode.width(vidMode),
				GLFWvidmode.height(vidMode), windowTitle, monitor, 0);
		glfwSetKeyCallback(window, keyCallback);
	}

	public Window(String windowTitle, int windowWidth, int windowHeight) {
		this();
		this.window = glfwCreateWindow(windowWidth, windowHeight, windowTitle,
				0, 0);

		ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(this.window,
				(GLFWvidmode.width(vidmode) - windowWidth) / 2,
				(GLFWvidmode.height(vidmode) - windowHeight) / 2);
		glfwSetKeyCallback(window, keyCallback);
	}
	
	private Window()
	{
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_RED_BITS, GLFWvidmode.REDBITS);
		glfwWindowHint(GLFW_GREEN_BITS, GLFWvidmode.GREENBITS);
		glfwWindowHint(GLFW_BLUE_BITS, GLFWvidmode.BLUEBITS);
		glfwWindowHint(GLFW_REFRESH_RATE, GLFWvidmode.REFRESHRATE);
		glfwWindowHint(GLFW_VISIBLE, GL11.GL_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GL11.GL_TRUE);
	}

	public void display() {
		glfwMakeContextCurrent(this.window);
		GLContext.createFromCurrent();
		glfwSwapInterval(1);

		glfwShowWindow(this.window);

	}

	public void getContext() {
		glfwMakeContextCurrent(this.window);
		GLContext.createFromCurrent();
	}

	public Keyboard getKeyboard() {
		return keyCallback;
	}

	public boolean isCloseRequested() {
		return glfwWindowShouldClose(this.window) == GL11.GL_TRUE;
	}

	public void update() {
		glfwSwapBuffers(this.window);

		glfwPollEvents();
	}

	public void close() {
		glfwDestroyWindow(this.window);
		glfwTerminate();
	}

	public void setScale(int minHeightUnits) {
		IntBuffer width = BufferUtils.createIntBuffer(1), height = BufferUtils
				.createIntBuffer(1);
		GLFW.glfwGetWindowSize(this.window, width, height);
		int w = width.get(), h = height.get();

		int texRes = 2;
		while (texRes * minHeightUnits < h) {
			texRes *= 2;
		}

		float heightUnits = h / (float) texRes / 2;

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(((w / (float) h) * -heightUnits),
				((w / (float) h) * heightUnits), -heightUnits, heightUnits, 1,
				-1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
	}

	public static void setUpLWJGL() {
		String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			os = "windows";
		}
		String osarch = System.getProperty("os.arch");
		if (osarch.equals("amd64")) {
			osarch = "x64";
		}
		System.setProperty("org.lwjgl.util.Debug", "true");
		System.setProperty(
				"org.lwjgl.librarypath",
				Window.class
						.getClassLoader()
						.getResource(
								"libraries/lwjgl/native/" + os + "/" + osarch)
						.getPath());
		if (glfwInit() != GL11.GL_TRUE) {
			System.err.println("Unable to initalize LWJGL");
			System.exit(-1);
		}
	}
}
