package com.luckyend.tools.captcha.producer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

/**
 * Test de productor de captchas Lucky {@link LuckyCaptchaProducer}
 * 
 * @author Ariel Carrera
 *
 */
public class LuckyCaptchaProducerTest {
	
	private LuckyCaptchaProducer producer = new LuckyCaptchaProducer();

	@Test
	public void test() {	
		BufferedImage img = producer.createImage(producer.createText());
		// comentar si no se quiere escribir en disco TEST
		try {
			ImageIO.write(img, "jpg", new File("test.jpg"));
		} catch (IOException e) {
			System.out.println("Error de escritura");
		}
		assert(img != null);
	}
}