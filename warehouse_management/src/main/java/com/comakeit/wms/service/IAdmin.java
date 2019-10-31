package com.comakeit.wms.service;

import java.time.LocalDate;
import java.util.List;

import com.comakeit.wms.bean.Customer;
import com.comakeit.wms.bean.Item;
import com.comakeit.wms.bean.ItemOrder;
import com.comakeit.wms.bean.Purchase;

public interface IAdmin {
	
	List<Item> getItems();
	Customer addCustomer(Customer customer);
	List<Customer> getCustomers(int customer_code);
	void deleteCustomer(String customer_name);
	void deleteItem(String item_name);
	Purchase placeOrder(Purchase purchase);
	List<Purchase> viewPurchases(LocalDate date);
	List<ItemOrder> viewOrders();
}
