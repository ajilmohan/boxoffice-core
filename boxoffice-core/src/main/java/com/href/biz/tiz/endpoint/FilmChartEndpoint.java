package com.href.biz.tiz.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.href.biz.tiz.domain.Film;
import com.href.biz.tiz.dto.TizStatus;
import com.href.biz.tiz.proxy.FilmProxy;

@Controller("filmChartEndpoint")
public class FilmChartEndpoint {
	
	final static Logger logger = LoggerFactory.getLogger(FilmChartEndpoint.class);
	
	@Autowired
	FilmProxy filmProxy;
	
	@RequestMapping(value = "/cinema/films", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Film>> getFilms(){
		logger.info("Endpoint .getFilms() invoked . ");
		List<Film>  films  = new ArrayList<Film>();
		try {
			films = filmProxy.findAll();
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<List<Film>>(films, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cinema/films/running", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Film>> getRunningFilms(){
		logger.info("Endpoint .getRunningFilms() invoked . ");
		List<Film>  films  = new ArrayList<Film>();
		try {
			films = filmProxy.getFilmByStatus();
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<List<Film>>(films, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cinema/film/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<TizStatus> updateFilm(@RequestBody Film film){
		logger.info("Endpoint .updateFilm() invoked . ");
		TizStatus status = new TizStatus();
		try {
			Film updatedFilm = filmProxy.save(film);
			status.setCode("200");
			status.setMessage("Film details updated.");
			status.setData(updatedFilm);
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
			status.setCode("300");
			status.setMessage("Error ocurred duirng update film details.");
		}
		logger.info("Exit . ");
		return new ResponseEntity<TizStatus>(status, HttpStatus.OK);
	}

}
