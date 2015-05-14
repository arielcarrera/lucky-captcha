package com.luckyend.tools.captcha;

import java.awt.Color;
import java.util.Properties;

import com.luckyend.tools.captcha.domain.BackgroundGradientDirection;
import com.luckyend.tools.captcha.domain.FileFormat;

/**
 * Configurable Captcha Properties
 * This class has a properties map (key/value) to store all the captcha properties
 * needed by a Captcha Producer.
 * Also it's provides methods accessors for commons properties.
 *  
 * @author Ariel Carrera
 *
 */
public class CaptchaProperties extends Properties {

	private static final long serialVersionUID = -7828157889371119403L;

	public class Keys {
		public static final String CAPTCHA_FILE_FORMAT = "luckyend.captcha.file.format";
		public static final String CAPTCHA_TEXT_PRODUCER = "luckyend.captcha.text.producer";
		public static final String CAPTCHA_FONT = "luckyend.captcha.font";
		public static final String CAPTCHA_FONT_SIZE = "luckyend.captcha.font.size";
		public static final String CAPTCHA_FONT_STYLE = "luckyend.captcha.font.style";
		public static final String CAPTCHA_FONT_COLOR = "luckyend.captcha.font.color";
		public static final String CAPTCHA_BACKGROUND_COLOR = "luckyend.captcha.background.color";
		public static final String CAPTCHA_BACKGROUND_GRADIENT_FROM_COLOR = "luckyend.captcha.background.gradient.from";
		public static final String CAPTCHA_BACKGROUND_GRADIENT_TO_COLOR = "luckyend.captcha.background.gradient.to";
		public static final String CAPTCHA_BACKGROUND_GRADIENT_DIRECTION = "luckyend.captcha.background.gradient.direction";
		public static final String CAPTCHA_SIZE_WIDTH = "luckyend.captcha.size.width";
		public static final String CAPTCHA_SIZE_HEIGHT = "luckyend.captcha.size.height";
		public static final String CAPTCHA_FILTER_WAVE = "luckyend.captcha.filter.wave";
		public static final String CAPTCHA_FILTER_WATER = "luckyend.captcha.filter.water";
		public static final String CAPTCHA_FILTER_NOISE = "luckyend.captcha.filter.noise";
		public static final String CAPTCHA_FILTER_LINE = "luckyend.captcha.filter.line";
		public static final String CAPTCHA_FILTER_ZOOM = "luckyend.captcha.filter.zoom";
		public static final String CAPTCHA_FILTER_BLUR = "luckyend.captcha.filter.blur";
		public static final String CAPTCHA_FILTER_SHADOW = "luckyend.captcha.filter.shadow";
		public static final String CAPTCHA_FILTER_CUSTOM = "luckyend.captcha.filter.custom";
	}

	public String getFileFormat() {
		return (String) this.get(Keys.CAPTCHA_FILE_FORMAT);
	}

	public void setFileFormat(FileFormat fmt) {
		this.setProperty(Keys.CAPTCHA_FILE_FORMAT, fmt.getValue());
	}

	public String getTextProducer() {
		return (String) this.get(Keys.CAPTCHA_TEXT_PRODUCER);
	}

	public void setTextProducer(Class<? extends TextProducer> producer) {
		this.setProperty(Keys.CAPTCHA_TEXT_PRODUCER, (producer != null ? producer.getCanonicalName() : null));
	}

	public String getFont() {
		return (String) this.get(Keys.CAPTCHA_FONT);
	}

	public void setFont(String font) {
		this.setProperty(Keys.CAPTCHA_FONT, font);
	}

	public String getFontSize() {
		return (String) this.get(Keys.CAPTCHA_FONT_SIZE);
	}

	public void setFontSize(Number size) {
		this.setProperty(Keys.CAPTCHA_FONT_SIZE, (size != null ? size.toString() : null));
	}

	public String getFontStyle() {
		return (String) this.get(Keys.CAPTCHA_FONT_STYLE);
	}

	public void setFontStyle(String style) {
		this.setProperty(Keys.CAPTCHA_FONT_STYLE, style);
	}

	public String getFontColor() {
		return (String) this.get(Keys.CAPTCHA_FONT_COLOR);
	}

	public void setFontColor(Color color) {
		this.setProperty(Keys.CAPTCHA_FONT_COLOR, (color != null ? color.toString() : null));
	}

	public String getBackgroundColor() {
		return (String) this.get(Keys.CAPTCHA_BACKGROUND_COLOR);
	}

	public void setBackgroundColor(Color color) {
		this.setProperty(Keys.CAPTCHA_BACKGROUND_COLOR, (color != null ? color.toString() : null));
	}

	public String getBackgroundGradientFromColor() {
		return (String) this.get(Keys.CAPTCHA_BACKGROUND_GRADIENT_FROM_COLOR);
	}

	public void getBackgroundGradientFromColor(Color color) {
		this.setProperty(Keys.CAPTCHA_BACKGROUND_GRADIENT_FROM_COLOR, (color != null ? color.toString() : null));
	}

	public String getBackgroundGradientToColor() {
		return (String) this.get(Keys.CAPTCHA_BACKGROUND_GRADIENT_TO_COLOR);
	}

	public void getBackgroundGradientToColor(Color color) {
		this.setProperty(Keys.CAPTCHA_BACKGROUND_GRADIENT_TO_COLOR, (color != null ? color.toString() : null));
	}

	public String getBackgroundGradientDirection() {
		return (String) this.get(Keys.CAPTCHA_BACKGROUND_GRADIENT_DIRECTION);
	}

	public void setBackgroundGradientDirection(BackgroundGradientDirection dir) {
		this.setProperty(Keys.CAPTCHA_BACKGROUND_GRADIENT_DIRECTION, (dir != null ? dir.getValue() : null));
	}

	public String getWidth() {
		return (String) this.get(Keys.CAPTCHA_SIZE_WIDTH);
	}

	public void setWidth(int w) {
		this.setProperty(Keys.CAPTCHA_SIZE_WIDTH, Integer.toString(w));
	}

	public String getHeight() {
		return (String) this.get(Keys.CAPTCHA_SIZE_HEIGHT);
	}

	public void setHeight(int h) {
		this.setProperty(Keys.CAPTCHA_SIZE_HEIGHT, Integer.toString(h));
	}

	public String getWaveFilter() {
		return (String) this.get(Keys.CAPTCHA_FILTER_WAVE);
	}

	public void setWaveFilter(String filter) {
		this.setProperty(Keys.CAPTCHA_FILTER_WAVE, filter);
	}

	public String getBlurFilter() {
		return (String) this.get(Keys.CAPTCHA_FILTER_BLUR);
	}

	public void setBlurFilter(String filter) {
		this.setProperty(Keys.CAPTCHA_FILTER_BLUR, filter);
	}

	public String getCustomFilter() {
		return (String) this.get(Keys.CAPTCHA_FILTER_CUSTOM);
	}

	public void setCustomFilter(String filter) {
		this.setProperty(Keys.CAPTCHA_FILTER_CUSTOM, filter);
	}

	public String getLineFilter() {
		return (String) this.get(Keys.CAPTCHA_FILTER_LINE);
	}

	public void setLineFilter(String filter) {
		this.setProperty(Keys.CAPTCHA_FILTER_LINE, filter);
	}

	public String getNoiseFilter() {
		return (String) this.get(Keys.CAPTCHA_FILTER_NOISE);
	}

	public void setNoiseFilter(String filter) {
		this.setProperty(Keys.CAPTCHA_FILTER_NOISE, filter);
	}

	public String getShadowFilter() {
		return (String) this.get(Keys.CAPTCHA_FILTER_SHADOW);
	}

	public void setShadowFilter(String filter) {
		this.setProperty(Keys.CAPTCHA_FILTER_SHADOW, filter);
	}

	public String getWaterFilter() {
		return (String) this.get(Keys.CAPTCHA_FILTER_WATER);
	}

	public void setWaterFilter(String filter) {
		this.setProperty(Keys.CAPTCHA_FILTER_WATER, filter);
	}

	public String getZoomFilter() {
		return (String) this.get(Keys.CAPTCHA_FILTER_ZOOM);
	}

	public void setZoomFilter(String filter) {
		this.setProperty(Keys.CAPTCHA_FILTER_ZOOM, filter);
	}
}
