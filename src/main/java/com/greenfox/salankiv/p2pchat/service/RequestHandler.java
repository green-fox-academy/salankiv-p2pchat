package com.greenfox.salankiv.p2pchat.service;

import com.greenfox.salankiv.p2pchat.model.Log;
import com.greenfox.salankiv.p2pchat.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class RequestHandler {

	@Autowired
	UserRepository chatUserRepository;

	public boolean checkEnvIfInfo() {
		return  (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO"));
	}

	public void printNewError(HttpServletRequest request) {
		Log log = new Log(request);
		log.setLogLevel("ERROR");
		String print = log.getLog().toString();
		System.err.println(print);
	}

	public void printNewLog(HttpServletRequest request) {
		if (checkEnvIfInfo()) {
			Log log = new Log(request);
			String print = log.getLog().toString();
			System.out.println(print);
		}
	}
}
