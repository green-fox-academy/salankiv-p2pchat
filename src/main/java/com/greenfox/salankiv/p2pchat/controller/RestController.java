package com.greenfox.salankiv.p2pchat.controller;

import com.greenfox.salankiv.p2pchat.service.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RestController {

	@Autowired
	RequestHandler requestHandler;

	@GetMapping(value = "/")
	@ResponseBody
	public void loadMain(HttpServletRequest request) {
		requestHandler.checkEnv(request);
	}

	@GetMapping(value = "/enter")
	public String loadEnter() {
		return "user";
	}

	@GetMapping(value = "/enter/add")
	public String addUser(@RequestParam(value = "userName", required = true) String userName,
						  HttpServletRequest request, Model model) {
		if (userName.equals("")) {
			model.addAttribute("noUserName", userName);
			requestHandler.printNewError(request);
			return "user";
		} else requestHandler.addChatUser(userName);
		requestHandler.printNewLog(request);
		return "redirect:/";
	}
}