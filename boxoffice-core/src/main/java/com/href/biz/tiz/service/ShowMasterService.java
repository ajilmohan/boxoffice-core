package com.href.biz.tiz.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.tiz.domain.ShowMaster;
import com.href.biz.tiz.domain.User;
import com.href.biz.tiz.proxy.ShowMasterProxy;
import com.href.biz.tiz.repository.ShowMasterRepo;

/****
 * 
 * @author Ajil
 *
 */

@Service("showMasterService")
@Transactional
public class ShowMasterService implements ShowMasterProxy {
	
	final static Logger logger = LoggerFactory.getLogger(ShowMasterService.class);
	
	@Autowired
	ShowMasterRepo showMasterRepo;
	
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

	public ShowMaster save(ShowMaster entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public ShowMaster findOne(long id) {
		return showMasterRepo.findOne(id);
	}

	public List<ShowMaster> findAll() {
		return showMasterRepo.findAll();
	}

	
}
