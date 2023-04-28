package com.project.webservices.mapper;

import com.project.webservices.dto.UserDto;
import com.project.webservices.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(), user.getName(), user.getEmail()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(), userDto.getName(), userDto.getEmail()
        );
    }
}
