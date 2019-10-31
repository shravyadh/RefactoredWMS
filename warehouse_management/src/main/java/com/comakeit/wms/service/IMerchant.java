package com.comakeit.wms.service;

import java.util.List;

import com.comakeit.wms.bean.ItemOrder;

public interface IMerchant {
	List<ItemOrder> viewOrders();
	ItemOrder acceptOrder(int id, int stock, int item_code);
	void cancelOrder(int id);
}
