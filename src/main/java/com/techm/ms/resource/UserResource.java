package com.techm.ms.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.spi.http.HttpContext;

import com.techm.ms.model.swagger.AccountResponse;
import com.techm.ms.model.swagger.UserResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the Interface definition for User Resource
 * 
 */

@Api("users")
@Path("/users")
@Produces({MediaType.APPLICATION_JSON})
public interface UserResource {
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/All")
	@ApiOperation(
			value = "Get Userr Resource",
			notes = "Returns all the Users in ResourceCollection representation format",
			response = UserResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "OK"),
					@ApiResponse(code = 204, message = "No Content")					
					})
	public Response findAllUsers();

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/newUser")
	@ApiOperation(
			value = "Get Userr Resource",
			notes = "Returns all the Users in ResourceCollection representation format",
			response = UserResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "OK"),
					@ApiResponse(code = 409, message = "CONFLICTED")
			})
	public Response createUser(@QueryParam("userName") String userName, @QueryParam("userAge") int userAge);


	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/findUser")
	@ApiOperation(
			value = "Get Userr Resource",
			notes = "Returns all the Users in ResourceCollection representation format",
			response = UserResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "OK"),
					@ApiResponse(code = 409, message = "CONFLICTED")
			})
	public Response findUserById( @QueryParam("userId") long userId);
}