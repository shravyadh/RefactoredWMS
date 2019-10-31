package com.comakeit.wms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.comakeit.wms.bean.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	@Query("select customer from Customer customer where customer_code = :customer_code")
	List<Customer> getCustomers(@PathVariable("customer_code") int customer_code);
	
	@Query("select customer from Customer customer where customer_name = :customer_name")
	Customer getCustomer(@PathVariable("customer_name") String customer_name);
}
