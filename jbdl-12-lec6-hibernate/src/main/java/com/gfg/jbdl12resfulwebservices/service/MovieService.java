package com.gfg.jbdl12resfulwebservices.service;

import com.gfg.jbdl12resfulwebservices.NotFoundException;
import com.gfg.jbdl12resfulwebservices.model.MovieRequest;
import com.gfg.jbdl12resfulwebservices.model.MovieResponse;
import com.gfg.jbdl12resfulwebservices.model.UpdateRequest;

public interface MovieService {
    void create(MovieRequest movieRequest);
    MovieResponse get(String movieName) throws NotFoundException;
    void update(String movieName, UpdateRequest movieRequest) throws NotFoundException;
    void delete(String movieName) throws NotFoundException;
}
