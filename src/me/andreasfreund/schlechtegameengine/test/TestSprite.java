package me.andreasfreund.schlechtegameengine.test;

import java.awt.Graphics;

import org.lwjgl.opengl.GL11;

import me.andreasfreund.schlechtegameengine.display.*;

public class TestSprite{
	private Sprite[] sprites;
	private long last;
	private int i;

	public TestSprite() {
		this.i = 0;
		this.last = System.currentTimeMillis();
		this.sprites = TextureLoader.getTextureLoader().fetchSprites("grass");
	}

	public void paint(Graphics g) {
		if (this.last + 1000 < System.currentTimeMillis()) {
			this.last = System.currentTimeMillis();
			this.i = (this.i + 1) % sprites[0].getFrameCount();
		}
	}

	public static void main(String[] args) {
		Window.setUpLWJGL();
		Window window = new Window("Schlechter Fenstertitel den man nicht sehen kann");
		window.getContext();
		window.setScale(10);
		TestSprite test = new TestSprite();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		while (!window.isCloseRequested()) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			GL11.glLoadIdentity();
			if (test.last + 1000 < System.currentTimeMillis()) {
				test.last = System.currentTimeMillis();
				test.i = (test.i + 1) % test.sprites[0].getFrameCount();
			}
			test.sprites[0].bindFrame(test.i);
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(-0.5f, -0.5f);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(-0.5f, 0.5f);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(0.5f, 0.5f);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(0.5f, -0.5f);
			GL11.glEnd();
			window.update();
		}
		/*
		 * Sprite[] sprites = TextureLoader.getTextureLoader()
		 * .fetchSprites("wall"); for (Sprite sprite : sprites) {
		 * System.out.println(sprite.getFrameCount()); for (int i = 0; i <
		 * sprite.getFrameCount(); i++) {
		 * System.out.println(sprite.getFrame(i).getHeight()); } }
		 */
	}
}