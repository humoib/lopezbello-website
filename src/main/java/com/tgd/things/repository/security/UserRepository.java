package com.tgd.things.repository.security;

import org.springframework.data.repository.CrudRepository;

import com.tgd.things.beans.db.security.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
