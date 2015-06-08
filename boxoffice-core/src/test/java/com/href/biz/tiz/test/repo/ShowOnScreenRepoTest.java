package com.href.biz.tiz.test.repo;

import java.util.Date;
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

import com.href.biz.tiz.domain.Film;
import com.href.biz.tiz.domain.Screen;
import com.href.biz.tiz.domain.ShowMaster;
import com.href.biz.tiz.domain.ShowOnScreen;
import com.href.biz.tiz.repository.FilmRepo;
import com.href.biz.tiz.repository.ScreenRepo;
import com.href.biz.tiz.repository.ShowMasterRepo;
import com.href.biz.tiz.repository.ShowOnScreenRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config.xml",
        "classpath:repo.xml"
})

@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
public class ShowOnScreenRepoTest {
	
	@Autowired
	ScreenRepo screenRepo;
	
	@Autowired
	ShowMasterRepo showMasterRepo;
	
	@Autowired
	FilmRepo filmRepo;
	
	@Autowired
	ShowOnScreenRepo onScreenRepo;
	
	
	
	//@Test
	@Transactional
	@Rollback(false)
	public void saveTest(){
		Film film = filmRepo.findOne(1l);
		Screen screen  = screenRepo.findOne(1l);
		ShowMaster show = showMasterRepo.findOne(1l);
		ShowOnScreen showon  = new ShowOnScreen();
		showon.setFilm(film);
		showon.setScreen(screen);
		showon.setShow(show);
		showon.setStatus("OPEN");
		showon.setStartDate(new Date());
		onScreenRepo.save(showon);
	}
	
	@Test
	@Transactional
	public void getShows(){
		
		
		List<ShowOnScreen> shows  = onScreenRepo.findAll();
		if(shows != null){
			System.out.println("Shows " + shows.size());
		}
	}

}
