package com.dominikangerer.q29550820;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
		String sampleJson = "{\"name\":\"Jhon\",\"lastName\":\"Smith\",\"clothes\":{\"gender\":\"male\",\"Shirt\":{\"id\":113608,\"name\":\"Green Shirt\",\"size\":\"Large\"},\"Pants\":{\"id\":115801,\"name\":\"Black Leather Pants\",\"size\":\"Large\"}}}";

		Gson g = new Gson();
		Person person = g.fromJson(sampleJson, Person.class);

		g = new Gson();
		PersonV2 personv2 = g.fromJson(sampleJson, PersonV2.class);
		System.out.println(personv2.getGender());

		g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		PersonV3 personv3 = g.fromJson(sampleJson, PersonV3.class);
		System.out.println(personv3.getClothes());
		System.out.println(personv3.getGender());
	}
}
