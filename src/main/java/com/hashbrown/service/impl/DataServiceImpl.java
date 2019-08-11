package com.hashbrown.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashbrown.cache.entity.CachedUser;
import com.hashbrown.cache.repository.RedisRepository;
import com.hashbrown.dao.entity.GroupInfo;
import com.hashbrown.dao.entity.UserInfo;
import com.hashbrown.dao.repository.GroupInfoRepository;
import com.hashbrown.dao.repository.UserInfoRepository;
import com.hashbrown.exception.GroupIsNotExistException;
import com.hashbrown.model.PostGroupRequestBody;
import com.hashbrown.model.PostUserRequestBody;
import com.hashbrown.model.UserInfoView;
import com.hashbrown.model.UserInfoViewList;
import com.hashbrown.service.DataService;

@Service
@Transactional
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
		return Optional.ofNullable(users).orElse(new ArrayList<UserInfo> ());
	}

	@Override
	public UserInfo saveUser(PostUserRequestBody u) {
		GroupInfo group = groupRepo.findById(u.getGid()).orElseThrow(() -> new GroupIsNotExistException("gid " + u.getGid() + " is not exist"));
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
	
	@Override
	public List<UserInfo> findAll() {
		return userRepo.findAll();
	}
	
	@Override
	public Page<UserInfo> findAll(Pageable pageable) {
		return userRepo.findAll(pageable);
	}
	
	@Override
	public UserInfoViewList findAllUsers() {
		List<UserInfoView> data = new ArrayList<>();
		List<UserInfo> users = userRepo.findAll();
		for(UserInfo user : users) {
			data.add(new UserInfoView(user));
		}
		return new UserInfoViewList(data);
	}
}
