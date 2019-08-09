package com.hashbrown.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hashbrown.dao.entity.GroupInfo;

public class GetGroupResponseBody {
	@JsonProperty("gid")
	private Long gid;
	@JsonProperty("created_time")
	private Timestamp createdTime;
	@JsonProperty("group_name")
	private String groupName;
	
	public GetGroupResponseBody(GroupInfo g) {
		this.gid = g.getGid();
		this.createdTime = g.getCreatedTime();
		this.groupName = g.getGroupName();
	}
	

	
}
