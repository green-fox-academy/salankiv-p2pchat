package com.greenfox.salankiv.p2pchat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
	private Message message;
	private Client client;

	public Request(Message message, Client client) {
		this.message = message;
		this.client = client;
	}

	public Request() {
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "message: {" + "\n" +
				this.getMessage() + "\n" +
				this.getClient() +"\n" +
				"}";
	}
}
