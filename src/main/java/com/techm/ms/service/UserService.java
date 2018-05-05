package com.techm.ms.service;

import java.util.List;

import com.techm.ms.model.User;



public interface UserService {

	User findById(long id);
	
	User findByName(String name);
	
	void saveAccount(User account);
	
	List<User> findAllUsers();
	
	boolean isUserExist(User account);
}
