package com.href.biz.tiz.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.tiz.domain.Screen;
import com.href.biz.tiz.domain.ShowOnScreen;
import com.href.biz.tiz.dto.ScreenDTO;
import com.href.biz.tiz.dto.ShowOnScreenDTO;
import com.href.biz.tiz.proxy.ShowOnScreenProxy;
import com.href.biz.tiz.repository.ShowOnScreenRepo;

/****
 * 
 * @author Ajil
 *
 */

@Service("showOnScreenService")
@Transactional
public class ShowOnScreenService implements ShowOnScreenProxy {
	
	final static Logger logger = LoggerFactory.getLogger(ShowOnScreenService.class);
	
	@Autowired
	ShowOnScreenRepo showOnScreenRepo;
	
	public ShowOnScreen save(ShowOnScreen entity) {
		return showOnScreenRepo.save(entity);
	}

	public void delete(long id) {
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
	}

	public ShowOnScreenDTO findOne(long id) {
		ShowOnScreen show = showOnScreenRepo.findOne(id);
		if(show != null){
			List<ShowOnScreen> shows= new ArrayList<ShowOnScreen>();
			shows.add(show);
			List<ShowOnScreenDTO> dtos = convertDomainToDTO(shows);
			return dtos.get(0);
		}else{
			return null;
		}
		
	}

	public List<ShowOnScreenDTO> findAll() {
		return convertDomainToDTO(showOnScreenRepo.findAll());
	}

	public List<ShowOnScreenDTO> getShowOnScreenByStatus(String status) {
		return convertDomainToDTO(showOnScreenRepo.getShowOnScreenByStatus(status));
	}
	
	private List<ShowOnScreenDTO> convertDomainToDTO(List<ShowOnScreen> shows){
		logger.info(".convertDomainToDTO(). invoked with status ");
		List<ShowOnScreenDTO> showDtos = new ArrayList<ShowOnScreenDTO>();
		String[] showOnScreenPropIgnore = {"screen"};
		String[] screenPropIgnore = {"cinema"};
		ShowOnScreenDTO showDto = null;
		ScreenDTO screenDto = null;
		for(ShowOnScreen show : shows){
			showDto = new ShowOnScreenDTO();
			BeanUtils.copyProperties(show, showDto,showOnScreenPropIgnore);
			screenDto = new ScreenDTO();
			BeanUtils.copyProperties(show.getScreen(), screenDto,screenPropIgnore);
			showDto.setScreen(screenDto);
			showDtos.add(showDto);
		}
		logger.info("Exit ");
		return showDtos;
	}
	
	private List<ShowOnScreen> convertDTOToDomain(List<ShowOnScreenDTO> showDtos){
		logger.info(".convertDomainToDTO(). invoked with status ");
		List<ShowOnScreen> shows = new ArrayList<ShowOnScreen>();
		String[] showOnScreenPropIgnore = {"screen"};
		String[] screenPropIgnore = {"cinema"};
		ShowOnScreen show = null;
		Screen screen = null;
		for(ShowOnScreenDTO showDto : showDtos){
			show = new ShowOnScreen();
			BeanUtils.copyProperties(showDto, show,showOnScreenPropIgnore);
			BeanUtils.copyProperties(showDto.getScreen(), screen,screenPropIgnore);
			show.setScreen(screen);
			shows.add(show);
		}
		logger.info("Exit ");
		return shows;
	}

	public ShowOnScreenDTO save(ShowOnScreenDTO entity) {
		logger.info(".save() invoked with status ");
		List<ShowOnScreenDTO> dtos = new ArrayList<ShowOnScreenDTO>();
		dtos.add(entity);
		List<ShowOnScreen> shows = convertDTOToDomain(dtos);
		ShowOnScreen show = showOnScreenRepo.save(shows.get(0));
		shows= new ArrayList<ShowOnScreen>();
		shows.add(show);
		ShowOnScreenDTO fDto = convertDomainToDTO(shows).get(0); 
		logger.info("Exit");
		return fDto;
	}

	

}
