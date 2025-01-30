package com.manager.website.controller;

import com.manager.website.dto.LoginDto;
import com.manager.website.dto.UserDto;
import com.manager.website.entity.UserEntity;
import com.manager.website.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<UserDto> join(@RequestBody UserEntity entity) {
        UserDto result = userService.join(entity);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        if (loginDto.username.equals("ehgus973") && loginDto.password.equals("to3847")) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(401).body("로그인 실패");
        }
    }
}
