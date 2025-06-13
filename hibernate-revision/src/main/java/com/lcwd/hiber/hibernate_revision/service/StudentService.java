package com.lcwd.hiber.hibernate_revision.service;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

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
	
	//HQL  [JPA] --native query
	
	//database independent
	
	//get all students using hql
	
	public List< Student> getAllStudnetsHql(){
		try(Session session =sessionFactory.openSession()){
			String getHQL="From Student";
			org.hibernate.Query<Student> query=session.createQuery(getHQL,Student.class);
			
			return query.list();
			
		}
	}
	
	public Student getStudentByName(String name) {
		try(Session session=sessionFactory.openSession()){
			String getByNameHql="From Student Where name=:StudnetName";
			
			org.hibernate.Query<Student> query=session.createQuery(getByNameHql,Student.class);
			
			query.setParameter("StudentName", name);
			return query.uniqueResult();
		}
	}
	
	public List<Student> getStuntsWithPagination (int pageNO,int pageSize){
		try(Session session=sessionFactory.openSession()){
			String pgiQuery="From Studnet";
			
			org.hibernate.Query<Student> query=session.createQuery(pgiQuery,Student.class);
			query.setFirstResult((pageNO-1)*pageSize);
			query.setMaxResults(pageSize);
			return query.list();
			
			
		}
	}
	
	
	
}
