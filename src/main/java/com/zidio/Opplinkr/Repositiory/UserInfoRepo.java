package com.zidio.Opplinkr.Repositiory;

import com.zidio.Opplinkr.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);
    List<UserInfo> findByRole(String role);
}
