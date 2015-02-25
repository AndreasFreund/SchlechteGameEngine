package me.andreasfreund.schlechtegameengine.display;

import static org.lwjgl.glfw.GLFW.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GL11;


public class Window {
	private long window;
	
	public Window()
	{
		if(glfwInit() != GL11.GL_TRUE)
		{
			System.err.println("Unable to initalize LWJGL");
			System.exit(-1);
		}
		long monitor = glfwGetPrimaryMonitor();
		ByteBuffer mode = glfwGetVideoMode(monitor);
		glfwWindowHint(GLFW_RED_BITS, GLFWvidmode.REDBITS);
		glfwWindowHint(GLFW_GREEN_BITS, GLFWvidmode.GREENBITS);
		glfwWindowHint(GLFW_BLUE_BITS,GLFWvidmode.BLUEBITS);
		glfwWindowHint(GLFW_REFRESH_RATE, GLFWvidmode.REFRESHRATE);
		window = glfwCreateWindow(GLFWvidmode.WIDTH, GLFWvidmode.HEIGHT, mode, monitor, 0);
		
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
 
        glfwShowWindow(window);
	}
	
	public boolean isCloseRequested()
	{
		return glfwWindowShouldClose(window) == GL11.GL_FALSE;
	}
	
	public void update()
	{
		glfwSwapBuffers(window);
		
        glfwPollEvents();
	}
	
	public void close()
	{
		glfwDestroyWindow(window);
        glfwTerminate();
	}
	
	public static void setUpLWJGL()
	{
		System.setProperty("org.lwjgl.librarypath", Window.class.getClassLoader().getResource("natives").getPath());
	}
}
