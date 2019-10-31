package com.comakeit.wms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.comakeit.wms.bean.Purchase;
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Integer>{
	
	@Query("select purchase from Purchase purchase where purchase.date_Of_purchase = :date")
	List<Purchase> viewPurchases(@PathVariable("date")LocalDate date);
}
