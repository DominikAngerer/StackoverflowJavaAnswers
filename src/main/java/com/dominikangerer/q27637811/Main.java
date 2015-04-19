package com.dominikangerer.q27637811;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
	
	public static void main(String[] args) {
		Gson g = new GsonBuilder().setPrettyPrinting().create();
		
		KeyValueObject nullObject = null;
		ListContainer list = new ListContainer();
		list.addToList("value1");
		list.addToList(nullObject);
		list.addToList("value2");
		
		System.out.println("With null values");
		System.out.println(g.toJson(list));
		
		// assign the new RemoveNullListSerializer for type List
		g = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(List.class, new RemoveNullListSerializer()).create();

		System.out.println("Without null values");
		System.out.println(g.toJson(list));
	}	
	
	
}
