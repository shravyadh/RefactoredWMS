package com.comakeit.wms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
public class WMSUnauthorisedException extends RuntimeException{
	/*
	 * 
	 */
	public static final long serialVersionUID=1L;
	
}
