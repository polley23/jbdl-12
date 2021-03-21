package com.gfg.jbdl12springsecurityuserdetailsservice.repository;

import com.gfg.jbdl12springsecurityuserdetailsservice.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
