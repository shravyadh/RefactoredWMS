package com.comakeit.wms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comakeit.wms.bean.Login;
import com.comakeit.wms.repository.LoginRepository;

@Service
public class LoginService implements ILogin{
	@Autowired
	LoginRepository loginRepository;

	@Override
	public Login validate(Login login) {
		// Validation 
		Login loginRes = loginRepository.validate(login.getUsername(), login.getPassword());
		return loginRes;
	}
}
