package com.href.biz.tiz.dto;



public class SeatMasterOfScreenDTO {
	
	private Long id;
	private String behaviour;
	private SeatMatrixMasterDTO seatMatrixMaster;
	private ScreenDTO screen;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBehaviour() {
		return behaviour;
	}
	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}
	public SeatMatrixMasterDTO getSeatMatrixMaster() {
		return seatMatrixMaster;
	}
	public void setSeatMatrixMaster(SeatMatrixMasterDTO seatMatrixMaster) {
		this.seatMatrixMaster = seatMatrixMaster;
	}
	public ScreenDTO getScreen() {
		return screen;
	}
	public void setScreen(ScreenDTO screen) {
		this.screen = screen;
	}
	
	

}
