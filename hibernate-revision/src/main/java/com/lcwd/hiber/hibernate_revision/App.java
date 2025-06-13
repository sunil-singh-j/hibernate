package com.lcwd.hiber.hibernate_revision;

import com.lcwd.hiber.hibernate_revision.entities.Student;
import com.lcwd.hiber.hibernate_revision.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! ready to learn hibernate" );
        
        Student student= new Student();
        
        student.setName("sunil");
        student.setAbout("good student");
        student.setAge(43);
        student.setCollage("kmc college");
        student.setGender("male");
        student.setPhone(98765444);
        
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        
       // System.out.println(sessionFactory);
        
        Session sesssion= sessionFactory.openSession();
        
        Transaction transaction=null;
        
        try {
        	transaction=sesssion.beginTransaction();
        	
//        	sesssion.persist(student);
        	
        	transaction.commit();
        	
        	System.out.println("student saved successfully");
        	
        	
        	sesssion.close();
        	sessionFactory.close();
        	
        	
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        
        
        
        
        
    }
}
