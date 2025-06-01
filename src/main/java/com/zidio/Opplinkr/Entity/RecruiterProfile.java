package com.zidio.Opplinkr.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recruiter_profile")
public class RecruiterProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recruiterId;
	private Long userId;
	private String company_name;
	private String designation;
	public Long getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
