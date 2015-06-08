package com.href.biz.tiz.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.tiz.domain.Cinema;
import com.href.biz.tiz.domain.User;
import com.href.biz.tiz.proxy.CinemaProxy;
import com.href.biz.tiz.repository.CinemaRepo;

/****
 * 
 * @author Ajil
 *
 */

@Service("cinemaService")
@Transactional
public class CinemaService implements CinemaProxy {
	
	final static Logger logger = LoggerFactory.getLogger(CinemaService.class);
	
	@Autowired
	CinemaRepo cinemaRepo;

	public User save(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public Cinema save(Cinema entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cinema findOne(long id) {
		return cinemaRepo.findOne(id);
	}

	public List<Cinema> findAll() {
		return cinemaRepo.findAll();
	}


}
