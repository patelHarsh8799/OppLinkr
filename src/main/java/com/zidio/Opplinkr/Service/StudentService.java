package com.zidio.Opplinkr.Service;

import com.zidio.Opplinkr.Entity.StudentProfile;
import com.zidio.Opplinkr.Entity.Users;
import com.zidio.Opplinkr.Repositiory.StudentRepo;
import com.zidio.Opplinkr.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public String createOrUpdate(StudentDto dto) {
        Optional<StudentProfile> optionalStudent = studentRepo.findByUser_Email(dto.email);

        StudentProfile student = optionalStudent.orElse(new StudentProfile());

        if (student.getUser() == null) {
            Users users = new Users();
            users.setEmail(dto.email);
            users.setName(dto.name);
            student.setUser(users);
        }
        student.setDegree(dto.course);
        student.setUniversity(dto.university);
        student.setResumeUrl(dto.resumeUrl);
        student.setSkill(dto.skill);

        studentRepo.save(student);

        return optionalStudent.isPresent() ? "Student profile updated." : "Student Profile created.";
    }
    public StudentDto getProfile(String email) {
        StudentProfile student = studentRepo.findByUser_Email(email).orElseThrow();
        StudentDto dto = new StudentDto();

        dto.name = student.getUser().getName();
        dto.email = student.getUser().getEmail();
        dto.course = student.getDegree();
        dto.university = student.getUniversity();
        dto.resumeUrl = student.getResumeUrl();
        dto.skill = student.getSkill();

        return dto;
    }
    public StudentProfile saveStudents(StudentProfile studentProfile) {
        return studentRepo.save(studentProfile);
    }
}
