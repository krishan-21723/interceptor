package com.interceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interceptor.handler.RequestInterceptor;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestInterceptor.class);
	
	@RequestMapping("/request")
	public String executeRequest(){
		LOGGER.info("Inside executeRequest method ");
		// api logic
		return "request interceptor called";
	}
	
	
	@RequestMapping("/modified/request")
	public String executeModifiedRequest(){
		LOGGER.info("Inside modified executeRequest method ");
		// api logic
		return "modified request interceptor called";
	}
}
