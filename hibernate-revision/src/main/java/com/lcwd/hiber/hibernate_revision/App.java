package com.lcwd.hiber.hibernate_revision;

import com.lcwd.hiber.hibernate_revision.entities.Certificate;
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
        
        student.setName("ram singh");
        student.setAbout("good student");
        student.setAge(43);
        student.setCollage("kc college");
        student.setGender("male");
        student.setPhone(98765444);
        
        
        Certificate certificate= new Certificate();
        certificate.setTitle("java programing ");
        certificate.setAbout("well done");
        certificate.setLink("/fjjgg/dgfg/html");
        certificate.setStudent(student);
        
        
        Certificate certificate1= new Certificate();
        certificate1.setTitle("python programing ");
        certificate1.setAbout("well done py");
        certificate1.setLink("/fjjgg/dgfg/html.py");
        certificate1.setStudent(student);
        

//        Certificate certificate2= new Certificate();
//        certificate2.setTitle("js programing ");
//        certificate2.setAbout("well done js");
//        certificate2.setLink("/fjjgg/dgfg/js");
//        certificate2.setStudent(student);
        
        student.getCertificates().add(certificate);
        student.getCertificates().add(certificate1);
//        student.getCertificates().add(certificate2);
        
        
        
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        
       // System.out.println(sessionFactory);
        
        Session sesssion= sessionFactory.openSession();
        
        Transaction transaction=null;
        
        try {
        	transaction=sesssion.beginTransaction();
        	
       	sesssion.persist(student);
        	
        	transaction.commit();
        	
        	System.out.println("student saved successfully");
        	
        	
        	sesssion.close();
        	sessionFactory.close();
        	
        	
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        
        
        
        
        
    }
}
