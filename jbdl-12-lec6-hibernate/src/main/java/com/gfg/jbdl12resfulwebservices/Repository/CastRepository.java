package com.gfg.jbdl12resfulwebservices.Repository;

import com.gfg.jbdl12resfulwebservices.model.Cast;
import com.gfg.jbdl12resfulwebservices.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CastRepository extends CrudRepository<Cast, Long> {
    Optional<Cast> findByName(String name);
}
