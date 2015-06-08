package com.href.biz.tiz.dto;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String password;
	
	private List<BoxOfficeDTO> boxoffices;
	
	private List<RoleDTO> roles;
	

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<BoxOfficeDTO> getBoxoffices() {
		return boxoffices;
	}

	public void setBoxoffices(List<BoxOfficeDTO> boxoffices) {
		this.boxoffices = boxoffices;
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}


}
