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

import com.href.biz.tiz.domain.ClassMaster;
import com.href.biz.tiz.repository.ClassMasterRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config.xml",
        "classpath:repo.xml"
})

@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
public class ClassMasterRepoTest {
	
	@Autowired
	ClassMasterRepo classMasterRepo;
	
	
	//@Test
	@Transactional
	@Rollback(false)
	public void saveTest(){
		
		ClassMaster cMaster = new ClassMaster();
		cMaster.setRate(200);
		cMaster.setType("Golden");
		classMasterRepo.save(cMaster);
		
		cMaster = new ClassMaster();
		cMaster.setRate(150);
		cMaster.setType("Silver");
		classMasterRepo.save(cMaster);
		
		cMaster = new ClassMaster();
		cMaster.setRate(100);
		cMaster.setType("Platinum");
		classMasterRepo.save(cMaster);
		
		
	}
	
	@Test
	public void getClassMaster(){
		
		List<ClassMaster> masters = new ArrayList<ClassMaster>();
		masters = classMasterRepo.findAll();
		if(masters != null){
			System.out.println(masters.size());
		}
	}

}
