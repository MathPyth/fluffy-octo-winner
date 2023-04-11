package com.springbootredis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootredis.entity.Movie;
import com.springbootredis.repository.MovieDao;

@SpringBootApplication
@RestController
@RequestMapping("/movie")
public class SpringbootRedisApplication {

	@Autowired
	private MovieDao dao;

	@PostMapping
	public Movie save(@RequestBody Movie movie) {
		return dao.save(movie);
	}

	@GetMapping
	public List<Movie> getAllMovies() {
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public Movie getMovieById(@PathVariable int id) {
		return dao.findMovieById(id);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id) {
		return dao.deleteMovie(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisApplication.class, args);
	}

}
