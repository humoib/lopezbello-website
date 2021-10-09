package com.tgd.things.service.security;

import com.tgd.things.beans.db.security.User;

public interface UserService {
	void save(User user);

	Iterable<User> getAllUsers();

	User findByUsername(String username);

}
