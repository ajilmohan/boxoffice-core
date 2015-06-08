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

import com.href.biz.tiz.domain.ShowOnScreen;
import com.href.biz.tiz.dto.ShowOnScreenDTO;
import com.href.biz.tiz.dto.TizStatus;
import com.href.biz.tiz.proxy.FilmProxy;
import com.href.biz.tiz.proxy.ShowOnScreenProxy;

@Controller("showChartEndpoint")
public class ShowChartEndpoint {
	
	final static Logger logger = LoggerFactory.getLogger(ShowChartEndpoint.class);
	
	@Autowired
	FilmProxy filmProxy;
	
	@Autowired
	ShowOnScreenProxy showOnScreen;
	
	
	@RequestMapping(value = "/cinema/chartedshows", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ShowOnScreenDTO>> getAllShows(){
		logger.info("Endpoint .getAllShows() invoked . ");
		List<ShowOnScreenDTO>  shows  = new ArrayList<ShowOnScreenDTO>();
		try {
			shows = showOnScreen.findAll();
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<List<ShowOnScreenDTO>>(shows, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cinema/shows/basedonstatus", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<List<ShowOnScreenDTO>> getShowsBasedOnStatus(@RequestBody ShowOnScreen show){
		logger.info("Endpoint .getShowsBasedOnStatus() invoked . ");
		List<ShowOnScreenDTO>  shows  = new ArrayList<ShowOnScreenDTO>();
		try {
			shows = showOnScreen.getShowOnScreenByStatus(show.getStatus());
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<List<ShowOnScreenDTO>>(shows, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cinema/chartshow/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<TizStatus> chartShow(@RequestBody ShowOnScreenDTO show){
		logger.info("Endpoint .chartShow() invoked . ");
		TizStatus status = new TizStatus();
		try {
			ShowOnScreenDTO updatedShow = showOnScreen.save(show);
			status.setCode("200");
			status.setMessage("Film details updated.");
			status.setData(updatedShow);
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
			status.setCode("300");
			status.setMessage("Error ocurred duirng chart show.");
		}
		logger.info("Exit . ");
		return new ResponseEntity<TizStatus>(status, HttpStatus.OK);
	}

}
