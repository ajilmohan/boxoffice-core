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

import com.href.biz.tiz.domain.Screen;
import com.href.biz.tiz.domain.SeatMasterOfScreen;
import com.href.biz.tiz.domain.SeatMatrixMaster;
import com.href.biz.tiz.repository.ScreenRepo;
import com.href.biz.tiz.repository.SeatMasterOfScreenRepo;
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
public class SeatMasterOfScreenRepoTest {
	
	@Autowired
	SeatMasterOfScreenRepo seatMasterOfScreenRepo;
	
	@Autowired
	SeatMatrixMasterRepo seatMatrixMasterRepo;
	
	@Autowired
	ScreenRepo screenRepo;
	
	@Test
	@Transactional
	@Rollback(false)
	public void saveTest(){
		
		SeatMatrixMaster master = seatMatrixMasterRepo.findOne(1l);
		
		Screen screen = screenRepo.findOne(1l);
		
		SeatMasterOfScreen seatMaster  = new SeatMasterOfScreen();
		seatMaster.setSeatMatrixMaster(master);
		seatMaster.setBehaviour("AVAILABLE");
		seatMaster.setScreen(screen);
		
		seatMasterOfScreenRepo.save(seatMaster);
	}
	
	@Test
	public void getRole(){
		
		
		
	}

}
