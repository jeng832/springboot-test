package com.hashbrown.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupRequestBody {
	@JsonProperty("group_name")
	private String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "GroupRequestBody [groupName=" + groupName + "]";
	}
	
	
}
