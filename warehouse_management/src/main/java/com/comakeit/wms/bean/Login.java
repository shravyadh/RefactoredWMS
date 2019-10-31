package com.comakeit.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Login {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int login_id;

	@Column(length = 20, nullable = false,unique=true)
	private String username;

	@Column(length = 20, nullable = false,unique=true)
	@Size(min = 4, max = 10, message = "Name must be between 2 and 32 characters long")
	private String password;

	@ManyToOne
	private Role role;

	public Login() {

	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
}
