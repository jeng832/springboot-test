package com.hashbrown.cache.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("user")
public class CachedUser implements Serializable {

	@Id
	private String userName;
	
	private String groupName;
	
	
	public CachedUser(String userName, String groupName) {
		this.userName = userName;
		this.groupName = groupName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
