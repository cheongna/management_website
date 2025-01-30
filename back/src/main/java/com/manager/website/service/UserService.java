package com.manager.website.service;

import com.manager.website.dto.UserDto;
import com.manager.website.db.UserDatabase;
import com.manager.website.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDatabase userDatabase;

    public UserDto join(UserEntity entity) {
        UserEntity user = userDatabase.save(entity);
        return UserDto.convertToDto(user);
    }
}
