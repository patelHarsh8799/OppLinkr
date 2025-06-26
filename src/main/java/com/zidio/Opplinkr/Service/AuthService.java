package com.zidio.Opplinkr.Service;

import com.zidio.Opplinkr.Entity.Users;
import com.zidio.Opplinkr.Repositiory.UserRepo;
import com.zidio.Opplinkr.dto.AuthDto.LoginRequest;
import com.zidio.Opplinkr.dto.AuthDto.RegisterRequest;
import com.zidio.Opplinkr.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;;
    public String register(RegisterRequest request) {
        Users users = new Users();
        users.setEmail(request.email);
        users.setPassword(new BCryptPasswordEncoder().encode(request.password));
        users.setRole(request.role);
        users.setName(request.name);
        userRepo.save(users);
        return "You have Successfully registered";
    }
    public String login(LoginRequest request) {
        Users users = userRepo.findByEmail(request.email).orElseThrow(() -> new RuntimeException("User Not Found"));
        if(!new BCryptPasswordEncoder().matches(request.password,users.getPassword())){
            throw new RuntimeException("Invalid Password");
        }
        return jwtUtil.generateToken(users.getEmail());
    }
}
