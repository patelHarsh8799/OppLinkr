package com.zidio.Opplinkr.Repositiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zidio.Opplinkr.Entity.Users;

public interface UserRepo extends JpaRepository<Users, Long>{
	
	Optional<Users> findByEmail(String email);

}
