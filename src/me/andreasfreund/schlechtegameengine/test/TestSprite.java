package me.andreasfreund.schlechtegameengine.test;

import java.awt.Graphics;

import javax.swing.JFrame;

import me.andreasfreund.schlechtegameengine.display.Sprite;
import me.andreasfreund.schlechtegameengine.display.TextureLoader;

public class TestSprite extends JFrame {
	private Sprite[] sprites;
	private long last;
	private int i;

	public TestSprite() {
		super("Test");
		this.i = 0;
		this.last = System.currentTimeMillis();
		this.sprites = TextureLoader.getTextureLoader().fetchSprites("wall");
		this.setUndecorated(true);
		this.setSize(sprites[0].getFrame(0).getWidth(), sprites[0].getFrame(0)
				.getHeight());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getGraphics().drawImage(sprites[0].getFrame(this.i), 0, 0, null);
	}

	public void paint(Graphics g) {
		if (this.last + 1000 < System.currentTimeMillis()) {
			this.last = System.currentTimeMillis();
			this.i = (this.i + 1) % 6;
			System.out.println(i);
			this.getGraphics().drawImage(sprites[0].getFrame(this.i), 0, 0,
					null);
		}
	}

	public static void main(String[] args) {
		TestSprite test = new TestSprite();
		while (true) {
			test.paint(test.getGraphics());
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
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