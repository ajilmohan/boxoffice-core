package com.href.biz.tiz.test.repo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.tiz.domain.BoxOffice;
import com.href.biz.tiz.domain.Role;
import com.href.biz.tiz.domain.User;
import com.href.biz.tiz.repository.BoxOfficeRepo;
import com.href.biz.tiz.repository.RoleRepo;
import com.href.biz.tiz.repository.UserRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config.xml",
        "classpath:repo.xml"
})

@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
public class UserRepoTest {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	BoxOfficeRepo boxOfficeRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	
	//@Test
	@Transactional
	@Rollback(false)
	public void saveTest(){
		
		List<BoxOffice>  offices = new ArrayList<BoxOffice>();
		
		User usr = new User();
		usr.setName("pratheesh");
		usr.setPassword("pratheesh");
		
		BoxOffice office = new BoxOffice();
		office.setCounter("Counter-1");
		offices.add(office);
		
		office = new BoxOffice();
		office.setCounter("Counter-2");
		offices.add(office);
		
		List<Role> roles = roleRepo.findAll();
		
		usr.setBoxoffices(offices);
		usr.setRoles(roles);
		
		userRepo.save(usr);
	}
	
	
	//@Test
	public void testGetUsers(){
		
		List<User>  users  = new ArrayList<User>();
		users = userRepo.findAll();
		if(users != null){
			System.out.println(users.size()+"User collections size ********************");
		}
	}
	
	@Test
	public void getUserByCredentials(){
		List<User>  users  = new ArrayList<User>();
		users = userRepo.getUserByCredentials("pratheesh", "pratheesh");
		if(users != null){
			System.out.println(users.size()+"User collections size ********************");
		}
	}
	

}
