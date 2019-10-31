package com.comakeit.wms.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.wms.bean.Customer;
import com.comakeit.wms.bean.Item;
import com.comakeit.wms.bean.ItemOrder;
import com.comakeit.wms.bean.Purchase;
import com.comakeit.wms.service.AdminService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminRest {

	@Autowired
	AdminService adminService;

	@GetMapping("/viewItems")
	public List<Item> getItems() {
		List<Item> items =  adminService.getItems();
		return items;
	}

	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		Customer addedCustomer =  adminService.addCustomer(customer);
		return addedCustomer;
	}

	@GetMapping("/viewCustomers/{customer_code}")
	public List<Customer> getCustomers(@PathVariable("customer_code") int customer_code) {
		List<Customer> customers =  adminService.getCustomers(customer_code);
		return customers;
	}

	@DeleteMapping("/deleteCustomer/{customer_name}")
	public void deleteCustomer(@PathVariable("customer_name") String customer_name) {
		adminService.deleteCustomer(customer_name);
	}

	@DeleteMapping("/deleteItem/{item_name}")
	public void deleteItem(@PathVariable("item_name") String item_name) {
		adminService.deleteItem(item_name);
	}

	@PostMapping("/purchase")
	public Purchase placeOrder(@RequestBody Purchase purchase) {
		Purchase purchaseMade = adminService.placeOrder(purchase);
		return purchaseMade;
	}

	@GetMapping("/viewPurchases/{date}")
	public List<Purchase> viewPurchases(@PathVariable("date") String date) {
		List<Purchase> purchases = adminService.viewPurchases(LocalDate.parse(date));
		return purchases;
	}

	@GetMapping("/viewOrders")
	public List<ItemOrder> viewOrders() {
		List<ItemOrder> itemOrders = adminService.viewOrders();
		return itemOrders;
	}

	@PutMapping("/addStock")
	public void addStock(@RequestBody ItemOrder itemOrder) {
		System.out.println(itemOrder.toString());
		 adminService.addStock(itemOrder);
	}
}
