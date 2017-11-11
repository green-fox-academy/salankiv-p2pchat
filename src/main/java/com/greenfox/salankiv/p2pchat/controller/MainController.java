package com.greenfox.salankiv.p2pchat.controller;

import com.greenfox.salankiv.p2pchat.service.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MainController {

	@Autowired
	RequestHandler requestHandler;

	@GetMapping(value = {"/", ""})
	public String loadMain(HttpServletRequest request) {
		return requestHandler.checkEnv(request);
	}
}
