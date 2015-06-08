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

import com.href.biz.tiz.domain.User;
import com.href.biz.tiz.dto.TizStatus;
import com.href.biz.tiz.proxy.UserProxy;

@Controller("userEndpoint")
public class UserEndpoint {
	
	final static Logger logger = LoggerFactory.getLogger(UserEndpoint.class);
	
	@Autowired
	UserProxy userProxy;
	
	@RequestMapping(value = "/cinema/users", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<User>> getUsers(){
		logger.info("Endpoint .getUsers() invoked . ");
		List<User>  users  = new ArrayList<User>();
		try {
			users = userProxy.findAll();
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/cinema/auth/user", method = RequestMethod.POST )
	@ResponseBody
	public ResponseEntity<TizStatus> getAuthUser(@RequestBody User user){
		logger.info("Endpoint .getAuthUser() invoked . ");
		TizStatus  status = new TizStatus();
		User  userRes  = null;
		String response = "";
		try {
			userRes = userProxy.getUserByCredentials(user.getName(), user.getPassword());
			if(userRes != null){
				response = "Welcome "+userRes.getName();
				status.setCode("200");
				status.setMessage(response);
				status.setData(userRes);
			}else{
				response = "Invalid user name or password.";
				status.setCode("300");
				status.setMessage(response);
			}
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<TizStatus>(status, HttpStatus.OK);
	}
	

}
