package com.dominikangerer.q29550820;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonV3 {
	@Expose
	private String name;

	@Expose
	private String lastName;

	@Expose
	@SerializedName("clothes")
	private Map<String, Object> clothesWrapper;

	private Map<String, Cloth> clothes;

	public String getGender() {
		return clothesWrapper.get("gender").toString();
	}

	public void setGender(String gender) {
		this.clothesWrapper.put("gender", gender);
	}

	public Map<String, Cloth> getClothes() {
		Gson g = new Gson();
		if (clothes == null) {
			clothes = new HashMap<String, Cloth>();
			for (Entry<String, Object> entry : clothesWrapper.entrySet()) {
				if (entry.getKey().equals("gender")) {
					continue;
				}
				String helper = g.toJson(entry.getValue());
				Cloth cloth = g.fromJson(helper, Cloth.class);
				clothes.put(entry.getKey(), cloth);
			}
		}
		return clothes;
	}
}
