package me.andreasfreund.schlechtegameengine;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class Keyboard extends GLFWKeyCallback {
	
	private boolean[] keys = new boolean[400];
	
	@Override
	public void invoke(long arg0, int arg1, int arg2, int arg3, int arg4) {
		this.keys[arg1] = arg3 == GLFW.GLFW_PRESS;
	}

	public boolean isKeyDown(int key)
	{
		return this.keys[key];
	}
}
