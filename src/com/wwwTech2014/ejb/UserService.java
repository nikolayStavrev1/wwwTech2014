package com.wwwTech2014.ejb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.transaction.Transaction;

import model.User;

import com.wwwTech2014.utils.JPAUtil;


@Stateless
public class UserService {

	private EntityManager em = JPAUtil.getEntityManager();
	
	public User checkUserInDB(String userName, String password){
    	try{
    	return em.createQuery("SELECT u from User u where u.userName = :username and u.password = :password", User.class)
				.setParameter("username", userName).setParameter("password", password).getSingleResult();
    	}catch(NoResultException e){
    		return null;
    	}
	}
	
	public void createUser(User user) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(user);
		tx.commit();
	}
}
