package com.dominikangerer.q27637811;

public class KeyValueObject {
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public KeyValueObject withKey(String value) {
		this.setKey(value);
		return this;
	}

}
