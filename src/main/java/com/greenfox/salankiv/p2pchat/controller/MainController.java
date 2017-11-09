package com.greenfox.salankiv.p2pchat.controller;

import com.greenfox.salankiv.p2pchat.model.Log;
import com.greenfox.salankiv.p2pchat.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MainController {

	@Autowired
	LogRepository logRepository;

	@GetMapping(value = "/")
	public void loadMain(HttpServletRequest request) {
		logRepository.save(new Log(request));
		System.out.println(new Log(request).getLog());
	}
}
