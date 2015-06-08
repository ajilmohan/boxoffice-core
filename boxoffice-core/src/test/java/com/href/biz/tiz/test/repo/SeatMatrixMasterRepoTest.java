package com.href.biz.tiz.test.repo;

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
import com.href.biz.tiz.domain.SeatMatrixMaster;
import com.href.biz.tiz.repository.ClassMasterRepo;
import com.href.biz.tiz.repository.SeatMatrixMasterRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config.xml",
        "classpath:repo.xml"
})

@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
public class SeatMatrixMasterRepoTest {
	
	@Autowired
	SeatMatrixMasterRepo seatMatrixMasterRepo;
	
	@Autowired
	ClassMasterRepo classMasterRepo;
	
	@Test
	@Transactional
	@Rollback(false)
	public void saveTest(){
		
		List<ClassMaster> cMas = classMasterRepo.findAll();
		
		SeatMatrixMaster seat = new SeatMatrixMaster();
		seat.setClassMaster(cMas.get(0));
		seat.setPosition("A2");
		seatMatrixMasterRepo.save(seat);
		
		seat = new SeatMatrixMaster();
		seat.setClassMaster(cMas.get(0));
		seat.setPosition("A2");
		seatMatrixMasterRepo.save(seat);
		
	}
	
	@Test
	public void getRole(){
		
	}

}
