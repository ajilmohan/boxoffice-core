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
import com.href.biz.tiz.domain.SeatMasterOfScreen;
import com.href.biz.tiz.domain.ShowOnScreen;
import com.href.biz.tiz.domain.TransShow;
import com.href.biz.tiz.domain.TransShowSeat;
import com.href.biz.tiz.repository.BoxOfficeRepo;
import com.href.biz.tiz.repository.SeatMasterOfScreenRepo;
import com.href.biz.tiz.repository.ShowOnScreenRepo;
import com.href.biz.tiz.repository.TransShowRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config.xml",
        "classpath:repo.xml"
})

@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
public class TransShowRepoTest {
	
	
	@Autowired
	ShowOnScreenRepo onScreenRepo;
	
	@Autowired
	BoxOfficeRepo boxOfficeRepo;
	
	@Autowired
	TransShowRepo transShowRepo;
	
	@Autowired
	SeatMasterOfScreenRepo seatMasterScreenRepo;
	
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void saveTest(){
		

		TransShow transShow = new TransShow();
		
		ShowOnScreen show  = onScreenRepo.findOne(1l);
		BoxOffice bo = boxOfficeRepo.findOne(1l);
		
		transShow.setBoxOffice(bo);
		transShow.setShowOnScreen(show);
		
		List<SeatMasterOfScreen> seats = seatMasterScreenRepo.findAll();
		
		List<TransShowSeat> trSeats  = new ArrayList<TransShowSeat>();
		for(SeatMasterOfScreen mSeat  :  seats ){
			TransShowSeat st = new TransShowSeat();
			st.setSeatMasterOfScreen(mSeat);
			st.setTransShow(transShow);
			st.setStatus("BOOKED");
			trSeats.add(st);
		}
		
		transShow.setTransShowSeats(trSeats);
		
		transShowRepo.save(transShow);
		
		
	}

}
