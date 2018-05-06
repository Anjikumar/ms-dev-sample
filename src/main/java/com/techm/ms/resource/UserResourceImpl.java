package com.techm.ms.resource;

import java.util.*;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.xml.ws.spi.http.HttpContext;

import com.techm.ms.exception.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.techm.ms.model.Account;
import com.techm.ms.model.User;
import com.techm.ms.model.representation.ResourceCollection;
import com.techm.ms.service.AccountService;
import com.techm.ms.service.UserService;

@Controller
public class UserResourceImpl implements UserResource {
	
	@Autowired
	UserService userService; //Service which will do all data retrieval/manipulation work
	
	private static String baseUrl = "/users";
	
	@Override
	public Response findAllUsers() {
		
		List<User> users = userService.findAllUsers();	
		if (users == null) {
			return Response.noContent().build();
		}		
		Link link = Link.fromUri(baseUrl).rel("self").build();
		ResourceCollection<User> resource = new ResourceCollection<>(users);
		return Response.ok(resource).links(link).build();
		
	}

	@Override
	public Response createUser(String userName, int userAge) {

		Link link = Link.fromUri(baseUrl).rel("self").build();

		User user = userService.findByName(userName);
		if(user == null && userName != null){
			userService.addUser(userName, userAge);
			return Response.status(Response.Status.CREATED).build();
		}
		else{
			return Response.status(Response.Status.CONFLICT).build();
		}
	}

	@Override
	public Response findUserById(long userId) {
		User user = userService.findById(userId);
		if(user != null){
			return  Response.status(Response.Status.FOUND).entity(user).build();
		}
		else{
			CustomError error = new CustomError("Account with id "+ userId +" not found", "NOT_FOUND");
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}

	}


}
