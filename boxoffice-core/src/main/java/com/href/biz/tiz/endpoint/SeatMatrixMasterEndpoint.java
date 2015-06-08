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

import com.href.biz.tiz.domain.Screen;
import com.href.biz.tiz.domain.SeatMatrixMaster;
import com.href.biz.tiz.dto.SeatMasterOfScreenDTO;
import com.href.biz.tiz.proxy.SeatMasterOfScreenProxy;
import com.href.biz.tiz.proxy.SeatMatrixMasterProxy;

@Controller("seatMatrixMasterEndpoint")
public class SeatMatrixMasterEndpoint {
	
	final static Logger logger = LoggerFactory.getLogger(SeatMatrixMasterEndpoint.class);
	
	@Autowired
	SeatMatrixMasterProxy seatMatrixMasterProxy;
	
	@Autowired
	SeatMasterOfScreenProxy seatMasterOfScreenProxy;
	
	@RequestMapping(value = "/cinema/seatmatrixmaster", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<SeatMatrixMaster>> getSeatMatrixMaster(){
		logger.info("Endpoint .getSeatMatrixMaster() invoked . ");
		List<SeatMatrixMaster>  seatMatrixMaster  = new ArrayList<SeatMatrixMaster>();
		try {
			seatMatrixMaster = seatMatrixMasterProxy.findAll();
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<List<SeatMatrixMaster>>(seatMatrixMaster, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cinema/screen/seatmaster", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<SeatMasterOfScreenDTO>> getSeatMasterOfScreen(@RequestBody Screen screen){
		logger.info("Endpoint .getSeatMasterOfScreen() invoked . ");
		List<SeatMasterOfScreenDTO>  seatMasterOfScreen  = new ArrayList<SeatMasterOfScreenDTO>();
		try {
			seatMasterOfScreen = seatMasterOfScreenProxy.getSeatMasterByScreenId(screen.getId());
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<List<SeatMasterOfScreenDTO>>(seatMasterOfScreen, HttpStatus.OK);
	}


}
