package me.andreasfreund.schlechtegameengine.world;

import java.util.ArrayList;


public class World {
	private ArrayList<Element> elements;

	public World() {
		this.elements = new ArrayList<Element>();
	}

	public void addElement(Element obj) {
		this.elements.add(obj);
	}

	
	public Element[] getByType(Class<?> type) {
		ArrayList<Element> elements = new ArrayList<Element>();
		for (Element o : this.elements) {
			if(type.isInstance(o)){
				elements.add(o);				
			}
		}
		return elements.toArray(new Element[elements.size()]);
	}
}
