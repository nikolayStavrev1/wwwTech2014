package com.wwwTech2014;

import javax.servlet.http.HttpServletRequest;
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

	@POST
	@Path("welcome")
	public Response homePagePOST(){
		return Response.ok(new Viewable("/welcome", null)).build();
	}
	
	@GET
	@Path("welcome")
	public Response homePageGET(){
		return Response.ok(new Viewable("/welcome", null)).build();
	}
	
	@GET
	@Path("logout")
	public Response logout(@Context HttpServletRequest request){
		request.getSession().invalidate();
		return Response.ok(new Viewable("/index", null)).build();
	}
	
}

