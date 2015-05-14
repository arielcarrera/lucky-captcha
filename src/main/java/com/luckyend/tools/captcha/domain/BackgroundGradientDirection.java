package com.luckyend.tools.captcha.domain;

public enum BackgroundGradientDirection {
	VERTICAL("VERTICAL"), HORIZONTAL("HORIZONTAL");

	private final String value;

	private BackgroundGradientDirection(String val) {
		this.value = val;
	}

	public String getValue() {
		return value;
	}
}
