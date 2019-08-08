package com.hashbrown.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostGroupRequestBody {
	@JsonProperty("group_name")
	@NotNull
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
