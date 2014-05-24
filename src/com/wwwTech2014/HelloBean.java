package com.wwwTech2014;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("www");
		EntityManager entityManager = emf.createEntityManager();
		System.out.println(entityManager.createQuery("SELECT t FROM Testtable t").getResultList());
		
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

