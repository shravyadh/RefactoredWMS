package com.comakeit.wms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comakeit.wms.bean.Item;
import com.comakeit.wms.bean.ItemOrder;
import com.comakeit.wms.repository.ItemOrderRepository;
import com.comakeit.wms.repository.ItemRepository;

@Service
public class MerchantService implements IMerchant{

	@Autowired
	ItemOrderRepository itemOrderRepository;

	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public List<ItemOrder> viewOrders() {
		return itemOrderRepository.viewOrders();
	}
	
	@Override
	public ItemOrder acceptOrder(int id, int stock, int item_code) {

		Item item = new Item();
		item = itemRepository.findById(item_code).get();
		item.setItem_stock(item.getItem_stock() + stock);
		itemRepository.save(item);

		ItemOrder itemOrder = itemOrderRepository.findById(id).get();
		itemOrder.setStatus("Accept");
		itemOrderRepository.save(itemOrder);
		
		return itemOrder;
	}

	@Override
	public void cancelOrder(int id) {
		ItemOrder itemOrder = itemOrderRepository.findById(id).get();
		itemOrder.setStatus("Cancel");
		itemOrderRepository.save(itemOrder);

	}
}
