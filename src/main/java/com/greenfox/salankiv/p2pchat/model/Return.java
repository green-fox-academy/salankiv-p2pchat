package com.greenfox.salankiv.p2pchat.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Return {
	String status;
	@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
	String message;

	public Return() {
	}
	public Return(String status) {
		this.status = status;
	}

	public Return(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
