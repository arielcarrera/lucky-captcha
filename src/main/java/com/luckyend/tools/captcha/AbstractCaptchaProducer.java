package com.luckyend.tools.captcha;

import java.awt.image.BufferedImage;

import lombok.Getter;
import lombok.Setter;

/**
 * Abstract Captcha Producer
 * Extends this class if you want to implement a configurable Captcha Producer.
 * 
 * @author Ariel Carrera
 *
 */
public abstract class AbstractCaptchaProducer implements CaptchaProducer {

	@Getter @Setter
	private CaptchaProperties config = null;
	
	
	public AbstractCaptchaProducer(CaptchaProperties config) {
		this.config = config;
	}
	

	@Override
	public abstract String createText();

	@Override
	public abstract BufferedImage createImage(String text);

}
