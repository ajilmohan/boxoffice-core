package com.href.biz.tiz.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TRANS_SHOW")
public class TransShow implements Serializable {

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
	@JoinColumn(name="SHOW_ON_SCREEN_ID",  nullable=false)
	private ShowOnScreen showOnScreen;
	
	@OneToOne (cascade=CascadeType.ALL)
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name="BOXOFFICE_ID",  nullable=false)
	private BoxOffice boxOffice;
	
	@Column(name = "SHOW_DATE")
	@Temporal(TemporalType.DATE)
	private Date showDate;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="transShow")
	private List<TransShowSeat> transShowSeats;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShowOnScreen getShowOnScreen() {
		return showOnScreen;
	}

	public void setShowOnScreen(ShowOnScreen showOnScreen) {
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

	public List<TransShowSeat> getTransShowSeats() {
		return transShowSeats;
	}

	public void setTransShowSeats(List<TransShowSeat> transShowSeats) {
		this.transShowSeats = transShowSeats;
	}

	
	
	

}
