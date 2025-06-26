package com.zidio.Opplinkr.dto.UserInfoDto;

public class UserInfoResponse {

    public String email;
    public String role;
    public boolean isActive;

    public UserInfoResponse(String email, String role, boolean isActive) {
        this.email = email;
        this.role = role;
        this.isActive = isActive;
    }
}
