package com.zidio.Opplinkr.Service;

import com.zidio.Opplinkr.Entity.RecruiterProfile;
import com.zidio.Opplinkr.Repositiory.RecruiterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruiterService {
    @Autowired
    private RecruiterRepo recruiterRepo;

    public Optional<RecruiterProfile> getByCompanyName(String name) {
        return recruiterRepo.findByCompanyName(name);
    }

    public RecruiterProfile saveRecruiter(RecruiterProfile  recruiterProfile) {
        return recruiterRepo.save(recruiterProfile);
    }
}
