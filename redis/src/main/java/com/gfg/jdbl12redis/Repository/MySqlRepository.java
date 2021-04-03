package com.gfg.jdbl12redis.Repository;

import com.gfg.jdbl12redis.models.MySqlUser;
import com.gfg.jdbl12redis.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MySqlRepository extends CrudRepository<MySqlUser, Long> {
    Optional<MySqlUser> findByUsername(String  username);
}
