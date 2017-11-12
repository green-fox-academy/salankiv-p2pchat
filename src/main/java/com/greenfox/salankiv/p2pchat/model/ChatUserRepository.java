package com.greenfox.salankiv.p2pchat.model;

import org.springframework.data.repository.CrudRepository;

public interface ChatUserRepository extends CrudRepository<ChatUser, Long> {

	ChatUser findChatUserByUserName(String userName);

	ChatUser findChatUserById(Long id);
}
