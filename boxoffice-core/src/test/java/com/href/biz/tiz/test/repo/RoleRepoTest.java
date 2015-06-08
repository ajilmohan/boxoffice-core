package com.href.biz.tiz.test.repo;

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

import com.href.biz.tiz.domain.Role;
import com.href.biz.tiz.repository.RoleRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config.xml",
        "classpath:repo.xml"
})

@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
public class RoleRepoTest {
	
	@Autowired
	RoleRepo roleRepo;
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void saveTest(){
		
		Role role = new Role();
		role.setType("MANAGER");
		roleRepo.save(role);
		
		role = new Role();
		role.setType("ADMIN");
		roleRepo.save(role);
		
		role = new Role();
		role.setType("USER");
		roleRepo.save(role);
		
	}
	
	@Test
	public void getRole(){
		
	}

}
