package com.comakeit.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.comakeit.wms.constants.Constants;



@SpringBootApplication
public class WarehouseManagementApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(WarehouseManagementApplication.class, args);
		String serverPort = context.getEnvironment().getProperty("server.port");
		 Constants.url = "http://localhost:" + serverPort + "/";
	}

}
