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
	UserRepository userRepository;

	public void addUser(String username) {
		User user = new User(username);
		userRepository.save(user);
	}

	public boolean checkIfUserExists(String username) {
		boolean exists = false;
		for (User user : userRepository.findAll()) {
			if (user.getUsername().equals(username)) {
				exists = true;
			}
		}
		return exists;
	}

	public User getUserFromDatabaseByName(String username) {
		return userRepository.findUserByUsername(username);
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}
}
