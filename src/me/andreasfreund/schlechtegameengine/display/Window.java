package me.andreasfreund.schlechtegameengine.display;

import static org.lwjgl.glfw.GLFW.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class Window {
	private long window;

	public Window(String windowTitle) {
		long monitor = GLFW.glfwGetPrimaryMonitor();
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_RED_BITS, GLFWvidmode.REDBITS);
		glfwWindowHint(GLFW_GREEN_BITS, GLFWvidmode.GREENBITS);
		glfwWindowHint(GLFW_BLUE_BITS, GLFWvidmode.BLUEBITS);
		glfwWindowHint(GLFW_REFRESH_RATE, GLFWvidmode.REFRESHRATE);
		glfwWindowHint(GLFW_VISIBLE, GL11.GL_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GL11.GL_TRUE);
		ByteBuffer vidMode = GLFW.glfwGetVideoMode(monitor);
		window = glfwCreateWindow(GLFWvidmode.width(vidMode),
				GLFWvidmode.height(vidMode), windowTitle, monitor, 0);
	}

	public Window(String windowTitle, int windowWidth, int windowHeight) {
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_RED_BITS, GLFWvidmode.REDBITS);
		glfwWindowHint(GLFW_GREEN_BITS, GLFWvidmode.GREENBITS);
		glfwWindowHint(GLFW_BLUE_BITS, GLFWvidmode.BLUEBITS);
		glfwWindowHint(GLFW_REFRESH_RATE, GLFWvidmode.REFRESHRATE);
		glfwWindowHint(GLFW_VISIBLE, GL11.GL_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GL11.GL_TRUE);
		window = glfwCreateWindow(windowWidth, windowHeight, windowTitle, 0, 0);

		ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window,
				(GLFWvidmode.width(vidmode) - windowWidth) / 2,
				(GLFWvidmode.height(vidmode) - windowHeight) / 2);
	}

	public void display() {
		glfwMakeContextCurrent(window);
		GLContext.createFromCurrent();
		glfwSwapInterval(1);

		glfwShowWindow(window);

	}

	public void getContext() {
		glfwMakeContextCurrent(window);
		GLContext.createFromCurrent();
	}

	public boolean isCloseRequested() {
		return glfwWindowShouldClose(window) == GL11.GL_TRUE;
	}

	public void update() {
		glfwSwapBuffers(window);

		glfwPollEvents();
	}

	public void close() {
		glfwDestroyWindow(window);
		glfwTerminate();
	}

	public void setScale(int scale) {
		IntBuffer width = BufferUtils.createIntBuffer(1), height = BufferUtils.createIntBuffer(1);
		GLFW.glfwGetWindowSize(window, width, height);
		int w = width.get(), h = height.get();
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho((int)((w / (float)h) * -scale), (int)((w / (float)h) * scale), -scale, scale, 1, -1);
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
