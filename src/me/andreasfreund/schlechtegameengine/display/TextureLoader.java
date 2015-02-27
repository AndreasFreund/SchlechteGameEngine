package me.andreasfreund.schlechtegameengine.display;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureLoader {
	private static TextureLoader instance;

	public static TextureLoader getTextureLoader() {
		if (instance == null) {
			instance = new TextureLoader();
		}
		return instance;
	}

	private TextureLoader() {

	}

	public Sprite[] fetchSprites(String object) {
		File[] files = new File(TextureLoader.class.getClassLoader()
				.getResource("assets/textures").getPath()).listFiles();
		Sprite[] sprites = new Sprite[4];
		for (File file : files) {
			String[] filename = file.getName().split("\\.");
			if (filename[0].equals(object)) {
				try {
					if (filename.length == 4) {
						sprites[Integer.parseInt(filename[1])] = new Sprite(
								ImageIO.read(file),
								Integer.parseInt(filename[2]));
					} else if (filename.length == 3) {
						Sprite sprite = new Sprite(
								ImageIO.read(file),
								Integer.parseInt(filename[1]));
						sprites[0] = sprite;
						sprites[1] = sprite;
						sprites[2] = sprite;
						sprites[3] = sprite;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return sprites;
	}
}
