package me.andreasfreund.schlechtegameengine.display;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Sprite {
	private ArrayList<BufferedImage> frames;

	public Sprite(BufferedImage image) {
		this(image, 1);
	}

	public Sprite(BufferedImage image, int frames) {
		this.frames = new ArrayList<BufferedImage>();
		int frameheight = image.getHeight() / frames;
		int framewidth = image.getWidth();
		for (int i = 0; i < frames; i++) {
			this.frames.add(image.getSubimage(0, frameheight * i, framewidth,
					frameheight));
		}
	}
	
	public BufferedImage getFrame(int i){
		return this.frames.get(i);
	}
	
	public int getFrameCount(){
		return this.frames.size();
	}
}
