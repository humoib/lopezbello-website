package com.tgd.things.service.security;

import com.tgd.things.beans.db.security.User;

public interface UserService {
	
	void save(User user);

	Iterable<User> getAllUsers();

	User findById(Long id);

	User findByUsername(String username);

	User addUser(String username, String fullname, String email, String password);

}
