package com.href.biz.tiz.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.tiz.domain.SeatMatrixMaster;
import com.href.biz.tiz.proxy.SeatMatrixMasterProxy;
import com.href.biz.tiz.repository.SeatMatrixMasterRepo;

/****
 * 
 * @author Ajil
 *
 */

@Service("seatMatrixMasterService")
@Transactional
public class SeatMatrixMasterService implements SeatMatrixMasterProxy {
	
	final static Logger logger = LoggerFactory.getLogger(SeatMatrixMasterService.class);
	
	@Autowired
	SeatMatrixMasterRepo seatMatrixMasterRepo;

	public SeatMatrixMaster save(SeatMatrixMaster entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public SeatMatrixMaster findOne(long id) {
		return seatMatrixMasterRepo.findOne(id);
	}

	public List<SeatMatrixMaster> findAll() {
		return seatMatrixMasterRepo.findAll();
	}
	
	
	
	
}
