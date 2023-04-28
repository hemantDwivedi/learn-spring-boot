package com.project.webservices.mapper;

import com.project.webservices.dto.UserDto;
import com.project.webservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoMapper {

    AutoMapper MAPPER = Mappers.getMapper(AutoMapper.class);
    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
