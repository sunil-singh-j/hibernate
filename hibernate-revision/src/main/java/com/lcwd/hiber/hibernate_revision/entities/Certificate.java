package com.lcwd.hiber.hibernate_revision.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

}
