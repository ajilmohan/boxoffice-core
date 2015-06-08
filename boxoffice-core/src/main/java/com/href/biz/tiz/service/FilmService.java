package com.href.biz.tiz.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.tiz.domain.Film;
import com.href.biz.tiz.proxy.FilmProxy;
import com.href.biz.tiz.repository.FilmRepo;

/****
 * 
 * @author Ajil
 *
 */

@Service("filmService")
@Transactional
public class FilmService implements FilmProxy {
	
	final static Logger logger = LoggerFactory.getLogger(FilmService.class);
	
	@Autowired
	FilmRepo filmRepo;
	
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public Film save(Film entity) {
		return filmRepo.save(entity);
	}

	public Film findOne(long id) {
		return filmRepo.findOne(id);
	}

	public List<Film> findAll() {
		return filmRepo.findAll();
	}

	public List<Film> getFilmByStatus() {
		return filmRepo.getFilmByStatus("RUNNING");
	}

}
