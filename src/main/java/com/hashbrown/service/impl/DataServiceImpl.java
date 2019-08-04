package com.hashbrown.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashbrown.model.GroupRequestBody;
import com.hashbrown.repository.Repository;
import com.hashbrown.repository.vo.GroupInfo;
import com.hashbrown.service.DataService;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private Repository repo;
	
	@Override
	public List<GroupInfo> findAll() {
		List<GroupInfo> groups = new ArrayList<GroupInfo>();
		repo.findAll().forEach(e -> groups.add(e));
		return groups;
	}

	@Override
	public GroupInfo save(GroupRequestBody g) {
		GroupInfo group = repo.save(new GroupInfo(g.getGroupName()));
		return group;
	}

	@Override
	public List<GroupInfo> findByGroupName(String groupName) {
		List<GroupInfo> groups = repo.findByGroupName(groupName);
		return Optional.ofNullable(groups).orElse(null);
	}

}
