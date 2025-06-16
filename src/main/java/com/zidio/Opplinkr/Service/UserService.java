package com.zidio.Opplinkr.Service;

import com.zidio.Opplinkr.Entity.Users;
import com.zidio.Opplinkr.Repositiory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Optional<Users> getUsersByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public Users saveUser(Users users) {
        return userRepo.save(users);
    }
 }
