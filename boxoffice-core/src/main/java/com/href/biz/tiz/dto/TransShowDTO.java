package com.href.biz.tiz.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.href.biz.tiz.domain.BoxOffice;

public class TransShowDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private ShowOnScreenDTO showOnScreen;
	
	private BoxOffice boxOffice;
	
	private Date showDate;
	
	private List<TransShowSeatDTO> transShowSeats;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShowOnScreenDTO getShowOnScreen() {
		return showOnScreen;
	}

	public void setShowOnScreen(ShowOnScreenDTO showOnScreen) {
		this.showOnScreen = showOnScreen;
	}

	public BoxOffice getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(BoxOffice boxOffice) {
		this.boxOffice = boxOffice;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public List<TransShowSeatDTO> getTransShowSeats() {
		return transShowSeats;
	}

	public void setTransShowSeats(List<TransShowSeatDTO> transShowSeats) {
		this.transShowSeats = transShowSeats;
	}

	
	
	

}
