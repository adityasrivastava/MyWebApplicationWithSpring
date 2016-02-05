package com.webpage.persistence.impl;

import java.util.List;

import org.hibernate.Session;

import com.webpage.model.User;
import com.webpage.persistence.util.HibernateUtil;
import com.webpage.persistence.util.UserInterface;

public class UserImpl implements UserInterface{

	private static Session session;
	
	static{
		session = HibernateUtil.getSessionFactory().openSession();
	}
	

	@Override
	public void addUserDetails(User obj_UserParam) {
        session.beginTransaction();
        session.save(obj_UserParam);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
	}

	@Override
	public void removeUserDetails(User obj_UserParam) {
		User user;
        session.beginTransaction();
        user = (User) session.get(User.class, obj_UserParam.getId());
        session.delete(user);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
		
	}

	@Override
	public void updateUserDetails(User obj_UserParam) {
		User user;
        session.beginTransaction();
        user = (User) session.get(User.class, obj_UserParam.getId());
	    if(obj_UserParam.getName() != ""){
	    	user.setName(obj_UserParam.getName());
	    }
	    
	    if(obj_UserParam.getProfession() != ""){
	    	user.setProfession(obj_UserParam.getProfession());
	    }
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
		
	}

	@Override
	public List<User> getAllUsers() {
		return session.createQuery("FROM User").list();
	}

}
