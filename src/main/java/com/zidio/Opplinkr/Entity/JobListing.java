package com.zidio.Opplinkr.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_listing")
public class JobListing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobId;
	private Long recruiterId;
	private String title;
	private String description;
	private String location;
	private String type;
	
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Long getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
