package com.hashbrown.service;

import java.util.List;

import com.hashbrown.repository.vo.GroupInfo;

public interface DataService {
	List<GroupInfo> findAll();
	GroupInfo save(GroupInfo g);
	List<GroupInfo> findByGroupName(String groupName);

}
