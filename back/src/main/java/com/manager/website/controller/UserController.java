package com.manager.website.controller;

import com.manager.website.dto.LoginDto;
import com.manager.website.dto.UserDto;
import com.manager.website.entity.UserEntity;
import com.manager.website.handler.exception.CustomException;
import com.manager.website.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public void login() {
    }

    @PostMapping("/find/username")
    public ResponseEntity<UserDto> findUsername(@RequestBody UserDto dto, HttpSession session) {
        UserDto result = userService.findUsername(dto);
        if (result != null) {
            session.setAttribute("username", result.getUsername());
            return ResponseEntity.ok(result);
        } else {
            return null;
        }
    }

    @PostMapping("/find/password")
    public ResponseEntity<String> findPassword(@RequestBody UserDto dto, HttpSession session) {
        String result = userService.findPassword(dto);
        if (result == null) {
            throw new CustomException("존재하지 않는 계정입니다.", HttpStatus.NOT_FOUND);
        } else {
            session.setAttribute("password", result);
            return ResponseEntity.ok(result);
        }
    }
}
