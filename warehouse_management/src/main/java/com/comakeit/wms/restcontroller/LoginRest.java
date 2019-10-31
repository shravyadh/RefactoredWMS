package com.comakeit.wms.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.wms.bean.Login;
import com.comakeit.wms.exception.WMSUnauthorisedException;
import com.comakeit.wms.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginRest {

	@Autowired
	LoginService loginService;

	Logger logger = Logger.getLogger(LoginRest.class);

	@PostMapping("/loginValidate")
	public Login validate(@RequestBody Login login) {
		logger.info("Validating the user. User will hold the type of user, that is, whether he is admin or merchant");
		Login user = loginService.validate(login);
		
		if (user == null) {
			logger.error("this is an error message");
			throw new WMSUnauthorisedException();
		}
		return user;
	}

}
