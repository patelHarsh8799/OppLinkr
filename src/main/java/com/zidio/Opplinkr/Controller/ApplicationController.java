package com.zidio.Opplinkr.Controller;

import com.zidio.Opplinkr.Service.ApplicationService;
import com.zidio.Opplinkr.dto.ApplicationDto.ApplicationRequest;
import com.zidio.Opplinkr.dto.ApplicationDto.ApplicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<ApplicationResponse> apply(@RequestBody ApplicationRequest request) {
        return ResponseEntity.ok(applicationService.apply(request));
    }

    @GetMapping("/student/{email}")
    public ResponseEntity<ApplicationResponse> getByStudentEmail(@PathVariable String email) {
        return ResponseEntity.ok((ApplicationResponse) applicationService.getApplicationsByStudent(email));
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<ApplicationResponse> getByJobId(@PathVariable Long jobId) {
        return ResponseEntity.ok((ApplicationResponse) applicationService.getApplicationByJobId(jobId));
    }
}
