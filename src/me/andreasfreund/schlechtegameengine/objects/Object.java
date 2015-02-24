package me.andreasfreund.schlechtegameengine.objects;

import java.awt.Graphics;

import me.andreasfreund.schlechtegameengine.display.Sprite;

public abstract class Object {
	private int x = 0, y = 0, rotation = 0;
	private Sprite[] sprites;

	public Object(Sprite[] sprites) {
		if(sprites.length != 4){
			throw new IllegalStateException("No Valid Sprites Supplied");
		}
		this.sprites = sprites;
	}
	
	public void draw(Graphics g){
		
	}
}
