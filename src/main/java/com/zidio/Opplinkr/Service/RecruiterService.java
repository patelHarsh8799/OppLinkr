package com.zidio.Opplinkr.Service;

import com.zidio.Opplinkr.Entity.RecruiterProfile;
import com.zidio.Opplinkr.Entity.Users;
import com.zidio.Opplinkr.Repositiory.RecruiterRepo;
import com.zidio.Opplinkr.dto.RecruiterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {
    @Autowired
    private RecruiterRepo recruiterRepo;

    public String createOrUpdate(RecruiterDto dto) {
        Optional<RecruiterProfile> optional = recruiterRepo.findByUser_Email(dto.email);

        RecruiterProfile profile = optional.orElse(new RecruiterProfile());

        if (profile.getUser() != null) {
            Users users = new Users();
            users.setEmail(dto.email);
            users.setName(dto.name);
            profile.setUser(users);
        }
        profile.setCompanyName(dto.companyName);
        profile.setDesignation(dto.designation);
        profile.setCompanyWebsite(dto.companyWebSite);

        recruiterRepo.save(profile);
        return optional.isPresent() ? "Recruiter profile updated." : "Recruiter profile created.";
    }

    public RecruiterDto getRecruiterProfile(String email) {
        RecruiterProfile profile = recruiterRepo.findByUser_Email(email).orElseThrow();
        RecruiterDto dto = new RecruiterDto();
        dto.email = profile.getUser().getEmail();
        dto.name = profile.getUser().getName();
        dto.companyName = profile.getCompanyName();
        dto.designation = profile.getDesignation();
        dto.companyWebSite = profile.getCompanyWebsite();

        return dto;
    }

//    public List<RecruiterDto> getAllRecruiters(){
//        return recruiterRepo.findAll().stream().map(r ->{
//            RecruiterDto dto = new RecruiterDto();
//            BeanUtils.copyproperties(RecruiterProfile, dto);
//            return dto;
//        }).collect(collectors.toList());
//    }

    public Optional<RecruiterProfile> getByCompanyName(String name) {
        return recruiterRepo.findByCompanyName(name);
    }

    public RecruiterProfile saveRecruiter(RecruiterProfile  recruiterProfile) {
        return recruiterRepo.save(recruiterProfile);
    }
}
