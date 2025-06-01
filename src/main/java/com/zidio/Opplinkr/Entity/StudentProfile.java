package com.zidio.Opplinkr.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_profile")
public class StudentProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	private Long userId;
	private String resumeUrl;
	private String education;
	private String skill;
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getResumeUrl() {
		return resumeUrl;
	}
	public void setResumeUrl(String resumeUrl) {
		this.resumeUrl = resumeUrl;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}

}
