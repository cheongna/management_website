package com.manager.website.config;

import com.manager.website.db.UserDatabase;
import com.manager.website.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class CustomUserdetailsFilter implements UserDetailsService {
    private final UserDatabase userDatabase;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = userDatabase.findByUsername(username);
        if (entity != null) {
            return new User(entity.getUsername(), entity.getPassword(), new ArrayList<>());
        } else {
            return null;
        }
    }
}
