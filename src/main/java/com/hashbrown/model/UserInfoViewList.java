package com.hashbrown.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfoViewList {
	@JsonProperty("data")
	private List<UserInfoView> data;

	public UserInfoViewList(List<UserInfoView> data) {
		this.data = data;
	}

	public List<UserInfoView> getData() {
		return data;
	}

	public void setData(List<UserInfoView> data) {
		this.data = data;
	}
	
	
}
