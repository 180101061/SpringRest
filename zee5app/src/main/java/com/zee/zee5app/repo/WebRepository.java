package com.zee.zee5app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.WebSeries;

@Repository
public interface WebRepository extends JpaRepository<WebSeries, String> {

	Boolean existsByWebSeriesName(String seriesName);
	public List<WebSeries> findAllByGenre(String genre);
	public List<WebSeries> findAllByWebSeriesName(String seriesName);
}
