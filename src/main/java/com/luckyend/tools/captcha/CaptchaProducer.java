package com.luckyend.tools.captcha;
import java.awt.image.BufferedImage;

public interface CaptchaProducer {

	/**
	 * Metodo que crea el texto random del captcha
	 * 
	 * @return texto del captcha
	 */
	public String createText();
	
	/**
	 * Metodo que crea la imagen del captcha
	 * 
	 * @return imagen del captcha
	 */
	public BufferedImage createImage(String text);


}
