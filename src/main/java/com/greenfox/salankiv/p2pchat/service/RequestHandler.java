package com.greenfox.salankiv.p2pchat.service;

import com.greenfox.salankiv.p2pchat.model.Log;
import com.greenfox.salankiv.p2pchat.model.LogRepository;
import com.greenfox.salankiv.p2pchat.model.ChatUser;
import com.greenfox.salankiv.p2pchat.model.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class RequestHandler {

	@Autowired
	ChatUserRepository chatUserRepository;

	@Autowired
	LogRepository logRepository;

	public void checkEnv(HttpServletRequest request) {
		if (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")) {
			printNewLog(request);
		}
	}

	public void printNewError(HttpServletRequest request) {
		Log log = new Log(request);
		log.setLogLevel("ERROR");
		String print = log.getLog().toString();
		System.err.println(print);
		logRepository.save(log);
	}

	public void printNewLog(HttpServletRequest request) {
		Log log = new Log(request);
		String print = log.getLog().toString();
		System.out.println(print);
		logRepository.save(log);
	}

	public void addChatUser(String userName) {
		ChatUser chatUser = new ChatUser(userName);
		chatUserRepository.save(chatUser);
	}
}
