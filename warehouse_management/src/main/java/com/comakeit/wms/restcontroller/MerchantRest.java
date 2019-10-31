package com.comakeit.wms.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.wms.bean.ItemOrder;
import com.comakeit.wms.service.MerchantService;

@RestController
public class MerchantRest {

	@Autowired
	MerchantService merchantService;

	@GetMapping("/viewO")
	public List<ItemOrder> viewOrders() {
		return merchantService.viewOrders();
	}

	@PostMapping("/accept/{id}/{stock}/{item_code}")
	public ItemOrder acceptOrder(@PathVariable("id") int id, @PathVariable("stock") int stock,
			@PathVariable("item_code") int item_code) {
		return merchantService.acceptOrder(id, stock, item_code);
	}

	@PostMapping("/cancel/{id}")
	public void cancelOrder(@PathVariable("id") int id) {
		merchantService.cancelOrder(id);
	}
}
