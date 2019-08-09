package com.hashbrown.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hashbrown.dao.entity.GroupInfo;
import com.hashbrown.dao.entity.UserInfo;

public class GetUserResponseBody {
	@JsonProperty("uid")
	private Long uid;
	@JsonProperty("created_time")
	private Timestamp createdTime;
	@JsonProperty("user_name")
	private String userName;
	@JsonProperty("group")
	private GroupInfo gid;
	
	public GetUserResponseBody(UserInfo u) {
		this.uid = u.getUid();
		this.createdTime = u.getCreatedTime();
		this.userName = u.getUserName();
		this.gid = u.getGroup();
	}
	

	
}
