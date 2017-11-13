package com.greenfox.salankiv.p2pchat.model;

import com.greenfox.salankiv.p2pchat.service.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Entity
@Table(name = "messages")
public class Message {

	@Id
	private int id;

	private String text;
	private String timestamp;
	private String username;

	public Message(String text) {
		this.text = text;
		this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
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

	public String getUsername() {
		return user.getUsername();
	}

	public Long getUserId() {
		return user.getId();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
