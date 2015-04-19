package com.dominikangerer.q25077756;

import java.util.HashMap;

public class RequestDataDTOContainer {

	private HashMap<String, RequestDataDTO> requestDataDTO = new HashMap<String, RequestDataDTO>();

	public HashMap<String, RequestDataDTO> getRequestDataDTO() {
		return requestDataDTO;
	}

	public void setRequestDataDTO(HashMap<String, RequestDataDTO> requestDataDTO) {
		this.requestDataDTO = requestDataDTO;
	}
	
	public void putRequestDataDTO(String key, RequestDataDTO value){
		this.requestDataDTO.put(key, value);
	}

}
