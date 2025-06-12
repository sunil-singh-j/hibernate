package com.lcwd.hiber.hibernate_revision.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	@Column(name="student_name" ,length = 100,unique =true )
	private String name;
	
	@Column(name="student_collage" ,length = 200,nullable = true)
	private String collage;
	private int age;
	private String gender;
	private Number phone;
	private boolean active=true;
	@Lob
	private String about;
	
}
