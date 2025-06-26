package com.zidio.Opplinkr.Controller;

import com.zidio.Opplinkr.Service.AuthService;
import com.zidio.Opplinkr.dto.AuthDto.LoginRequest;
import com.zidio.Opplinkr.dto.AuthDto.RegisterRequest;
import com.zidio.Opplinkr.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<String> register(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
    @GetMapping("/validate")
    public ResponseEntity<String> validate(@RequestParam String token) {
        boolean isValid = jwtUtil.validateToken(token);
        return isValid
                ? ResponseEntity.ok("Valid Token")
                : ResponseEntity.status(401).body("Invalid Token");
    }
}
