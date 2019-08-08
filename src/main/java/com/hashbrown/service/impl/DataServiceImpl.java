package com.hashbrown.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashbrown.dao.mysql.entity.GroupInfo;
import com.hashbrown.dao.mysql.entity.UserInfo;
import com.hashbrown.dao.mysql.repository.GroupInfoRepository;
import com.hashbrown.dao.mysql.repository.UserInfoRepository;
import com.hashbrown.dao.redis.entity.CachedUser;
import com.hashbrown.dao.redis.repository.RedisRepository;
import com.hashbrown.model.PostGroupRequestBody;
import com.hashbrown.model.PostUserRequestBody;
import com.hashbrown.service.DataService;

@Service
public class DataServiceImpl implements DataService {
	private Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);
	@Autowired
	private GroupInfoRepository groupRepo;
	
	@Autowired
	private UserInfoRepository userRepo;
	
	@Autowired
	private RedisRepository redisRepo;
	
	
	@Override
	public List<GroupInfo> findAllGroup() {
		List<GroupInfo> groups = new ArrayList<GroupInfo>();
		groupRepo.findAll().forEach(e -> groups.add(e));
		return groups;
	}

	@Override
	public GroupInfo saveGroup(PostGroupRequestBody g) {
		GroupInfo group = groupRepo.save(new GroupInfo(g.getGroupName()));
		return group;
	}

	@Override
	public List<GroupInfo> findByGroupName(String groupName) {
		List<GroupInfo> groups = groupRepo.findByGroupName(groupName);
		return Optional.ofNullable(groups).orElse(null);
	}

	@Override
	public GroupInfo findByGid(Long gid) {
		return groupRepo.findById(gid).get();
	}
	
	@Override
	public List<UserInfo> findAllUser() {
		List<UserInfo> users = new ArrayList<UserInfo>();
		userRepo.findAll().forEach(e -> users.add(e));
		return users;
	}

	@Override
	public List<UserInfo> findByUserName(String userName) {
		List<UserInfo> users = userRepo.findByUserName(userName);
		return Optional.ofNullable(users).orElse(null);
	}

	@Override
	public UserInfo saveUser(PostUserRequestBody u) {
		GroupInfo group = groupRepo.findById(u.getGid()).get();
		UserInfo user = userRepo.save(new UserInfo(u.getUserName(), group));
		redisRepo.save(new CachedUser(u.getUserName(), group.getGroupName()));
		return user;
	}
	
	@Override
	public String getGroupNameByUserName(String userName) {
		logger.info("getGroupNameByUserName " + userName);
		if(!redisRepo.existsById(userName)) {
			logger.info("key is not exist");
			Long gid = userRepo.findByUserName(userName).get(0).getGroup().getGid();
			String groupName = groupRepo.findById(gid).get().getGroupName();
			redisRepo.save(new CachedUser(userName, groupName));
			return groupName;
		}
		return redisRepo.findById(userName).get().getGroupName();
	}

	@Override
	public UserInfo findByUid(Long uid) {
		return userRepo.findById(uid).get();
	}

}
