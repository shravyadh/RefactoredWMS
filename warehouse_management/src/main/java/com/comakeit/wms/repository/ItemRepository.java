package com.comakeit.wms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.comakeit.wms.bean.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {

	@Query("select item from Item item")
	List<Item> getItems();
	
	@Query("select item from Item item where item_name = :item_name")
	Item selectItemByName(@PathVariable("item_name") String item_name);
}
