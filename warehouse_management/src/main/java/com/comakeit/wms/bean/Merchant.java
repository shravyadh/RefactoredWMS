package com.comakeit.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Merchant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int merchant_code;
	
	@Column(nullable=false,unique=true)
	private String merchant_name;
	
	public Merchant()
	{
		
	}
	
	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

}
