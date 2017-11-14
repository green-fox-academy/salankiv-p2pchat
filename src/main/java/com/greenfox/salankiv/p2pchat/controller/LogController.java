package com.greenfox.salankiv.p2pchat.controller;

import com.greenfox.salankiv.p2pchat.P2pchatApplication;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class LogController {
	public static Logger logr = Logger.getLogger(P2pchatApplication.class.getName());

	public LogController() {
		if (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")) {
			logr.setLevel(Level.INFO);
		} else logr.setLevel(Level.SEVERE);
	}
}
