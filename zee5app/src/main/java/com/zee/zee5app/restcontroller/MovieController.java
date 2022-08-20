package com.zee.zee5app.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.RecordAlreadyExistsException;
import com.zee.zee5app.exceptions.RecordNotFoundException;
import com.zee.zee5app.service.MovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired
	MovieService movieService;
	@PostMapping("/add")
	public ResponseEntity<?> insertMovie(@RequestBody Movie movie) throws RecordAlreadyExistsException{
		Movie movie2 = new Movie();
		movie2 = movieService.insertMovie(movie);
		return ResponseEntity.status(HttpStatus.CREATED).body(movie2);
	}
	@GetMapping("/getall")
	public List<Movie> getAllMovie() {

		Optional<List<Movie>> result = movieService.getAllMovies();
		List<Movie> movies = result.get();
		for(Movie movie : movies)System.out.println(movie);
		return movies;
	}
	@PutMapping("/put/{movieId}")
	public String updateUser(@PathVariable("movieId")String movieId, @RequestBody Movie movie) throws InvalidIdException {
		movieService.updateMovie(movieId, movie);
		return "Updated Successfully ";
	}
	@GetMapping("/get/dsc")
	public List<Movie> findByOrderByMovieNameDsc(){
		return movieService.findByOrderByMovieNameDsc();
	}
	
	@GetMapping("/id/{movieId}")
	public Movie getMovieByMovieId(@PathVariable("movieId")String movieId) {
		Optional<Movie>result =  movieService.getMovieByMovieId(movieId);
		Movie movie = result.get();
		return movie;
	}
	@GetMapping("/genre/{genre}")
	public List<Movie> getAllMoviesByGenre(@PathVariable("genre")String genre){
		return movieService.getAllMoviesByGenre(genre);
	}
	@GetMapping("/name/{movieName}")
	public List<Movie> getAllMoviesByMovieName(@PathVariable("movieName")String movieName){
		return movieService.getAllMoviesByName(movieName);
	}
	@DeleteMapping("/{movieId}")
	public String deleteMovieById(@PathVariable("movieId")String movieId) throws RecordNotFoundException{
		movieService.deleteMovieByMovieId(movieId);
		return "deleted Successfully";
	}
	
}
