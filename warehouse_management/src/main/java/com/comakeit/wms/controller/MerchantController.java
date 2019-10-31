package com.comakeit.wms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.comakeit.wms.bean.ItemOrder;
import com.comakeit.wms.constants.Constants;

@Controller
public class MerchantController {

	RestTemplate restTemplate = new RestTemplate();

	/// MerchantOperation/list
	@RequestMapping("/MerchantOperation")
	public ModelAndView doOperation(HttpServletRequest request) {

		ModelAndView modelView = new ModelAndView();

		HttpSession session = request.getSession();

		String operation = request.getParameter("operation");

		if (operation.equals("list")) {
			ResponseEntity<List<ItemOrder>> itemorders = restTemplate.exchange(Constants.url + "viewO", HttpMethod.GET,
					null, new ParameterizedTypeReference<List<ItemOrder>>() {
					});

			if (itemorders != null) {

				session.setAttribute("itemorders", itemorders.getBody());

				modelView.setViewName("merchantoperations.jsp");
				return modelView;
			}
		}

		if (operation.equals("accept")) {

			int id = Integer.parseInt(request.getParameter("id"));
			int stock = Integer.parseInt(request.getParameter("quantity"));
			int item_code = Integer.parseInt(request.getParameter("item"));
			ItemOrder itemOrder = restTemplate.postForObject(
					Constants.url + "accept/" + id + "/" + stock + "/" + item_code, null, ItemOrder.class);
			if (itemOrder != null) {
				modelView.setViewName("success.jsp");
			}
		}
		if (operation.equals("cancel")) {

			int id = Integer.parseInt(request.getParameter("id"));
			restTemplate.postForObject(Constants.url + "cancel/" + id, null, ItemOrder.class);
			modelView.setViewName("MerchantOperation?operation=list");

		}
	
		return modelView;
	}
}
