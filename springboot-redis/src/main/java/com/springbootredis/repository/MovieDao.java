package com.springbootredis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.springbootredis.entity.Movie;

@Repository
public class MovieDao {
    public static final String HASH_KEY = "Movie";

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    public Movie save(Movie movie) {
        template.opsForHash().put(HASH_KEY, movie.getId(), movie);
        return movie;
    }

    public List<Movie> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Movie findMovieById(int id) {
        return (Movie) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteMovie(int id) {
        template.opsForHash().delete(HASH_KEY, id);

        return "movie removed!";
    }
}
