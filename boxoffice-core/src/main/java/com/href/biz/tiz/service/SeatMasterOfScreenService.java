package com.href.biz.tiz.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.tiz.domain.SeatMasterOfScreen;
import com.href.biz.tiz.dto.ClassMasterDTO;
import com.href.biz.tiz.dto.ScreenDTO;
import com.href.biz.tiz.dto.SeatMasterOfScreenDTO;
import com.href.biz.tiz.dto.SeatMatrixMasterDTO;
import com.href.biz.tiz.proxy.SeatMasterOfScreenProxy;
import com.href.biz.tiz.repository.SeatMasterOfScreenRepo;

/****
 * 
 * @author Ajil
 *
 */

@Service("seatMasterOfScreenService")
@Transactional
public class SeatMasterOfScreenService implements SeatMasterOfScreenProxy {
	
	final static Logger logger = LoggerFactory.getLogger(SeatMasterOfScreenService.class);
	
	@Autowired
	SeatMasterOfScreenRepo seatMasterOfScreenRepo;
	
	public SeatMasterOfScreen save(SeatMasterOfScreen entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public SeatMasterOfScreen findOne(long id) {
		return seatMasterOfScreenRepo.findOne(id);
	}

	public List<SeatMasterOfScreen> findAll() {
		return seatMasterOfScreenRepo.findAll();
	}

	public List<SeatMasterOfScreenDTO> getSeatMasterByScreenId(Long id) {
		logger.info("Service 'getSeatMasterByScreenId' invoked . ");
		List<SeatMasterOfScreen> seats = seatMasterOfScreenRepo.getSeatMasterByScreenId(id);
		List<SeatMasterOfScreenDTO> seatsDTOs = new ArrayList<SeatMasterOfScreenDTO>();
		String[] seatMasterPropIgnore = {"seatMatrixMaster","screen"};
		String[] seatMatrixPropIgnore = {"classMaster"};
		String[] screenPropIgnore = {"cinema"};
		SeatMasterOfScreenDTO dto = null;
		SeatMatrixMasterDTO smDTO = null;
		ScreenDTO screenDTO = null;
		ClassMasterDTO clDTO = null;
		for(SeatMasterOfScreen seat : seats){
			dto = new SeatMasterOfScreenDTO();
			BeanUtils.copyProperties(seat, dto,seatMasterPropIgnore);
			smDTO = new SeatMatrixMasterDTO();
			BeanUtils.copyProperties(seat.getSeatMatrixMaster(), smDTO,seatMatrixPropIgnore);
			clDTO = new ClassMasterDTO();
			BeanUtils.copyProperties(seat.getSeatMatrixMaster().getClassMaster(), clDTO);
			smDTO.setClassMaster(clDTO);
			dto.setSeatMatrixMaster(smDTO);
			screenDTO = new ScreenDTO();
			BeanUtils.copyProperties(seat.getScreen(), screenDTO,screenPropIgnore);
			dto.setScreen(screenDTO);
			seatsDTOs.add(dto);
		}
		logger.info("Exit. ");
		return seatsDTOs;
	}

	
}
