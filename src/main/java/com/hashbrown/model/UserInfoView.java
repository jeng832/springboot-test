package com.hashbrown.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hashbrown.dao.entity.UserInfo;

public class UserInfoView {
	
	@JsonProperty("uid")
	private Long uid;
	@JsonProperty("user_name")
	private String name;
	@JsonProperty("created_time")
	private Timestamp createdTime;
	
	public UserInfoView(UserInfo u) {
		this.uid = u.getUid();
		this.name = u.getUserName();
		this.createdTime = u.getCreatedTime();
	}
	
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
}
