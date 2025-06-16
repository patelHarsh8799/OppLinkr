package com.zidio.Opplinkr.Service;

import com.zidio.Opplinkr.Entity.Job;
import com.zidio.Opplinkr.Repositiory.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<Job> searchByTitle(String title) {
        return jobRepo.findByTitleContainingIgnoreCase(title);
    }
    public List<Job> getJobsByRecruiter(Long userId) {
        return jobRepo.findByPostedBy_UserId(userId);
    }
    public Job postJob(Job job) {
        return jobRepo.save(job);
    }
}
