package com.comakeit.wms.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customer_code=0;

	@Column(length = 30, nullable = false)
	private String customer_name;

	@Column(length = 14, nullable = false,unique=true)
	private String phone_number;

	@Column(length = 20, nullable = false)
	private String address;

	@ManyToOne(cascade=CascadeType.ALL)
	Login login;

	public Customer() {

	}

	public int getCustomer_code() {
		return customer_code;
	}

	public void setCustomer_code(int customer_code) {
		this.customer_code = customer_code;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Customer [customer_code=" + customer_code + ", customer_name=" + customer_name + ", phone_number="
				+ phone_number + ", address=" + address + ", login=" + login + "]";
	}

}
