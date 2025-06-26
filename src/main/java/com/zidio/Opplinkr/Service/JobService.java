package com.zidio.Opplinkr.Service;

import com.zidio.Opplinkr.Entity.Job;
import com.zidio.Opplinkr.Repositiory.JobRepo;
import com.zidio.Opplinkr.dto.JobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public String jobPost(JobRequest request) {
        Job job = new Job();
        job.setTitle(request.title);
        job.setDescription(request.description);
        job.setCompanyName(request.companyName);
        job.setLocation(request.location);
        job.setType(request.type);
        job.setDurationWeeks(request.durationWeeks);
        job.setSkill(request.skill);

        jobRepo.save(job);

        return "Job post saves successfully";
    }

    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public List<Job> searchByTitle(String title) {
        return jobRepo.findByTitleContainingIgnoreCase(title);
    }
    public List<Job> searchByCompanyName(String companyName) {
        return jobRepo.findByCompanyNameContainingIgnoreCase(companyName);
    }
    public List<Job> getJobsByRecruiter(Long userId) {
        return jobRepo.findByPostedBy_UserId(userId);
    }
    public Job postJob(Job job) {
        return jobRepo.save(job);
    }
}
