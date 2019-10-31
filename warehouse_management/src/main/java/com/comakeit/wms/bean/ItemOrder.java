package com.comakeit.wms.bean;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderid;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(length=20,nullable=false)
	String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Item item;
	
	@Column
	private String merchant_name;

	public int getOrderid() {
		return orderid;
	}

	public int getQuantity() {
		return quantity;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ItemOrder [orderid=" + orderid + ", quantity=" + quantity + ", date=" + date + ", status=" + status
				+ ", item=" + item + ", merchant_name=" + merchant_name + "]";
	}
}
