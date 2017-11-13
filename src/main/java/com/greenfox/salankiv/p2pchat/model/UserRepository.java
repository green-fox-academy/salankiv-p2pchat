package com.greenfox.salankiv.p2pchat.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	User findUserByUsername(String userName);

	User findUserById(Long id);

//	@Modifying
//	@Query("UPDATE chat_user SET username = ?1 WHERE id =?2")
//	void saveUser(String newUserName, Long id);

}
