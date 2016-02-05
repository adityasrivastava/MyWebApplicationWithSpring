package com.webpage.persistence.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
		
		try{
			return new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Hibarnate connection initialization failed: "+ex);
			throw new ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void shutdown(){
		sessionFactory.close();
	}

}
