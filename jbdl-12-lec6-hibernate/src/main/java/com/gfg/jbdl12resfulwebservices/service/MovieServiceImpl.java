package com.gfg.jbdl12resfulwebservices.service;

import com.gfg.jbdl12resfulwebservices.NotFoundException;
import com.gfg.jbdl12resfulwebservices.Repository.CastRepository;
import com.gfg.jbdl12resfulwebservices.Repository.MovieRepository;
import com.gfg.jbdl12resfulwebservices.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Qualifier("MovieServiceImpl1")
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CastRepository castRepository;

    @Override
    public void create(MovieRequest movieRequest) {
        List<Cast> castList = new ArrayList<>();
        List<Award> awardList = new ArrayList<>();

        Movie movie =Movie.builder()
                .movieName(movieRequest.getMovieName())
                .genre(movieRequest.getGenre())
                .language(movieRequest.getLanguage())
                .castList(castList)
                .awards(awardList)
                .rating(Rating.builder().rating(movieRequest.getRatingRequest().getRating()).build())
                .build();
        movie.getRating().setMovie(movie);

        for(CastRequest castRequest : movieRequest.getCastRequest()){
            Optional<Cast> castOptional = castRepository.findByName(castRequest.getName());
            Cast cast = null;
            if(!castOptional.isPresent()) {
                cast = Cast.builder()
                        .gender(castRequest.getGender())
                        .name(castRequest.getName())
                        .movieList(Arrays.asList(movie)).build();
            }else{
                cast = castOptional.get();
                cast.getMovieList().add(movie);
            }
            castList.add(cast);
        }
        for(AwardRequest awardRequest : movieRequest.getAwardRequests()){
            Award award = Award.builder().name(awardRequest.getName()).year(awardRequest.getYear()).movie(movie).build();
            awardList.add(award);
        }
        movieRepository.save(movie);
    }

    @Override
    public MovieResponse get(String movieName) throws NotFoundException {
         Movie movie = movieRepository.findByMovieName(movieName)
                .orElseThrow(()->new NotFoundException(movieName+ " is not found"));
        List<CastResponse> castResponseList = new ArrayList<>();
        List<AwardResponse> awardResponses = new ArrayList<>();

        MovieResponse movieResponse = MovieResponse.builder()
                .movieName(movie.getMovieName())
                .genre(movie.getGenre())
                .language(movie.getLanguage())
                .castResponses(castResponseList).build();

        for(Cast cast : movie.getCastList()){
            CastResponse castResponse = CastResponse.builder()
                    .gender(cast.getGender())
                    .name(cast.getName()).build();
            castResponseList.add(castResponse);
        }
        for(Award award : movie.getAwards()){
            AwardResponse awardResponse = AwardResponse.builder()
                    .year(award.getYear())
                    .name(award.getName()).build();
            awardResponses.add(awardResponse);
        }
        movieResponse.setCastResponses(castResponseList);
        movieResponse.setAwardResponses(awardResponses);
        movieResponse.setRatingResponse(RatingResponse.builder().rating(movie.getRating().getRating()).build());
        return movieResponse;


    }

    @Override
    public void update(String movieName, UpdateRequest movieRequest) throws NotFoundException {
        Movie movie = movieRepository.findByMovieName(movieName)
                .orElseThrow(()->new NotFoundException(movieName+ " is not found"));
        if(movieRequest.getGenre() != null){
            movie.setGenre(movieRequest.getGenre());
        }

        if(movieRequest.getLanguage() != null){
            movie.setLanguage(movieRequest.getLanguage());
        }
        movieRepository.save(movie);
    }

    @Override
    public void delete(String movieName) throws NotFoundException {
        Movie movie = movieRepository.findByMovieName(movieName)
                .orElseThrow(()->new NotFoundException(movieName+ " is not found"));
        movieRepository.delete(movie);
    }
}

