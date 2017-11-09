package com.greenfox.salankiv.p2pchat.service;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

@Service
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
	public void displayHttpError(HttpMessageNotReadableException exeption) {
		System.err.println(exeption.getMessage());
	}
}
