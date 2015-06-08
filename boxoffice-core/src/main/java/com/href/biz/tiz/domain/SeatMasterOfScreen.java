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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SEAT_MASTER_OF_SCREEN")
public class SeatMasterOfScreen implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "BEHAVIOUR")
	private String behaviour;
	
	@OneToOne (cascade=CascadeType.ALL)
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name="SEAT_MATRIX_MASTER_ID",  nullable=false)
	private SeatMatrixMaster seatMatrixMaster;
	
	@OneToOne (cascade=CascadeType.ALL)
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name="SCREEN_ID",  nullable=false)
	private Screen screen;
	
	
	
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

	public SeatMatrixMaster getSeatMatrixMaster() {
		return seatMatrixMaster;
	}

	public void setSeatMatrixMaster(SeatMatrixMaster seatMatrixMaster) {
		this.seatMatrixMaster = seatMatrixMaster;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}


}
