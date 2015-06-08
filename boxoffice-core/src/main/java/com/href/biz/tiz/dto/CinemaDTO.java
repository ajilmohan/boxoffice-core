package com.href.biz.tiz.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

public class CinemaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	@Column(name = "LOCATION")
	private String location;
	
	private List<ScreenDTO> screens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<ScreenDTO> getScreens() {
		return screens;
	}

	public void setScreens(List<ScreenDTO> screens) {
		this.screens = screens;
	}


}
