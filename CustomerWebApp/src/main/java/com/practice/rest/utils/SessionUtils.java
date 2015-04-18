package com.practice.rest.utils;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class SessionUtils {

	private final static SessionUtils instance = new SessionUtils();
	private final SessionFactory factory;
	
	private SessionUtils(){
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		factory = configuration.configure().buildSessionFactory();
	}
	
	public static Session getSession(){
		Session session = getInstance().factory.openSession();
		return session;
	}
	
	public static SessionUtils getInstance(){
		return instance;
	}
}
