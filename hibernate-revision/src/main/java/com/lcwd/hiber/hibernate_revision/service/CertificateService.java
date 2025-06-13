package com.lcwd.hiber.hibernate_revision.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lcwd.hiber.hibernate_revision.entities.Certificate;
import com.lcwd.hiber.hibernate_revision.entities.Student;
import com.lcwd.hiber.hibernate_revision.util.HibernateUtil;

public class CertificateService {
	
	private static SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
	public static void saveCertificate(Certificate certificate) {
		
		try(Session session= sessionFactory.openSession()){
			Transaction transaction=session.beginTransaction();
			session.persist(certificate);

			transaction.commit();
		}
		
		
		
	}
	
	public static List<Certificate>allCertificates(){
		try(Session session= sessionFactory.openSession()){
			String getHQL="From certificate";
			
org.hibernate.Query<Certificate> query=session.createQuery(getHQL,Certificate.class);
			
			return query.list();
		}
	}

}
