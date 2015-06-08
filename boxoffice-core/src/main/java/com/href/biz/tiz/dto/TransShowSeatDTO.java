package com.href.biz.tiz.dto;

import java.io.Serializable;

public class TransShowSeatDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private SeatMasterOfScreenDTO seatMasterOfScreen;
	
	private TransShowDTO transShow;
	
	private String status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SeatMasterOfScreenDTO getSeatMasterOfScreen() {
		return seatMasterOfScreen;
	}

	public void setSeatMasterOfScreen(SeatMasterOfScreenDTO seatMasterOfScreen) {
		this.seatMasterOfScreen = seatMasterOfScreen;
	}

	public TransShowDTO getTransShow() {
		return transShow;
	}

	public void setTransShow(TransShowDTO transShow) {
		this.transShow = transShow;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	

}
