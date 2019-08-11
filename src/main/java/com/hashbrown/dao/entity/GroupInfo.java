package com.hashbrown.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


@Entity
public class GroupInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="gid", nullable = false)
	private Long gid;
	@Column(name="group_name", nullable = false)
	private String groupName;
	@JoinColumn(name="created_time", nullable = false)
	private Timestamp createdTime;

	public GroupInfo() {
		this.createdTime = new Timestamp(System.currentTimeMillis());
	}
	public GroupInfo(String groupName) {
		
		this.groupName = groupName;
		this.createdTime = new Timestamp(System.currentTimeMillis());
	}

	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
}