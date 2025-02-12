package com.manager.website.config;

import com.manager.website.db.UserDatabase;
import com.manager.website.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomUserdetailsFilter implements UserDetailsService {
    private final UserDatabase userDatabase;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity entity = userDatabase.findByUsername(username);
        if (entity == null) {
            log.error("로그인 오류 발생 USERNAME: " + username);
            throw new UsernameNotFoundException(username + "은 존재하지 않거나 사용이 불가능한 아이디입니다.");
        } else {
            return new User(entity.getUsername(), entity.getPassword(), new ArrayList<>());
        }
    }
}
