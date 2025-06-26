package com.zidio.Opplinkr.Controller;

import com.zidio.Opplinkr.Service.StudentService;
import com.zidio.Opplinkr.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody StudentDto dto) {
        String response = studentService.createOrUpdate(dto);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/profile/{email}")
    public ResponseEntity<StudentDto> getStudentProfile(@PathVariable String email) {
        StudentDto dto = studentService.getProfile(email);
        return ResponseEntity.ok(dto);
    }
}
