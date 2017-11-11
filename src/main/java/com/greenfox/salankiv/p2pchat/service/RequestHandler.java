package com.greenfox.salankiv.p2pchat.service;

import com.greenfox.salankiv.p2pchat.model.Log;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class RequestHandler {

	public String checkEnv(HttpServletRequest request) {
		return System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")? printNewLog(request) : null;
	}

	public String printNewError(HttpServletRequest request) {
		Log log = new Log(request);
		log.setLogLevel("ERROR");
		String print = log.getLog().toString();
		System.err.println(print);
		return print;
	}

	private String printNewLog(HttpServletRequest request) {
		String print = new Log(request).getLog().toString();
		System.out.println(print);
		return print;
	}


}
