package com.gfg.jbdl12resfulwebservices.service;

import com.gfg.jbdl12resfulwebservices.NotFoundException;
import com.gfg.jbdl12resfulwebservices.model.Movie;
import com.gfg.jbdl12resfulwebservices.model.MovieRequest;
import com.gfg.jbdl12resfulwebservices.model.UpdateRequest;

import java.util.List;

public interface MovieService {
    void create(MovieRequest movieRequest);
    List<Movie> get(String movieName) throws NotFoundException;
    void update(String movieName, UpdateRequest movieRequest);
    void delete(String movieName);
}
