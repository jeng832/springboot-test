package com.hashbrown.service;

import java.util.List;

import javax.validation.Valid;

import com.hashbrown.dao.mysql.entity.GroupInfo;
import com.hashbrown.dao.mysql.entity.UserInfo;
import com.hashbrown.model.PostGroupRequestBody;
import com.hashbrown.model.PostUserRequestBody;

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

}
