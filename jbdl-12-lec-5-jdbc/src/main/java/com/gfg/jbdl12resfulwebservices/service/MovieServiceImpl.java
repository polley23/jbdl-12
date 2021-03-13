package com.gfg.jbdl12resfulwebservices.service;

import com.gfg.jbdl12resfulwebservices.NotFoundException;
import com.gfg.jbdl12resfulwebservices.Repository.MovieRepository;
import com.gfg.jbdl12resfulwebservices.model.Movie;
import com.gfg.jbdl12resfulwebservices.model.MovieRequest;
import com.gfg.jbdl12resfulwebservices.model.UpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Qualifier("MovieServiceImpl1")
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void create(MovieRequest movieRequest) {
        movieRepository.create(Movie.builder()
        .movieName(movieRequest.getMovieName())
        .genre(movieRequest.getGenre())
        .language(movieRequest.getLanguage()).build());
    }

    @Override
    public List<Movie> get(String movieName) throws NotFoundException {
        return movieRepository.get(movieName);
    }

    @Override
    public void update(String movieName, UpdateRequest movieRequest) {
        movieRepository.update(movieName,movieRequest);
    }

    @Override
    public void delete(String movieName) {
        movieRepository.delete(movieName);
    }
}

