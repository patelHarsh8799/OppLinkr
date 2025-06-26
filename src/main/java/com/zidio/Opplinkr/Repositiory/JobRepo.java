package com.zidio.Opplinkr.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.Opplinkr.Entity.Job;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job, Long>{

    List<Job> findByTitleContainingIgnoreCase(String title);
    List<Job> findByCompanyNameContainingIgnoreCase(String companyName);
    List<Job> findByPostedBy_UserId(Long userId);
	
}
