package com.greenfox.salankiv.p2pchat.model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	User findUserByUserName(String userName);

	User findUserById(Long id);
}
