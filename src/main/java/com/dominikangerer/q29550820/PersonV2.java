package com.dominikangerer.q29550820;

import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonV2 {
	@Expose
	private String name;

	@Expose
	private String lastName;

	@Expose
	@SerializedName("clothes")
	private Map<String, Object> clothesWrapper;

	public String getGender() {
		return clothesWrapper.get("gender").toString();
	}

	public void setGender(String gender) {
		this.clothesWrapper.put("gender", gender);
	}
}
