package com.zee.zee5app.dto;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.naming.InvalidNameException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zee.zee5app.enums.Genres;
import com.zee.zee5app.enums.Languages;
import com.zee.zee5app.exceptions.InvalidIdException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table(name = "movie_table")
public class Movie {
	
	@Id
	@GenericGenerator(name="movieIdGenerator",strategy = "com.zee.zee5app.utils.MovieIdGenerator")
	@GeneratedValue(generator = "movieIdGenerator")
    private String movieId;
	@NotNull
	private String actors;
	@NotNull
	@Size(min = 3)
    private String movieName;
	@NotNull
    private String director;
    
    private String genre;
    private String production;
    
    private String languages;
    @Column(columnDefinition = "TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH-mm-ss")
    private LocalTime movieLength;
    
    private String trailer1;
    
//	public void setActors(String[] actors) {
//		this.actors = actors;
//	}
//
//	public void setMovieName(String movieName) throws InvalidNameException {
//		int length = movieName.length();
//		if(movieName==null||movieName == ""||length<3) {
//			throw new InvalidNameException("Invalid Movie Name");
//		}
//		else this.movieName = movieName;
//	}
//
//	public void setDirector(String director) {
//		this.director = director;
//	}
//
//	
//
//	public void setProduction(String production) {
//		this.production = production;
//	}
//
//	public void setLanguages(String[] languages) throws InvalidNameException {
//		int count=0;
//		for(String string: languages) {
//			//System.out.println(Languages.valueOf(string));
//			for(Languages l : Languages.values()) {
//				if(Languages.valueOf(string).compareTo(l)==0) {
//					count++;
//				}
//			}
//		}
//		if(count!=languages.length) {
//            throw new InvalidNameException("Invalid language set");
//        }
//		this.languages = languages;
//		//throw Exception()
//	}
//
//	public void setMovieLength(float movieLength) {
//		
//		this.movieLength = movieLength;
//	}
//	public Movie() {
//		// TODO Auto-generated constructor stub
//	}
//    public Movie(String movieId, String[] actors, String movieName, String director, Genres genre, String production,
//			String[] languages, float movieLength,String trailer1) throws InvalidIdException, InvalidNameException {
//		super();
//		this.setMovieId(movieId);
//		this.setActors(actors);
//		this.setMovieName(movieName);
//		this.director = director;
//		this.genre = genre;
//		this.production = production;
//		this.setLanguages(languages);
//		this.movieLength = movieLength;
//		this.trailer1 = trailer1;
//	}
//	public void setGenre(Genres genre) {
//		this.genre = genre;
//	}
	
    //private byte[] trailer2;
}

