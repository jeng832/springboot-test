package com.hashbrown.cache.repository;

import org.springframework.data.repository.CrudRepository;

import com.hashbrown.cache.entity.CachedUser;

public interface RedisRepository extends CrudRepository<CachedUser, String> {

}
