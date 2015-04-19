package com.dominikangerer.q29396608;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class EscapeStringSerializer implements JsonSerializer<String> {

	@Override
	public JsonElement serialize(String src, Type typeOfSrc,
			JsonSerializationContext context) {
		src = createEscapedString(src);
		return new JsonPrimitive(src);
	}

	private String createEscapedString(String src) {
		// StringBuilder for the new String
		StringBuilder builder = new StringBuilder();

		// First occurrence
		int index = src.indexOf('/');
		// lastAdded starting at position 0
		int lastAdded = 0;

		while (index >= 0) {
			// append first part without a /
			builder.append(src.substring(lastAdded, index));

			// if / doesn't have a \ directly in front - add a \
			if (index - 1 >= 0 && !src.substring(index - 1, index).equals("\\")) {
				builder.append("\\");
				// if we are at index 0 we also add it because - well it's the
				// first character
			} else if (index == 0) {
				builder.append("\\");
			}

			// change last added to index
			lastAdded = index;
			// change index to the new occurrence of the /
			index = src.indexOf('/', index + 1);
		}

		// add the rest of the string
		builder.append(src.substring(lastAdded, src.length()));
		// return the new String
		return builder.toString();
	}
}