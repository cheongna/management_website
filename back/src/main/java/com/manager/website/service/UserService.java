package com.manager.website.service;

import com.manager.website.dto.UserDto;
import com.manager.website.db.UserDatabase;
import com.manager.website.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDatabase userDatabase;
    private final PasswordEncoder passwordEncoder;

    public UserDto join(UserEntity entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        UserEntity user = userDatabase.save(entity);
        return UserDto.convertToDto(user);
    }

    public UserDto findUsername(UserDto dto) {
        String name = dto.getName();
        String phone = dto.getPhone();
        UserEntity entity = userDatabase.findByNameAndPhone(name, phone);
        if (entity != null) {
            return UserDto.convertToDto(entity);
        } else {
            return null;
        }
    }
}
