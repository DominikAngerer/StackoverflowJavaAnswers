package com.dominikangerer.q26691395;

import java.util.HashMap;

import com.dominikangerer.q26691395.Mobile;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) {
		HashMap<String, Mobile> map;
		Gson g = new Gson();
		String s = "{\"9912412412\":{\"name\":\"nameerra\",\"email\":\"varrrr\"},\"99349346346\":{\"email\":\"varrrr\"},\"934636236\":{\"address\":\"something\"}}";
		map = g.fromJson(s, new TypeToken<HashMap<String, Mobile>>(){}.getType());
		System.out.println(g.toJson(map));
	}
}
