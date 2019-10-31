package com.comakeit.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comakeit.wms.bean.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	@Query("select l from Login l JOIN FETCH l.role where l.username= :username and l.password= :password")
	public Login validate(@Param(value = "username") String username, @Param(value = "password") String password);

}