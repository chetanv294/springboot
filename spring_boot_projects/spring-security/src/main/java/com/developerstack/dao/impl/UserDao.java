package com.developerstack.dao.impl;

import java.util.List;

import com.chetan.users.model.User;
import com.developerstack.model.UserDetails;

public interface UserDao {
	
	List<UserDetails> getUserDetails();
	UserDetails findUserByEmail(String email);

	public User findByUserName(String username);
}
