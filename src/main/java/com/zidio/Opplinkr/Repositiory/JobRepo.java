package com.zidio.Opplinkr.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.Opplinkr.Entity.JobListing;

@Repository
public interface JobRepo extends JpaRepository<JobListing, Long> {

}
