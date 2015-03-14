package me.andreasfreund.schlechtegameengine.world;

import java.util.ArrayList;

import me.andreasfreund.schlechtegameengine.SchlechteGameEngine;

public class World {
	private ArrayList<Element> elements;
	private int sx, sy;

	public World() {
		this.elements = new ArrayList<Element>();
	}

	public void addElement(Element obj) {
		this.elements.add(obj);
	}

	public void setSize(int sx, int sy) {
		this.sx = sx;
		this.sy = sy;
	}

	public Element[] get(Class<?> type, View view) {
		ArrayList<Element> elements = new ArrayList<Element>();
		for (Element o : this.elements) {
			if ((type == null || type.isInstance(o))
					&& (view == null || view.canSee(o))) {
				elements.add(o);
			}
		}
		return elements.toArray(new Element[elements.size()]);
	}

	public void draw() {
		for (Element e : elements) {
			e.draw();
		}
	}

	public void tick(SchlechteGameEngine engine) {
		for (Element e : elements) {
			e.tick(engine);
		}
	}
}
