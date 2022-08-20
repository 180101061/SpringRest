package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.WebSeries;
import com.zee.zee5app.enums.Genres;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.RecordAlreadyExistsException;
import com.zee.zee5app.exceptions.RecordNotFoundException;

public interface WebSeriesService {

	public WebSeries insertSeries(WebSeries webSeries) throws RecordAlreadyExistsException;
    public WebSeries updateSeries(String webSeriesId, WebSeries webSereis) throws RecordNotFoundException ;
    public Optional<WebSeries> getSereisByWebSeriesId(String webSeriesId);
    public Optional<List<WebSeries>> getAllSereis();
    public List<WebSeries> getAllSeriesByGenre(String genre);
    public List<WebSeries> getAllSeriesByName(String webSeriesName);
    public String deleteSeriesBySeriesId(String webSeriesId) throws RecordNotFoundException ;
	
}
