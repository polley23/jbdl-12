package com.gfg.jdbl12redis.Repository;

import com.gfg.jdbl12redis.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RedisRepository extends CrudRepository<User, String> {
}
