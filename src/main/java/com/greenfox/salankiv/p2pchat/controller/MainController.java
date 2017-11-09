package com.greenfox.salankiv.p2pchat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping(value = "/")
	public String loadMain() {
		return "Peer to Peer Chat Program";
	}
}
