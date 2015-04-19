package com.dominikangerer.q29396608;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {
		Gson g = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(String.class, new EscapeStringSerializer()).create();

		String src = "12 /first /second \\/third\\/fourth\\//fifth";
		
		System.out.println(g.toJson(src));
	}

}
