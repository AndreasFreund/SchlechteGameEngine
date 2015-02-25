package me.andreasfreund.schlechtegameengine.display;

import static org.lwjgl.glfw.GLFW.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;


public class Window {
	private long window;
	
	public Window()
	{
		long monitor = GLFW.glfwGetPrimaryMonitor();
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_RED_BITS, GLFWvidmode.REDBITS);
		glfwWindowHint(GLFW_GREEN_BITS, GLFWvidmode.GREENBITS);
		glfwWindowHint(GLFW_BLUE_BITS,GLFWvidmode.BLUEBITS);
		glfwWindowHint(GLFW_REFRESH_RATE, GLFWvidmode.REFRESHRATE);
        glfwWindowHint(GLFW_VISIBLE, GL11.GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL11.GL_TRUE);
        ByteBuffer vidMode = GLFW.glfwGetVideoMode(monitor);
		window = glfwCreateWindow(GLFWvidmode.width(vidMode), GLFWvidmode.height(vidMode), "WindowTitle", 0, 0);
		
		System.out.println(window == GL11.GL_FALSE);
		
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
 
        glfwShowWindow(window);
        
        GLContext.createFromCurrent();
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
		System.setProperty("org.lwjgl.librarypath", Window.class.getClassLoader().getResource("libraries/lwjgl/native").getPath());
		if(glfwInit() != GL11.GL_TRUE)
		{
			System.err.println("Unable to initalize LWJGL");
			System.exit(-1);
		}
	}
}
