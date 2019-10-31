package com.comakeit.wms.constants;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.comakeit.wms.bean.Customer;
import com.comakeit.wms.bean.Item;
import com.comakeit.wms.bean.ItemOrder;
import com.comakeit.wms.bean.Login;
import com.comakeit.wms.bean.Purchase;

public class Constants {
	public Constants() {

	}

	public static String url = "http://localhost:8181/";

	public double getTotal(int quantity, double price) {
		if (quantity < 10) {
			return price * quantity;
		} else if (quantity >= 10 && quantity <= 100) {
			return price * 0.9 * quantity;
		} else {
			return price * 0.8 * quantity;
		}
	}

	public Customer setCustomer(String name, String phoneno, String address, Login login) {
		Customer customer = new Customer();
		customer.setCustomer_name(name);
		customer.setPhone_number(phoneno);
		customer.setAddress(address);
		customer.setLogin(login);
		return customer;
	}

	public Purchase setPurchase(Item item, int id, int quantity, LocalDate date, double price, Customer customer) {
		Purchase purchase = new Purchase();
		purchase.setQuantity_purchased(quantity);
		purchase.setItem(item);
		purchase.setDate_Of_purchase(date);
		purchase.setTotal(price);
		purchase.setCustomer(customer);
		return purchase;
	}

	public double getPrice(ResponseEntity<List<Item>> genericItems, int id, int quantity) {
		double price = 0;
		
			for (Item item : genericItems.getBody()) {
				if (item.getItem_code() == id && item.getItem_stock() > quantity) {
						
						price = price + getTotal(quantity, item.getItem_price());
						return price;
				}
			}
			return 0;
	}

	public Item setItemStock(ResponseEntity<List<Item>> genericItems, int id, int quantity) {

	
			for (Item item : genericItems.getBody()) {
				if (item.getItem_code() == id && item.getItem_stock() > quantity) {
					   
						
						item.setItem_stock(item.getItem_stock() - quantity);
						
						return item;
	
					
				}
			}return null;
	}

	public Customer setCustomer(ResponseEntity<List<Customer>> customers, int customer_code) {
		for (Customer customer : customers.getBody()) {
			if (customer.getCustomer_code() == customer_code) {
				return customer;
			}
		}
		return null;
	}
	
	public Item getItem(ResponseEntity<List<Item>> genericItems,String customer_name) {
		for(Item item : genericItems.getBody()) {
			if(item.getItem_name().equals(customer_name))
			{
				return item;
			}
		}
		return null;
	}
	
	public ItemOrder setItemOrder(Item item, int quantity, LocalDate date) {
		ItemOrder itemOrder = new ItemOrder();
		itemOrder.setDate(date);
		itemOrder.setItem(item);
		itemOrder.setMerchant_name(item.getMerchant().getMerchant_name());
		itemOrder.setQuantity(quantity);
		itemOrder.setStatus("pending");
		return itemOrder;
	}
}
