package com.href.biz.tiz.dto;

import java.io.Serializable;

public class SeatMatrixMasterDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String position;
	
	private ClassMasterDTO classMaster;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public ClassMasterDTO getClassMaster() {
		return classMaster;
	}

	public void setClassMaster(ClassMasterDTO classMaster) {
		this.classMaster = classMaster;
	}


}
