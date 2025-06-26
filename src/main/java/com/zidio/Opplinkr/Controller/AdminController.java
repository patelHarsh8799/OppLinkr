package com.zidio.Opplinkr.Controller;

import com.zidio.Opplinkr.Service.AdminService;
import com.zidio.Opplinkr.dto.UserInfoDto.UserInfoResponse;
import com.zidio.Opplinkr.dto.UserInfoDto.UserStatusUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/user/status")
    public ResponseEntity<UserInfoResponse> updateUserStatus(@RequestBody UserStatusUpdateRequest request) {
        return ResponseEntity.ok(adminService.updateUserStatus(request));
    }

    @GetMapping("/users")
    public ResponseEntity<UserInfoResponse> getAllUsers() {
        return ResponseEntity.ok((UserInfoResponse) adminService.getAllUsers());
    }

    @GetMapping("/users/{role}")
    public ResponseEntity<UserInfoResponse> getUsersByRole(@PathVariable String role) {
        return ResponseEntity.ok((UserInfoResponse) adminService.getUserByRole(role));
    }
}
