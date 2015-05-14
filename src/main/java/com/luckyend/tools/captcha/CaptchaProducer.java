package com.luckyend.tools.captcha;
import java.awt.image.BufferedImage;

public interface CaptchaProducer {

	/**
	 * Generate a random text
	 * 
	 * @return the generated text for the captcha
	 */
	public String createText();
	
	/**
	 * Generate a captcha image for a given text
	 * 
	 * @return captcha image
	 */
	public BufferedImage createImage(String text);


}
