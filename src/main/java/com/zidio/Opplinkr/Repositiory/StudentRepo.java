package com.zidio.Opplinkr.Repositiory;

import com.zidio.Opplinkr.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.Opplinkr.Entity.StudentProfile;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<StudentProfile, Long>{

    Optional<StudentProfile> findByUser_Email(String email);

}
