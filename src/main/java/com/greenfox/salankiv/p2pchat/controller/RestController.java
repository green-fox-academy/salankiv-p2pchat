package com.greenfox.salankiv.p2pchat.controller;

import com.greenfox.salankiv.p2pchat.model.Request;
import com.greenfox.salankiv.p2pchat.model.Return;
import com.greenfox.salankiv.p2pchat.service.MessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	MessageHandler messageHandler;

	@CrossOrigin("*")
	@PostMapping(value = "/api/message/receive")
	public Return receiveMessage(@RequestBody Request clientMessage) {
		Return sendReturn = new Return();
		String errorMessage = "Missing field(s): ";
		boolean badMessage = false;
		if (clientMessage.getMessage().getId() == 0) {
			errorMessage += "message.id ";
			badMessage = true;
		}
		if (clientMessage.getMessage().getUsername() == null) {
			errorMessage += "message.username ";
			badMessage = true;
		}
		if (clientMessage.getMessage().getText() == null) {
			errorMessage += "message.text ";
			badMessage = true;
		}
		if (clientMessage.getMessage().getTimestamp() == null) {
			errorMessage += "message.timestamp";
			badMessage = true;
		}
		if (clientMessage.getClient().getId() == null) {
			errorMessage += "client.id";
			badMessage = true;
		}
		if (badMessage) {
			sendReturn.setStatus("error");
			sendReturn.setMessage(errorMessage);
			return sendReturn;
		} else {
			messageHandler.saveNewMessage(clientMessage.getMessage());
			return new Return("ok");
		}
	}
}
