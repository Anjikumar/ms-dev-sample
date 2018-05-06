package com.techm.ms.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.techm.ms.model.Account;
import com.techm.ms.model.User;

@Service("userService")
public class UserServiceIml  implements UserService{
	private static final AtomicLong counter = new AtomicLong();
	private static List<User> users;
	

	static {
		users= populateDummyUsers();
	}
	
	@Override
	public User findById(long id) {

		User  currentUser= null;
		for(User user : users){
			if(user.getId() == id){
				currentUser = user;
			}
		}
		return currentUser;
	
	}

	@Override
	public User findByName(String name) {
		User  currentUser= null;
		for(User user : users){
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
		return users;
	}

	@Override
	public boolean isUserExist(User account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addUser(String name, int age) {
		User user = new User(counter.incrementAndGet(), name, age, 4);
		users.add(user);

	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"Anji", 22, 1));
		users.add(new User(counter.incrementAndGet(),"Anji2", 33, 2));
		users.add(new User(counter.incrementAndGet(),"Anji3",44,3));
		return users;
	}

}
