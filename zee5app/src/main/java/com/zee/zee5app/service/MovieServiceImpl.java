package com.zee.zee5app.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.enums.Genres;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.RecordAlreadyExistsException;
import com.zee.zee5app.exceptions.RecordNotFoundException;
import com.zee.zee5app.repo.MovieRepository;


@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired

	private MovieRepository movieRepository;

	@Override
	public Movie insertMovie(Movie movie) throws  RecordAlreadyExistsException {
		// TODO Auto-generated method stub
		if(movieRepository.existsByMovieName(movie.getMovieName())) {
			throw new RecordAlreadyExistsException("Movie Name : "+movie.getMovieName()+" already exists");
		}
		return movieRepository.save(movie);
	}

	@Override
	public Movie updateMovie(String movieId, Movie movie) {
		// TODO Auto-generated method stub
	
		if(movieRepository.existsById(movieId)) {
			movie.setMovieId(movieId);
			return movieRepository.save(movie);
		}
		else return null;
	}

	@Override
	public List<Movie> findByOrderByMovieNameDsc() {
		// TODO Auto-generated method stub
		return movieRepository.findAllByOrderByMovieNameDesc();
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
		return movieRepository.findById(movieId);
	}

	@Override
	public Optional<List<Movie>> getAllMovies() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAll());
	}

	@Override
	public List<Movie> getAllMoviesByGenre(String genre) {
		// TODO Auto-generated method stub
		return movieRepository.findAllByGenre(genre);
	}

	@Override
	public List<Movie> getAllMoviesByName(String movieName) {
		// TODO Auto-generated method stub
		return movieRepository.findAllByMovieName(movieName);
	}

	@Override
	public String deleteMovieByMovieId(String movieId) throws RecordNotFoundException  {
		// TODO Auto-generated method stub
		if(movieRepository.existsById(movieId)) {
			movieRepository.deleteById(movieId);
			return "DELETED SUCCESSFULLY";
		}else {
			throw new RecordNotFoundException("Movie Id "+movieId+"not found ");
		}
		
	}
	

}
