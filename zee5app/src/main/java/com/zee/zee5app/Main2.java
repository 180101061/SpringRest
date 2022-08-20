package com.zee.zee5app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Employee;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exceptions.RecordAlreadyExistsException;
import com.zee.zee5app.repo.EmployeeRepository;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.UserService;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ConfigurableApplicationContext context = null;
//		context = SpringApplication.run(Zee5appApplication.class, args);
//		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		
//		employeeRepository.save(new Employee(17021629L,"Rahul Kumar","CSE",150));
//		employeeRepository.save(new Employee(18021629L,"Rakesh Kumar","CIVIL",1500));
//		employeeRepository.save(new Employee(19021629L,"Sakala Kumar","CHEMICAL",15000));
//		employeeRepository.save(new Employee(13021629L,"Babu Bhaiya","CSE",1500));
		//List<Employee> employees = employeeRepository.findBySalaryGreaterThanEqual(150);
		//for(Employee employee : employees)System.out.println(employee);
		
		
		
		
		ConfigurableApplicationContext context = null;
		context = SpringApplication.run(Zee5appApplication.class, args);
		MovieService movieService = context.getBean(MovieService.class);
		
//		try {
//			movieService.insertMovie(new Movie("", "actor", "Vikrant Rona", "abc", "ACTION", "abc", "language",
//					LocalTime.of(2, 30), "trailer1"));
//			movieService.insertMovie(new Movie("", "actor1", "Vikrant Rona 2", "abc1", "ROMANCE", "abc1", "language1",
//					LocalTime.of(2, 15), "trailer2"));
//			movieService.insertMovie(new Movie("", "actor2", "KIARA", "abc", "THRILLER", "abc", "language",
//					LocalTime.of(2, 19), "trailer3"));
//			movieService.insertMovie(new Movie("", "actor", "The Shawshank Redemption", "abc", "THRILLER", "abc",
//					"language", LocalTime.of(3, 0, 11), "trailer1"));
//
//		} catch (RecordAlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			
//		Optional<List<Movie>> movies = movieService.getAllMovies();
//		
//		if(!movies.isPresent()) {
//			System.out.println("No Record Found");
//		}
//		else {
//			List<Movie> movies1 = movies.get();
//			for(Movie movie : movies1)System.out.println(movie);
//		}
//		List<Movie> allmovies = movieService.getAllMoviesByGenre("THRILLER");
//		for(Movie movie : allmovies)System.out.println(movie);
		
//		List<Movie> allmovies1 = movieService.findByOrderByMovieNameDsc();
//		for(Movie movie : allmovies1)System.out.println(movie);
		
	}

}
