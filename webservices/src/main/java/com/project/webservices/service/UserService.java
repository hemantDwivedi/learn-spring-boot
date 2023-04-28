package com.project.webservices.service;

import com.project.webservices.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto userDto);
    UserDto getById(Long id);
    List<UserDto> getAll();
    UserDto update(UserDto userDto);
    void delete(Long id);
}
