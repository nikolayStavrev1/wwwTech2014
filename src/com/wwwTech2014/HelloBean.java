package com.wwwTech2014;
	

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
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
	
	/**
	 * 
	 * @return welcome.jsp
	 */
	@GET
	public Response get(){
		return Response.ok(new Viewable("/welcome", null)).build();
	}
	
	/**
	 * 
	 * @param request
	 * @param userName
	 * @param password
	 * @return
	 */
	@Path("login")
	@GET
	public Response login(){
		return Response.ok(new Viewable("/login", null)).build();
	}

	@POST
	@Path("login")
	public Response doLogin(@Context HttpServletRequest request, @FormParam("email") String userName, @FormParam("password") String password){
		User user = userService.checkUserInDB(userName, password);
		System.out.println("USER: " + user);
		if(user != null){
			request.getSession().setAttribute("User",user);
			return Response.ok(new Viewable("/welcome", null)).build();
		} else {
			Map<String, String> badCredentialsResult = new HashMap<String, String>();
			badCredentialsResult.put("error","Bad Credentials");
			return Response.ok(new Viewable("/login", badCredentialsResult)).build();
		}
	}
	
	@Path("register")
	@GET
	public Response getRegisterPage(){
		return Response.ok(new Viewable("/register", null)).build();
	}
	
	@Path("register")
	@POST
	public Response register(@Context HttpServletRequest request, @FormParam("email") String userName, @FormParam("password") String password,
			@FormParam("first_name") String firstName, @FormParam("last_name") String lastName,
			@FormParam("display_name") String displayName){
		
		if(userService.checkUserInDB(userName, password) == null){
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setDisplayName(displayName);
			userService.createUser(user);
			request.getSession().setAttribute("User", user);
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
		return Response.ok(new Viewable("/login", null)).build();
	}
	
}

