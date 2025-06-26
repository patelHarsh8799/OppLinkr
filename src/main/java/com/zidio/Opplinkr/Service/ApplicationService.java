package com.zidio.Opplinkr.Service;

import com.zidio.Opplinkr.Entity.Application;
import com.zidio.Opplinkr.Repositiory.ApplicationRepository;
import com.zidio.Opplinkr.dto.ApplicationDto.ApplicationRequest;
import com.zidio.Opplinkr.dto.ApplicationDto.ApplicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;


    private ApplicationResponse mapToResponse(Application application) {
        return new ApplicationResponse(
                application.getId(),
                application.getStudentEmail(),
                application.getJobId(),
                application.getStatus()
        );
    }

    public ApplicationResponse apply(ApplicationRequest request) {
        applicationRepository.findByStudentEmailAndJobId(request.studentEmail, request.jobId)
                .ifPresent(a -> {
                    throw new RuntimeException("Already applied");
                });

        Application application = new Application();
        application.setStudentEmail(request.studentEmail);
        application.setJobId(request.jobId);
        application.setStatus("Applied");

        application = applicationRepository.save(application);

        return mapToResponse(application);
    }

    public List<ApplicationResponse> getApplicationsByStudent(String studentEmail) {
        return applicationRepository.findByStudentEmail(studentEmail)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<ApplicationResponse> getApplicationByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId)
                .stream().map(this::mapToResponse).toList();
    }


}
