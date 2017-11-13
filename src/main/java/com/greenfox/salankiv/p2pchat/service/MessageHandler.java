package com.greenfox.salankiv.p2pchat.service;

import com.greenfox.salankiv.p2pchat.model.Message;
import com.greenfox.salankiv.p2pchat.model.MessageRepository;
import com.greenfox.salankiv.p2pchat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
