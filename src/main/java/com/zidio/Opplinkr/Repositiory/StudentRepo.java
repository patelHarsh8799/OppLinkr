package com.zidio.Opplinkr.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.Opplinkr.Entity.StudentProfile;

@Repository
public interface StudentRepo extends JpaRepository<StudentProfile, Long>{

	
}
