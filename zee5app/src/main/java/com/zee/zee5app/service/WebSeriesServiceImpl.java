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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.WebSeries;
import com.zee.zee5app.enums.Genres;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.RecordAlreadyExistsException;
import com.zee.zee5app.exceptions.RecordNotFoundException;
import com.zee.zee5app.repo.WebRepository;

@Service
public class WebSeriesServiceImpl implements WebSeriesService {

	@Autowired
	private WebRepository repo;
	@Override
	public WebSeries insertSeries(WebSeries webSeries) throws RecordAlreadyExistsException {
		if(repo.existsByWebSeriesName(webSeries.getWebSeriesName())) {
			throw new RecordAlreadyExistsException("WebSeries Name : "+webSeries.getWebSeriesName()+" already exists");
		}
		return repo.save(webSeries);
	}

	@Override
	public WebSeries updateSeries(String webSeriesId, WebSeries webSereis) throws RecordNotFoundException  {
		if(repo.existsById(webSeriesId)) {
			webSereis.setWebSeriesId(webSeriesId);
			System.out.println("UPDATED SUCCESSFULLY !");
			return repo.save(webSereis);
		}
		else throw new RecordNotFoundException("webSeriesId " +webSeriesId+" not found");
	}

	@Override
	public Optional<WebSeries> getSereisByWebSeriesId(String webSeriesId) {
		// TODO Auto-generated method stub
		return repo.findById(webSeriesId);
	}

	@Override
	public Optional<List<WebSeries>> getAllSereis() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repo.findAll());
	}

	@Override
	public List<WebSeries> getAllSeriesByGenre(String genre) {
		// TODO Auto-generated method stub
		return repo.findAllByGenre(genre);
	}

	@Override
	public List<WebSeries> getAllSeriesByName(String webSeriesName) {
		// TODO Auto-generated method stub
		return repo.findAllByWebSeriesName(webSeriesName);
	}

	@Override
	public String deleteSeriesBySeriesId(String webSeriesId) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		if(repo.existsById(webSeriesId)) {
			repo.deleteById(webSeriesId);
			return "DELETED SUCCESSFULLY";
		}else {
			throw new RecordNotFoundException("WebSeries Id "+webSeriesId+"not found ");
		}
	}

	

}
