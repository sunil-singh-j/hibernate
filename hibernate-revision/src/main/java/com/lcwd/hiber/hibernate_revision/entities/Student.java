package com.lcwd.hiber.hibernate_revision.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@OneToMany(mappedBy = "student",fetch=FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Certificate> certificates=new ArrayList<Certificate>();
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getCollage() {
		return collage;
	}
	public void setCollage(String collage) {
		this.collage = collage;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Number getPhone() {
		return phone;
	}
	public void setPhone(Number phone) {
		this.phone = phone;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getAbout() {
		return about;
	}
	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", collage=" + collage + ", age=" + age
				+ ", gender=" + gender + ", phone=" + phone + ", active=" + active + ", about=" + about
				+ ", certificates=" + certificates + "]";
	}
	
	
	
}
