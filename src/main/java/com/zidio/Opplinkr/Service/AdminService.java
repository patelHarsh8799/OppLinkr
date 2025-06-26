package com.zidio.Opplinkr.Service;

import com.zidio.Opplinkr.Entity.UserInfo;
import com.zidio.Opplinkr.Repositiory.UserInfoRepo;
import com.zidio.Opplinkr.dto.UserInfoDto.UserInfoResponse;
import com.zidio.Opplinkr.dto.UserInfoDto.UserStatusUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserInfoRepo userInfoRepo;

    public UserInfoResponse updateUserStatus(UserStatusUpdateRequest request) {
        UserInfo user = userInfoRepo.findByEmail(request.email).orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setActive(request.isActive);
        UserInfo saved = userInfoRepo.save(user);
        return toResponse(saved);
    }

    public List<UserInfoResponse> getAllUsers() {
        return userInfoRepo.findAll()
                .stream().map(this::toResponse).toList();
    }

    public List<UserInfoResponse> getUserByRole(String role) {
        return userInfoRepo.findByRole(role.toUpperCase()).stream().map(this::toResponse).toList();
    }

    public UserInfoResponse toResponse(UserInfo userInfo) {
        return new UserInfoResponse(userInfo.getEmail(), userInfo.getRole(), userInfo.isActive());
    }
}
