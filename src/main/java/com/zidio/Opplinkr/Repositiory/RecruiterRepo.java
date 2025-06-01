package com.zidio.Opplinkr.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.Opplinkr.Entity.RecruiterProfile;

@Repository
public interface RecruiterRepo extends JpaRepository<RecruiterProfile, Long> {

}
