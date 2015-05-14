package com.luckyend.tools.captcha.producer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import com.luckyend.tools.captcha.AbstractCaptchaProducer;
import com.luckyend.tools.captcha.CaptchaProducer;
import com.luckyend.tools.captcha.CaptchaProperties;

public class ByteCaptchaProducer extends AbstractCaptchaProducer {

	private static Random random = new Random(System.currentTimeMillis());

	private static int captchaSize = 4;
	private static Color FONT_COLOR = new Color(75, 140, 172);// TEXT COLOR
	private static int FONT_COLOR_INT = (byte) FONT_COLOR.getRGB();// TEXT COLOR
	private static Color FONT_BACKGROUND_COLOR = Color.BLACK;// BACKGROUND COLOR
	private static int FONT_BACKGROUND_COLOR_INT = (byte)FONT_BACKGROUND_COLOR.getRGB();// BACKGROUND COLOR
	
	private static Dimension charDimension = new Dimension(22, 32);
	private static int imageCharWidth = Math.round(charDimension.width * 1.2f);
	private static int imageCharHeight = Math.round(charDimension.height * 1.2f);
	private static int imageWidth = imageCharWidth * captchaSize;
	private static int imageHeight = imageCharHeight;


	private static Color BACKGROUND_COLOR_FROM = new Color(208, 226, 236);// BACKGROUND COLOR
	private static Color BACKGROUND_COLOR_TO = new Color(243, 242, 245);// BACKGROUND COLOR
	private static int[] background_pattern = createBackgroundPattern();
	private static int[] background = createBackground();

	//private static String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(Locale.US);
	private static String[] fonts ={Font.SERIF, Font.SANS_SERIF, Font.MONOSPACED, Font.DIALOG};
	private static final int fontCount = fonts.length;
	
	private final static char[] chars = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
	private final static int[][] char1 = createCharArray("1");
	private final static int[][] char2 = createCharArray("2");
	private final static int[][] char3 = createCharArray("3");
	private final static int[][] char4 = createCharArray("4");
	private final static int[][] char5 = createCharArray("5");
	private final static int[][] char6 = createCharArray("6");
	private final static int[][] char7 = createCharArray("7");
	private final static int[][] char8 = createCharArray("8");
	private final static int[][] char9 = createCharArray("9");
	private final static int[][] char0 = createCharArray("0");
	
	
	private static int MIN_OFFSET = -4;
	private static int MAX_OFFSET = 10;

	
	public ByteCaptchaProducer(CaptchaProperties config) {
		super(config);
	}
	
	
	// LOGICA PRINCIPAL y DE CREACION DE LA FRASE RANDOM

	/**
	 * Genera la imagen del captcha a renderizar en pantalla
	 * 
	 * @return imagen del captcha
	 */
	public BufferedImage createImage(String text) {
		int[] array = getFilledImage(text);
		BufferedImage img = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
		img.setRGB(0, 0, imageWidth, imageHeight, array, 0, imageWidth);
		
		return img;
	}

	public String createText() {
		char[] value = new char[captchaSize];
		// se genera la clave aleatoria
		for (int i = 0; i < captchaSize; i++) {
			value[i] = getRandomChar();
		}
		return String.valueOf(value);
	}

	private char getRandomChar() {
		return chars[random.nextInt(10)];
	}

	private static int random(int maxOffset) {
		return ThreadLocalRandom.current().nextInt(0, maxOffset + 1);
	}

	// LOGICA INTERNA DE LA IMPLEMENTACION DE LA IMAGEN

	private static int[] createBackgroundPattern() {
		BufferedImage img = new BufferedImage(imageWidth, 1, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = img.createGraphics();
		GradientPaint gp = new GradientPaint(0, 0, BACKGROUND_COLOR_FROM, imageWidth, 0, BACKGROUND_COLOR_TO);
		g.setPaint(gp);
		g.fillRect(0, 0, imageWidth, 1);

		return ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
	}

	private static int[] createBackground() {
		int[] back = new int[imageHeight * imageWidth];
		for (int i = 0; i < imageHeight * imageWidth; i++) {
			back[i] = background_pattern[i % imageWidth];
		}
		return back;
	}

	private static int[] createChar(String c, String fontName, int type, int size, Color color) {
		BufferedImage img = new BufferedImage(charDimension.width, charDimension.height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = img.createGraphics();
		
		Font font = new Font(fontName, type, size);
		g.setFont(font);
		g.setColor(color);
		g.drawString(c, 1, 30);

		// comentar si no se quiere escribir en disco TEST
//		try {
//			ImageIO.write(img, "jpg", new File("test_" + c + "_" + fontName +".jpg"));
//		} catch (IOException e) {
//			System.out.println("Error de escritura");
//		}

		return ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
	}
	
	private static int[][] createCharArray(String c) {
		int[][] array = new int[fontCount + 1][];
		for (int i = 0; i < fontCount; i++) {
			array[i] = createChar(c, fonts[i], Font.PLAIN, 40, FONT_COLOR);
		}
		return array;
	}

	private static int[] getChar(char ch) {
		int rnd = randomOffset(0, fontCount);
		switch (ch) {
		case '1':
			return char1[rnd];
		case '2':
			return char2[rnd];
		case '3':
			return char3[rnd];
		case '4':
			return char4[rnd];
		case '5':
			return char5[rnd];
		case '6':
			return char6[rnd];
		case '7':
			return char7[rnd];
		case '8':
			return char8[rnd];
		case '9':
			return char9[rnd];
		case '0':
			return char0[rnd];
		}
		return new int[0];
	}

	private int[] getFilledImage(String text) {
		//debe venir la cantidad de caracteres esperados en el texto
		if (text.length() != captchaSize) throw new RuntimeException("Error creando captcha, cadena insuficiente");
		
		int[] img = new int[imageWidth * imageHeight];
		System.arraycopy(background, 0, img, 0, imageWidth * imageHeight);
		
		CharImg[] charImgs = new CharImg[captchaSize];
		for (int i = 0; i < captchaSize; i++) {
			charImgs[i] = new CharImg(text.charAt(i), i);
//			System.out.println("\nCHAR: " + i);
			for (int x = 0; x < charDimension.width; x++) {
				for (int y = 0; y < charDimension.height; y++) {
					int xpos = charImgs[i].x + x;
//					System.out.print("\nx=" + xpos + ",");
					if (xpos >= 0 && xpos < charImgs[i].toX){
						int ypos = charImgs[i].y + y;
//						System.out.print("y=" + ypos + ",");
						if (ypos >= 0 && ypos < charImgs[i].toY){
							int value = charImgs[i].get(x, y);
//							System.out.print("z=" + value);
							if (value != FONT_BACKGROUND_COLOR_INT) {
								img[xpos + (ypos * imageWidth)] = value;
//								System.out.print("print=x" + xpos + " y" + ypos);
							}
						} else {
							continue;
						}
					} else {
						continue;
					}
				}
			}
		}
		
	
		return img;
	}
	
	private static int randomOffset(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}
	
	
	protected class CharImg {
		
		public int[] charData;
		public int pos;
		private int offsetX;
		private int offsetY;
		//posicion relativa al captcha completo:
		public int x;
		public int y;
		public int toX;
		public int toY;
			
		public CharImg(char character, int pos){
			this.charData = getChar(character);
			this.pos = pos;
			this.offsetX = randomOffset(MIN_OFFSET, MAX_OFFSET);
			this.offsetY = randomOffset(MIN_OFFSET, MAX_OFFSET);
			
			this.x = (pos * charDimension.width) +  offsetX;
			this.y = offsetY;
			this.toX = this.x + charDimension.width;
			this.toY = this.y + charDimension.height;
			if (this.toX > imageWidth) this.toX = imageWidth;
			if (this.toY > imageHeight) this.toY = imageHeight;
		}

		public int get(int x, int y){
			int pos = x + (y * charDimension.width);
			return charData[pos];
		}
	}

}
