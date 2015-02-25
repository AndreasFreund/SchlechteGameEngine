package me.andreasfreund.schlechtegameengine.world;

import java.util.ArrayList;

public class World {
	private ArrayList<Object> objects;
	
	public World() {
		
	}
	
	public void addObject(Object obj){
		this.objects.add(obj);
	}
}
