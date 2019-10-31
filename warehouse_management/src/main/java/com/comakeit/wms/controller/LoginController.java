package com.comakeit.wms.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.comakeit.wms.RestUrl;
import com.comakeit.wms.bean.Login;
import com.comakeit.wms.constants.Constants;


@Controller
public class LoginController {
	@Autowired
	RestUrl resturl;
	
	RestTemplate restTemplate = new RestTemplate();
    
    @RequestMapping(value = "/controller")
	public ModelAndView validate(HttpServletRequest request) {
		String operation = request.getParameter("operation");

		HttpSession session = request.getSession();
		ModelAndView modelView = new ModelAndView();
	
		if (operation.equals("validate")) 
		{
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			Login user = new Login();
			user.setUsername(username);
			user.setPassword(password);
			
			user = restTemplate.postForObject(Constants.url + "loginValidate", user, Login.class);

			
			session.setAttribute("login", user);
				if (user.getRole().getRole_name().equals("Admin")) {
					modelView.setViewName("adminoperations.jsp");
					
				} else {
					modelView.setViewName("MerchantOperation?operation=list");
				
				}
		}
		return modelView;
	}
}
