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

import com.href.biz.tiz.domain.Cinema;
import com.href.biz.tiz.domain.Screen;
import com.href.biz.tiz.domain.ShowMaster;
import com.href.biz.tiz.proxy.CinemaProxy;
import com.href.biz.tiz.proxy.ScreenProxy;
import com.href.biz.tiz.proxy.ShowMasterProxy;

@Controller("cinemaEndpoint")
public class CinemaMasterEndpoint {
	
	final static Logger logger = LoggerFactory.getLogger(CinemaMasterEndpoint.class);
	
	@Autowired
	CinemaProxy cinemaProxy;
	
	@Autowired
	ScreenProxy screenProxy;
	
	@Autowired
	ShowMasterProxy showMasterProxy;
	
	@RequestMapping(value = "/cinema", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Cinema>> getCinema(){
		logger.info("Endpoint .getCinema() invoked . ");
		List<Cinema>  cinemas  = new ArrayList<Cinema>();
		try {
			cinemas = cinemaProxy.findAll();
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<List<Cinema>>(cinemas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cinema/screens", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<Screen>> getScreens(@RequestBody Cinema cinema){
		logger.info("Endpoint .getScreens() invoked . ");
		List<Screen>  screens  = new ArrayList<Screen>();
		try {
			screens = screenProxy.getScreensByCinemaId(cinema.getId());
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<List<Screen>>(screens, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cinema/showmaster", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ShowMaster>> getShowMaster(){
		logger.info("Endpoint .getShowMaster() invoked . ");
		List<ShowMaster>  showMasters  = new ArrayList<ShowMaster>();
		try {
			showMasters = showMasterProxy.findAll();
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<List<ShowMaster>>(showMasters, HttpStatus.OK);
	}

}
