package com.greenfox.salankiv.p2pchat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity(name = "log")
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String path;
	private String method;
	private String createdAt;
	private String logLevel;
	private String requestData;

	public Log() {
	}

	public Log(HttpServletRequest request) {
		this.path = request.getServletPath();
		this.method = request.getMethod();
		this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
		this.requestData = request.getQueryString();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}

	public String getLog() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.createdAt).append("  ")
				.append(this.logLevel).append(' ')
				.append(this.path).append(' ')
				.append(this.method).append(' ')
				.append(this.requestData);
		return sb.toString();
	}
}
