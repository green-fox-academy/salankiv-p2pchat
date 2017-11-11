package com.greenfox.salankiv.p2pchat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {

	@Autowired
	RequestHandler requestHandler;

	@org.springframework.web.bind.annotation.ExceptionHandler(Throwable.class)
	public String handleException(HttpServletRequest request, Throwable exception) {
		return requestHandler.printNewError(request);
	}
}
