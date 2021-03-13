package com.gfg.jbdl12resfulwebservices.Repository;

import com.gfg.jbdl12resfulwebservices.NotFoundException;
import com.gfg.jbdl12resfulwebservices.model.Movie;
import com.gfg.jbdl12resfulwebservices.model.UpdateRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class MovieRepositoryImpl implements MovieRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Movie movie) {
        String sql = "INSERT INTO movie\n" +
                "(`name`,`genre`, `language`)\n" +
                "VALUES\n" +
                "(?,?,?)";
        jdbcTemplate.update(sql,movie.getMovieName(),
                movie.getGenre(),movie.getLanguage());
    }

    @Override
    public List<Movie> get(String movieName) throws NotFoundException {
        String sql = "SELECT * FROM movie\n"+
                "WHERE `name`=?";

        List<Movie> movies = jdbcTemplate
                .query(sql, new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setString(1, movieName);
                    }
                }, new RowMapper<Movie>() {
                    @Override
                    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
                        return Movie
                                .builder()
                                .movieName(resultSet.getString(2))
                                .genre(resultSet.getString(3))
                                .language(resultSet.getString(4))
                                .build();
                    }
                });

        if(movies.size()==0){
            throw new NotFoundException("No movie is found");
        }
        return movies;
    }

    @Override
    public void update(String movieName, UpdateRequest updateRequest) {
        if(updateRequest.getLanguage()!= null) {
            String sqlLanguage = "UPDATE movie set `language` = ? WHERE `name` = ?";
            jdbcTemplate.update(sqlLanguage,updateRequest.getLanguage(),movieName);

        }
        if(updateRequest.getGenre()!= null) {
            String sqlGenre = "UPDATE movie set `genre` = ? WHERE `name` = ?";
            jdbcTemplate.update(sqlGenre,updateRequest.getGenre(),movieName);

        }

    }
    @Override
    public void delete(String movieName) {
        String sql = "DELETE FROM movie  WHERE `name` = ?";
        jdbcTemplate.update(sql,movieName);
    }


}
