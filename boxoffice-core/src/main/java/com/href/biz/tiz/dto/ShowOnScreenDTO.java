package com.href.biz.tiz.dto;

import java.io.Serializable;
import java.util.Date;

import com.href.biz.tiz.domain.Film;
import com.href.biz.tiz.domain.ShowMaster;

public class ShowOnScreenDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private ShowMaster show;
	
	private ScreenDTO screen;
	
	private Film film;
	
	private String status;
	
	private Date startDate;
	
	private Date endDate;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public ScreenDTO getScreen() {
		return screen;
	}

	public void setScreen(ScreenDTO screen) {
		this.screen = screen;
	}

	public ShowMaster getShow() {
		return show;
	}

	public void setShow(ShowMaster show) {
		this.show = show;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


}
