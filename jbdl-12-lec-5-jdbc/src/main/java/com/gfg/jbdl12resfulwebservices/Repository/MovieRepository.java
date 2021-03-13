package com.gfg.jbdl12resfulwebservices.Repository;

import com.gfg.jbdl12resfulwebservices.NotFoundException;
import com.gfg.jbdl12resfulwebservices.model.Movie;
import com.gfg.jbdl12resfulwebservices.model.MovieRequest;
import com.gfg.jbdl12resfulwebservices.model.UpdateRequest;

import java.util.List;

public interface MovieRepository {
    void create(Movie movie);
    List<Movie> get(String movieName) throws NotFoundException;
    void update(String movieName, UpdateRequest updateRequest);
    void delete(String movieName);

}
