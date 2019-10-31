package com.comakeit.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	private int id;
	
	@Column(unique=true,nullable=false)
	private String role_name;
	
	@Column(unique=true,nullable=false)
	private String role_code;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

}
