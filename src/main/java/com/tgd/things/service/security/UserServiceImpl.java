package com.tgd.things.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tgd.things.beans.db.Box;
import com.tgd.things.beans.db.security.User;
import com.tgd.things.repository.security.RoleRepository;
import com.tgd.things.repository.security.UserRepository;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		//user.setId(user.);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
	}

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User addUser(String username, String fullname, String email, String password) {
		User user = new User();
		user.setUsername(username);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setPassword(bCryptPasswordEncoder.encode(password));

		user.setRoles(new HashSet<>(roleRepository.findAll()));

		return userRepository.save(user);
	}

}
