package me.andreasfreund.schlechtegameengine.display;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class Keyboard extends GLFWKeyCallback {
	
	private boolean[] keys = new boolean[400];
	//TODO: implement isKeyDown()
	@Override
	public void invoke(long arg0, int arg1, int arg2, int arg3, int arg4) {
		keys[arg1] = arg4 == GLFW.GLFW_PRESS;
	}

}
