package com.href.biz.tiz.domain;

import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "USER")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
    @JoinTable(name="BOXOFFICE_BELONGSTO_USER", joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")}, 
    inverseJoinColumns={@JoinColumn(name="BOXOFFICE_ID", referencedColumnName="ID")})
	private List<BoxOffice> boxoffices;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
    @JoinTable(name="ROLE_BELONGSTO_USER", joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")}, 
    inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	
	//@Transient
	private List<Role> roles;
	

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

	public List<BoxOffice> getBoxoffices() {
		return boxoffices;
	}

	public void setBoxoffices(List<BoxOffice> boxoffices) {
		this.boxoffices = boxoffices;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


}
