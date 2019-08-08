package com.hashbrown.dao.mysql.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="uid")
	private Long uid;
	@Column(name="user_name")
	private String userName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="gid")
	private GroupInfo group;
	@JoinColumn(name="created_time")
	private Timestamp createdTime;
	
	public UserInfo() {
		this.createdTime = new Timestamp(System.currentTimeMillis());
	}
	
	public UserInfo(String userName, GroupInfo group) {
		this.userName = userName;
		this.createdTime = new Timestamp(System.currentTimeMillis());
		this.group = group;
	}
	
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public GroupInfo getGroup() {
		return group;
	}
	public void setGroup(GroupInfo group) {
		this.group = group;
	}
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
}
