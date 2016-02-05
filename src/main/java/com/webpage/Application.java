package com.webpage;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.webpage.model.User;
import com.webpage.persistence.util.HibernateUtil;

public class Application {
	
	private User user;
	private static Session session = HibernateUtil.getSessionFactory().openSession();

	public static void main(String[] args) {
	     System.out.println("Maven + Hibernate + MySQL");
	      User user = new User();
	      user.setId(3);
	      user.setName("Aditya1");
	      user.setProfession("Software1");
	      
	      Application app = new Application();
	      
	      //app.deleteTest(user);
//	      app.getAllUsers();
	      app.updateTest(user);
	}
	
	public void getAllUsers(){
		List<User> users = session.createQuery("FROM User").list();
		
		Iterator<User> it = users.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next().toString());;
		}
		
	}
	
	public void insertTest(User obj_UserParam){
        session.beginTransaction();
        session.save(obj_UserParam);
        session.getTransaction().commit();
	}
	
	
	public void deleteTest(User obj_UserParam){
        session.beginTransaction();
	    user = (User) session.get(User.class, obj_UserParam.getId());
        session.delete(user);
        session.getTransaction().commit();
	}
	
	public void updateTest(User obj_UserParam){
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
	}

}
