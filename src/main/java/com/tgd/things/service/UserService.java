package com.tgd.things.service;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tgd.things.beans.db.security.User;

@Service
@Transactional
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	public User getFooUser(){
		User u = new User();
		u.setId((long)1);
		u.setUsername("foo");
		return u;
	}

}
