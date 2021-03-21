package com.gfg.jbdl12springsecurityuserdetailsservice.repository;

import com.gfg.jbdl12springsecurityuserdetailsservice.models.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Roles,Long> {
    Optional<Roles> findByRole(String role);
}
