package com.href.biz.tiz.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANS_SHOW_SEAT")
public class TransShowSeat implements Serializable {

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
	@JoinColumn(name="SCREEN_SEAT_ID",  nullable=false)
	private SeatMasterOfScreen seatMasterOfScreen;
	
	@ManyToOne
    @JoinColumn(name="TRANS_SHOW_ID", nullable=false)
	private TransShow transShow;
	
	@Column(name = "STATUS")
	private String status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SeatMasterOfScreen getSeatMasterOfScreen() {
		return seatMasterOfScreen;
	}

	public void setSeatMasterOfScreen(SeatMasterOfScreen seatMasterOfScreen) {
		this.seatMasterOfScreen = seatMasterOfScreen;
	}

	public TransShow getTransShow() {
		return transShow;
	}

	public void setTransShow(TransShow transShow) {
		this.transShow = transShow;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	

}
