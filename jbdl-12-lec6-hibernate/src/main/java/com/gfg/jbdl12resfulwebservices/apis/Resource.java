package com.gfg.jbdl12resfulwebservices.apis;
import com.gfg.jbdl12resfulwebservices.NotFoundException;
import com.gfg.jbdl12resfulwebservices.model.*;
import com.gfg.jbdl12resfulwebservices.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class Resource {
    @Autowired
    @Qualifier("MovieServiceImpl1")
    private MovieService movieService;

    @PostMapping("/v1/movie")
    void createMovie(@RequestBody MovieRequest movieRequest){
        movieService.create(movieRequest);
    }

    @PostMapping("/v2/movie")
    void createMovieV2(@RequestBody MovieRequestV2 movieRequest){
        log.info(movieRequest.getMovieName() + " has been created");
        log.info("genre is "+movieRequest.getGenre());
        log.info("language is "+movieRequest.getLanguage());
    }

    @GetMapping("/v2/movie")
    ResponseEntity getMovie(@RequestParam("movieName") String movieName){
        try {
            return ResponseEntity.ok(movieService.get(movieName));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/v2/movie/{movieName}")
    ResponseEntity updateMovie(@PathVariable("movieName") String movieName,
                               @RequestBody UpdateRequest updateRequest){
        try {
            movieService.update(movieName,updateRequest);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v2/movie/{movieName}")
    ResponseEntity deleteMovie(@PathVariable("movieName") String movieName){
        try {
            movieService.delete(movieName);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }


}

