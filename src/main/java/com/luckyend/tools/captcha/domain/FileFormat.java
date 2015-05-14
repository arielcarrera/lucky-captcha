package com.luckyend.tools.captcha.domain;

public enum FileFormat {
	JPG("jpg"), PNG("png"), GIF("gif"), BMP("bmp"), WBMP("wbmp");

	private final String value;

	private FileFormat(String val) {
		this.value = val;
	}

	public String getValue() {
		return value;
	}
}
