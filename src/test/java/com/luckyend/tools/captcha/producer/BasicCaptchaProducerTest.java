package com.luckyend.tools.captcha.producer;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.BeforeClass;
import org.junit.Test;

import com.luckyend.tools.captcha.CaptchaProperties;

/**
 * Test de productor de captchas Lucky {@link BasicCaptchaProducer}
 * 
 * @author Ariel Carrera
 *
 */
public class BasicCaptchaProducerTest {

	private static BasicCaptchaProducer producer;

	private static final int count = 10000;

	@BeforeClass
	public static void init() {
		producer = new BasicCaptchaProducer(new CaptchaProperties());
		// precalentado
		producer.createImage(producer.createText());
	}

	@Test
	public void test() {
		BufferedImage img = producer.createImage(producer.createText());
		// comentar si no se quiere escribir en disco TEST
		try {
			ImageIO.write(img, "jpg", new File("test.jpg"));
		} catch (IOException e) {
			System.out.println("Error de escritura");
		}
		assert (img != null);
	}

	@Test
	public void testPng() {
		BufferedImage img = producer.createImage(producer.createText());
		// comentar si no se quiere escribir en disco TEST
		try {
			ImageIO.write(img, "png", new File("test.png"));
		} catch (IOException e) {
			System.out.println("Error de escritura");
		}
		assert (img != null);
	}

	@Test
	public void testGif() {
		BufferedImage img = producer.createImage(producer.createText());
		// comentar si no se quiere escribir en disco TEST
		try {
			ImageIO.write(img, "gif", new File("test.gif"));
		} catch (IOException e) {
			System.out.println("Error de escritura");
		}
		assert (img != null);
	}

	@Test
	public void testLoop() {

		for (int i = 0; i < count; i++) {
			try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
				BufferedImage img = producer.createImage(producer.createText());
				assert (img != null);
				ImageIO.write(img, "jpg", os);
			} catch (IOException e) {
				System.out.println("Error interno");
			}
		}

	}

	@Test
	public void testPngLoop() {
		for (int i = 0; i < count; i++) {
			try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
				BufferedImage img = producer.createImage(producer.createText());
				assert (img != null);
				ImageIO.write(img, "png", os);
			} catch (IOException e) {
				System.out.println("Error interno");
			}
		}
	}

	@Test
	public void testGifLoop() {
		for (int i = 0; i < count; i++) {

			try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
				BufferedImage img = producer.createImage(producer.createText());
				assert (img != null);
				ImageIO.write(img, "gif", os);
			} catch (IOException e) {
				System.out.println("Error interno");
			}
		}
	}
}