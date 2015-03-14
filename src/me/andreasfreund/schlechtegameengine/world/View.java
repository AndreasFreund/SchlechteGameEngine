package me.andreasfreund.schlechtegameengine.world;

public class View {
	private Element element;
	private int range;

	public View(Element element, int range) {
		this.element = element;
		this.range = range;
	}

	public boolean canSee(Element element) {
		return Math.max(Math.abs(element.getX() - this.element.getX()),
				Math.abs(element.getY() - this.element.getY())) <= this.range;
	}
}