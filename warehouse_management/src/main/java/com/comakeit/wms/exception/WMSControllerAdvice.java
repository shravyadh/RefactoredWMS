package com.comakeit.wms.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class WMSControllerAdvice {
	
	HttpServletRequest request;
	
	@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(value = {WMSUnauthorisedException.class})
	public ModelAndView UnauthorisedException(WMSUnauthorisedException e) throws IOException {
		  ModelAndView modelView = new ModelAndView();
		  modelView.addObject("error", HttpStatus.UNAUTHORIZED);
		  modelView.setViewName("error");
		  return modelView;
	}
}
