package com.href.biz.tiz.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.tiz.domain.BoxOffice;
import com.href.biz.tiz.domain.Role;
import com.href.biz.tiz.domain.User;
import com.href.biz.tiz.proxy.UserProxy;
import com.href.biz.tiz.repository.UserRepo;

/****
 * 
 * @author Ajil
 *
 */

@Service("userService")
@Transactional
public class UserService implements UserProxy {
	
	final static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepo userRepo;

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

	public User findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll() {
		List<User> users = userRepo.findAll();
		for(User user : users){
			user.getBoxoffices();
			user.getRoles();
		}
		return users;
	}

	public User getUserByCredentials(String name, String pass) {
		logger.info("Endpoint .getUserByCredentials() invoked . ");
		List<User> users = userRepo.getUserByCredentials(name, pass);
		User user = null;
		List<BoxOffice> boxoffices = null;
		List<Role> roles = null;
		if(users != null  && !users.isEmpty()){
			user = users.get(0);
			boxoffices = user.getBoxoffices();
			for(BoxOffice bx : boxoffices){
				bx.getCounter();
			}
			roles = user.getRoles();
			for(Role role : roles){
				role.getType();
			}
			user.setBoxoffices(boxoffices);
			user.setRoles(roles);
		}
		logger.info("Exit.");
		return user;
	}

}
