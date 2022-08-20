package com.zee.zee5app.dto;

import java.time.LocalTime;

import javax.naming.InvalidNameException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

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
//@Table(name = "series_table")
public class WebSeries {
	
	

	@Id
	@GenericGenerator(name="seriesIdGenerator",strategy = "com.zee.zee5app.utils.SeriesIdGenerator")
	@GeneratedValue(generator = "seriesIdGenerator")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String webSeriesId;
	private String actors;
	@NotNull
	@Size(min = 2)
    private String webSeriesName;
    private String director;
    private String genre;
    private String production;
    private String languages;
    @NotNull
    private Integer episodeNumber;
    private String trailer1;
}
