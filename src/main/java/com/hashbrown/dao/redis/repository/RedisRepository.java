package com.hashbrown.dao.redis.repository;

import org.springframework.data.repository.CrudRepository;

import com.hashbrown.dao.redis.entity.CachedUser;

public interface RedisRepository extends CrudRepository<CachedUser, String> {

}
