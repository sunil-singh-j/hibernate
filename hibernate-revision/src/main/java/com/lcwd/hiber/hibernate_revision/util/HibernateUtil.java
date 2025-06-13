package com.lcwd.hiber.hibernate_revision.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lcwd.hiber.hibernate_revision.entities.Certificate;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		try {
			if(sessionFactory==null) {
			sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Certificate.class).buildSessionFactory();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory () {
		return sessionFactory;
	}

}
