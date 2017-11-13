package com.greenfox.salankiv.p2pchat.model;

import org.springframework.data.repository.CrudRepository;

public interface ChatUserRepository extends CrudRepository<User, Long> {

	User findChatUserByUserName(String userName);

	User findChatUserById(Long id);
}
