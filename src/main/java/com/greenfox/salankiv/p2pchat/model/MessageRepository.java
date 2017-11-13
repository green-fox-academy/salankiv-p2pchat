package com.greenfox.salankiv.p2pchat.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer>{

	List<Message> findAllByUser(User user);
}
