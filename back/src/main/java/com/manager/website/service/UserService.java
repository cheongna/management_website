package com.manager.website.service;

import com.manager.website.dto.UserDto;
import com.manager.website.db.UserDatabase;
import com.manager.website.entity.UserEntity;
import com.manager.website.handler.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
            throw new CustomException("해당 유저는 존재하지 않습니다(아이디 찾기 오류)", HttpStatus.NOT_FOUND);
        }
    }

    public String findPassword(UserDto dto) {
        String username = dto.getUsername();
        String name = dto.getName();
        String phone = dto.getPhone();
        UserEntity entity = userDatabase.findByUsernameAndNameAndPhone(username, name, phone);
        if (entity == null) {
            throw new CustomException("해당 유저는 존재하지 않습니다(비밀번호 찾기 오류)", HttpStatus.NOT_FOUND);
        } else {
            entity.setPassword(passwordEncoder.encode("qwe123!"));
            userDatabase.save(entity);
            return "qwe123!";
        }
    }

    public UserEntity findUserById(long id) {
        return userDatabase.findById(id)
                .orElseThrow(() -> new CustomException("해당 id에 존재하는 유저가 없습니다.", HttpStatus.NOT_FOUND));
    }
}
