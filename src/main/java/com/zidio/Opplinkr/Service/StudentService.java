package com.zidio.Opplinkr.Service;

import com.zidio.Opplinkr.Entity.StudentProfile;
import com.zidio.Opplinkr.Repositiory.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Optional<StudentProfile> getByUserId(Long userId) {
        return studentRepo.findByUserId(userId);
    }
    public StudentProfile saveStudents(StudentProfile studentProfile) {
        return studentRepo.save(studentProfile);
    }
}
