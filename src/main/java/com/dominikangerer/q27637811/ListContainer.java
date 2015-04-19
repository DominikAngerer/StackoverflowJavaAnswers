package com.dominikangerer.q27637811;

import java.util.ArrayList;
import java.util.List;

public class ListContainer {
	private List<KeyValueObject> list = new ArrayList<KeyValueObject>();

	public List<KeyValueObject> getList() {
		return list;
	}

	public void setList(List<KeyValueObject> list) {
		this.list = list;
	}

	public void addToList(String value) {
		list.add(new KeyValueObject().withKey(value));
	}
	
	public void addToList(KeyValueObject keyValue) {
		list.add(keyValue);
	}
}
