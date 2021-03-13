package com.gfg.jbdl12resfulwebservices.configuration;


import com.gfg.jbdl12resfulwebservices.Repository.MovieRepository;
import com.gfg.jbdl12resfulwebservices.model.Movie;
import com.gfg.jbdl12resfulwebservices.service.MovieService;
import com.gfg.jbdl12resfulwebservices.service.MovieServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Conf {
    @Bean
    DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource =
                new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/movie");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //driverManagerDataSource.setPassword();
        return driverManagerDataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
    //Consturctor based DI
//    @Bean
//    MovieService movieService(MovieRepository movieRepository){
//        return new MovieServiceImpl(movieRepository);
//    }
    //Getter Setter based Impl
//    @Bean
//    MovieService movieService(MovieRepository movieRepository){
//        MovieServiceImpl movieServiceImpl = new MovieServiceImpl();
//        movieServiceImpl.setMovieRepository(movieRepository);
//        return movieServiceImpl;
//    }



}


/*
CREATE TABLE `movie`(
	`id` BIGINT PRIMARY KEY,
	`name` VARCHAR(255) NOT NULL,
	`genre` VARCHAR(255) NOT NULL,
	`language` VARCHAR(255) NOT NULL
);
 */