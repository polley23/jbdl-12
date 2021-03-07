package com.gfg.jbdl12resfulwebservices.apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfg.jbdl12resfulwebservices.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class Resource {
    ArrayList<Movie> movies = new ArrayList<>(Arrays.asList(Movie.builder()
            .genre("action")
            .language("English")
            .movieName("batman")
            .build(), Movie.builder()
            .genre("horror")
            .language("English")
            .movieName("Shining")
            .build()));




    @PostMapping("/v1/movie")
    void createMovie(@RequestBody MovieRequest movieRequest){
        log.info(movieRequest.getMovieName() + " has been created");
        log.info("genre is "+movieRequest.getGenre());
        log.info("language is "+movieRequest.getLanguage());
    }

    @PostMapping("/v2/movie")
    void createMovieV2(@RequestBody MovieRequestV2 movieRequest){
        log.info(movieRequest.getMovieName() + " has been created");
        log.info("genre is "+movieRequest.getGenre());
        log.info("language is "+movieRequest.getLanguage());
    }

    @GetMapping("/v2/movie")
    ResponseEntity getMovie(@RequestParam("movieName") String movieName){
        for(Movie movie : movies){
            if(movie.getMovieName().equalsIgnoreCase(movieName)){
                return ResponseEntity.ok(movie);
            }
        }
        return ResponseEntity.badRequest().body(BadRequest.builder()
                .message("No movie Found")
                .build());
    }

    @PutMapping("/v2/movie/{movieName}")
    ResponseEntity updateMovie(@PathVariable("movieName") String movieName,
                               @RequestBody UpdateRequest updateRequest){
        for(Movie movie : movies){
            if(movie.getMovieName().equalsIgnoreCase(movieName)){
                if(Objects.nonNull(updateRequest.getGenre())){
                    movie.setGenre(updateRequest.getGenre());
                }
                if(Objects.nonNull(updateRequest.getLanguage())){
                    movie.setLanguage(updateRequest.getLanguage());
                }
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.badRequest().body(BadRequest.builder()
                .message("No movie Found")
                .build());
    }

    @DeleteMapping("/v2/movie/{movieName}")
    ResponseEntity deleteMovie(@PathVariable("movieName") String movieName){
        int index =0;
        int indexToDelete=-1;
        for(Movie movie : movies){
            if(movie.getMovieName().equalsIgnoreCase(movieName)){
                indexToDelete=index;
            }
            index++;
        }
        if(indexToDelete > -1){
            movies.remove(indexToDelete);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body(BadRequest.builder()
                .message("No movie Found")
                .build());
    }


}

