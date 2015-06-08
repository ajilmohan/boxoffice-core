package com.href.biz.tiz.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.tiz.domain.Screen;
import com.href.biz.tiz.domain.User;
import com.href.biz.tiz.proxy.ScreenProxy;
import com.href.biz.tiz.repository.ScreenRepo;

/****
 * 
 * @author Ajil
 *
 */

@Service("screenService")
@Transactional
public class ScreenService implements ScreenProxy {
	
	final static Logger logger = LoggerFactory.getLogger(ScreenService.class);
	
	@Autowired
	ScreenRepo screenRepo;
	
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

	public Screen save(Screen entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Screen findOne(long id) {
		return screenRepo.findOne(id);
	}

	public List<Screen> findAll() {
		return screenRepo.findAll();
	}

	public List<Screen> getScreensByCinemaId(Long id) {
		return screenRepo.getScreensByCinemaId(id);
	}

	

}
