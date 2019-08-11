package com.hashbrown.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hashbrown.dao.entity.GroupInfo;
import com.hashbrown.dao.entity.UserInfo;
import com.hashbrown.model.PostGroupRequestBody;
import com.hashbrown.model.PostUserRequestBody;
import com.hashbrown.model.UserInfoView;
import com.hashbrown.model.UserInfoViewList;

public interface DataService {
	List<GroupInfo> findAllGroup();
	GroupInfo saveGroup(PostGroupRequestBody g);
	List<GroupInfo> findByGroupName(String groupName);
	GroupInfo findByGid(Long gid);
	
	List<UserInfo> findAllUser();
	UserInfo saveUser(PostUserRequestBody u);
	List<UserInfo> findByUserName(String groupName);
	UserInfo findByUid(Long uid);
	String getGroupNameByUserName(String userName);
	List<UserInfo> findAll();
	Page<UserInfo> findAll(Pageable pageable);
	UserInfoViewList findAllUsers();
	Long countUser();
	UserInfoViewList findByUidBetween(Long start, Long end);

}
