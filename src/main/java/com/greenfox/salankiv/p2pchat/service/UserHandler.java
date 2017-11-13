package com.greenfox.salankiv.p2pchat.service;

import com.greenfox.salankiv.p2pchat.model.UserRepository;
import com.greenfox.salankiv.p2pchat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHandler {

	private User activeUser;

	public User getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
	}

	@Autowired
	UserRepository chatUserRepository;

	public void addChatUser(String userName) {
		User chatUser = new User(userName);
		chatUserRepository.save(chatUser);
	}

	public boolean checkIfUserExists(String userName) {
		boolean exists = false;
		for (User user : chatUserRepository.findAll()) {
			if (user.getUserName().equals(userName)) {
				exists = true;
			}
		}
		return exists;
	}

	public User getUserFromDatabaseByName(String userName) {
		return chatUserRepository.findUserByUserName(userName);
	}

	public User getUserFromDatabaseById(Long id) {
		return chatUserRepository.findUserById(id);
	}

	public void saveUser(User user) {
		chatUserRepository.save(user);
	}
}
