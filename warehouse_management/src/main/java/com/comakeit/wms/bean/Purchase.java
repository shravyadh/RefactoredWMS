package com.comakeit.wms.bean;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transaction_id;

	@ManyToOne
	Customer customer;

	@ManyToOne
	Item item;

	@Column(nullable = false)
	private LocalDate date_Of_purchase;

	@Column(nullable = false)
	private int quantity_purchased;

	@Column(nullable = false)
	private double total;

	public Purchase() {

	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double price) {
		this.total = price;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public LocalDate getDate_Of_purchase() {
		return date_Of_purchase;
	}

	public void setDate_Of_purchase(LocalDate date_Of_purchase) {
		this.date_Of_purchase = date_Of_purchase;
	}

	public int getQuantity_purchased() {
		return quantity_purchased;
	}

	public void setQuantity_purchased(int quantity_purchased) {
		this.quantity_purchased = quantity_purchased;
	}

	@Override
	public String toString() {
		return "Purchase [transaction_id=" + transaction_id + ", customer=" + customer + ", item=" + item
				+ ", date_Of_purchase=" + date_Of_purchase + ", quantity_purchased=" + quantity_purchased + ", total="
				+ total + "]";
	}

}
