package com.gfg.jbdl12ouath.repository;

import com.gfg.jbdl12ouath.models.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Roles,Long> {
    Optional<Roles> findByRole(String role);
}
