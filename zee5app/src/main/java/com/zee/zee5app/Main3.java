package com.zee.zee5app;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.WebSeries;
import com.zee.zee5app.exceptions.RecordAlreadyExistsException;
import com.zee.zee5app.exceptions.RecordNotFoundException;
import com.zee.zee5app.service.WebSeriesService;



public class Main3 {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = null;
		context = SpringApplication.run(Zee5appApplication.class, args);
		WebSeriesService seriesService = context.getBean(WebSeriesService.class);
//		private String webSeriesId;
//		private String actors;
//	    private String webSeriesName;
//	    private String director;
//	    private String genre;
//	    private String production;
//	    private String languages;
//	    private Integer episodeNumber;
//	    private String trailer1;
//		try {
//			seriesService.insertSeries(new WebSeries("","actors1","The Family Man","director1","ACTION","production1","languages",8,"trailer1"));
//			seriesService.insertSeries(new WebSeries("","actors2","Mirzapur","director2","CRIME","production2","languages2",7,"trailer2"));
//			seriesService.insertSeries(new WebSeries("","actors3","Peaky Binders","director3","SUSPENSE","production3","languages3",5,"trailer3"));
//		} catch (RecordAlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			seriesService.updateSeries("Mi00000002", new WebSeries("","actors of mirzapur","Mirzapur","director1","ACTION","production1","HINDI",8,"trailer1"));
//		} catch (RecordNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Optional<WebSeries> series = seriesService.getSereisByWebSeriesId("Mi00000002");
//		System.out.println(series.get());
//		Optional<List<WebSeries>> series = seriesService.getAllSereis();
//		
//		if(!series.isPresent()) {
//			System.out.println("No Record Found");
//		}
//		else {
//			List<WebSeries> result = series.get();
//			for(WebSeries webSeries : result)System.out.println(webSeries);
//		}
		
//		try {
//			seriesService.deleteSeriesBySeriesId("Mi00000002");
//		} catch (RecordNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
}
