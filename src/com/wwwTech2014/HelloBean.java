package com.wwwTech2014;


import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;

import model.User;

import com.sun.jersey.api.view.Viewable;
import com.wwwTech2014.ejb.UserService;
import com.wwwTech2014.utils.JPAUtil;


@Path("/")
public class HelloBean{
	
	@EJB
	private UserService userService;
	
	@GET
	public Response get(){
		return Response.ok(new Viewable("/index", null)).build();
	}
	
	/**
	 * 
	 * @param request
	 * @param userName
	 * @param password
	 * @return
	 */
	@Path("login")
	@POST
	public Response login(){
		return Response.ok(new Viewable("/welcome", null)).build();
	}

	@Path("register")
	@GET
	public Response getRegisterPage(){
		return Response.ok(new Viewable("/register", null)).build();
	}
	
	@POST
	@Path("register")
	public Response register(@FormParam("email") String userName, @FormParam("password") String password,
			@FormParam("first_name") String firstName, @FormParam("last_name") String lastName,
			@FormParam("display_name") String displayName){
		
		if(!userService.checkUserInDB(userName, password)){
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setDisplayName(displayName);
			userService.createUser(user);
			return Response.ok(new Viewable("/welcome", null)).build();
		} else {
			Map<String, String> errorResult = new HashMap<String, String>();
			errorResult.put("error", "Username " + userName + " exists in the DB !");
			return Response.ok(new Viewable("/welcome", errorResult)).build();
		}
	}
	
	@Path("logout")
	@GET
	public Response logout(@Context HttpServletRequest request){
		request.getSession().invalidate();
		return Response.ok(new Viewable("/index", null)).build();
	}
	
}

