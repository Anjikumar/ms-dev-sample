package com.techm.ms.resource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;

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
	
/*	@Override
	public Response findById() {
		
		boolean isPresent = userService.findById();	
		if (users == null) {
			return Response.noContent().build();
		}		
		Link link = Link.fromUri(baseUrl).rel("self").build();		
		ResourceCollection<User> resource = new ResourceCollection<>(users);
		return Response.ok(resource).links(link).build();
		
	}*/
	

	
}
