package me.andreasfreund.schlechtesgame;

import me.andreasfreund.schlechtegameengine.display.*;
import me.andreasfreund.schlechtegameengine.world.*;

public class Tree extends Element{

	public Tree() {
		super(TextureLoader.getTextureLoader().fetchSprites("wall"));
	}
	
	/*public String toString(){
		return this.getClass().getName();
	}*/
	
}
