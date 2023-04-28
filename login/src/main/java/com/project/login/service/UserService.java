package com.project.login.service;

import com.project.login.dto.UserDto;
import com.project.login.entity.User;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
