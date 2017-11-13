package com.greenfox.salankiv.p2pchat.controller;

import com.greenfox.salankiv.p2pchat.model.Message;
import com.greenfox.salankiv.p2pchat.service.MessageHandler;
import com.greenfox.salankiv.p2pchat.service.UserHandler;
import com.greenfox.salankiv.p2pchat.service.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@Autowired
	RequestHandler requestHandler;

	@Autowired
	UserHandler userHandler;

	@Autowired
	MessageHandler messageHandler;

	@GetMapping(value = "/")
	public String loadMain(HttpServletRequest request, Model model) {
		requestHandler.printNewLog(request);
		if (userHandler.getActiveUser() == null) {
			return "user";
		} else {
			model.addAttribute("activeUser", userHandler.getActiveUser());
			model.addAttribute("messages", messageHandler.getUserMessages(userHandler.getActiveUser()));
			return "main";
		}
	}

	@GetMapping(value = "/enter")
	public String loadEnter() {
		return "user";
	}

	@GetMapping(value = "/enter/add")
	public String addUser(@RequestParam(value = "username", required = true) String username,
						  HttpServletRequest request, Model model) {
		if (username.equals("")) {
			model.addAttribute("noUserName", username);
			requestHandler.printNewError(request);
			return "user";
		} else if (userHandler.checkIfUserExists(username)) {
			userHandler.setActiveUser(userHandler.getUserFromDatabaseByName(username));
			return "redirect:/";
		} else {
			userHandler.addUser(username);
			userHandler.setActiveUser(userHandler.getUserFromDatabaseByName(username));
			requestHandler.printNewLog(request);
			return "redirect:/";
		}
	}

	@GetMapping(value = "/update")
	public String updateUser(@RequestParam(value = "username", required = true) String userName,
							 HttpServletRequest request, Model model) {
		if (userName.equals("")) {
			model.addAttribute("noUserName", userName);
			model.addAttribute("activeUser", userHandler.getActiveUser());
			requestHandler.printNewError(request);
			return "main";
		} else if (userHandler.checkIfUserExists(userName)) {
			model.addAttribute("existingUserName", true);
			model.addAttribute("activeUser", userHandler.getActiveUser());
			return "main";
		} else {
			userHandler.getActiveUser().setUsername(userName);
			userHandler.saveUser(userHandler.getActiveUser());
		}
		return "redirect:/";
	}

	@GetMapping(value = "/logout")
	public String logoutUser() {
		userHandler.setActiveUser(null);
		return "redirect:/";
	}

	@GetMapping(value = "/newmessage")
	public String saveMessage(@RequestParam(value = "newMessage") String messageText) {
		Message message = new Message(messageText);
		message.setUser(userHandler.getActiveUser());
		messageHandler.saveNewMessage(message);
		return "redirect:/";
	}
}