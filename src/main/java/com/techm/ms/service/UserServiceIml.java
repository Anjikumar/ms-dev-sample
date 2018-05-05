package com.techm.ms.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.techm.ms.model.Account;
import com.techm.ms.model.User;

@Service("userService")
public class UserServiceIml  implements UserService{

		List<User> userList = new ArrayList();
	
	UserServiceIml(){
		User user1 = new User();
		user1.setId(1);
		user1.setName("Anji");
		userList.add(user1);
		user1.setId(2);
		user1.setName("Bhavani");
		userList.add(user1);
		
	}
	
	@Override
	public User findById(long id) {

		User  currentUser= null;
		for(User user : userList){
			if(user.getId() == id){
				currentUser = user;
			}
		}
		return currentUser;
	
	}

	@Override
	public User findByName(String name) {
		User  currentUser= null;
		for(User user : userList){
			if(user.getName().equalsIgnoreCase(name)){
				currentUser = user;
			}
		}
		return currentUser;
	}

	@Override
	public void saveAccount(User account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAllUsers() {
		return userList;
	}

	@Override
	public boolean isUserExist(User account) {
		// TODO Auto-generated method stub
		return false;
	}

}
