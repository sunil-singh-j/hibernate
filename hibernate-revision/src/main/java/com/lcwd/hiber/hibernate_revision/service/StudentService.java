package com.lcwd.hiber.hibernate_revision.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lcwd.hiber.hibernate_revision.entities.Student;
import com.lcwd.hiber.hibernate_revision.util.HibernateUtil;

public class StudentService {
	
	private org.hibernate.SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
	//save
	
	public void saveStudent(Student student) {
		try(Session session=sessionFactory.openSession()){
			Transaction beginTransaction=session.beginTransaction();
			session.save(student);
			beginTransaction.commit();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	//get by id
	
	public Student getById(Long StudentId) {
		try(Session session =sessionFactory.openSession()){
			Student student=session.get(Student.class, StudentId);
			
			return student;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//update 
	
	public Student updateStudent(long studentId,Student student) {
		try(Session session= sessionFactory.openSession()){
			Transaction transaction= session.beginTransaction();
			
			Student oldstudent= session.get(Student.class, studentId);
			
			if(oldstudent!=null) {
				oldstudent.setName(student.getName());
				oldstudent.setAge(student.getAge());
				oldstudent.setCollage(student.getCollage());
				oldstudent.setGender(student.getGender());
				oldstudent.setPhone(student.getPhone());
				
				
				session.merge(oldstudent);
				
				
			}
			transaction.commit();
			return oldstudent;
		}
	}
	
	//delete student
	
	public boolean deleteStudent(long studentId) {
		try(Session session=sessionFactory.openSession()){
			Transaction transaction=session.getTransaction();
			Student student= session.get(Student.class, studentId);
			if(student!=null) {
				session.delete(student);
			}
			
			transaction.commit();
			
			return true;
			
			
		}
	}
	
	//HQL
	
	
}
