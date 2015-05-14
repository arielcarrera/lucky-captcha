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
 * Captcha Producers benchmark test class
 * 
 * @author Ariel Carrera
 *
 */
public class CompareProducerTest {

	private final int count = 10000;

	private static ByteCaptchaProducer bitProducer;
	private static BasicCaptchaProducer basicProducer;

	@BeforeClass
	public static void init() throws IOException {
		bitProducer = new ByteCaptchaProducer(new CaptchaProperties());
		basicProducer = new BasicCaptchaProducer(new CaptchaProperties());

		// prepare producers instances for test
		ImageIO.write(basicProducer.createImage(basicProducer.createText()), "jpg", new File("test_basicProducer.jpg"));
		ImageIO.write(bitProducer.createImage(bitProducer.createText()), "jpg", new File("test_bitProducer.jpg"));
	}

	@Test
	public void testBasicCaptcha() throws IOException {
		for (int i = 0; i < count; i++) {
			try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
				BufferedImage img = basicProducer.createImage(basicProducer.createText());
				assert (img != null);
				ImageIO.write(img, "jpg", os);
			}
		}
	}

	@Test
	public void testBitCaptcha() throws IOException {
		for (int i = 0; i < count; i++) {
			try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
				BufferedImage img = bitProducer.createImage(bitProducer.createText());
				assert (img != null);
				ImageIO.write(img, "jpg", os);
			}
		}
	}

}
