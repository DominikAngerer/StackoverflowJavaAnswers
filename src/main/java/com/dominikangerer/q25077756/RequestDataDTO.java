package com.dominikangerer.q25077756;

import com.google.gson.annotations.SerializedName;

public class RequestDataDTO {
	// {"AppId":"2","ThirdParty":"3","UserId":"1","UserToken":"4"}

	@SerializedName("AppId")
	private String appId;
	@SerializedName("ThirdParty")
	private String thirdParty;
	@SerializedName("UserId")
	private String userId;
	@SerializedName("UserToken")
	private String userToken;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getThirdParty() {
		return thirdParty;
	}

	public void setThirdParty(String thirdParty) {
		this.thirdParty = thirdParty;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

}
