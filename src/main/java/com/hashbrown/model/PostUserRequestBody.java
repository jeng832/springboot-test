package com.hashbrown.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostUserRequestBody {
	@JsonProperty("user_name")
	@NotNull
	private String userName;
	@JsonProperty("gid")
	@NotNull
	private Long gid;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}


}
