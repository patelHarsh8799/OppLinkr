package com.zidio.Opplinkr.Controller;

import com.zidio.Opplinkr.Service.RecruiterService;
import com.zidio.Opplinkr.dto.RecruiterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/Recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping("/save")
    public ResponseEntity<String> saveOrUpdate(@RequestBody RecruiterDto dto) {
        return ResponseEntity.ok(recruiterService.createOrUpdate(dto));
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<RecruiterDto> getProfile(@PathVariable String email) {
        return ResponseEntity.ok(recruiterService.getRecruiterProfile(email));
    }
}
