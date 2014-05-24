package com.wwwTech2014.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("wwwTech2014");
	}
	
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
}
