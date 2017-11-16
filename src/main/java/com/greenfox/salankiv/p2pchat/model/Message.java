package com.greenfox.salankiv.p2pchat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

@Entity
@Table(name = "messages")
public class Message {

	@Id
	private int id;

	private String text;
	private Timestamp timestamp;
	private String username;

	public Message(String text) {
		this.text = text;
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.id = new Random().nextInt(9999999) + 1000000;
	}

	public Message() {
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@OneToOne
	public User user;

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
