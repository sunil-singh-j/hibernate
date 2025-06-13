package com.lcwd.hiber.hibernate_revision.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="student_Certificate")
public class Certificate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long certificateId;
	
	private String title;
	private String about;
	private String link;
	@ManyToOne
	private Student student;
	
	
	
	public long getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(long certificateId) {
		this.certificateId = certificateId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "Certificate [certificateId=" + certificateId + ", title=" + title + ", about=" + about + ", link="
				+ link + "]\n";
	}

	
	
}
