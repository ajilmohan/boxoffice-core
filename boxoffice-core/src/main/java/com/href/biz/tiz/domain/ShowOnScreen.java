package com.href.biz.tiz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SHOW_ON_SCREEN")
public class ShowOnScreen implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToOne (cascade=CascadeType.ALL)
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name="SHOW_ID",  nullable=false)
	private ShowMaster show;
	
	@OneToOne (cascade=CascadeType.ALL)
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name="SCREEN_ID",  nullable=false)
	private Screen screen;
	
	@OneToOne (cascade=CascadeType.ALL)
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name="FILM_ID",  nullable=false)
	private Film film;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "END_DATE")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
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
