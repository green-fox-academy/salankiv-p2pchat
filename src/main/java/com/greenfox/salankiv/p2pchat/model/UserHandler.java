package com.greenfox.salankiv.p2pchat.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHandler {

	private ChatUser activeUser;

	public ChatUser getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(ChatUser activeUser) {
		this.activeUser = activeUser;
	}

	@Autowired
	ChatUserRepository chatUserRepository;

	public void addChatUser(String userName) {
		ChatUser chatUser = new ChatUser(userName);
		chatUserRepository.save(chatUser);
	}

	public boolean checkIfUserExists(String userName) {
		boolean exists = false;
		for (ChatUser user : chatUserRepository.findAll()) {
			if (user.getUserName().equals(userName)) {
				exists = true;
			}
		}
		return exists;
	}

	public ChatUser getUserFromDatabaseByName(String userName) {
		return chatUserRepository.findChatUserByUserName(userName);
	}

	public ChatUser getUserFromDatabaseById(Long id) {
		return chatUserRepository.findChatUserById(id);
	}

	public void saveUser(ChatUser user) {
		chatUserRepository.save(user);
	}
}
