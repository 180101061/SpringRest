package com.zee.zee5app.service;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.enums.Genres;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.RecordAlreadyExistsException;
import com.zee.zee5app.exceptions.RecordNotFoundException;

public interface MovieService {
    
    public Movie insertMovie(Movie movie) throws RecordAlreadyExistsException;
    public Movie updateMovie(String movieId, Movie movie);
    public List<Movie> findByOrderByMovieNameDsc();
    public Optional<Movie> getMovieByMovieId(String movieId);
    public Optional<List<Movie>> getAllMovies();
    //public List<Movie> getAllMoviesByGenre(Genres genre);
    public List<Movie> getAllMoviesByName(String movieName);
    public String deleteMovieByMovieId(String movieId) throws RecordNotFoundException;
	List<Movie> getAllMoviesByGenre(String genre);
}

