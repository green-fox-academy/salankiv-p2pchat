package com.greenfox.salankiv.p2pchat.service;

import com.greenfox.salankiv.p2pchat.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MessageHandler {

	@Autowired
	MessageRepository messageRepository;

	public void saveNewMessage(Message message) {
		messageRepository.save(message);
	}

	public List<Message> getUserMessages(User user) {
		return messageRepository.findAllByUser(user);
	}

	public Iterable<Message> getAllMessages() {
		return messageRepository.findAll();
	}

	public void postMessage(Message message) {
		Request requestToSend = new Request(message, new Client());
		RestTemplate template = new RestTemplate();
//		String url = System.getenv("CHAT_APP_PEER_ADDRESSS");
		String url = "https://salankiv-p2pchat.herokuapp.com/api/message/receive";
		Return response = template.postForObject(url, requestToSend, Return.class);
		System.out.println(response.getStatus());
		System.out.println(response.getMessage());
	}
}
