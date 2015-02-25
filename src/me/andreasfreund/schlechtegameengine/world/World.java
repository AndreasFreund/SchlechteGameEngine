package me.andreasfreund.schlechtegameengine.world;

import java.util.ArrayList;


public class World {
	private ArrayList<Object> objects;

	public World() {

	}

	public void addObject(Object obj) {
		this.objects.add(obj);
	}

	
	public Object[] getByType(Class<Object> type) {
		ArrayList<Object> objects = new ArrayList<Object>();
		for (Object o : this.objects) {
			if(type.isInstance(o)){
				objects.add(o);				
			}
		}
		return objects.toArray(new Object[objects.size()]);
	}
}
