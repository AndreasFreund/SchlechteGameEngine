package me.andreasfreund.schlechtegameengine.display;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Hashtable;

import org.lwjgl.BufferUtils;

public class Sprite {
	private ArrayList<BufferedImage> frames;

	private int[] texIDs;

	private ColorModel glAlphaColorModel = new ComponentColorModel(
			ColorSpace.getInstance(ColorSpace.CS_sRGB),
			new int[] { 8, 8, 8, 8 }, true, false,
			ComponentColorModel.TRANSLUCENT, DataBuffer.TYPE_BYTE);

	private ColorModel glColorModel = new ComponentColorModel(
			ColorSpace.getInstance(ColorSpace.CS_sRGB),
			new int[] { 8, 8, 8, 0 }, false, false, ComponentColorModel.OPAQUE,
			DataBuffer.TYPE_BYTE);

	public Sprite(BufferedImage image) {
		this(image, 1);
	}

	public Sprite(BufferedImage image, int frames) {
		this.frames = new ArrayList<BufferedImage>();
		this.texIDs = new int[frames];
		int frameheight = image.getHeight() / frames;
		int framewidth = image.getWidth();
		for (int i = 0; i < frames; i++) {
			BufferedImage img = image.getSubimage(0, frameheight * i,
					framewidth, frameheight);
			this.frames.add(img);
			this.texIDs[i] = this.createTex(img);
		}
	}

	public BufferedImage getFrame(int i) {
		return this.frames.get(i);
	}

	public int getFrameCount() {
		return this.frames.size();
	}

	public void bindFrame(int i) {
		glBindTexture(GL_TEXTURE_2D, texIDs[i]);
	}

	private int createTex(BufferedImage bufferedImage) {
		int srcPixelFormat = 0;

		int target = GL_TEXTURE_2D;
		int id = glGenTextures();

		glBindTexture(target, id);

		if (bufferedImage.getColorModel().hasAlpha()) {
			srcPixelFormat = GL_RGBA;
		} else {
			srcPixelFormat = GL_RGB;
		}

		ByteBuffer textureBuffer = convertToBuffer(bufferedImage);

		if (target == GL_TEXTURE_2D) {
			glTexParameteri(target, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
			glTexParameteri(target, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		}
		glTexImage2D(target, 0, GL_RGBA, get2Fold(bufferedImage.getWidth()),
				get2Fold(bufferedImage.getHeight()), 0, srcPixelFormat,
				GL_UNSIGNED_BYTE, textureBuffer);

		return id;
	}

	private ByteBuffer convertToBuffer(BufferedImage bufferedImage) {
		ByteBuffer imageBuffer = null;
		WritableRaster raster;
		BufferedImage texImage;

		int texWidth = this.get2Fold(bufferedImage.getWidth());
		int texHeight = this.get2Fold(bufferedImage.getHeight());

		if (bufferedImage.getColorModel().hasAlpha()) {
			raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE,
					texWidth, texHeight, 4, null);
			texImage = new BufferedImage(glAlphaColorModel, raster, false,
					new Hashtable<>());
		} else {
			raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE,
					texWidth, texHeight, 3, null);
			texImage = new BufferedImage(glColorModel, raster, false,
					new Hashtable<>());
		}

		Graphics g = texImage.getGraphics();
		g.setColor(new Color(0f, 0f, 0f, 0f));
		g.fillRect(0, 0, texWidth, texHeight);
		g.drawImage(bufferedImage, 0, 0, texWidth, texHeight, null);
		byte[] data = ((DataBufferByte) texImage.getRaster().getDataBuffer())
				.getData();

		imageBuffer = BufferUtils.createByteBuffer(data.length);
		imageBuffer.put(data, 0, data.length);
		imageBuffer.flip();

		return imageBuffer;
	}

	private int get2Fold(int fold) {
		int ret = 2;
		while (ret < fold) {
			ret *= 2;
		}
		return ret;
	}
}
