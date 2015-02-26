package me.andreasfreund.schlechtegameengine.test;

import me.andreasfreund.schlechtegameengine.world.*;
import me.andreasfreund.schlechtesgame.*;

public class TestWorld {
	public static void main(String[] args){
		World world = new World();
		Wall wall = new Wall();
		Tree tree = new Tree();
		world.addElement(wall);
		world.addElement(tree);
		System.out.println(wall);
		System.out.println(tree);
	}
}
