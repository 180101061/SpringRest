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
import com.zee.zee5app.dto.WebSeries;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.RecordAlreadyExistsException;
import com.zee.zee5app.exceptions.RecordNotFoundException;
import com.zee.zee5app.service.WebSeriesService;

@RestController
@RequestMapping("/api/series")
public class SeriesController {

	@Autowired
	WebSeriesService seriesService;
	@PostMapping("/add")
	public ResponseEntity<?> insertSeries(@RequestBody WebSeries series) throws RecordAlreadyExistsException{
		WebSeries series2 = new WebSeries();
		series2 = seriesService.insertSeries(series);
		return ResponseEntity.status(HttpStatus.CREATED).body(series2);
	}
	@GetMapping("/getall")
	public List<WebSeries> getAllSeries() {

		Optional<List<WebSeries>> result = seriesService.getAllSereis();
		List<WebSeries> series = result.get();
		for(WebSeries all : series)System.out.println(all);
		return series;
	}
	@PutMapping("/put/{seriesId}")
	public String updateUser(@PathVariable("seriesId")String seriesId, @RequestBody WebSeries series) throws RecordNotFoundException {
		seriesService.updateSeries(seriesId, series);
		return "Updated Successfully ";
	}
	@GetMapping("/id/{seriesId}")
	public WebSeries getSeriesBySeriesId(@PathVariable("seriesId")String seriesId) {
		Optional<WebSeries>result =  seriesService.getSereisByWebSeriesId(seriesId);
		WebSeries series = result.get();
		return series;
	}
	
	@GetMapping("/genre/{genre}")
	public List<WebSeries> getAllSeriesByGenre(@PathVariable("genre")String genre){
		return seriesService.getAllSeriesByGenre(genre);
	}
	@GetMapping("/name/{seriesName}")
	public List<WebSeries> getAllSeriesByWebSeriesName(@PathVariable("seriesName")String seriesName){
		return seriesService.getAllSeriesByName(seriesName);
	}
	@DeleteMapping("/{seriesId}")
	public String deleteSeriesById(@PathVariable("seriesId")String seriesId) throws RecordNotFoundException{
		seriesService.deleteSeriesBySeriesId(seriesId);
		return "deleted Successfully";
	}
}
