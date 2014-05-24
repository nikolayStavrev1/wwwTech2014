package com.wwwTech2014;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;


@Path("/")
public class HelloBean{
	
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

	@Path("logout")
	@GET
	public Response logout(@Context HttpServletRequest request){
		request.getSession().invalidate();
		return Response.ok(new Viewable("/index", null)).build();
	}
	
}

