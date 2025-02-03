package com.manager.website.dto;

import com.manager.website.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    public String name;
    public String username;
    public String address;
    public String phone;

    public static UserDto convertToDto(UserEntity entity) {
        return new UserDto(entity.getName(), entity.getUsername(), entity.getAddress(), entity.getPhone());
    }
}
