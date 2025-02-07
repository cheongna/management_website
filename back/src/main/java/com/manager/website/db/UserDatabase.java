package com.manager.website.db;

import com.manager.website.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDatabase extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);

    UserEntity findByNameAndPhone(String username, String phone);
}
