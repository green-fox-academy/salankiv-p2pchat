package com.greenfox.salankiv.p2pchat.controller;

import com.greenfox.salankiv.p2pchat.model.ClientMessage;
import com.greenfox.salankiv.p2pchat.model.Return;
import com.greenfox.salankiv.p2pchat.service.MessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	MessageHandler messageHandler;

	@PostMapping(value = "/api/message/receive")
	public Return receiveMessage(@RequestBody ClientMessage clientMessage) {
		messageHandler.saveNewMessage(clientMessage.getMessage());
		return new Return("ok");
	}
}
